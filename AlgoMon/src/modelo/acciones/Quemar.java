package modelo.acciones;

import modelo.algomones.AlgoMon;
import modelo.estados.Quemado;

public class Quemar implements Accion {

	public void actuar(AlgoMon atacante, AlgoMon atacado) {
		atacado.setEstadoPersistente(new Quemado());
	}

}
