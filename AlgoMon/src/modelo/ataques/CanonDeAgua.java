package modelo.ataques;

import modelo.Tipo;

public class CanonDeAgua extends Ataque {

	public CanonDeAgua() {
		super(20,8, Tipo.AGUA);
	}
	
	public int cantidadInicial(){
		return 8;
	}

}
