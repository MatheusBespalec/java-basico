package main.bin;

import main.exceptions.TestException;
import main.exceptions.TestThrowable;

public class Exceptions {
	public static void main(String[] args) {
		//  Excecoes podem ser do tipo checked(devem ser obrigatoriamente tratadas) e unchecked
		
		try {
			int num = 1 / 0;
		} catch (Exception e) {
			// Imprime a stackde erro no console
			/*e.printStackTrace();*/
			
			// Pega a mensagem de erro
			System.out.println(e.getMessage());
			
			// Mesmo resultado do teste de cima
			System.out.println(e.getLocalizedMessage());
			
			// Pega o nome da classe de erro
			System.out.println(e.getClass().getName());
			
			// Retorna a stack como um array de erros
			for (StackTraceElement error : e.getStackTrace()) {
				System.out.println(error.getClassName());
				System.out.println(error.getFileName());
				System.out.println(error.getLineNumber());
				System.out.println(error.getMethodName());
				System.out.println(error.getModuleName());
				System.out.println(error.getClassLoaderName());
			}
		}
	}
}
