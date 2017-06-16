package modelo.juego;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

import modelo.equipo.Equipo;
import modelo.jugador.Jugador;
import modelo.tablero.ErrorCasilleroYaOcupado;
import modelo.tablero.ErrorNoHayMasExtremos;
import modelo.tablero.Tablero;
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
	
	public void colocarPersonajesEnTablero( Map<String, Jugador> listajugadores) throws ErrorNoHayMasExtremos{
		
		List<Equipo> listaEquipos = new ArrayList<Equipo>();
		
		for (Map.Entry<String, Jugador> entry : listajugadores.entrySet()) {
			Equipo equipo = entry.getValue().getEquipo();
			listaEquipos.add(equipo);
		}
		
		this.tablero.colocarPersonajes(listaEquipos);
		
	}
}
