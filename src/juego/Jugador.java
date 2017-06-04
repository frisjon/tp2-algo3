package juego;

/**
 * Clase que representa un Jugador, con su nombre y el equipo al que pertenece.
 * @author Ramiro
 *
 */


public class Jugador {
	private String nombre;
	private String equipo;
	
	public Jugador(String nombre) {
		this.nombre = nombre;
	}
	
	private String getNombre() {
		return this.nombre;
	}
}
