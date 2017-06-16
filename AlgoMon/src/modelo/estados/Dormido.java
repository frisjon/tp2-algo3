package modelo.estados;

import modelo.algomones.AlgoMon;

public class Dormido implements Estado {
	
	private int turnos;
	
	public Dormido(){
		this.turnos = 3;
	}

	public void nuevoTurno(AlgoMon algomon) {
		turnos--;
		if(turnos == 0){
			algomon.getEstados().setEstadoEfimero(new EstadoNormal());
		}
	}

	public boolean puedeAtacar() {
		return false;
	}

}
