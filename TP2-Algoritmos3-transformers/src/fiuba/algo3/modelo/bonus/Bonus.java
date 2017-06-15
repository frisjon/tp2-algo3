package fiuba.algo3.modelo.bonus;

import fiuba.algo3.modelo.personajes.Personaje;
import fiuba.algo3.modelo.personajes.Posicionable;
import fiuba.algo3.modelo.tablero.Posicion;

public abstract class Bonus  implements Posicionable {
	protected int turnos;	
	protected TipoBonus type;
	protected Posicion posicion;
	
	public abstract void aplicarEfecto(Personaje personaje);
	public abstract void quitarEfecto(Personaje personaje);
	public abstract void reiniciarTurnos();
	
	public int getTurnos(){
		return this.turnos;
	}
	
	public void reducirTurno(){
		this.turnos = this.turnos -1;
	}	

	public void setPosicion(Posicion posicion) {
		this.posicion = posicion;		
	}
	
	public Posicion getPosicion() {
		return (this.posicion);
	}

	public TipoBonus getType() {
		return this.type;
	}
}
