package main.classes;

import java.util.ArrayList;
import java.util.List;

public class Student extends People {
	public static String APPROVED = "aprovado";
	public static String DISAPPROVED = "reprovado";
	public static String RECOVERY = "em recuperacao";
	
	private List<Test> tests = new ArrayList<Test>();
	
	/* No Java podemos ter multiplos construtores */
	public Student() {
		
	}
	
	public Student(String name) {
		/* Para acessar atributos podemos acessar atraves do `this` ou simplesmente pelo nome caso nao exista nenhuma variavel 
		 * com o mesmo nome do atributo no bloco */
		super.name = name;
	}
	
	public Student(String name, int age) {
		super.name = name;
		super.age = age;
	}

	public void addTest(Test test) {
		this.tests.add(test);
	}
	
	public List<Test> getTests() {
		return this.tests;
	}
	
	public double testsAverage() {
		double sum = 0;
		
		for (Test test : tests) {
			sum+= test.getGrade();
		}
		
		return sum / tests.size();
	}
	
	public String status() {
		double average = this.testsAverage();
		
		if (average >= 70) {
			return APPROVED;
		} else if (average >= 50) {
			return RECOVERY;
		}
		return DISAPPROVED;
	}
	
	/* Podemos sobreescrever uma funcao sem o `@Override`,porem ele nos garante que estamos sobreescrevendo um metodo verificando na classe
	 * Pai se existe algum metodo com o mesmo nome, caso nao haja teremos um erro. Ele tambem nos garante que o tipo do retorno seja igual
	 * tanto na classe pai como na classe filha*/
	@Override
	public boolean polimorficTest() {
		return false;
	}
}
