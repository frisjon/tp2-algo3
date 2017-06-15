package fiuba.algo3.modelo.estados;

public abstract class ModoUnico extends ModoAlgoformer {

	@Override
	public boolean esHumanoide() {
		return false;
	}
	
	@Override
	public boolean esAlterno() {
		return false;
	}
	
	@Override 
	public boolean esUnico(){
		return true;
	}
	
	@Override
	public boolean esUnidadTerrestre(){
		return true;
	}
	
	@Override
	public boolean esUnidadAerea(){
		return false;
	}
	
}
