package main.projects.miniprojects.queue.classes;

import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;

public class ContactQueue extends Thread {
	private static ConcurrentLinkedQueue<Contact> queue = new ConcurrentLinkedQueue<Contact>();
	
	public static void add(Contact contact) {
		queue.add(contact);
	}
	
	@Override
	public void run() {
		System.out.println("rodando fila");
		
		while (true) {
			Iterator<Contact> list = queue.iterator();
			
			synchronized (list) { // Bloqueia o acesso a lista por outros processos
				while (list.hasNext()) {
					Contact contact = list.next();
					
					System.out.println("------------------------------------------------");
					System.out.println("Cadastrando o contato " + contact.getName());
					System.out.println("Enviando email de boas vindas para " + contact.getEmail());
					list.remove();
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}	
				}
			}
			
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
		}
	}
}
