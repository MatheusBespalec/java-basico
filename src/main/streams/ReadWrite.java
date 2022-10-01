package main.streams;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;
import java.nio.file.Paths;

public class ReadWrite {

	public static void main(String[] args) throws IOException {
		String currentDir = Paths.get("src/main/streams").toAbsolutePath().toString();
		// Read
		/*
		File readFile = new File(currentDir + "/test.txt");
		
		if (!readFile.exists()) {
			readFile.createNewFile();
		}
		
		InputStream inputStream = new FileInputStream(readFile);
		*/
		InputStream inputStream = System.in;
		Reader reader = new InputStreamReader(inputStream);
		BufferedReader bufferedReader = new BufferedReader(reader);
		
		// Write
		
		File writeFile = new File(currentDir + "/test_copy.txt");
		
		if (!writeFile.exists()) {
			writeFile.createNewFile();
		}
		
		OutputStream outputStream = new FileOutputStream(writeFile);
		
		
		//OutputStream outputStream = System.out;
		Writer writer = new OutputStreamWriter(outputStream);
		BufferedWriter bufferedWriter = new BufferedWriter(writer);
		
		String row = bufferedReader.readLine();
		
		while (row != null && !row.isEmpty()) {
			bufferedWriter.write(row);
			bufferedWriter.newLine();
			bufferedWriter.flush();
			row = bufferedReader.readLine();
		}
		
		bufferedReader.close();
		bufferedWriter.close();
	}
}
