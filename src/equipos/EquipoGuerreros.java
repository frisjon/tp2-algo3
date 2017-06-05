package equipos;

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
