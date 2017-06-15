package fiuba.algo3.modelo.bonus;

import fiuba.algo3.modelo.personajes.Personaje;

public class Flash extends Bonus {
	
	public Flash(){
		this.turnos = 3;
		this.type = TipoBonus.Flash;
	}
	
	@Override
	public void reiniciarTurnos(){
		this.turnos = 3;
	}
	
	@Override
	public void aplicarEfecto(Personaje personaje){
		personaje.bonificarVelocidad(personaje.getVelocidad() *3);
	}
	
	@Override
	public void quitarEfecto(Personaje personaje){
		personaje.bonificarVelocidad(personaje.getVelocidad() /3);
	}

}
