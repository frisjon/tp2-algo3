package fiuba.algo3.modelo.personajes;

import java.util.HashMap;
import java.util.Stack;

import fiuba.algo3.modelo.bonus.Bonus;
import fiuba.algo3.modelo.bonus.TipoBonus;
import fiuba.algo3.modelo.estados.ModoAlgoformer;
import fiuba.algo3.modelo.estados.OptimusAlterno;
import fiuba.algo3.modelo.estados.OptimusHumanoide;

public class Optimus extends Autobot {
	public Optimus(){
		this.ptosDeVida = 500;
		this.modoAlgoformer = new OptimusHumanoide();
		this.listaBonus = new HashMap<TipoBonus,Bonus>();
		ModoAlgoformer modoAlterno = new OptimusAlterno();
		this.distintosModos = new Stack<ModoAlgoformer>();
		this.distintosModos.push(modoAlterno);
	}
	@Override
	public String toString(){
		return ("Optimus"); 
	}
}
