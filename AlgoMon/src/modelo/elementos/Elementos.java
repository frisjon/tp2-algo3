package modelo.elementos;

import modelo.algomones.AlgoMon;
import modelo.excepciones.CantidadElementoAgotadaException;
import modelo.excepciones.ElementoInvalidoException;

import java.util.ArrayList;
import java.util.List;

public class Elementos {
	
	private List<Elemento> elementos;
	
	public Elementos () {
		this.setElementos();
	}
	
	public void setElementos() {
		elementos = new ArrayList<Elemento>();
		elementos.add(new Pocion());
		elementos.add(new SuperPocion());
		elementos.add(new Restaurador());
		elementos.add(new Vitamina());
	}

	public void aplicar(Elemento elemento, AlgoMon algomonActivo) {
		if(!tieneElemento(elemento)) throw new ElementoInvalidoException();
		if(cantidadElemento(elemento) <= 0) throw new CantidadElementoAgotadaException();
		getElemento(elemento).aplicar(algomonActivo);
		disminuirCantidad(elemento);
	}
	
	public int cantidadElemento(Elemento elemento){
		return this.getElemento(elemento).cantidadElemento();
	}
	
	private boolean tieneElemento(Elemento elemento){
		return this.getElemento(elemento) != null;
	}
	
	private void disminuirCantidad(Elemento elemento){
		this.getElemento(elemento).disminuirCantidad();
	}
	
	public Elemento getElemento(Elemento elemento) {
		Elemento elementoActual = null;
		for(Elemento unElemento: elementos){
			if(unElemento.equals(elemento)) elementoActual = unElemento;
		}
		return elementoActual;
	}

	public List<Elemento> getListaDeElementos() {
		return this.elementos;
	}
}
