package main.bin;

import main.classes.Student;

public class POOTests {
	public static void main(String[] args) {
		// metodos contrutores nao sao herdados
		Student student = new Student("Matheus");
		System.out.println(student.polimorficTest());
	}
}
