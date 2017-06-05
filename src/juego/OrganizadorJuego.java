package juego;

import java.util.ArrayList;

import equipos.Equipo;
import jugadores.Jugador;
import personajes.Personaje;
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
	
	public void otorgarEquipo(Jugador jugador, Equipo equipo) {
		jugador.establecerEquipo(equipo);
	}
	
	public void colocarPersonajesEnTablero(Jugador jugador1, Jugador jugador2) {
			
		ArrayList<ArrayList<Personaje>> listaEquipos = new ArrayList<ArrayList<Personaje>>();
		ArrayList<Personaje> equipo1 = new ArrayList<Personaje>();
		ArrayList<Personaje> equipo2 = new ArrayList<Personaje>();
		equipo1 = (ArrayList<Personaje>) jugador1.getEquipo().pedirListaPersonajes();
		equipo2 = (ArrayList<Personaje>) jugador2.getEquipo().pedirListaPersonajes();
		
		listaEquipos.add(equipo1);
		listaEquipos.add(equipo2);
		
		this.tablero.colocarPersonajes(listaEquipos);
		this.tablero.mostrarPosicionesPersonajes();
	}
}
