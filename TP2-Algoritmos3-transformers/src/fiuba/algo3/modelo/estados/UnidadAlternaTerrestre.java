package fiuba.algo3.modelo.estados;

public abstract class UnidadAlternaTerrestre extends ModoAlterno {
	
	@Override
	public boolean pantanoReduceVelocidad(){
		return true;
	}
	
	@Override
	public void reducirVelocidadPantano(){
		this.velocidad = this.velocidad - 1;
	}
}
