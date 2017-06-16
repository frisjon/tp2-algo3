package modelo.ataques;

import modelo.Tipo;

public class LatigoCepa extends Ataque {

	public LatigoCepa() {
		super(15,10, Tipo.PLANTA);
	}
	
	public int cantidadInicial(){
		return 10;
	}

}
