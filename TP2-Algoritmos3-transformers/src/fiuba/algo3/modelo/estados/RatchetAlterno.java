package fiuba.algo3.modelo.estados;

public class RatchetAlterno extends UnidadAlternaAerea{
	public RatchetAlterno(){
		this.ataque = 35;
		this.distanciaDeAtaque = 2;
		this.velocidad = 8;
		this.tormentaPsionica = false;
	}

	@Override
	public boolean esUnidadTerrestre() {
		return false;
	}

	@Override
	public boolean esUnidadAerea() {
		return true;
	}
	
	@Override
	public void reestablecerVelocidad(){
		this.velocidad = 8;
	}
}
