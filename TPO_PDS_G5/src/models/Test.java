package models;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LocalDate date = LocalDate.now();
		LocalDate date2 = date.plusDays(2000);
		//necesito un metodo que me devuelva la diferencia de dias entre dos dates

		long diferenciaEnDias = ChronoUnit.DAYS.between(date, date2);
		System.out.println("Diferencia en días: " + diferenciaEnDias);

		System.out.println(date2);
	}

}
