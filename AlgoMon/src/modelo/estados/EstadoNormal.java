package modelo.estados;

import modelo.algomones.AlgoMon;

public class EstadoNormal implements Estado {

	public void nuevoTurno(AlgoMon algomon) {}

	public boolean puedeAtacar() {
		return true;
	}

}
