package fiuba.algo3.modelo.personajes;


import fiuba.algo3.modelo.excepciones.AlgoformerNoPuedeAtacarException;
import fiuba.algo3.modelo.tablero.Posicion;

public abstract class Autobot extends Personaje{
	
	@Override
	public void setPosicion(Posicion posicion) {
		this.posicion = posicion;
		
	}
	
	@Override
	public Posicion getPosicion() {
		return (this.posicion);
	}
	
	@Override
	public void atacar (Personaje personaje){
		if (this.puedeAtacar(personaje.getPosicion())){
			personaje.recibirAtaqueDe(this);
		}else{
			throw new AlgoformerNoPuedeAtacarException();
		}
	}

	@Override
	public void recibirAtaqueDe(Decepticon decepticon) {
		int ataqueRecibido = decepticon.getAtaque();
		
			if(this.modoAlgoformer.getInmunidad())
				ataqueRecibido = 0;
		
		this.ptosDeVida = this.ptosDeVida - ataqueRecibido;
	}
	
	@Override
	public void recibirAtaqueDe(Autobot autobot) {
	}
	
	@Override
	public void reducirVida() {
		this.ptosDeVida = this.ptosDeVida - ((this.ptosDeVida*5)/100);
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
