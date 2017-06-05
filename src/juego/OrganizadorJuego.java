package juego;

import java.util.ArrayList;

import equipos.Equipo;
import jugadores.Jugador;

/**
 * Clase que representa al Organizador del Juego, encargado de generar el tablero, ubicar los personajes, los consumibles, etc.
 * @author Ramiro
 *
 */


public class OrganizadorJuego {
	private Tablero tablero;
	private Jugador turno;
	final int FILAS = 30, COLUMNAS = 30;
	
	public OrganizadorJuego() {
		this.tablero = new Tablero(FILAS, COLUMNAS);
	}
	
	public void siguienteTurno(Jugador jugador_que_juega) {
		this.turno = jugador_que_juega;
	}
	
	public void otorgarEquipo(Jugador jugador, Equipo equipo) {
		jugador.establecerEquipo(equipo);
	}
	
	public void colocarPersonajesEnTablero(Jugador jugador1, Jugador jugador2) {
		ArrayList<ArrayList> listaequipos =  new ArrayList<ArrayList>();
		listaequipos.add(jugador1.getEquipo().pedirListaPersonajes());
		listaequipos.add(jugador2.getEquipo().pedirListaPersonajes());
		this.tablero.colocarPersonajes(listaequipos);
	}
}