package fiuba.algo3.modelo.superficies;

import fiuba.algo3.modelo.personajes.Personaje;

public class SuperficieTormentaPsionica extends SuperficieAerea {
	
	@Override
	public void producirEfecto(Personaje algoformer) {
		algoformer.reducirAtaque();
	}

	@Override
	public boolean puedeAtravesarlo(Personaje algoformer) {
		return (algoformer.puedeAtravesarTormenta());
	}

	@Override
	public boolean seReduceLaVelocidad(Personaje algoformer) {
		return (algoformer.tormentaReduceVelocidad());
	}
}
