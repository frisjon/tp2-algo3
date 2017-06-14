package modelo.tablero;

import java.util.ArrayList;
import java.util.List;

public final class Extremo {
	
	 public static final String izquierda = "izq";
	 public static final String derecha = "der";
	 public static final String arriba = "arriba";
	 public static final String abajo = "abajo";
	 private static final List<String> orden = new ArrayList<String>(){
		 {
			 add(izquierda);
		     add(derecha);
		     add(arriba);
		     add(abajo);	        
		 }
	 };

	 public static String obtenerSiguienteExtremo (String extremoActual){
		 if (orden.indexOf(extremoActual) == orden.size() - 1)
			 return izquierda;
		 
		 return orden.get(orden.indexOf(extremoActual) + 1); 
	 }

}
