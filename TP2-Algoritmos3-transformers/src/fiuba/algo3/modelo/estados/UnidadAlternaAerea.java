package fiuba.algo3.modelo.estados;

import fiuba.algo3.modelo.personajes.Personaje;

public abstract class UnidadAlternaAerea extends ModoAlterno{
	boolean tormentaPsionica;
	
	@Override
	public void quitarVidaEspinas(Personaje algoformer){
		
	}
	
	@Override
	public void reducirAtaque(){
		if (!this.tormentaPsionica){
		this.ataque = this.ataque - ((this.ataque *40)/100);
		this.tormentaPsionica = true;
		}
	}
}
