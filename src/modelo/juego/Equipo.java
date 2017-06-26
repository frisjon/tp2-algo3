package modelo.juego;

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
	private Hashtable<String, Personaje> listaPersonajes; //se crea diccionario: {nombre_personaje: PERSONAJE}
	private String nombre;
	private int cantidadEsferas;
	private int cantidadPersonajesInicial;
	private int cantidadPersonajesMuertos;
	
	public Equipo(String nombre_equipo) {
		this.listaPersonajes = new Hashtable<String, Personaje>();
		this.nombre = nombre_equipo;
		this.cantidadEsferas = 0;
		this.cantidadPersonajesInicial = 0;
		this.cantidadPersonajesMuertos = 0;
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
		this.cantidadPersonajesInicial++;
	}
	
	public void matarPersonaje(){
		this.cantidadPersonajesMuertos++;		
		//this.listaPersonajes.remove(personaje.getNombre());
		// use getNombre y no getNombrexTransformacion porque como se cargaron al princpio del
		// juego en el diccionario, se cargaron con su nombre original
	}
	
	public int cantidadPersonajes(){
		return this.listaPersonajes.size();
	}
	
	public int getCantidadPersonajesIniciales(){
		return this.cantidadPersonajesInicial;
	}
	
	public int getCantidadPersonajesMuertos(){
		return this.cantidadPersonajesMuertos;
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
    	Gohan gohan = new Gohan("Guerreros Z");
    	Piccolo piccolo = new Piccolo("Guerreros Z");
    	Goku goku = new Goku("Guerreros Z");
        this.agregarPersonaje(goku);
        this.agregarPersonaje(gohan);
        this.agregarPersonaje(piccolo);
        gohan.setAliado1(goku);
        gohan.setAliado2(piccolo);
        piccolo.setProtegido(gohan);
        
    }

    //Agrega a la instantcia de equipo, los personajes del equipo Enemigos
    public void asignarEquipoEnemigos() {
        this.agregarPersonaje(new Cell("Enemigos de la Tierra"));
        this.agregarPersonaje(new Freezer("Enemigos de la Tierra"));
        this.agregarPersonaje(new MajinBoo("Enemigos de la Tierra"));
    }
    
    public void sumarEsferasObtenidas(int cantidadEsferas){
    	this.cantidadEsferas += cantidadEsferas;
    }
    
    public int getCantidadEsferas(){
    	return this.cantidadEsferas;
    }
}
