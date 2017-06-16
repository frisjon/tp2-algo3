package modelo.ataques;

import modelo.Tipo;
import modelo.acciones.Quemar;

public class Fogonazo extends Ataque {

	public Fogonazo() {
		super(2,4, Tipo.FUEGO, new Quemar());
	}
	
	public int cantidadInicial(){
		return 4;
	}
}
