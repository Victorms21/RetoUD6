package retoUd6;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CluedoJugando {

	private static Scanner sc = new Scanner (System.in);
	private static List<Jugador> listaJugadores = new ArrayList<>();
	private static String arrayPersonajes[] = {"Amapola","Celeste", "Prado","Mora", "Rubio" , "Blanco"};
	private static String arrayArmas[]= {"Bate" , "Pistola" , "Candelabro", "Cuchillo" ,"Cuerda", "Hacha", "Pesa", "Veneno", "Trofeo"};
	private static String arrayLugares[]= {"Casa de invitados", "Teatro", "Spa", "Observatorio", "Terraza","Salón","Cocina", "Vestíbulo"};
	
	public static void main(String[] args) {


		MensajeBienvenida();
		do {
			System.out.println("Los personajes son:");
			MostrarArrays(arrayPersonajes);
			System.out.println("Las armas son:");
			MostrarArrays(arrayArmas);
			System.out.println("Los lugares son:");
			MostrarArrays(arrayLugares);
			PreguntarSobreIncluir();
			while(BarajarCartas()==false);
			preguntarSobreMostrarCartas();
		} while (preguntarSobreSeguir());
		GuardarEnFichero();
		mostrarDespedida();
		sc.close();
		
	}
	
	public static void MensajeBienvenida() {
		
		System.out.println("|||||||||||||||||||||||||||||||||||||||||||||\n"
														+"||||| Bienvenido a Cluedo |||||\n"
														+"|||||||||||||||||||||||||||||||||||||\n");
														
		System.out.println("Las cartas se barajarán de forma automática. \n");
	}
	
	public static void PreguntarSobreIncluir() {
		String respuesta="", incluir= "";
		int opcion=0, inclusiones=0;
		    do {
		    	 try { 
		    		   System.out.println("¿Deseas añadir algo a alguna de las listas mostradas? Responde (Sí/No):");
		    		   respuesta = sc.next();
		    	 }catch(Exception e) {
		    		 System.out.println("Ha ocurrido un error.");
		    	 }
		   if(respuesta.equalsIgnoreCase("Sí")==false && respuesta.equalsIgnoreCase("Sí")== false && respuesta.equalsIgnoreCase("No")==false) {
			   		System.out.println("Solo se puede introducir Sí o No");
		   }
		   }while(respuesta.equalsIgnoreCase("Sí")==false && respuesta.equalsIgnoreCase("Sí")==false && respuesta.equalsIgnoreCase("No")==false);
		    
		if(respuesta.equalsIgnoreCase("Sí") || respuesta.equalsIgnoreCase("Sí")) {
			while(incluir.equalsIgnoreCase("No")==false) {
				do {
					 try {
						 System.out.println("¿A que categoría quiere añadir un elemento?(Introduzca un número):\n"
								 														+ "1. Personajes\n"
								 														+ "2. Armas\n"
								 														+ "3. Habitaciones\n"
								 														+ "4. No añadir nada\n");
						opcion=sc.nextInt();
					 }catch(Exception ex) {
						 System.out.println("Por favor, introduzca solo valores del 1 al 4");
						 sc.nextLine();					 
					 }	 
				}while(opcion<1 || opcion>4);
					do {
						  if(opcion!=4) {
							  try {
								   System.out.println("¿Cuantos elementos va a incluir?(Introduzca el número):\n");
								   inclusiones=sc.nextInt();
							  }catch(Exception ex) {
								  System.out.println("Solo se pueden introducir números enteros positivos.");
								  inclusiones=0;
								  sc.nextLine();
								  
							  }
						  }else { 
							  	inclusiones=1;
						  }
					}while(inclusiones<1);
					switch(opcion) {
					case 1:
						System.out.println("El estado actual de la lista es el siguiente: ");
						MostrarArrays(arrayPersonajes);
						arrayPersonajes=CrearNuevoArray(arrayPersonajes, inclusiones);
						IncluirEnArray(inclusiones, arrayPersonajes);
						System.out.println("La lista ha quedado de la siguiente forma: ");
						MostrarArrays(arrayPersonajes);
						break;
					case 2:
						System.out.println("El estado actual de la lista es el siguiente: ");
						MostrarArrays(arrayArmas);
						arrayArmas=CrearNuevoArray(arrayArmas, inclusiones);
						IncluirEnArray(inclusiones, arrayArmas);
						MostrarArrays(arrayArmas);
						break;
					case 3:
						System.out.println("El estado actual de la lista es el siguiente: ");
						MostrarArrays(arrayLugares);
						arrayLugares=CrearNuevoArray(arrayLugares, inclusiones);
						IncluirEnArray(inclusiones, arrayLugares);
						MostrarArrays(arrayLugares);
						break;
					default:
						System.out.println("No se añadirá nada");
						break;
			}
				do {
					  if(opcion!=4) {
						  try {
							   System.out.println("¿Quieres añadir algo más a alguna lista? Responda Sí o No:");
							   incluir=sc.next();
							   if(incluir.equalsIgnoreCase("Sí")==false && incluir.equalsIgnoreCase("Sí")== false && incluir.equalsIgnoreCase("No")==false) {
								   			System.out.println("Solo puede introducir Sí o No");
							   }
						  }catch(Exception ex) {
							  	System.out.println("Ha sucedido un error");
						  }
						  
						  }else {
							  	incluir="No";
						  }
					  
				}while(incluir.equalsIgnoreCase("Sí")==false &&  incluir.equalsIgnoreCase("Sí")== false && incluir.equalsIgnoreCase("No")==false);
				
			}			
						
		}else {
			    System.out.println("Vale, continuemos");
		}
						
	}				
				//Se le pide una clave al usuario		
						
	 public static void preguntarSobreMostrarCartas() {
		 String clave;
		 System.out.println("Te puedo mostrar las cartas que dan como lugar al asesino, pero sólo si aciertas la clave.");
		 System.out.println("Introduce una clave: ");
		 clave=sc.next();
		 if(clave.equalsIgnoreCase("Victor")) {
			 System.out.println(listaJugadores.get(listaJugadores.size()-1));
		 }else {
			 System.out.println("No tienes permiso para ver las cartas.");
		}
	}	
			
	 //Se le pregunta al usuario si quiere seguir
	 
	 public static boolean preguntarSobreSeguir() {
			String respuesta="";
			do {
				System.out.println("¿Quieres generar nuevas combinaciones? Responde (Sí/No): ");
				respuesta=sc.next();
				if(respuesta.equalsIgnoreCase("Sí")==false && respuesta.equalsIgnoreCase("Si")== false && respuesta.equalsIgnoreCase("No")==false) {
					System.out.println("Sólo puedes introducir Sí o No");
				}
			}while(respuesta.equalsIgnoreCase("Sí")==false && respuesta.equalsIgnoreCase("Si")== false && respuesta.equalsIgnoreCase("No")==false);
				if(respuesta.equalsIgnoreCase("Sí") || respuesta.equalsIgnoreCase("Si")) {
					return true;
				}else {
					return false;
				}
		}
	 
	  //Se muestra el mensaje de despedida
	 
     public static void mostrarDespedida() {
    	 System.out.println("\n El programa va a finalizar");
    
	 }		
		 //Creacion de arrays  
      public static String[] CrearNuevoArray(String[] array, int inclusiones) {
    	  String nuevoArray[] = new String[array.length+inclusiones];
    	  for(int i=0; i <array.length; i++) {
    		  	nuevoArray[i]=array[i];
    	
    	  }
          return nuevoArray;
      } 
     //Se incluyen las cosas en el array
     
     public static void IncluirEnArray(int inclusiones, String[] array) {
    	 int contador=1;
    	 boolean valido=true;
    	 sc.nextLine();
    	 for(int i=array.length-(inclusiones+1); i<array.length-1;i++) {
    		 System.out.println("Introduzca la" + contador + "ª incorporación a la lista:");
    		 do { 
    			 	valido=true;
    			 	try {
    			 			array[i]=sc.nextLine();
    			 	}catch(Exception ex) {
    			 		System.out.println("Ha habido un error");
    			 		valido=false;
    			 		
    			 	}
    		 }while(valido==false);
    		 contador++;
    		}
     }
     //Se muestran las posiciones de los arrays
     public static void MostrarArrays(String array[]) {
    	 for(int i=0; i<array.length-1; i++){
    		  System.out.println("· " + array[i]);
    	 }
     System.out.println();
		    	 
	  }
	//Se generan 3 números aleatorios para elegir la posición del array, lo llamaré "Barajar"
	
	public static boolean BarajarCartas() {
		int aleatorioPersonajes, aleatorioArmas, aleatorioLugares;
		
		aleatorioPersonajes=(int)(Math.random()*(arrayPersonajes.length));
		aleatorioArmas=(int)(Math.random()*(arrayArmas.length));
		aleatorioLugares=(int)(Math.random()*(arrayLugares.length));
		try {
			Jugador asesino = new Jugador(arrayPersonajes[aleatorioPersonajes],arrayArmas[aleatorioArmas],arrayLugares[aleatorioLugares]);
			IncluirEnLista(asesino);
			
			return true;
		}catch(Exception ex) {
			System.out.println("Ha ocurrido un error.");
			return false;
		}	
	}
	
	//Añadir lo que se genera al barajar cartas
	public static void IncluirEnLista(Jugador jugador) {
			listaJugadores.add(jugador);
	}
	
	//Se guarda la partida en un fichero
	public static void GuardarEnFichero() {
		try {
			 BufferedWriter writer = new BufferedWriter(new FileWriter("SaveData.txt", true));
			 writer.write("Fecha de partida: \n" + LocalDate.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy"))+"\n");
			 writer.newLine();
			 for(Jugador jugador : listaJugadores) {
				 writer.write(jugador.toString()+"\n");
				 writer.newLine();
		}
		writer.close();
		System.out.println("\n **Partida guardada con éxito**");
	}catch(Exception ex) {
		System.out.println("\n Ha ocurrido un error.");
	}
		
	
	}

}
