package modelo.ataques;

import modelo.Tipo;
import modelo.acciones.ChuparVida;

public class Chupavidas extends Ataque {

	public Chupavidas() {
		super(15, 8, Tipo.PLANTA, new ChuparVida());
	}
	
	public int cantidadInicial(){
		return 8;
	}
	
}
