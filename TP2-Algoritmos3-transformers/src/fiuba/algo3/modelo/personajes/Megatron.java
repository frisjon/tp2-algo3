package fiuba.algo3.modelo.personajes;

import java.util.HashMap;
import java.util.Stack;

import fiuba.algo3.modelo.estados.ModoAlgoformer;
import fiuba.algo3.modelo.bonus.Bonus;
import fiuba.algo3.modelo.bonus.TipoBonus;
import fiuba.algo3.modelo.estados.MegatronAlterno;
import fiuba.algo3.modelo.estados.MegatronHumanoide;

public class Megatron extends Decepticon {
	public Megatron(){
		this.ptosDeVida = 550;
		this.modoAlgoformer = new MegatronHumanoide();
		this.listaBonus = new HashMap<TipoBonus,Bonus>();
		ModoAlgoformer modoAlterno = new MegatronAlterno();
		this.distintosModos = new Stack<ModoAlgoformer>();
		this.distintosModos.push(modoAlterno);
	}
	@Override
	public String toString(){
		return ("Megatron"); 
	}
}
