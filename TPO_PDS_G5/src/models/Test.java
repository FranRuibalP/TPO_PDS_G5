package models;
import models.Socio.*;
import strategies.Notificador;
import models.Ejemplar.Ejemplar;

import java.sql.Date;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import adapters.Ubicacion;
import controllers.ControllerEjemplar;
import controllers.ControllerPrestamo;
import controllers.ControllerSocio;
import enumerations.MedioComunicacion;
import strategies.Notificacion;

public class Test {

	public static void main(String[] args) {

		ControllerEjemplar instanciaEjemplar=ControllerEjemplar.instanciaEjemplar();
		ControllerPrestamo instanciaPrestamo= ControllerPrestamo.obtenerInstancia();
		ControllerSocio instanciaSocio=ControllerSocio.obtenerInstancia();
		
		Scanner sc= new Scanner(System.in);
		
		Modificador modificador=new Modificador();
		
		MedioComunicacion medio= MedioComunicacion.EMAIL  ;
		
		MedioComunicacion medio2= MedioComunicacion.SMS  ;
		MedioComunicacion medio3= MedioComunicacion.WHATSAPP  ;
		
		

		ArrayList<Prestamo> prestamosActivos=new ArrayList<Prestamo>();

		ArrayList<Prestamo> historiaPrestamos=new ArrayList<Prestamo>();

		Ubicacion ubicacion=new Ubicacion ( 1, 2 ) ;
		
		Date fecha = Date.valueOf("1987-02-15");


		Ejemplar revista=new Revista("15" , "Hola", "Alberto" , fecha , ubicacion );

		Ejemplar libro=new Libro("11" , "Gaturro", "Nik" , fecha , ubicacion );

		Ejemplar diario=new Diario("12" , "Clarin", "Franco" , fecha , ubicacion );
		
		ArrayList<Ejemplar> listaEjemplares=new ArrayList<Ejemplar>();
		instanciaEjemplar.setEjemplares(listaEjemplares);
		instanciaEjemplar.nuevoEjemplar(revista);
		instanciaEjemplar.nuevoEjemplar(libro);
		instanciaEjemplar.nuevoEjemplar(diario);


		Socio socio = new Socio("Lionel","Messi",33016244,"lmessi@gmail.com","44335126",medio,historiaPrestamos,prestamosActivos,modificador);

		Socio socio2 = new Socio("Agustina","Perez",42340231,"aperez@gmail.com","44335121",medio3,historiaPrestamos,prestamosActivos,modificador);

		Socio socio3 = new Socio("Diego","Maradona",14332134,"dmaradona@gmail.com","34920132",medio2,historiaPrestamos,prestamosActivos,modificador);

		ArrayList<Socio> listaSocios=new ArrayList<Socio>();
		instanciaSocio.setSocios(listaSocios);
		instanciaSocio.nuevoSocio(socio);
		instanciaSocio.nuevoSocio(socio2);
		instanciaSocio.nuevoSocio(socio3);

		Prestamo prestamo = new Prestamo (revista, socio);

		Prestamo prestamo2 = new Prestamo (diario, socio2);

		Prestamo prestamo3 = new Prestamo (libro, socio3);

		ArrayList<Prestamo> listaPrestamos=new ArrayList<Prestamo>();
		instanciaPrestamo.setPrestamos(listaPrestamos);
		instanciaPrestamo.nuevoPrestamo(prestamo);
		instanciaPrestamo.nuevoPrestamo(prestamo2);
		instanciaPrestamo.nuevoPrestamo(prestamo3);

		historiaPrestamos.add(prestamo);
		
		
		Notificador notificador=new Notificador();
		
		notificador.Cambio(medio3);

		Notificacion notificacion = new Notificacion(fecha,"Se acerca fecha","Vencimiento",socio.getTelefono(),socio.getMail());
		
		notificador.setNotificacion(notificacion);
		
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
				
				System.out.println("Ingrese el nombre : ");
				String nombre=  sc.nextLine();
				System.out.println("Ingrese el apellido: ");
				String apellido=  sc.nextLine();
				System.out.println("Ingrese el dni : ");
				int dni=  Integer.parseInt(sc.nextLine()) ;
				System.out.println("Ingrese el mail: ");
				String mail=  sc.nextLine();
				System.out.println("Ingrese el telefono : ");
				String telefono=  sc.nextLine();
				System.out.println("Ingrese el medio comunicacion : ");
				String medioSocio=  sc.nextLine().toUpperCase();
				
				List<Prestamo> nuevaListaSocio = null;
				
				Socio nuevoSocioSistema=new Socio(nombre,apellido,dni,mail,telefono,MedioComunicacion.valueOf(medioSocio),
						nuevaListaSocio,nuevaListaSocio,new Modificador());
				
				instanciaSocio.nuevoSocio(nuevoSocioSistema);

				ArrayList<Socio> copiaSocios= new ArrayList<Socio> (instanciaSocio.getSocios());
				while(!copiaSocios.isEmpty()) {
					Socio primero=copiaSocios.get(0);
					System.out.println(primero.toString());
					copiaSocios.remove(0);
				}

				break;
			case "2":
				
				
				System.out.println("Ingrese el id : ");
				String id=  sc.nextLine();
				System.out.println("Ingrese el titulo: ");
				String titulo=  sc.nextLine();
				System.out.println("Ingrese el autor : ");
				String autor=  sc.nextLine() ;
				System.out.println("Ingrese la fecha : ");
				Date fechaPublicacion=  Date.valueOf(sc.nextLine() );
				
				
				Ejemplar ejemplarNuevo=new Ejemplar(id,titulo,autor,fechaPublicacion,new Ubicacion(3,4));
				
				instanciaEjemplar.nuevoEjemplar(ejemplarNuevo);
				
				ArrayList<Ejemplar> copiaEjemplares= new ArrayList<Ejemplar> (instanciaEjemplar.getEjemplares());
				while(!copiaEjemplares.isEmpty()) {
					Ejemplar primero=copiaEjemplares.get(0);
					System.out.println(primero.toString());
					copiaEjemplares.remove(0);
				}
				System.out.println("hola");
				
				System.out.println("chau");
				break;
			case "3":
				ArrayList<Ejemplar> busquedaEjemplares= instanciaEjemplar.getEjemplares();
				ArrayList<Ejemplar> busquedaCopiaEjemplares= new ArrayList<Ejemplar> (instanciaEjemplar.getEjemplares());
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
								System.out.println(primero.toString());
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
								System.out.println(primero.toString());
							
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
								System.out.println(primero.toString());
							
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
						
						Socio socioRealizaDevolucion=instanciaSocio.buscarSocio(33016244);
						
						Ejemplar EjemplarDevuelto = instanciaEjemplar.buscarEjemplarId("15");
						
						Prestamo prestamoFinal = instanciaSocio.SolicitarPrestamo(EjemplarDevuelto, socioRealizaDevolucion);
						
						prestamoFinal.setDiasTranscurridos(25);
						
						if (prestamoFinal.equals(null)) {
							System.out.println("No se ha podido realizar el prestamo");
						}
					
						else {
							String mensaje = prestamoFinal.toString();
							System.out.println(mensaje);
						}
						
						break;
				
					case "2":
						Socio socioRealizaDevolucion2 = instanciaSocio.buscarSocio(33016244);
						Ejemplar EjemplarDevuelto2 = instanciaEjemplar.buscarEjemplarId("15");
						
						
						
						Prestamo prestamoFinal2 = instanciaSocio.SolicitarPrestamo(EjemplarDevuelto2, socioRealizaDevolucion2);
						
						prestamoFinal2.setDiasTranscurridos(8);
						
						prestamoFinal2.devolver();
						
						
						System.out.println(prestamoFinal2.toString());
						
						Modificador mod=prestamoFinal2.getSocio().getModificador();
						
						System.out.println("Dias penalizados: " + mod.getDias());
						System.out.println("Prestamos en tiempo: " + mod.getPrestamosEnTiempo());
						
						
						
						break;


				
				}
				
