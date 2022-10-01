package main.dates;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class CalendarClass {

	public static void main(String[] args) {
		Calendar calendar = Calendar.getInstance();
		
		System.out.println(calendar.get(Calendar.DAY_OF_MONTH)); // Dia do mes
		System.out.println(calendar.get(Calendar.DAY_OF_WEEK)); // Dia da semana em numero (comeca no 1)
		System.out.println(calendar.get(Calendar.HOUR)); // Hora Atual
		System.out.println(calendar.get(Calendar.HOUR_OF_DAY));
		System.out.println(calendar.get(Calendar.MINUTE)); // Minuto da hora atual
		System.out.println(calendar.get(Calendar.SECOND)); // Segundos da hora atual
		System.out.println(calendar.get(Calendar.MILLISECOND)); // Milisegundos da hora atual
		System.out.println(calendar.getTime().getTime());
		
		calendar.setTime(new Date(122, 4, 21));
		
		SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd");
		System.out.println(formater.format(calendar.getTime()));
		
		calendar.add(Calendar.DAY_OF_MONTH, 5);
		System.out.println(formater.format(calendar.getTime()));
		
		calendar.add(Calendar.DAY_OF_MONTH, 40);
		System.out.println(formater.format(calendar.getTime()));
		
		calendar.add(Calendar.DAY_OF_MONTH, 400);
		System.out.println(formater.format(calendar.getTime()));
		
		calendar.add(Calendar.MONTH, 2);
		System.out.println(formater.format(calendar.getTime()));
		
		calendar.add(Calendar.YEAR, 1);
		System.out.println(formater.format(calendar.getTime()));
		
		calendar.add(Calendar.DAY_OF_MONTH, -50);
		System.out.println(formater.format(calendar.getTime()));
	}

}
