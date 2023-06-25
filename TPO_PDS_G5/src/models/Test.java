package models;
import models.Socio.*;
import strategies.Notificador;
import models.Modificador;
import models.Ejemplar.Ejemplar;

import java.sql.Date;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import adapters.Ubicacion;
import controllers.ControllerEjemplar;
import controllers.ControllerSocio;
import enumerations.MedioComunicacion;
import enumerations.MedioComunicacion;

public class Test {

	public static void main(String[] args) {
		
		Scanner sc= new Scanner(System.in);
		
		Modificador modificador=new Modificador();
		
		Notificador notificador = new Notificador();
		
		MedioComunicacion medio= MedioComunicacion.EMAIL  ;

		ArrayList<Prestamo> prestamosActivos=new ArrayList<Prestamo>();
		
		ArrayList<Prestamo> historiaPrestamos=new ArrayList<Prestamo>();

		Ubicacion ubicacion=new Ubicacion ( 1, 2 ) ;
		
		Date fecha = Date.valueOf("1987-02-15");
		
		Revista revista=new Revista("15" , "hola", "Alberto" , fecha , ubicacion );
		
		ArrayList<Ejemplar> listaEjemplares=new ArrayList<Ejemplar>();
		
		ControllerEjemplar.obtenerInstancia().setEjemplares(listaEjemplares);
		
		ControllerEjemplar.obtenerInstancia().nuevoEjemplar(revista);
		
		
		Ejemplar ejemplar = new Ejemplar ("15" , "hola ", "Alberto" , fecha , ubicacion , 10);
		
		Socio socio=new Socio("Lionel","Messi",12345678,"capo@gmail.com","44335126",medio,historiaPrestamos,prestamosActivos,modificador);
		
		ArrayList<Socio> listaSocios=new ArrayList<Socio>();
		
		ControllerSocio.obtenerInstancia().setSocios(listaSocios);
		
		ControllerSocio.obtenerInstancia().nuevoSocio(socio);
		
		
		
		Prestamo prestamo = new Prestamo (ejemplar, socio);
	
		
		System.out.println("Ingrese accion a realizar : ");
		System.out.println("Salir del sistema = 0 ");
		System.out.println("Cargar nuevos socios = 1 ");
		System.out.println("Cargar ejemplares = 2 ");
		System.out.println("Buscar ejemplares = 3 ");
		System.out.println("Actualizar el estado de ejemplares prestados = 4 ");
		System.out.println("Actualizar parametros de prestamos= 5 ");
		System.out.println("Notificar a socios acerca de situaciones particulares= 6 ");
		System.out.println("Visualizar el historial de prestamos de un socio= 7 ");
		
		
		String str=  sc.nextLine();              //Lee el input de la consola
		while (!str.equals("0")) {
			switch(str){
			case "1":
				ArrayList<Socio> socios = ControllerSocio.obtenerInstancia().getSocios();
				ArrayList<Socio> copiaSocios= new ArrayList<Socio> (ControllerSocio.obtenerInstancia().getSocios());
				while(!copiaSocios.isEmpty()) {
					Socio primero=copiaSocios.get(0);
					System.out.println(primero.getDni());
					copiaSocios.remove(0);
				}
				System.out.println("hola");
				break;
			case "2":
				
				ArrayList<Ejemplar> ejemplares= ControllerEjemplar.obtenerInstancia().getEjemplares();
				ArrayList<Ejemplar> copiaEjemplares= new ArrayList<Ejemplar> (ControllerEjemplar.obtenerInstancia().getEjemplares());
				while(!copiaEjemplares.isEmpty()) {
					Ejemplar primero=copiaEjemplares.get(0);
					System.out.println(primero.getAutor());
					copiaEjemplares.remove(0);
				}
				System.out.println("hola");
				
				System.out.println("chau");
				break;
			case "3":
				ArrayList<Ejemplar> busquedaEjemplares= ControllerEjemplar.obtenerInstancia().getEjemplares();
				ArrayList<Ejemplar> busquedaCopiaEjemplares= new ArrayList<Ejemplar> (ControllerEjemplar.obtenerInstancia().getEjemplares());
				Scanner nuevoScanner= new Scanner(System.in);
				System.out.println("Ingrese busqueda a realizar : ");
				System.out.println("Salir del sistema = 0 ");
				System.out.println("Busqueda por Id = 1 ");
				System.out.println("Busqueda por Autor = 2 ");
				System.out.println("Busqueda por Titulo = 3 ");
				
				String busqueda=  nuevoScanner.nextLine();
				
				switch(busqueda){
					case "1":
						
						System.out.println("Ingrese el Id: ");
						
						Scanner scannerId= new Scanner(System.in);
						
						String idString=  scannerId.nextLine();
						
						int flagId=-1;

						while(!busquedaCopiaEjemplares.isEmpty()) {
							Ejemplar primero=busquedaCopiaEjemplares.get(0);
							if (primero.getId().equals(idString)) {
								System.out.println(primero.getAutor());
								flagId=0;
							
							}
							

							break;
						}
						
						
						if(flagId==-1) {
							System.out.println("No encontrado");
						}
							
						
						
						break;
						
					case "2":
						
						System.out.println("Ingrese el Autor: ");
						
						Scanner scannerAutor= new Scanner(System.in);
						
						String AutorString=  scannerAutor.nextLine();
						
						int flagAutor=-1;
						
						while(!busquedaCopiaEjemplares.isEmpty()) {
							Ejemplar primero=busquedaCopiaEjemplares.get(0);
							if (primero.getAutor().equals(AutorString)) {
								System.out.println(primero.getAutor());
							
							}
							
							flagAutor=0;
						
							break;
						}
						
						if(flagAutor==-1)
							System.out.println("No encontrado");
						
						break;
						
					case "3": 
						
						System.out.println("Ingrese el Titulo: ");
						
						Scanner scannerTitulo= new Scanner(System.in);
						
						String TituloString=  scannerTitulo.nextLine();
						
						int flagTitulo=-1;
						
						while(!busquedaCopiaEjemplares.isEmpty()) {
							Ejemplar primero=busquedaCopiaEjemplares.get(0);
							if (primero.getTitulo().equals(TituloString)) {
								System.out.println(primero.getTitulo());
							
							}
							
							flagTitulo=0;
						
							break;
							
							
						}
						
						if(flagTitulo==-1)
							System.out.println("No encontrado");
						
						break;
						
						
				
						
					default:
						System.out.println("Ingrese un comando valido");
				}
				
				
				
				
				break;
			
			case "4": 
				
				
				
				Scanner scannerPrestamo= new Scanner(System.in);
				System.out.println("Ingrese comando a realizar : ");
				System.out.println("Salir del sistema = 0 ");
				System.out.println("Solicitar Prestamo = 1 ");
				System.out.println("Realizar Devolucion = 2 ");
				
				String comandoPrestamo=  scannerPrestamo.nextLine();
				
				switch(comandoPrestamo){
					case "1":
						
						Socio socioRealizaDevolucion = ControllerSocio.obtenerInstancia().buscarSocio(12345678);
						Ejemplar EjemplarDevuelto = ControllerEjemplar.obtenerInstancia().buscarEjemplarId("15");
						
						Prestamo prestamoFinal = ControllerSocio.obtenerInstancia().SolicitarPrestamo(EjemplarDevuelto, socioRealizaDevolucion);
						
						if (prestamoFinal.equals(null)) {
							System.out.println("No se ha podido realizar el prestamo");
						}
					
						else {
							String mensaje = prestamoFinal.toString();
							System.out.println(mensaje);
						}
						
						break;
				
					case "2":
						
						break;


				
				}
				
			case "5":
				
				
				
				
				break;
				
			case "7":
				
				
				ArrayList<Prestamo> copiaHistorialPrestamos=new ArrayList<Prestamo>(ControllerSocio.obtenerInstancia().getSocios().get(0).getHistoriaPrestamos());
				while(!copiaHistorialPrestamos.isEmpty()) {
					Prestamo primerPrestamo=copiaHistorialPrestamos.get(0);
					System.out.println(primerPrestamo.getEjemplar().getAutor());
					copiaHistorialPrestamos.remove(0);
					
				}
				
				break;
				
			default:
				System.out.println("Ingrese un comando valido");	
			}
			System.out.println("Desea continuar ? Pulse 0 para salir / escriba otra cosa para continuar");
			str=  sc.nextLine();
			if(!str.equals("0")) {
				System.out.println("Ingrese accion a realizar : ");
				System.out.println("Cargar nuevos socios = 1 ");
				System.out.println("Cargar ejemplares = 2 ");
				System.out.println("Buscar ejemplares = 3 ");
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
