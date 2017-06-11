package equipos;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;
import personajes.Personaje;

/**
 * Clase que representa un Equipo.
 * @author Ramiro
 *
 */

public class Equipo {
	private Hashtable<String, Personaje> listapersonajes; //cree diccionario: {nombre_personaje: PERSONAJE}
	private String nombre;
	
	public Equipo(String nombre_equipo) {
		this.listapersonajes = new Hashtable<String, Personaje>();
		this.nombre = nombre_equipo;
	}
	
	/**
	 *Se pasan los personajes del diccionario a una lista para que despues puedan ser distribuidos por Tablero.
	 */
	public ArrayList<Personaje> pedirListaPersonajes() {
		 ArrayList<Personaje> personajes_enlistados = new ArrayList<Personaje>();
		 Enumeration<Personaje> personajes = this.listapersonajes.elements();
		 while(personajes.hasMoreElements()) {
			 personajes_enlistados.add(personajes.nextElement());
		 }
		 return personajes_enlistados;
	}
	
	public void agregarPersonaje(Personaje personaje_nuevo) {
		this.listapersonajes.put(personaje_nuevo.getNombre(),personaje_nuevo);
	}
	
	/**
	 * Se puede implementar el tienePersonaje o clavar una excepcion en el metodo devolverPersonaje.
	 */
	
	public boolean tienePersonaje(Personaje personaje) {
		return this.listapersonajes.containsKey(personaje.getNombre());
	}
	
	/**
	 * Este metodo se usaria asumiendo que se pregunto primero con tienePersonaje.
	 */
	
	public Personaje devolverPersonaje(String nombre_personaje) {
		return this.listapersonajes.get(nombre_personaje);
	}
	
	public String getNombre() {
		return this.nombre;
	}
}
