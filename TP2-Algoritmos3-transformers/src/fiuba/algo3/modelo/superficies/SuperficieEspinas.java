package fiuba.algo3.modelo.superficies;

import fiuba.algo3.modelo.personajes.Personaje;

public class SuperficieEspinas extends SuperficieTerrestre{	
	@Override
	public void producirEfecto(Personaje algoformer) {
		algoformer.reducirVidaEspinas();
	}

	@Override
	public boolean puedeAtravesarlo(Personaje algoformer) {
		return (algoformer.puedeAtravesarEspinas());
	}

	@Override
	public boolean seReduceLaVelocidad(Personaje algoformer) {
		return (algoformer.espinasReduceVelocidad());
	}
}
