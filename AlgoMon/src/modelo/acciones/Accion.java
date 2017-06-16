package modelo.acciones;

import modelo.algomones.AlgoMon;

public interface Accion {

	void actuar(AlgoMon atacante, AlgoMon atacado);
}
