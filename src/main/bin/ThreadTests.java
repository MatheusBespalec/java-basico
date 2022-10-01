package main.bin;

public class ThreadTests {
	public static void main(String[] args) {
		
		new Thread() {
			public void run() {
				for (int i = 1; i <= 10; i++) {
					try {
						Thread.sleep(1000);
					} catch (Exception e) {
						e.printStackTrace();
					}
					
					System.out.println(i + "s");
				}
			};
		}.start();
		
		Thread notifyUsers = new Thread(sendEmails);
		notifyUsers.start();
		
		System.out.println("Teste de Programacao Paralela");
	}
	
	private static Runnable sendEmails = new Runnable() {
		
		@Override
		public void run() {
			for (int i = 0; i < 20; i++) {
				try {
					Thread.sleep(400);
				} catch (Exception e) {
					e.printStackTrace();
				}
				System.out.println("Enviando email " + (i + 1));
			}
		}
	};
}
