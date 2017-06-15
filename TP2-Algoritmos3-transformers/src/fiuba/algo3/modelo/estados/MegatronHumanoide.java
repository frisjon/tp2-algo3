package fiuba.algo3.modelo.estados;

public class MegatronHumanoide extends ModoHumanoide{
	public MegatronHumanoide(){
		this.ataque = 10;
		this.distanciaDeAtaque = 3;
		this.velocidad = 1;
	}
	
	@Override
	public void reestablecerVelocidad(){
		this.velocidad = 1;
	}
}
