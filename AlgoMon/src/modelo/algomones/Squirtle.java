package modelo.algomones;

import modelo.Tipo;
import modelo.ataques.AtaqueRapido;
import modelo.ataques.Burbuja;
import modelo.ataques.CanonDeAgua;

public class Squirtle extends AlgoMon {
	
	public Squirtle() {
		super(150, Tipo.AGUA);
		this.agregarAtaque(new Burbuja());
		this.agregarAtaque(new AtaqueRapido());
		this.agregarAtaque(new CanonDeAgua());
	}

	@Override
	public int getVidaOriginal() {
		return 150;
	}

}
