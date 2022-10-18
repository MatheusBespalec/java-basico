package main.bin;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;

public class Collections {
	public static void main(String[] args) {
		/*
		 * Trabalham com tabelas de espalhamento, portanto nao possuem ordenacao
		 * Nao armazenam elementos repetidos
		 * Muito mais rapidas que listas
		 */
		
		Collection<Integer> numbers;
		// numbers = new HashSet<Integer>();
		numbers = new LinkedHashSet<Integer>(); // Mantem a ordem em que os itens foram adicionados
		
		numbers.add(1);
		numbers.add(10);
		numbers.add(33);
		numbers.add(9);
		numbers.add(5);
		numbers.add(12);
		
		System.out.println(numbers);
		
		// Formas de iteracao
		
		System.out.println("Iterando Collenctions com forEach");
		numbers.forEach((number) -> System.out.println(number));
		
		System.out.println();
		
		System.out.println("Iterando Collenctions com for");
		for (Integer number : numbers) {
			System.out.println(number);
		}
		
		System.out.println();
		
		System.out.println("Iterando Collenctions com Iterator");
		Iterator<Integer> numbersIterator = numbers.iterator();
		
		while (numbersIterator.hasNext()) {
			System.out.println(numbersIterator.next());
		}
	}
}
