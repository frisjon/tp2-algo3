package equipos;

import java.util.ArrayList;
import java.util.List;

import personajes.Personaje;
import personajes.Gohan.Gohan;
import personajes.Goku.Goku;
import personajes.Piccolo.Piccolo;

/**
 * Clase que representa al equipo de los guerreros z.
 * 
 * @author Ramiro
 *
 */

public class EquipoGuerreros extends Equipo {
	
	private List<Personaje> listaPersonajes;		
	
	public EquipoGuerreros() {
		this.listaPersonajes = new ArrayList<Personaje>();
		
		Personaje goku = new Goku();
		Personaje gohan = new Gohan();
		Personaje piccolo = new Piccolo();
		this.listaPersonajes.add(goku);
		this.listaPersonajes.add(gohan);
		this.listaPersonajes.add(piccolo);
	}
	
	public List<Personaje> pedirListaPersonajes() {
		return this.listaPersonajes;
	}

}
