package modelo.elementos;

import modelo.algomones.AlgoMon;

public class SuperPocion extends Elemento {
	
	private int valorCuracion;
	
	public SuperPocion(){
		this.valorCuracion = 40;
		this.cantidad = 2;
	}
	
	public void aplicar(AlgoMon algomon){
		algomon.aumentarVida(valorCuracion);
	}

	@Override
	public int cantidadInicial() {
		return 2;
	}
}
