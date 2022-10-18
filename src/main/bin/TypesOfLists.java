package main.bin;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

import main.classes.Employee;

public class TypesOfLists {

	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		// List<String> list = new LinkedList<String>();
		
		list.add("abc");
		list.add("test");
		list.add("Hellow World!");
		list.add("Lists in Java");
		
		System.out.println("----- Lista 1 Sem Orderdacao -----");
		list.forEach((text) -> System.out.println(text));
		
		System.out.println("----- Lista 1 Ordenacao Lexica -----");
		
		Collections.sort(list);
		list.forEach((text) -> System.out.println(text));
		
		System.out.println("----- Lista 1 Ordenacao Customizada-----");
		
		// Ordenar pelo tamanho da string
		Collections.sort(list, (item1, item2) -> item1.length() - item2.length());
		list.forEach((text) -> System.out.println(text));
		
		System.out.println("----------");
		
		List<Integer> numericList = new ArrayList<Integer>();
		
		numericList.add(5);
		numericList.add(9);
		numericList.add(1);
		numericList.add(7);
		numericList.add(8);
		numericList.add(3);
		
		System.out.println("----- Lista 2 Sem Orderdacao -----");
		
		numericList.forEach((number) -> System.out.println(number));
		
		System.out.println("----- Lista 2 Ordem Crescente -----");
		
		numericList.sort(null);
		numericList.forEach((number) -> System.out.println(number));
		
		System.out.println("----- Lista 2 Ordem Decrescente -----");
		
		Collections.sort(numericList, (number1, number2) -> number2 - number1);
		numericList.forEach((number) -> System.out.println(number));
		
		List<Employee> employees = new ArrayList<Employee>();
		
		employees.add(new Employee("Roberto", 4600));
		employees.add(new Employee("Ana", 5000));
		employees.add(new Employee("Carlos", 3000));
		
		System.out.println("----- Lista de Funcionarios Sem Orderdacao -----");
		
		employees.forEach((employee) -> System.out.println(employee));
		
		System.out.println("----- Lista de Funcionarios Ordenados por Salario -----");
		
		// employees.sort((employee1, employee2) -> Double.compare(employee1.getSalary(), employee2.getSalary()));
		employees.sort(Comparator.comparing(Employee::getSalary)); // Metodo Reference => Employee::getSalary == e -> e->getSalary() 
		employees.forEach((employee) -> System.out.println(employee));
	}

}
