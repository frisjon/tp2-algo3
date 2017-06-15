package fiuba.algo3.modelo.superficies;

import fiuba.algo3.modelo.personajes.Personaje;

public class SuperficieRocosa extends SuperficieTerrestre{

	@Override
	public boolean puedeAtravesarlo(Personaje algoformer) {
		return (algoformer.puedeAtravesarRocosa());
	}

	@Override
	public boolean seReduceLaVelocidad(Personaje algoformer) {
		return (algoformer.rocosaReduceVelocidad());
	}
}
