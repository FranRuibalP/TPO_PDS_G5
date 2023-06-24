package models;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class Test {

	public static void main(String[] args) {
		
		Scanner sc= new Scanner(System.in);
		System.out.println("Ingrese accion a realizar : ");
		System.out.println("Salir del sistema = 0 ");
		System.out.println("Ejecutar primer comando = 1 ");
		System.out.println("Ejecutar segundo comando = 2 ");
		String str=  sc.nextLine();              //Lee el input de la consola
		while (!str.equals("0")) {
			switch(str){
			case "1":
				System.out.println("hola");
				break;
			case "2":
				System.out.println("chau");
				break;
			default:
				System.out.println("Ingrese un comando valido");	
			}
			System.out.println("Desea continuar ? Pulse 0 para salir / escriba otra cosa para continuar");
			str=  sc.nextLine();
			if(!str.equals("0")) {
				System.out.println("Ingrese accion a realizar : ");
				System.out.println("Ejecutar primer comando = 1 ");
				System.out.println("Ejecutar segundo comando = 2 ");
			}
		}
		/*
		LocalDate date = LocalDate.now();
		LocalDate date2 = date.plusDays(2000);

		long diferenciaEnDias = ChronoUnit.DAYS.between(date, date2);
		System.out.println("Diferencia en días: " + diferenciaEnDias);

		System.out.println(date2);
		*/
	}

}
