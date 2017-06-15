package fiuba.algo3.modelo.estados;

public class RatchetHumanoide extends ModoHumanoide{
	public RatchetHumanoide(){
		this.ataque = 5;
		this.distanciaDeAtaque = 5;
		this.velocidad = 1;
	}
	@Override
	public void reestablecerVelocidad(){
		this.velocidad = 1;
	}
}
