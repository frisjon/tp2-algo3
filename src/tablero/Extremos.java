package tablero;

public abstract class Extremos {
	
	 public static final int izquierda = 1;
	 public static final int derecha = 2;
	 public static final int arriba = 3;
	 public static final int abajo = 4;
	 
	 public static int obtenerSiguienteExtremo (int extremoActual){
		 if (extremoActual == 4)
			 return 1;
		 
		 return extremoActual++;
	 }

}
