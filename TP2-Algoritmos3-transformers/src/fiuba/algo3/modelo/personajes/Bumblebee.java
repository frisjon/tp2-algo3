package fiuba.algo3.modelo.personajes;

import java.util.HashMap;
import java.util.Stack;

import fiuba.algo3.modelo.bonus.Bonus;
import fiuba.algo3.modelo.bonus.TipoBonus;
import fiuba.algo3.modelo.estados.BumblebeeAlterno;
import fiuba.algo3.modelo.estados.BumblebeeHumanoide;
import fiuba.algo3.modelo.estados.ModoAlgoformer;

public class Bumblebee extends Autobot {
	public Bumblebee(){
		this.ptosDeVida = 350;
		this.modoAlgoformer = new BumblebeeHumanoide();
		this.listaBonus = new HashMap<TipoBonus,Bonus>();
		ModoAlgoformer modoAlterno = new BumblebeeAlterno();
		this.distintosModos = new Stack<ModoAlgoformer>();
		this.distintosModos.push(modoAlterno);
	}
	@Override
	public String toString(){
		return ("Bumblebee"); 
	}
}
