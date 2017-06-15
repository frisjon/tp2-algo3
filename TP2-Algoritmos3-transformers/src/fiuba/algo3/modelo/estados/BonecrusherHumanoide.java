package fiuba.algo3.modelo.estados;

public class BonecrusherHumanoide extends ModoHumanoide{
	public BonecrusherHumanoide(){
		this.ataque = 30;
		this.distanciaDeAtaque = 3;
		this.velocidad = 1;
	}
	
	@Override
	public void reestablecerVelocidad(){
		this.velocidad = 1;
	}
}
