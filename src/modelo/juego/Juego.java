package modelo.juego;

import java.util.ArrayList;
import java.util.List;

import modelo.tablero.ErrorNoHayMasExtremos;

/**
 * Clase que representa el Juego con sus respectivos jugadores y organizador del juego.
 * @author Ramiro
 *
 */

public class Juego {
	private List<Jugador> jugadores;
	private OrganizadorJuego organizador;
	
	public Juego() {
		this.jugadores = new ArrayList<Jugador>();
		this.organizador = new OrganizadorJuego();
	}
	
	public void agregarJugador(Jugador jugador_nuevo) {
		this.jugadores.add(jugador_nuevo);
	}
	
	public void distribuirPersonajesEquipos() throws ErrorNoHayMasExtremos {
		this.organizador.colocarPersonajesEnTablero(this.jugadores);		
	}
	
	public int inicializarJuegoAdjudicandoPrimerTurno() {
		int definidor_turno = this.organizador.otorgarPrimerTurno(jugadores);
		return definidor_turno;
	}

	//Devuelve el OrganizadorJuego
    public OrganizadorJuego getOrganizadorJuego() {
        return this.organizador;
    }

}
