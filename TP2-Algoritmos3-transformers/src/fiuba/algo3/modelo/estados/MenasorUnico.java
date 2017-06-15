package fiuba.algo3.modelo.estados;

public class MenasorUnico extends ModoUnico{
	public MenasorUnico(){
		this.ataque = 115;
		this.distanciaDeAtaque = 2;
		this.velocidad = 2;
	}	

	@Override
	public void reestablecerVelocidad(){
		this.velocidad = 2;
	}
}
