package juego;

import java.util.ArrayList;
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
	
	public void otorgarEquipo(Jugador jugador, Equipo equipo) {
		jugador.establecerEquipo(equipo);
	}
	
	public void colocarPersonajesEnTablero(Jugador jugador1, Jugador jugador2) {
			
		List<Equipo> listaEquipos = new ArrayList<Equipo>();
		
		Equipo equipo1 = jugador1.getEquipo(); 
		Equipo equipo2 = jugador2.getEquipo();
		
		listaEquipos.add(equipo1);
		listaEquipos.add(equipo2);
		
		this.tablero.colocarPersonajes(listaEquipos);
		this.tablero.mostrarPosicionesPersonajes();
	}
}
