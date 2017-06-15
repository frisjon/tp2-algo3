package fiuba.algo3.modelo.superficies;

import fiuba.algo3.modelo.personajes.Personaje;

public class SuperficieNube extends SuperficieAerea {

	@Override
	public boolean puedeAtravesarlo(Personaje algoformer) {
		return (algoformer.puedeAtravesarNube());
	}

	@Override
	public boolean seReduceLaVelocidad(Personaje algoformer) {
		return (algoformer.nubeReduceVelocidad());
	}
	
}
