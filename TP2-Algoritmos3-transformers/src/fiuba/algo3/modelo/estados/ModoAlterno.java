package fiuba.algo3.modelo.estados;

public abstract class ModoAlterno extends ModoAlgoformer {

	@Override
	public boolean esHumanoide() {
		return false;
	}

	@Override
	public boolean esAlterno() {
		return true;
	}
	@Override 
	public boolean esUnico(){
		return false;
	}
	
}
