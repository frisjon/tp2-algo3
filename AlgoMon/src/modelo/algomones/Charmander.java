package modelo.algomones;

import modelo.Tipo;
import modelo.ataques.AtaqueRapido;
import modelo.ataques.Brasas;
import modelo.ataques.Fogonazo;

public class Charmander extends AlgoMon {

	public Charmander() {
		super(170, Tipo.FUEGO);
		this.agregarAtaque(new Brasas());
		this.agregarAtaque(new AtaqueRapido());
		this.agregarAtaque(new Fogonazo());
	}

	@Override
	public int getVidaOriginal() {
		return 170;
	}

}
