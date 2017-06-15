package fiuba.algo3.modelo.estados;

public class FrenzyHumanoide extends ModoHumanoide{
	public FrenzyHumanoide(){
		this.ataque = 10;
		this.distanciaDeAtaque = 5;
		this.velocidad = 2;
	}
	
	@Override
	public void reestablecerVelocidad(){
		this.velocidad = 2;
	}
}
