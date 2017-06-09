package equipos;

import personajes.Personaje;
import personajes.Gohan;
import personajes.Goku;
import personajes.Piccolo;

/**
 * Clase que representa al equipo de los guerreros z.
 * 
 * @author Ramiro
 *
 */

public class EquipoGuerreros extends Equipo {

	public EquipoGuerreros() {
		super();
		Personaje goku = new Goku();
		Personaje gohan = new Gohan();
		Personaje piccolo = new Piccolo();
		this.listapersonajes.add(goku);
		this.listapersonajes.add(gohan);
		this.listapersonajes.add(piccolo);
	}

}
