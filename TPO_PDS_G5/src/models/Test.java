package models;
import models.Socio.*;
import strategies.NotificacionStrategy;
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
import controllers.ControllerPrestamo;
import controllers.ControllerSocio;
import enumerations.MedioComunicacion;
import enumerations.MedioComunicacion;
import strategies.Notificacion;

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
		
		Ejemplar revista=new Revista("15" , "hola", "Alberto" , fecha , ubicacion );
		
		ArrayList<Ejemplar> listaEjemplares=new ArrayList<Ejemplar>();
		
		ControllerEjemplar.obtenerInstancia().setEjemplares(listaEjemplares);
		
		ControllerEjemplar.obtenerInstancia().nuevoEjemplar(revista);
		
		
		Socio socio=new Socio("Lionel","Messi",12345678,"capo@gmail.com","44335126",medio,historiaPrestamos,prestamosActivos,modificador);
		
		ArrayList<Socio> listaSocios=new ArrayList<Socio>();
		
		ControllerSocio.obtenerInstancia().setSocios(listaSocios);
		
		ControllerSocio.obtenerInstancia().nuevoSocio(socio);
		
		ControllerSocio instanciaSocio=ControllerSocio.obtenerInstancia();
		
		ControllerPrestamo instanciaPrestamo= ControllerPrestamo.obtenerInstancia();
		
		
		Prestamo prestamo = new Prestamo (revista, socio);
		
		historiaPrestamos.add(prestamo);
		
		
		Notificador contexto=new Notificador();
		
		contexto.Cambio(medio);

		
		
		/*
		 * private String mensaje;
	private Date fecha;
	private String motivo;
	private String telefono;
	private String email;
		 */
		
		Notificacion notificacion = new Notificacion(fecha,"hola","prueba",socio.getTelefono(),socio.getMail());
		
		contexto.setNotificacion(notificacion);
		
		System.out.println(contexto.getNotificacion().toString());
		System.out.println(contexto.getEstrategia());
		
		//contexto.setEstrategia(socio.getMedio());
	
		
		
		
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
						
						prestamoFinal.setDiasTranscurridos(15);
						
						if (prestamoFinal.equals(null)) {
							System.out.println("No se ha podido realizar el prestamo");
						}
					
						else {
							String mensaje = prestamoFinal.toString();
							System.out.println(mensaje);
						}
						
						break;
				
					case "2":
						Socio socioRealizaDevolucion2 = ControllerSocio.obtenerInstancia().buscarSocio(12345678);
						Ejemplar EjemplarDevuelto2 = ControllerEjemplar.obtenerInstancia().buscarEjemplarId("15");
						
						
						
						Prestamo prestamoFinal2 = ControllerSocio.obtenerInstancia().SolicitarPrestamo(EjemplarDevuelto2, socioRealizaDevolucion2);
						
						prestamoFinal2.setDiasTranscurridos(200);
						
						prestamoFinal2.devolver();
						
						
						System.out.println(prestamoFinal2.toString());
						
						Modificador mod=prestamoFinal2.getSocio().getModificador();
						
						
						
						break;


				
				}
				
				break;
				
			case "5":
				
				System.out.println("Que tipo desea: Revista, Diario, Revista Especial, Libro");
				
				System.out.println("Que tipo desea: Revista, Diario, Revista Especial, Libro");
				
				Scanner scannerLibrito= new Scanner(System.in);
				

				String cambioLibro=  scannerLibrito.nextLine();
				
				switch(cambioLibro){
					case "Diario":
						
						Diario diario = new Diario();
						
						System.out.println("Ingrese la cantidad de dias: "); 
						
						Scanner cantidadDias= new Scanner(System.in);
						
						String cambiarDias=  cantidadDias.nextLine();
						
						diario.setDiasPrestamo( Integer.parseInt(cambiarDias) );
						
						System.out.println(diario.getDiasPrestamo());
						
						break;
						
				}

				break;
				
			case"6":
				
				Socio socioRealizaDevolucion2 = ControllerSocio.obtenerInstancia().buscarSocio(12345678);
				Ejemplar EjemplarDevuelto2 = ControllerEjemplar.obtenerInstancia().buscarEjemplarId("15");
				
				Prestamo prestamoFinal2 = ControllerSocio.obtenerInstancia().SolicitarPrestamo(EjemplarDevuelto2, socioRealizaDevolucion2);
				
				for(int i=0;i<10;i++) {
					prestamoFinal2.setDiasTranscurridos(prestamoFinal2.getDiasTranscurridos()+1);
					System.out.println(prestamoFinal2.getDiasTranscurridos());
					System.out.println(prestamoFinal2.getDiasPrestamo());
					if (i==8) { //prestamoFinal2.getDiasTranscurridos()==prestamoFinal2.getDiasPrestamo()-1) {
						System.out.println("dasd");
						
						prestamoFinal2.setNotificador(contexto);
						
						instanciaPrestamo.notificar(prestamoFinal2);

						
					}
					
				}
				
				
				break;
				
				
			case "7":
				
				List<Prestamo> historialPrestamosimprimir =  instanciaSocio.buscarSocio(12345678).getHistoriaPrestamos();
				
				
				for(Prestamo prestamofor : historialPrestamosimprimir) {
					System.out.println(prestamofor.getEjemplar().getAutor());
					
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
