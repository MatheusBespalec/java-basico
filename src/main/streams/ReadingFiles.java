package main.streams;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.nio.file.Paths;
import java.util.Scanner;

public class ReadingFiles {

	public static void main(String[] args) throws FileNotFoundException {
		String currentDir = Paths.get("src/main/streams").toAbsolutePath().toString();
		File file = new File(currentDir + "/test.txt");
		Scanner textFile = new Scanner(file, "UTF-8");
		
		while (textFile.hasNext()) {
			String row = textFile.nextLine();
			
			if (!row.isEmpty()) {
				System.out.println(row);
			}
		}
	}

}
