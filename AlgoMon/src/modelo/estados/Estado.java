package modelo.estados;

import modelo.algomones.AlgoMon;

public interface Estado {
	void nuevoTurno(AlgoMon algomon);
	boolean puedeAtacar();
}
