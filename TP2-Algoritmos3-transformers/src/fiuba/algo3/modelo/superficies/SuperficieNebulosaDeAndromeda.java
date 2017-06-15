package fiuba.algo3.modelo.superficies;

import fiuba.algo3.modelo.personajes.Personaje;

public class SuperficieNebulosaDeAndromeda extends SuperficieAerea {
	
	@Override
	public void producirEfecto(Personaje algoformer) {
		algoformer.inmovilizacionDeNebulosa();
	}

	@Override
	public boolean puedeAtravesarlo(Personaje algoformer) {
		return (algoformer.puedeAtravesarNebulosa());
	}

	@Override
	public boolean seReduceLaVelocidad(Personaje algoformer) {
		return (algoformer.nebulosaReduceVelocidad());
	}
}
