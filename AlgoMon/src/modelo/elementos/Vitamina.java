package modelo.elementos;

import modelo.algomones.AlgoMon;
import modelo.ataques.Ataque;

public class Vitamina extends Elemento {
	
	private int cantidadAumentarAtaques;
	
	public Vitamina(){
		this.cantidadAumentarAtaques = 2;
		this.cantidad = 5;
	}
	
	public void aplicar(AlgoMon algomon){
		for (Ataque ataque: algomon.getAtaques()){
			ataque.aumentarAtaque(cantidadAumentarAtaques);
		}
	}

	@Override
	public int cantidadInicial() {
		return 5;
	}
}
