package modelo.tablero;

import java.util.List;

import modelo.personajes.Personaje;

public final class ValidadorMovimientoyAtaque {
	
	private static int diferencia(int n1, int n2){
		int diferencia;
		
		if (n2 > n1){
			diferencia = n2 - n1;
		}else{
			diferencia = n1 - n2;		
		}
		
		return diferencia;		
	}		
	
	public static boolean movimientoValido(Personaje personaje, List<Casillero> camino){
				
		double velocidad = personaje.getVelocidad();
		int x = personaje.getCasillero().getCoordenada().getX();
		int y = personaje.getCasillero().getCoordenada().getY();
		
		Casillero ultimoCasillero = camino.get(camino.size()-1);
		
		int xDestino = ultimoCasillero.getCoordenada().getX();
		int yDestino = ultimoCasillero.getCoordenada().getY();
		
		int diferenciaX, diferenciaY;
		
		diferenciaX = diferencia(x, xDestino);
		diferenciaY = diferencia(y, yDestino);
		
		int diferenciaTotal = diferenciaX + diferenciaY;
		// hice que no se pueda mover en diagonal, sino seria muy 'rapido' cada movimiento
		// despues le preguntamos a Carlos que onda
		
		if (diferenciaTotal > velocidad) // si se quiso ir mas lejos de lo que la velocidad lo permite
			return false;
		
		// ahora me fijo si me choco con algun personaje
		
		for (int i = 0; i < camino.size(); i++){
			if (!camino.get(i).estaLibre()) //a modificar (esta libre si tiene un consumible tira false, pero el pj puede pasar arriba de un consumible)
				return false;	
		}
				
		return true;
	}
	
	public static boolean ataqueValido(Personaje p1, Personaje p2){
		double distanciaAtaque = p1.getDistanciaAtaque();
		
		int x = p1.getCasillero().getCoordenada().getX();
		int y = p1.getCasillero().getCoordenada().getY();
		
		int xDestino = p2.getCasillero().getCoordenada().getX();
		int yDestino = p2.getCasillero().getCoordenada().getY();
		
		int diferenciaX, diferenciaY;
		
		diferenciaX = diferencia(x, xDestino);
		diferenciaY = diferencia(y, yDestino);
		
		if (diferenciaX > distanciaAtaque || diferenciaY > distanciaAtaque)
			return false;		
		
		return true;
	}
	

}
