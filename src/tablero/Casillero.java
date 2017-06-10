package tablero;

public class Casillero {

	private Coordenada coordenada;
	private ObjetoJuego objeto;  // Personaje y Consumible deben implementar la interfaz ObjetoJuego
	
	public Casillero (int x, int y) {
		this.objeto = null;
		this.coordenada = new Coordenada(x,y);
	}
	
	public boolean estaLibre(){ 
		return this.objeto == null;
	}
	
	public ObjetoJuego getObjeto() throws ErrorNoHayObjeto {
		if (this.estaLibre())
			throw new ErrorNoHayObjeto("No hay ningun objeto");
				
		return this.objeto;
	}
	
	public void setObjeto(ObjetoJuego objeto) {
		if (!this.estaLibre())
			//throw new ErrorCasilleroYaOcupado("Casillero ocupado");
			return;
		
		this.objeto = objeto;
	}
	
	public boolean esExtremo (int tipoDeExtremo, int ancho, int alto){
		if (tipoDeExtremo == Extremos.izquierda)
			return (this.coordenada.getX() == 0);
		
		if (tipoDeExtremo == Extremos.derecha)
			return (this.coordenada.getX() + 1 == ancho);
				
		if (tipoDeExtremo == Extremos.arriba) 
			return (this.coordenada.getY() == 0);
		
		// abajo	
		return (this.coordenada.getY() + 1 == alto);		
	}	
	
	public Coordenada getCoordenada(){
		return this.coordenada;
	}

}
