package fiuba.algo3.modelo.estados;

public class OptimusHumanoide extends ModoHumanoide{
	
	public OptimusHumanoide(){
		this.ataque = 50;
		this.velocidad = 2;
		this.distanciaDeAtaque = 2;
	}
	
	@Override
	public void reestablecerVelocidad(){
		this.velocidad = 2;
	}
}
