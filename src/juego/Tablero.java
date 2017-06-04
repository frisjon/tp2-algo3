package juego;

/**
 * Clase que representa al Tablero donde se ubicaran tanto a los personajes como a los consumibles.
 * @author Ramiro
 *
 */

public class Tablero {
	/**
     * Puse 30 por tirar un nùmero. Después le rpeguntamos a fontela de cuanto tiene que ser.
     */
	final int FILAS = 30, COLUMNAS = 30;
	private Casillero[][] tablero;
	
	public Tablero() {
		int i; int j;
		this.tablero = new Casillero[FILAS][COLUMNAS];
		for(i= 0; i < this.tablero.length; i++) {
			for(j= 0; j < this.tablero[i].length; j++) {
				this.tablero[i][j] = new Casillero();
			}
		}
	}
	
}