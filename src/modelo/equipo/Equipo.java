package modelo.equipo;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.List;

import modelo.personajes.Goku;
import modelo.personajes.Gohan;
import modelo.personajes.Piccolo;
import modelo.personajes.Cell;
import modelo.personajes.Freezer;
import modelo.personajes.MajinBoo;
import modelo.personajes.Personaje;

/**
 * Clase que representa un Equipo.
 * @author Ramiro
 *
 */

public class Equipo {
	private Hashtable<String, Personaje> listaPersonajes; //cree diccionario: {nombre_personaje: PERSONAJE}
	private String nombre;
	
	public Equipo(String nombre_equipo) {
		this.listaPersonajes = new Hashtable<String, Personaje>();
		this.nombre = nombre_equipo;
	}
	
	/**
	 *Se pasan los personajes del diccionario a una lista para que despues puedan ser distribuidos por Tablero.
	 */
	public List<Personaje> pedirListaPersonajes() {
		 List<Personaje> personajes_enlistados = new ArrayList<Personaje>();
		 Enumeration<Personaje> personajes = this.listaPersonajes.elements();
		 while(personajes.hasMoreElements()) {
			 personajes_enlistados.add(personajes.nextElement());
		 }
		 return personajes_enlistados;
	}
	
	public void agregarPersonaje(Personaje personaje_nuevo) {
		this.listaPersonajes.put(personaje_nuevo.getNombre(),personaje_nuevo);
	}
	
	public void eliminarPersonaje(Personaje personaje){
		this.listaPersonajes.remove(personaje.getNombre());
		// use getNombre y no getNombrexTransformacion porque como se cargaron al princpio del
		// juego en el diccionario, se cargaron con su nombre original
	}
	
	public int cantidadPersonajes(){
		return this.listaPersonajes.size();
	}
	
	/**
	 * Se puede implementar el tienePersonaje o clavar una excepcion en el metodo devolverPersonaje.
	 */
	
	public boolean tienePersonaje(Personaje personaje) {
		return this.listaPersonajes.containsKey(personaje.getNombre());
	}
	
	/**
	 * Este metodo se usaria asumiendo que se pregunto primero con tienePersonaje.
	 */
	
	public Personaje devolverPersonaje(String nombre_personaje) {
		return this.listaPersonajes.get(nombre_personaje);
	}
	
	public String getNombre() {
		return this.nombre;
	}

	//Agrega a la instantcia de equipo, los personajes del equipo Guerreros
    public void asignarEquipoGuerreros() {
        this.agregarPersonaje(new Goku("Guerreros"));
        this.agregarPersonaje(new Gohan("Guerreros"));
        this.agregarPersonaje(new Piccolo("Guerreros"));
    }

    //Agrega a la instantcia de equipo, los personajes del equipo Enemigos
    public void asignarEquipoEnemigos() {
        this.agregarPersonaje(new Cell("Enemigos"));
        this.agregarPersonaje(new Freezer("Enemigos"));
        this.agregarPersonaje(new MajinBoo("Enemigos"));
    }
}
