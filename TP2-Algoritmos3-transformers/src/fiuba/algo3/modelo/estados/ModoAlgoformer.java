package fiuba.algo3.modelo.estados;


import fiuba.algo3.modelo.personajes.Personaje;

public abstract class ModoAlgoformer {	
	protected int ataque;
	protected int velocidad;
	protected int distanciaDeAtaque;
	protected boolean inmunidad;
	
	public abstract boolean esHumanoide();
	public abstract boolean esAlterno();
	public abstract boolean esUnico();
	public abstract boolean esUnidadTerrestre();
	public abstract boolean esUnidadAerea();
	public abstract void reestablecerVelocidad();
	
	public int getVelocidad() {
		return (this.velocidad);
		
	}
	public int getDistanciaDeAtaque() {
		return (this.distanciaDeAtaque);
		
	}

	public int getAtaque() {		
		return (this.ataque);
	}

	public void setAtaque(int attack) {
		this.ataque = attack;
	}
	
	public void setInmunidad(boolean inmunity) {
		this.inmunidad = inmunity;
	}
	
	public boolean getInmunidad() {
		return this.inmunidad;
	}

	public boolean puedeAtravesarPantano(){
		return true;
	}
	
	public void quitarVidaEspinas(Personaje algoformer){
		algoformer.reducirVida();
	}

	public void reducirAtaque(){
		
	}

	public void reducirVelocidad(){
		this.velocidad = this.velocidad - 1;
	}
	
	public boolean pantanoReduceVelocidad(){
		return false;
	}
	
	public void setVelocidad(int velocity) {
		this.velocidad = velocity;
	}
	
	public void reducirVelocidadPantano(){
		
	}
	
}
