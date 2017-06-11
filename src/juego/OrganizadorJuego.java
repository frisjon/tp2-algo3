package juego;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.List;

import equipos.Equipo;
import jugadores.Jugador;
import tablero.Tablero;
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
	
	public void colocarPersonajesEnTablero( Hashtable<String, Jugador> listajugadores) {
		
		List<Equipo> listaEquipos = new ArrayList<Equipo>();
		
		Enumeration<Jugador> jugadores = listajugadores.elements();
		while (jugadores.hasMoreElements()) {
			Equipo equipo = ((Jugador) jugadores).getEquipo();
			listaEquipos.add(equipo);
		}
		
		this.tablero.colocarPersonajes(listaEquipos);
	}
}
