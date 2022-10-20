package main.classes;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashSet;

public class Course {
	String name;
	Teacher teacher;
	Collection<Class> classes = new LinkedHashSet<Class>();
	Collection<Student> students = new HashSet<Student>();
	
	public Course(String name, Teacher teacher) {
		this.name = name;
		this.teacher = teacher;
	}
	
	public Course addStudent(Student student) {
		this.students.add(student);
		return this;
	}
	
	public Course addClass(Class classOfCourse) {
		this.classes.add(classOfCourse);
		return this;
	}
	
	public Collection<Class> getClasses() {
		return Collections.unmodifiableCollection(this.classes);
	}
	
	public Collection<Student> getStudents() {
		return Collections.unmodifiableCollection(this.students);
	}
	
	public Teacher getTeacher() {
		return teacher;
	}
	
	public String getName() {
		return name;
	}
}
