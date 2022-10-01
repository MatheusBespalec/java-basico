package main.bin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.swing.JOptionPane;

import main.classes.Student;
import main.classes.Test;

public class ListOfStudents {
	public static void main(String[] args) {
		
		HashMap<String, List<Student>> studentsMap = new HashMap<String, List<Student>>();
		studentsMap.put(Student.APPROVED, new ArrayList<Student>());
		studentsMap.put(Student.DISAPPROVED, new ArrayList<Student>());
		studentsMap.put(Student.RECOVERY, new ArrayList<Student>());
		
		while (true) {
			String inputName = JOptionPane.showInputDialog("Qual o nome do aluno?");
			String inputNota = JOptionPane.showInputDialog("Qual a nota de " + inputName + " em Java?");
			
			Test test = new Test(Double.parseDouble(inputNota), "Java");
		
			Student student = new Student(inputName);
			student.addTest(test);
			
			studentsMap.get(student.status()).add(student);
			
			int breakLoop = JOptionPane.showConfirmDialog(null, "Deseja cadastrar outro aluno?");
			if (breakLoop != JOptionPane.YES_OPTION) {
				break;			
			}
		}
		
		System.out.println("----- ALUNOS APROVADOS ------");
		for (Student student : studentsMap.get(Student.APPROVED)) {
			System.out.println(student.getName());
		}
		
		System.out.println("----- ALUNOS REPROVADOS------");
		for (Student student : studentsMap.get(Student.DISAPPROVED)) {
			System.out.println(student.getName());
		}
		
		System.out.println("----- ALUNOS EM RECUPERACAO ------");
		for (Student student : studentsMap.get(Student.RECOVERY)) {
			System.out.println(student.getName());
		}
	}
}
