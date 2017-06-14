package modelo.tablero;

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
	
	public void setObjeto(ObjetoJuego objeto) throws ErrorCasilleroYaOcupado {
		if (!this.estaLibre() && objeto != null) 
			throw new ErrorCasilleroYaOcupado("Casillero ocupado");
		
		this.objeto = objeto;
	}
	
	public boolean esExtremo (String tipoDeExtremo, int ancho, int alto){
		if (tipoDeExtremo.equals(Extremo.izquierda))
			return (this.coordenada.getX() == 0);
		
		if (tipoDeExtremo.equals(Extremo.derecha))
			return (this.coordenada.getX() + 1 == ancho);
				
		if (tipoDeExtremo.equals(Extremo.arriba)) 
			return (this.coordenada.getY() == 0);
		
		// abajo	
		return (this.coordenada.getY() + 1 == alto);		
	}	
	
	public Coordenada getCoordenada(){
		return this.coordenada;
	}

}
