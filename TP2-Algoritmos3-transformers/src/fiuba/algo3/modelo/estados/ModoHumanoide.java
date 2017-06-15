package fiuba.algo3.modelo.estados;

public abstract class ModoHumanoide extends ModoAlgoformer {
	
	@Override
	public boolean esHumanoide() {
		return true;
	}

	@Override
	public boolean esAlterno() {
		return false;
	}
	
	@Override 
	public boolean esUnico(){
		return false;
	}
	
	@Override
	public boolean esUnidadTerrestre(){
		return true;
	}
	
	@Override
	public boolean esUnidadAerea(){
		return false;
	}
	
	@Override
	public boolean puedeAtravesarPantano() {
		return false;
	}
	
}
