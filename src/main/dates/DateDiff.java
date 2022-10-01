package main.dates;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.temporal.ChronoUnit;

public class DateDiff {

	public static void main(String[] args) {
		long diff = ChronoUnit.DAYS.between(LocalDate.parse("2022-09-21"), LocalDate.parse("2022-09-25"));
		System.out.println(diff);
		
		long diff2 = ChronoUnit.DAYS.between(LocalDate.parse("2021-09-21"), LocalDate.parse("2022-09-25"));
		System.out.println(diff2);
		
		long diff3 = ChronoUnit.DAYS.between(LocalDate.parse("2022-10-05"), LocalDate.parse("2022-09-25"));
		System.out.println(diff3);
		
		long diff4 = ChronoUnit.MONTHS.between(LocalDate.parse("2023-09-21"), LocalDate.parse("2022-09-25"));
		System.out.println(diff4);
		
		long diff5 = ChronoUnit.HOURS.between(LocalDateTime.parse("2022-09-25T18:00:00"), LocalDateTime.parse("2022-09-25T22:00:00"));
		System.out.println(diff5);
		
		long diff6 = ChronoUnit.HOURS.between(LocalDateTime.parse("2022-09-25T18:14:00"), LocalDateTime.parse("2022-09-25T22:00:00"));
		System.out.println(diff6);
		
		long diff7 = ChronoUnit.MINUTES.between(LocalDateTime.parse("2022-09-25T18:14:00"), LocalDateTime.parse("2022-09-25T22:00:00"));
		System.out.println(diff7);
		
		System.out.println("----------------------------");
		
		LocalDate date1 = LocalDate.of(2022, 11, 10);
		LocalDate date2 = LocalDate.of(2020, 5, 21);
		
		Period period = Period.between(date2, date1);
		
		System.out.println(period.getYears() + " anos " + period.getMonths() + " meses e " + period.getDays());
		System.out.println(period.toTotalMonths());
	}

}
