package modelo.juego;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import modelo.consumibles.Consumible;
import modelo.equipo.Equipo;
import modelo.jugador.Jugador;
import modelo.personajes.Personaje;
import modelo.tablero.Casillero;
import modelo.tablero.ErrorAtaqueInvalido;
import modelo.tablero.ErrorCasilleroYaOcupado;
import modelo.tablero.ErrorMovimientoInvalido;
import modelo.tablero.ErrorNoHayMasExtremos;
import modelo.tablero.ObjetoJuego;
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
	private static final int FILAS = 10, COLUMNAS = 10;
	private Jugador jugadorActual;
	private Jugador jugadorSiguiente;
	private static final int CANTIDAD_KI_QUE_AUMENTA_CADA_TURNO = 5;
	
	public OrganizadorJuego() {
		this.turno = 0;
		this.tablero = new Tablero(FILAS, COLUMNAS);
	}
	
	public int getTurno(){
		return this.turno;
	}
	
	//al ser un diccionario no se sabe cual va a ser el ultimo jugador en iterar, y ese va a ser el primero que juegue
	public void otorgarPrimerTurno( Map<String, Jugador> listajugadores) {
		for (Map.Entry<String, Jugador> entry : listajugadores.entrySet()) {
			this.jugadorActual = entry.getValue();
		}
		
		for (Map.Entry<String, Jugador> entry : listajugadores.entrySet()) {
			if (this.jugadorActual == entry.getValue()) continue;
			this.jugadorSiguiente = entry.getValue();
		}
	}
	
	public Jugador getJugadorActual() {
		return this.jugadorActual;
	}
	
	public Jugador getJugadorSiguiente() {
		return this.jugadorSiguiente;
	}
	
	public ObjetoJuego empezarSiguienteTurno(){
		this.turno++;
		
		this.tablero.eliminarConsumiblesSinTurnosRestantes();
		this.tablero.restarTurnoRestanteConsumibles();	
		
		for (int i = 0; i < this.jugadorActual.getEquipo().pedirListaPersonajes().size(); i++){
			this.jugadorActual.getEquipo().pedirListaPersonajes().get(i).agregarKi(CANTIDAD_KI_QUE_AUMENTA_CADA_TURNO);
		}
		
		for (int i = 0; i < this.jugadorSiguiente.getEquipo().pedirListaPersonajes().size(); i++){
			this.jugadorSiguiente.getEquipo().pedirListaPersonajes().get(i).agregarKi(CANTIDAD_KI_QUE_AUMENTA_CADA_TURNO);
		}
		
		Consumible consumible = null;
		
		if (this.turno % this.TURNOS_PARA_QUE_APAREZCA_CONSUMIBLE == 0 || 
				this.turno % this.TURNOS_PARA_QUE_APAREZCA_CONSUMIBLE == 1 )
			consumible = this.tablero.crearConsumible();
			// el or con 1 es para que sea "justo" y aparezca un consumible en el
			// turno del otro jugador tambien
		
		
		Jugador jugadorAux = this.jugadorSiguiente;
		this.jugadorSiguiente = this.jugadorActual;
		this.jugadorActual = jugadorAux;
					
		return consumible;
		// si se creo lo devuelve, sino devuelve null
		// esto es para que se pueda visualizar		
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
    public Tablero getTablero() { // necesario 100% ?
        return this.tablero;
    }
    
    public boolean ataque(Personaje p1, Personaje p2) throws ErrorAtaqueInvalido {
    	// devuelve true si el personaje atacado muere
    	// si el ataque no es válido devuelve una excepcion
    	 boolean resultadoPelea = this.tablero.ataqueBasico(p1,p2);
    	 if (resultadoPelea)
    		 this.jugadorSiguiente.getEquipo().eliminarPersonaje(p2);
    	 	// murio el p2, lo saco del equipo enemigo
    	 
    	 return resultadoPelea;   	 
    } 
    
    public boolean ataqueEspecial(Personaje p1, Personaje p2) throws ErrorAtaqueInvalido {
    	// devuelve true si el personaje atacado muere
    	// si el ataque no es válido devuelve una excepcion
    	boolean resultadoPelea = this.tablero.ataqueEspecial(p1,p2);
    	if (resultadoPelea)
    		this.jugadorSiguiente.getEquipo().eliminarPersonaje(p2);
   	 		// murio el p2, lo saco del equipo enemigo
    	
    	return resultadoPelea;
    }
    
    public void moverPersonaje(Personaje personaje, List<Casillero> camino) throws ErrorCasilleroYaOcupado, ErrorMovimientoInvalido {
    	// si no se puede mover levanta la excepcion correspondiente
    	int cantidadEsferasConseguidas = this.tablero.moverPersonaje(personaje, camino);    			
    	this.jugadorActual.getEquipo().sumarEsferasObtenidas(cantidadEsferasConseguidas);
    	// se puede devolver lo que sea necesario! yo no pense en nada ya que la nueva posicion
    	// ya la sabes (es donde te moviste), en el caso de que la excepcion no se levanto
    }    
    
    public boolean finalizarTurno(){
    	// devuelve true si el jugador que estaba en el turno en cuestión ganó la partida
    	if (this.jugadorSiguiente.getEquipo().cantidadPersonajes() == 0)
    		return true;
    	
    	if (this.jugadorActual.getEquipo().getCantidadEsferas() >= 7)
    		return true;   	
    	
    	// no se si es necesario hacer algo más al finalizar el turno
    	
    	return false;    	
    }
    
    
}
