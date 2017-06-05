package equipos;

import java.util.ArrayList;
import java.util.List;

//import javafx.scene.control.Cell;
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
	
	private List<Personaje> listaPersonajes;		
		
	public EquipoEnemigos() {
		this.listaPersonajes = new ArrayList<Personaje>();
		
		Personaje freezer = new Freezer();
		// Personaje cell = new Cell();
		Personaje majinboo = new MajinBoo();
		this.listaPersonajes.add(freezer);
		// this.listapersonajes.add(cell);
		this.listaPersonajes.add(majinboo);
	}
	
	public List<Personaje> pedirListaPersonajes() {
		return this.listaPersonajes;
	}
}
