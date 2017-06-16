package modelo.ataques;

import modelo.Tipo;

public class Brasas extends Ataque {

	public Brasas() {
		super(16,10, Tipo.FUEGO);
	}
	
	public int cantidadInicial(){
		return 10;
	}

}
