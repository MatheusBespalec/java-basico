package main.streams;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import main.classes.People;
import main.classes.Student;
import main.projects.miniprojects.queue.classes.Contact;

public class JsonFiles {

	public static void main(String[] args) throws IOException {
		String currentDir = Paths.get("src/main/streams").toAbsolutePath().toString();
		File file = new File(currentDir + "/test.json");
		
		if (!file.exists()) {
			file.createNewFile();
		}
		
		createJson(file);
		readJson(file);
	}
	
	public static void createJson(File file) throws IOException {
		List<Contact> contacts = new ArrayList<Contact>();
		contacts.add(new Contact("Joao", "joao@gmail.com"));
		contacts.add(new Contact("Maria", "maria@gmail.com"));
		
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		//String json = new Gson().toJson(peoples);
		String json = gson.toJson(contacts);
		
		Writer fileWriter = new FileWriter(file);
		fileWriter.write(json);
		fileWriter.flush();
		fileWriter.close();
	}
	
	public static void readJson(File file) throws IOException {
		List<Contact> contacts = new ArrayList<Contact>();
		
		Reader fileReader = new FileReader(file);
		JsonArray jsonArray = (JsonArray) JsonParser.parseReader(fileReader);
		jsonArray.forEach((JsonElement jsonElement) -> {
			contacts.add(new Gson().fromJson(jsonElement, Contact.class));
		});
		
		contacts.forEach((contact) -> System.out.println(contact));
	}

}
