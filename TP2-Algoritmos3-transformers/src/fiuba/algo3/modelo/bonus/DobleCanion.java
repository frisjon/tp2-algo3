package fiuba.algo3.modelo.bonus;

import fiuba.algo3.modelo.personajes.Personaje;

public class DobleCanion extends Bonus {
	
	public DobleCanion(){
		this.turnos = 3;
		this.type = TipoBonus.DobleCanion;
	}
	
	@Override
	public void reiniciarTurnos(){
		this.turnos = 3;
	}
	
	@Override
	public void aplicarEfecto(Personaje personaje){
		personaje.bonificarAtaque(personaje.getAtaque() *2);
	}
	
	@Override
	public void quitarEfecto(Personaje personaje){
		personaje.bonificarAtaque(personaje.getAtaque() /2);
	}

}
