package main.bin;

import java.util.List;

public class Arrays {
	public static void main(String[] args) {
		/*
		 * Na declaracao de um array podermos fazer de 2 formas
		 * 
		 *  tipo[] nomeVar
		 *  tipo nomeVar[]
		 */
		
		// double tests[] = new double[2];
		double[] tests = new double[2];
		
		tests[0] = 9;
		tests[1] = 5.6;
		tests[0] = 5.9;
		// double tests[] = {9, 5.6, 5.9};
		
		System.out.println(tests[0]);
		

		System.out.println("===============================");
		// ----------------------------
		 
		String names = "Maria, Felipe, Marcos, Anderson";
		String[] arrayOfNames = names.split(", ");
		 
		for (int i = 0; i < arrayOfNames.length; i++) {
			System.out.println(arrayOfNames[i]);
		}
		
		System.out.println("===============================");
		// ----------------------------
		
		List<String> list = java.util.Arrays.asList(arrayOfNames);
		
		for (String name : list) {
			System.out.println(name);
		}
		
		System.out.println("===============================");
		// ----------------------------
		
		String[] otherArray = list.toArray(new String[list.size()]);
		
		for (int position = 0; position < otherArray.length; position++) {
			System.out.println(otherArray[position]);
		}
		
		System.out.println("===============================");
		// ----------------------------
		
		double[][] testsOfStudents = new double[2][4];
		
		testsOfStudents[0][0] = 5;
		testsOfStudents[0][1] = 10;
		testsOfStudents[0][2] = 8.6;
		testsOfStudents[0][3] = 7.7;
		
		testsOfStudents[1][0] = 9.7;
		testsOfStudents[1][1] = 5;
		testsOfStudents[1][2] = 6.9;
		testsOfStudents[1][3] = 8;
		
		for (int studentPosition = 0; studentPosition < testsOfStudents.length; studentPosition++) {
			System.out.println("-------------------");
			for (int testPosition = 0; testPosition < testsOfStudents[studentPosition].length; testPosition++) {
				System.out.println(testsOfStudents[studentPosition][testPosition]);
			}
		}
		 
	}
}
