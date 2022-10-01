package main.bin;

import javax.swing.JOptionPane;

import main.classes.Student;
import main.classes.Test;

public class Average {
	public static void main(String[] args) {
		/* O construtor usado vai depender do tipo de atributo que esta sendo passado */
		Student student = new Student(JOptionPane.showInputDialog("Insira o nome do aluno"));
		
		String inputDisciplineTest1 = JOptionPane.showInputDialog("Insira a disciplina da primeira prova");
		String inputGradeTest1 = JOptionPane.showInputDialog("Insira a nota da primeira prova");
		
		String inputDisciplineTest2 = JOptionPane.showInputDialog("Insira a disciplinada segunda prova");
		String inputGradeTest2 = JOptionPane.showInputDialog("Insira a nota da segundaprova");
		
		String inputDisciplineTest3 = JOptionPane.showInputDialog("Insira a disciplina da segunda prova");
		String inputGradeTest3 = JOptionPane.showInputDialog("Insira a nota da segunda prova");

		double gradeTest1 = Double.parseDouble(inputGradeTest1);
		double gradeTest2 = Double.parseDouble(inputGradeTest2);
		double gradeTest3 = Double.parseDouble(inputGradeTest3);
		
		student.addTest(new Test(gradeTest1, inputDisciplineTest1));
		student.addTest(new Test(gradeTest2, inputDisciplineTest2));
		student.addTest(new Test(gradeTest3, inputDisciplineTest3));
		
		JOptionPane.showMessageDialog(null, student.getName() + " esta " + student.status() + " com media " + student.testsAverage());
		
		int showTests = JOptionPane.showConfirmDialog(null, "Desejar ver as provas do aluno?");
		
		if (showTests == JOptionPane.YES_OPTION) {
			for (Test test : student.getTests()) {
				JOptionPane.showMessageDialog(null, "A nota de " + student.getName() + " em " + test.getDiscipline() + " foi " + test.getGrade());
			}
		}
	}
}
