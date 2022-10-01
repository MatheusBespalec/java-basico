package main.streams;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Paths;

public class WritingFiles {

	public static void main(String[] args) throws IOException {
		String currentDir = Paths.get("src/main/streams").toAbsolutePath().toString();
		File file = new File(currentDir + "/test.txt");
		System.out.println(currentDir);
		if (!file.exists()) {
			file.createNewFile();
		}
		
		FileWriter writer = new FileWriter(file);
		
		System.out.println(file.isAbsolute());
		System.out.println(file.isFile());
		System.out.println(file.isDirectory());
		System.out.println(file.lastModified());
		System.out.println(file.canWrite());
		
		for (int i = 0; i < 10; i++) {
			writer.write("Linha " + i + "\n");
		}
		
		writer.flush();
		writer.close();
	}

}
