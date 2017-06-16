package modelo.ataques;

import modelo.Tipo;

public class Burbuja extends Ataque {

	public Burbuja() {
		super(10,15, Tipo.AGUA);
	}
	
	public int cantidadInicial(){
		return 15;
	}

}
