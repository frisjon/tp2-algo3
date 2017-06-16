package modelo.elementos;

import modelo.algomones.AlgoMon;
import modelo.estados.EstadoNormal;

public class Restaurador extends Elemento {
	
	public Restaurador(){
		this.cantidad = 3;
	}
	
	public void aplicar(AlgoMon algomon){
		algomon.setEstadoPersistente(new EstadoNormal());
		algomon.setEstadoEfimero(new EstadoNormal());
	}

	@Override
	public int cantidadInicial() {
		return 3;
	}
	
}
