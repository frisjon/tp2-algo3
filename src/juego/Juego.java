package juego;

import java.util.Hashtable;
import jugadores.*;
import tablero.ErrorCasilleroYaOcupado;
import tablero.ErrorNoHayMasExtremos;

/**
 * Clase que representa el Juego con sus respectivos jugadores y organizador del juego.
 * @author Ramiro
 *
 */

public class Juego {
	private Hashtable<String, Jugador> listajugadores; //creo diccionario: {nombre_jugador: JUGADOR}
	private OrganizadorJuego organizador;
	
	
	public Juego() {
		this.listajugadores = new Hashtable<String, Jugador>();
		this.organizador = new OrganizadorJuego();
	}
	
	public void agregarJugador(Jugador jugador_nuevo) {
		this.listajugadores.put(jugador_nuevo.getNombre(), jugador_nuevo);
	}
	
	public Jugador pedirJugador(String nombre_jugador) {
		return this.listajugadores.get(nombre_jugador);
	}
	
	public void distribuirPersonajesEquipos() throws ErrorNoHayMasExtremos {
		this.organizador.colocarPersonajesEnTablero(this.listajugadores);		
	}

}
