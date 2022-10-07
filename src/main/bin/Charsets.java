package main.bin;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public class Charsets {

	public static void main(String[] args) throws UnsupportedEncodingException {
		String s = "calçada";
		System.out.println(s.codePointAt(3));
		
		Charset charset = Charset.defaultCharset(); // charset do sistema atual 
		System.out.println(charset.displayName()); 
		
		String newString;
		byte[] bytes;
		
		System.out.println("---------------");
		
		// Quantidade de bytes da string
		bytes = s.getBytes(StandardCharsets.UTF_8);
		System.out.println(bytes.length + " " + StandardCharsets.UTF_8); // 8 
		newString = new String(bytes, StandardCharsets.UTF_8); 
		System.out.println(newString); // lendo em utf-8
		
		System.out.println("---------------");
		
		bytes = s.getBytes(StandardCharsets.UTF_16);
		System.out.println(bytes.length + " " + StandardCharsets.UTF_16); // 16
		newString = new String(bytes, StandardCharsets.UTF_16); 
		System.out.println(newString);
		
		System.out.println("---------------");
		
		bytes = s.getBytes(StandardCharsets.US_ASCII);
		System.out.println(bytes.length + " " + StandardCharsets.US_ASCII); // 7
		newString = new String(bytes, StandardCharsets.US_ASCII); 
		System.out.println(newString); // erro no ç
		
		System.out.println("---------------");
		
		bytes = s.getBytes(StandardCharsets.ISO_8859_1);
		System.out.println(bytes.length + " " + StandardCharsets.ISO_8859_1); // 7
		newString = new String(bytes, StandardCharsets.ISO_8859_1); 
		System.out.println(newString);
		
		System.out.println("---------------");
		
		bytes = s.getBytes("windows-1252");
		System.out.println(bytes.length + " " + "windows-1252"); // 7
		newString = new String(bytes, "windows-1252"); 
		System.out.println(newString);
	}

}
