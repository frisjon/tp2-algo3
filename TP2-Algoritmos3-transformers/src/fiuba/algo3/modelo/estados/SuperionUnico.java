package fiuba.algo3.modelo.estados;

public class SuperionUnico extends ModoUnico{
	public SuperionUnico(){
		this.ataque = 100;
		this.distanciaDeAtaque = 2;
		this.velocidad = 3;
	}
	@Override
	public void reestablecerVelocidad(){
		this.velocidad = 3;
	}

	
}
