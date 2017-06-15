package fiuba.algo3.modelo.personajes;

import java.util.HashMap;
import java.util.Stack;

import fiuba.algo3.modelo.bonus.Bonus;
import fiuba.algo3.modelo.bonus.TipoBonus;
import fiuba.algo3.modelo.estados.BonecrusherAlterno;
import fiuba.algo3.modelo.estados.BonecrusherHumanoide;
import fiuba.algo3.modelo.estados.ModoAlgoformer;

public class Bonecrusher extends Decepticon {
	public Bonecrusher(){
		this.ptosDeVida = 200;		
		this.modoAlgoformer = new BonecrusherHumanoide();
		this.listaBonus = new HashMap<TipoBonus,Bonus>();
		ModoAlgoformer modoAlterno = new BonecrusherAlterno();
		this.distintosModos = new Stack<ModoAlgoformer>();
		this.distintosModos.push(modoAlterno);
	}
	@Override
	public String toString(){
		return ("Bonecrusher"); 
	}

}
