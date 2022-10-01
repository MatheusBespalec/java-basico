package main.dates;

import java.util.Date;

public class DateClass {

	public static void main(String[] args) {
		Date date = new Date();
		System.out.println(date); // Imprime no formato Sun Sep 25 08:11:28 BRT 2022
		
		System.out.println(date.getDate()); // dia do mes
		System.out.println(date.getDay()); // Dia da semana (Obs: comeca em 0)
		System.out.println(date.getHours()); // Hora Atual
		System.out.println(date.getMinutes()); // Minutos da hora atual.
		System.out.println(date.getSeconds()); // Segundos  da hora atual
		System.out.println(date.getTime()); // Data atual em milisegundos
		System.out.println(date.getTimezoneOffset());
		System.out.println(date.toGMTString()); // Data atual no formato 25 Sep 2022 11:19:06 GMT
		System.out.println(date.toLocaleString()); // Data atual em string de acordo com o formato local

		Date date2 = new Date(120, 5, 4); // O Ano deve ser passado contando a partir de 1900
		System.out.println(date2.toLocaleString());
		System.out.println(date.after(date2));
		
		Date date3 = new Date(120, 5, 4);
		Date date4 = new Date(119, 5, 4);
		System.out.println(date2.compareTo(date)); // Quando a data for maior retorna -1
		System.out.println(date2.compareTo(date3)); // Quando a data for igual retorna 0
		System.out.println(date2.compareTo(date4)); // Quando a data for menor retorna 1
	}

}
