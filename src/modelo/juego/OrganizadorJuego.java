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
	private final int TURNOS_PARA_QUE_APAREZCA_CONSUMIBLE = 4;
	private Tablero tablero;
	private int turno; // esta bueno para mostrarlo por consola
	private final int FILAS = 15, COLUMNAS = 15;
	
	public OrganizadorJuego() {
		this.turno = 0;
		this.tablero = new Tablero(FILAS, COLUMNAS);
	}
	
	public int getTurno(){
		return this.turno;
	}
	
	public void empezarSiguienteTurno(){
		this.turno++;
		
		this.tablero.eliminarConsumiblesSinTurnosRestantes();
		this.tablero.restarTurnoRestanteConsumibles();		
		
		if (this.turno % this.TURNOS_PARA_QUE_APAREZCA_CONSUMIBLE == 0 || 
				this.turno % this.TURNOS_PARA_QUE_APAREZCA_CONSUMIBLE == 1 )
			tablero.crearConsumible();
			// el or con 1 es para que sea "justo" y aparezca un consumible en el
			// turno del otro jugador tambien
		
		// capaz que aca haya que hacer alguna interaccion con el controlador		
	}
	
	public void colocarPersonajesEnTablero( Map<String, Jugador> listajugadores) throws ErrorNoHayMasExtremos{
		
		List<Equipo> listaEquipos = new ArrayList<Equipo>();
		
		for (Map.Entry<String, Jugador> entry : listajugadores.entrySet()) {
			Equipo equipo = entry.getValue().getEquipo();
			listaEquipos.add(equipo);
		}
		
		this.tablero.colocarPersonajes(listaEquipos);
		
	}

	//Devuelve el tablero
    public Tablero getTablero() {
        return this.tablero;
    }
}
