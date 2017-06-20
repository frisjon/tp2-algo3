package modelo.juego;

import java.util.HashMap;
import java.util.Map;

import modelo.jugador.*;
import modelo.tablero.ErrorNoHayMasExtremos;

/**
 * Clase que representa el Juego con sus respectivos jugadores y organizador del juego.
 * @author Ramiro
 *
 */

public class Juego {
	private Map<String, Jugador> listajugadores; //creo diccionario: {nombre_jugador: JUGADOR}
	private OrganizadorJuego organizador;
	
	public Juego() {
		this.listajugadores = new HashMap<String, Jugador>();
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
	
	public void inicializarJuegoAdjudicandoPrimerTurno() {
		this.organizador.otorgarPrimerTurno(listajugadores);
	}

	//Devuelve el OrganizadorJuego
    public OrganizadorJuego getOrganizadorJuego() {
        return this.organizador;
    }

}
