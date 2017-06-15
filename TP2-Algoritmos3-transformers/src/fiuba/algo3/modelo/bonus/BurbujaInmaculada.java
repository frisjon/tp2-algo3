package fiuba.algo3.modelo.bonus;

import fiuba.algo3.modelo.personajes.Personaje;

public class BurbujaInmaculada extends Bonus {
	
	public BurbujaInmaculada(){
		this.turnos = 2;
		this.type = TipoBonus.BurbujaInmaculada;
	}
	
	@Override
	public void reiniciarTurnos(){
		this.turnos = 2;
	}
	
	@Override
	public void aplicarEfecto(Personaje personaje){
		personaje.aplicarInmunidad(true);
	}	
	
	@Override
	public void quitarEfecto(Personaje personaje){
		personaje.aplicarInmunidad(false);
	}
}
