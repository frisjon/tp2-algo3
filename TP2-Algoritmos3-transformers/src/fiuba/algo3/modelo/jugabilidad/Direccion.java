package fiuba.algo3.modelo.jugabilidad;

import fiuba.algo3.modelo.tablero.Posicion;

public class Direccion {
	private Posicion izquierda;
	private Posicion derecha;
	private Posicion arriba;
	private Posicion abajo;
	private Posicion diagonalIzqSuperior;
	private Posicion diagonalDerSuperior;
	private Posicion diagonalIzqInferior;
	private Posicion diagonalDerInferior;
	
	public Direccion(){
		this.izquierda = new Posicion(0,-1);
		this.derecha = new Posicion(0,1);
		this.arriba = new Posicion(-1,0);
		this.abajo = new Posicion(1,0);
		this.diagonalIzqSuperior = new Posicion(-1,-1);
		this.diagonalDerSuperior = new Posicion(-1,1);
		this.diagonalIzqInferior = new Posicion(1,-1);
		this.diagonalDerInferior = new Posicion(1,1);
	}
	
	public Posicion getIzquierda(){
		return (this.izquierda);
	}
	
	public Posicion getDerecha(){
		return (this.derecha);
	}
	
	public Posicion getArriba(){
		return (this.arriba);
	}
	
	public Posicion getAbajo(){
		return (this.abajo);
	}
	
	public Posicion getDiagonalIzqSuperior(){
		return (this.diagonalIzqSuperior);
	}
	
	public Posicion getDiagonalDerSuperior(){
		return (this.diagonalDerSuperior);
	}
	
	public Posicion getDiagonalIzqInferior(){
		return (this.diagonalIzqInferior);
	}
	
	public Posicion getDiagonalDerInferior(){
		return (this.diagonalDerInferior);
	}

}

