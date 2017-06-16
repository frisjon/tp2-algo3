package modelo.elementos;

import modelo.algomones.AlgoMon;

public class Pocion extends Elemento {
	
	private int valorCuracion;
	
	public Pocion(){
		this.valorCuracion = 20;
		this.cantidad = 4;
	}
	
	public void aplicar(AlgoMon algomon){
		algomon.aumentarVida(valorCuracion);
	}

	@Override
	public int cantidadInicial() {
		return 4;
	}
}