				break;
				
			case "5":
				
				Scanner scannerLibrito= new Scanner(System.in);
				

				String cambioLibro=  scannerLibrito.nextLine();
				
				switch(cambioLibro){
					case "Diario":
						
						Diario diario2 = new Diario();
						
						System.out.println("Ingrese la cantidad de dias: "); 
						
						Scanner cantidadDias= new Scanner(System.in);
						
						String cambiarDias=  cantidadDias.nextLine();
						
						diario2.setDiasPrestamo( Integer.parseInt(cambiarDias) );
						
						System.out.println(diario.getDiasPrestamo());
						
						break;
						
				}

				break;
				
			case"6":
				
				Socio socioRealizaDevolucion2 = instanciaSocio.buscarSocio(14332134);
				Ejemplar EjemplarDevuelto2 = instanciaEjemplar.buscarEjemplarId("11");
				
				Prestamo prestamoFinal2 = instanciaSocio.SolicitarPrestamo(EjemplarDevuelto2, socioRealizaDevolucion2);
				
				for(int i=0;i<10;i++) {
					prestamoFinal2.setDiasTranscurridos(prestamoFinal2.getDiasTranscurridos()+1);
					System.out.println("Dia: " + i);
					if (prestamoFinal2.getDiasPrestamo()-1==prestamoFinal2.getDiasTranscurridos()) {
						
						prestamoFinal2.setNotificador(notificador);
						
						instanciaPrestamo.notificar(prestamoFinal2);

						
					}
					
				}
				
				
				break;
				
				
			case "7":
				
				List<Prestamo> historialPrestamosimprimir =  instanciaSocio.buscarSocio(33016244).getHistoriaPrestamos();
				
				
				for(Prestamo prestamofor : historialPrestamosimprimir) {
					System.out.println(prestamofor.toString());
					
					
					
				}
				
				
				
				break;
				
			default:
				System.out.println("Ingrese un comando valido");	
			}
			System.out.println("Desea continuar ? Pulse 0 para salir / escriba otra cosa para continuar");
			str=  sc.nextLine();
			if(!str.equals("0")) {
				System.out.println("Ingrese accion a realizar : ");
				System.out.println("Salir del sistema = 0 ");
				System.out.println("Cargar nuevos socios = 1 ");
				System.out.println("Cargar ejemplares = 2 ");
				System.out.println("Buscar ejemplares = 3 ");
				System.out.println("Actualizar el estado de ejemplares prestados = 4 ");
				System.out.println("Actualizar parametros de prestamos= 5 ");
				System.out.println("Notificar a socios acerca de situaciones particulares= 6 ");
				System.out.println("Visualizar el historial de prestamos de un socio= 7 " + "\n" );
				str=  sc.nextLine();
			}
		}

	}

	
}
