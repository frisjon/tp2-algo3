package fiuba.algo3.modelo.superficies;

import fiuba.algo3.modelo.personajes.Personaje;

public abstract class Superficie {
	public void producirEfecto(Personaje algoformer){
		
	}
	
	public abstract boolean puedeAtravesarlo(Personaje algoformer);
	public abstract boolean seReduceLaVelocidad (Personaje algoformer);

}
