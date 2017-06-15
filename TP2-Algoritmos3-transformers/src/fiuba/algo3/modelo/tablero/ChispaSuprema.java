package fiuba.algo3.modelo.tablero;

import fiuba.algo3.modelo.personajes.Posicionable;
import fiuba.algo3.modelo.tablero.Posicion;

public class ChispaSuprema implements Posicionable {
	private boolean capturada;
	private Posicion posicion;

	public ChispaSuprema(){
		this.capturada = false;
		this.posicion = new Posicion(24,25);
	}

	public ChispaSuprema(int alto, int largo){
		this.capturada = false;
		this.posicion = new Posicion(Integer.divideUnsigned(alto, 2),Integer.divideUnsigned(largo, 2));
	}

	public void capturar(){
		this.capturada = true;
	}

	public boolean chispaCapturada(){
		return this.capturada;
	}

	@Override
	public Posicion getPosicion(){
		return (this.posicion);
	}

	@Override
	public void setPosicion(Posicion posicion) {
		this.posicion = posicion;

	}

}
