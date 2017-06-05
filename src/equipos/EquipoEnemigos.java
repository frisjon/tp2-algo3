package equipos;

import javafx.scene.control.Cell;
import personajes.Personaje;
import personajes.Freezer.Freezer;
import personajes.MajinBoo.MajinBoo;

/**
 * Clase que representa al equipo de los enemigos de la tierra.
 * 
 * @author Ramiro
 *
 */

public class EquipoEnemigos extends Equipo {
	public EquipoEnemigos() {
		super();
		Personaje freezer = new Freezer();
		Personaje cell = new Cell();
		Personaje majinboo = new MajinBoo();
		this.listapersonajes.add(freezer);
		this.listapersonajes.add(cell);
		this.listapersonajes.add(majinboo);
	}
}
