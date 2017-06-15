package fiuba.algo3.modelo.estados;

public class BumblebeeHumanoide extends ModoHumanoide{
	public BumblebeeHumanoide(){
		this.ataque = 40;
		this.distanciaDeAtaque = 1;
		this.velocidad = 2;
	}
	
	@Override
	public void reestablecerVelocidad(){
		this.velocidad = 2;
	}
}
