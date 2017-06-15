package fiuba.algo3.modelo.personajes;

import fiuba.algo3.modelo.excepciones.AlgoformerNoPuedeAtacarException;

public abstract class Decepticon extends Personaje {
	
	@Override
	public void atacar (Personaje personaje){
		if (this.puedeAtacar(personaje.getPosicion())){
			personaje.recibirAtaqueDe(this);
		}else{
			throw new AlgoformerNoPuedeAtacarException();
		}
	}
	
	@Override
	public void recibirAtaqueDe(Autobot autobot) {
		int ataqueRecibido = autobot.getAtaque();
		
		if(this.modoAlgoformer.getInmunidad())
			ataqueRecibido = 0;
		
		this.ptosDeVida = this.ptosDeVida - ataqueRecibido;
	}
	
	@Override
	public void recibirAtaqueDe(Decepticon decepticon) {
	}
	
	
	@Override
	public void reducirVida() {
		this.ptosDeVida = this.ptosDeVida - ((this.ptosDeVida*5)/100);
	}
	
	@Override
	public boolean puedeAtravesarPantano(){
		return (this.modoAlgoformer.puedeAtravesarPantano());
	}
	
	@Override
	public void reducirAtaque(){
		this.modoAlgoformer.reducirAtaque();
	}
	@Override
	public void reducirVelocidad(){
		this.modoAlgoformer.reducirVelocidad();
	}
}
