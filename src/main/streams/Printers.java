package main.streams;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;

public class Printers {

	public static void main(String[] args) throws IOException {
		File file = new File("src/main/streams/print.txt");
		
		if (!file.exists() ) {
			file.createNewFile();
		}
		
		PrintStream writer = new PrintStream(file);
		// PrintWriter writer = new PrintWriter(file);
		
		writer.println("Linha 1");
		writer.println("Linha 2");
		writer.println("Linha 3");
		writer.println("Linha 4");
		writer.println("Linha 5");
		writer.print("Linha 6");
		
		writer.close();
	}

}
