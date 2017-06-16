package modelo.algomones;

import modelo.Tipo;
import modelo.ataques.AtaqueRapido;
import modelo.ataques.Burbuja;
import modelo.ataques.Canto;

public class Jigglypuff extends AlgoMon {
	
	public Jigglypuff() {
		super(130, Tipo.NORMAL);
		this.agregarAtaque(new Canto());
		this.agregarAtaque(new AtaqueRapido());
		this.agregarAtaque(new Burbuja());
	}

	@Override
	public int getVidaOriginal() {
		return 130;
	}

}
