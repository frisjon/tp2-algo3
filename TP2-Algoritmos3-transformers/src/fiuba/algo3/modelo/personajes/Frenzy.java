package fiuba.algo3.modelo.personajes;

import java.util.HashMap;
import java.util.Stack;

import fiuba.algo3.modelo.bonus.Bonus;
import fiuba.algo3.modelo.bonus.TipoBonus;
import fiuba.algo3.modelo.estados.FrenzyAlterno;
import fiuba.algo3.modelo.estados.FrenzyHumanoide;
import fiuba.algo3.modelo.estados.ModoAlgoformer;


public class Frenzy extends Decepticon {
	public Frenzy(){
		this.ptosDeVida = 400;
		this.modoAlgoformer = new FrenzyHumanoide();
		this.listaBonus = new HashMap<TipoBonus,Bonus>();
		ModoAlgoformer modoAlterno = new FrenzyAlterno();
		this.distintosModos = new Stack<ModoAlgoformer>();
		this.distintosModos.push(modoAlterno);
	}
	@Override
	public String toString(){
		return ("Frenzy"); 
	}
}
