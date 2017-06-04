package juego;

/**
 * Clase que representa al Organizador del Juego, encargado de generar el tablero, ubicar los personajes, los consumibles, etc.
 * @author Ramiro
 *
 */


public class OrganizadorJuego {
	private Tablero tablero;
	
	public OrganizadorJuego() {
		this.tablero = new Tablero();
	}
}
