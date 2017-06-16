package modelo.algomones;

import modelo.Tipo;
import modelo.ataques.AtaqueRapido;
import modelo.ataques.Canto;
import modelo.ataques.LatigoCepa;

public class Chansey extends AlgoMon {
	
	public Chansey() {
		super(130, Tipo.NORMAL);
		this.agregarAtaque(new Canto());
		this.agregarAtaque(new AtaqueRapido());
		this.agregarAtaque(new LatigoCepa());
	}

	@Override
	public int getVidaOriginal() {
		return 130;
	}
	
}
