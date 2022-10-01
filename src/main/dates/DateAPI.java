package main.dates;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class DateAPI {

	public static void main(String[] args) {
		LocalDate currentDate = LocalDate.now();
		System.out.println(currentDate);
		
		LocalTime currentTime = LocalTime.now();
		System.out.println(currentTime);
		
		LocalDateTime now = LocalDateTime.now();
		System.out.println(now);
		
		System.out.println(now.format(DateTimeFormatter.ISO_DATE));
		System.out.println(now.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
		System.out.println(now.format(DateTimeFormatter.ISO_DATE_TIME));
		
		
		System.out.println(now + " + 5 minutos eh igual a " + now.plusMinutes(5));
		
		LocalDate today = LocalDate.now();
		System.out.println("Amanha sera " + today.plusDays(1));
		System.out.println("Ontem foi " + today.minusDays(1));
	}

}
