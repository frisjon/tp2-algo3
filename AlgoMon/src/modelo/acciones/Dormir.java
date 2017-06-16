package modelo.acciones;

import modelo.algomones.AlgoMon;
import modelo.estados.Dormido;

public class Dormir implements Accion {

	public void actuar(AlgoMon atacante, AlgoMon atacado) {
		atacado.setEstadoEfimero(new Dormido());
	}

}
