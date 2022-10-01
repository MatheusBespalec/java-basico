package main.dates;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SimpleDateFormatClass {
	public static void main(String[] args) throws ParseException {
		Date now = new Date();
		SimpleDateFormat formater = new SimpleDateFormat("dd/MM/yyyy");
		/*
		System.out.println(formater.format(now));
		System.out.println(formater.format(formater.parse("22/14/2022")));
		if (now.after(formater.parse("22/07/2022"))) {
			System.out.println("Boleto nao vencido");
		} else {
			System.out.println("Boleto vencido");
		}
		*/
		System.out.println(formater.parse("01/222/2022"));
	}
}
