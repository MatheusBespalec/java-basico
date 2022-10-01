package main.streams;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

import main.projects.miniprojects.queue.classes.Contact;

public class CsvFiles {

	public static void main(String[] args) throws IOException {		
		ArrayList<Contact> contacts = new ArrayList<Contact>();
		contacts.add(new Contact("Rodrigo", "rodrigo@gmail.com"));
		contacts.add(new Contact("Erick", "erick@gmail.com"));
		contacts.add(new Contact("Maria", "maria@gmail.com"));
		
		String currentDir = Paths.get("src/main/streams").toAbsolutePath().toString();
		File file = new File(currentDir + "/contacts.csv");
		
		if (!file.exists()) {
			file.createNewFile();
		}
		
		FileWriter fileWriter = new FileWriter(file);
		
		for (Contact contact : contacts) {
			fileWriter.write(contact.toString() + "\n");
		}
		
		fileWriter.flush();
		fileWriter.close();
		ArrayList<Contact> otherContacts = new ArrayList<Contact>();
		
		Scanner fr = new Scanner(file);
		
		while (fr.hasNextLine()) {
			String[] row = fr.nextLine().split(",");
			otherContacts.add(new Contact(row[0], row[1]));
		}
		
		for (Contact contact : otherContacts) {
			System.out.println("-------------------------");
			System.out.println("Nome: " + contact.getName() + " | Email: " + contact.getEmail());
		}
		
		fr.close();
	}

}
