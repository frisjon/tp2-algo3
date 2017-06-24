package modelo.juego;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import modelo.jugador.*;
import modelo.tablero.ErrorNoHayMasExtremos;

/**
 * Clase que representa el Juego con sus respectivos jugadores y organizador del juego.
 * @author Ramiro
 *
 */

public class Juego {
	private Map<String, Jugador> listaJugadores; //creo diccionario: {nombre_jugador: JUGADOR}
	private OrganizadorJuego organizador;
	
	public Juego() {
		this.listaJugadores = new HashMap<String, Jugador>();
		this.organizador = new OrganizadorJuego();
	}
	
	public void agregarJugador(Jugador jugador_nuevo) {
		this.listaJugadores.put(jugador_nuevo.getNombre(), jugador_nuevo);
	}
	
	public Jugador pedirJugador(String nombre_jugador) {
		return this.listaJugadores.get(nombre_jugador);
	}
	
	public void distribuirPersonajesEquipos() throws ErrorNoHayMasExtremos {
		this.organizador.colocarPersonajesEnTablero(this.listaJugadores);		
	}
	
	public void inicializarJuegoAdjudicandoPrimerTurno() {
		List<Jugador> jugadores = new ArrayList<Jugador>();
		for (Map.Entry<String, Jugador> entry : this.listaJugadores.entrySet()) {
			jugadores.add(entry.getValue());
		}
		
		this.organizador.otorgarPrimerTurno(jugadores);
	}

	//Devuelve el OrganizadorJuego
    public OrganizadorJuego getOrganizadorJuego() {
        return this.organizador;
    }

}
