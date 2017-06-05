package equipos;

import java.util.ArrayList;

import personajes.Personaje;

/**
 * Clase abstracta que representa un Equipo.
 * @author Ramiro
 *
 */

public abstract class Equipo {
	protected ArrayList<Personaje> listapersonajes;
	
	public Equipo() {
		this.listapersonajes = new ArrayList<Personaje>();
	}
	
	public ArrayList<Personaje> pedirListaPersonajes() {
		return this.listapersonajes;
	}
}
