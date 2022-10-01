package main.classes;

public class Test {
	private double grade;
	private String discipline;
	
	public Test(double grade, String discipline) {
		this.grade = grade;
		this.discipline = discipline;
	}

	public double getGrade() {
		return this.grade;
	}

	public String getDiscipline() {
		return this.discipline;
	}
}
