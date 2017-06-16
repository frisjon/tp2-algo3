package modelo.elementos;

import modelo.algomones.AlgoMon;

public abstract class Elemento {
	
	protected int cantidad;
	
	public abstract void aplicar(AlgoMon algomon);
	
	public void disminuirCantidad(){
		this.cantidad --;
	}
	
	public int cantidadElemento(){
		return cantidad;
	}
	
	public boolean equals(Elemento otro){
		return this.getClass().equals(otro.getClass());
	}
	
	public abstract int cantidadInicial();
	
}
