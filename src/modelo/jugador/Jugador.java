package modelo.jugador;

import modelo.equipo.Equipo;

/**
 * Clase que representa un Jugador, con su nombre y el equipo al que pertenece.
 * @author Ramiro
 *
 */


public class Jugador {
	private String nombre;
	private Equipo equipo;
	
	public Jugador(String nombre, Equipo equipo_jugador) {
		this.nombre = nombre;
		this.equipo = equipo_jugador;
	}
	
	public String getNombre() {
		return this.nombre;
	}
	
	public Equipo getEquipo() {
		return this.equipo;
	}
}
