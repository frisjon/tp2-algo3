package fiuba.algo3.modelo.personajes;

import java.util.HashMap;
import java.util.Stack;

import fiuba.algo3.modelo.bonus.Bonus;
import fiuba.algo3.modelo.bonus.TipoBonus;
import fiuba.algo3.modelo.estados.ModoAlgoformer;
import fiuba.algo3.modelo.estados.RatchetAlterno;
import fiuba.algo3.modelo.estados.RatchetHumanoide;

public class Ratchet extends Autobot {
	public Ratchet(){
		this.ptosDeVida = 150;
		this.modoAlgoformer = new RatchetHumanoide();
		this.listaBonus = new HashMap<TipoBonus,Bonus>();
		ModoAlgoformer modoAlterno = new RatchetAlterno();
		this.distintosModos = new Stack<ModoAlgoformer>();
		this.distintosModos.push(modoAlterno);
	}
	@Override
	public String toString(){
		return ("Ratchet"); 
	}
}
