package modelo.acciones;

import modelo.algomones.AlgoMon;

public class ChuparVida implements Accion {
	
	private int potencia = 15;

	public void actuar(AlgoMon atacante, AlgoMon atacado) {
		
		double multiplicador = atacante.getTipo().obtenerMultiplicador(atacado.getTipo());
		
		atacante.aumentarVida((int)(potencia * multiplicador * 0.3));
	}

}
