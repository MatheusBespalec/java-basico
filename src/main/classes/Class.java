package main.classes;

public class Class {
	String title;
	Double duration;
	
	public Class(String title, Double duration) {
		this.title = title;
		this.duration = duration;
	}
	
	public String getTitle() {
		return title;
	}
	
	public Double getDuration() {
		return duration;
	}
}
