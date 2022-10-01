package main.dates;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class InstantClass {

	public static void main(String[] args) throws InterruptedException {
		Instant start = Instant.now();
		
		Thread.sleep(2000);
		
		Instant end = Instant.now();
		
		Duration duration = Duration.between(start, end);
		
		System.out.println("Duracao em segundos: " + duration.toSeconds());
		System.out.println("Duracao em milisegundos: " + duration.toMillis());
	}
	
}
