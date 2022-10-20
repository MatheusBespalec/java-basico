package main.bin;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import main.classes.Class;
import main.classes.Course;
import main.classes.Student;
import main.classes.Teacher;

public class StreamTests {

	public static void main(String[] args) {
		Course course  = courseDataProvider();
		
		// as streams nao afetam a colletion original
		
		Collection<Class> classes = course.getClasses();
		// Collection<Class> longClasses
		System.out.println("Lista de cursos com mais de 15 minutos:");
		classes.stream()
			.filter(classOfCourse -> classOfCourse.getDuration() > 15)
			.forEach(classOfCourse -> System.out.println(classOfCourse.getTitle()));
		
		System.out.println("-----------------------------------");
		
		Double courseDuration = classes.stream()
			.mapToDouble(Class::getDuration)
			.sum();
		
		System.out.println("A duracao do curso de " + course.getName() + " e de " + courseDuration + " minutos.");
		
		Optional<Class> optionalClassOfCourse = classes.stream()
			.filter(classOfCourse -> classOfCourse.getDuration() > 15)
			// .findAny() // Devolve qualuqer um
			.findFirst(); // devolve o promeiro
		
		// Um optional pode conter uma classe ou null
		optionalClassOfCourse.ifPresent(classOfCourse -> System.out.println(classOfCourse.getTitle())); // Se estiver presente realiza a acai
		optionalClassOfCourse.get(); // Se o valor estiver presente o retorna, caso contrario lanca uma excecao
		optionalClassOfCourse.orElse(null); // Se o valor estiver presente o retorna, caso contrario retorna o valor passado por parametro
		
		classes.stream()
			.filter(classOfCourse -> classOfCourse.getDuration() > 15)
			.findAny()
			.ifPresent(classOfCourse -> System.out.println("Existe ao menos uma aula com mais de 15 m de duracao"));
		
		List<Class> listOfLongClasses =  classes.stream()
			.filter(classOfCourse -> classOfCourse.getDuration() > 15)
			.collect(Collectors.toList()); // atraves do collect podemos obter realmente uma lista/collection/map com estes objetos filtrados
		
		classes.stream()
			.filter(classOfCourse -> classOfCourse.getDuration() > 15)
			.collect(Collectors.toMap(Class::getTitle, Class::getDuration))
			.forEach((name, duration) -> System.out.println("A aula " + name + " possui " + duration + "m  de duracao"));
		
	}
	
	
	public static Course courseDataProvider() {
		Course course = new Course("Java", new Teacher("Roberto"));
		
		// Adicionar Aulas
		course.addClass(new Class("Tipos de Dados", 10.0))
			.addClass(new Class("Estruturas Condicionais", 12.0))
			.addClass(new Class("Estruturas de Repeticao", 20.0))
			.addClass(new Class("Orientacao a Objetos", 20.0));
		
		// Matricular Estudantes
		course.addStudent(new Student("Alfredo"))
			.addStudent(new Student("Rafael"))
			.addStudent(new Student("Bruno"))
			.addStudent(new Student("Fernanda"))
			.addStudent(new Student("Gustavo"))
			.addStudent(new Student("Pedro"))
			.addStudent(new Student("Larissa"));
		
		return course;
	}
}
