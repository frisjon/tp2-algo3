package modelo.ataques;

import modelo.Tipo;
import modelo.acciones.Accion;
import modelo.acciones.AccionNula;
import modelo.algomones.AlgoMon;
import modelo.excepciones.AtaquesAgotadosException;

public abstract class Ataque {
	
	private int potencia;
	private int cantidad;
	private Tipo tipo;
	private Accion accion;
		
	public Ataque(int potencia, int cantidad, Tipo tipo, Accion accion){
		this.setPotencia(potencia);
		this.setCantidad(cantidad);
		this.setTipo(tipo);
		this.setAccion(accion);
	}
	
	public Ataque(int potencia, int cantidad, Tipo tipo){
		this.setPotencia(potencia);
		this.setCantidad(cantidad);
		this.setTipo(tipo);
		this.setAccion(new AccionNula());
	}
	
	public void atacar(AlgoMon atacante, AlgoMon atacado) throws AtaquesAgotadosException{
		if(this.getCantidad() == 0)
			throw new AtaquesAgotadosException();
		this.getAccion().actuar(atacante, atacado);
		double multiplicador = this.getTipo().obtenerMultiplicador(atacado.getTipo());
		atacado.disminuirVida((int)(this.getPotencia()*multiplicador));
		this.reducirCantidadDeAtaque();
	}
		
	public int getPotencia() {
		return potencia;
	}

	private void setPotencia(int potencia) {
		this.potencia = potencia;
	}

	public int getCantidad() {
		return cantidad;
	}

	private void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public Tipo getTipo() {
		return tipo;
	}

	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}
	
	public boolean equals(Ataque otroAtaque){
		return this.getClass().equals(otroAtaque.getClass());
	}
	
	private void reducirCantidadDeAtaque() {
		(this.cantidad)--;
	}

	private Accion getAccion() {
		return accion;
	}

	private void setAccion(Accion accion) {
		this.accion = accion;
	}
	
	public abstract int cantidadInicial();
	
	public void aumentarAtaque(int aumento){
		int cantidadAumentada = this.getCantidad() + aumento;
		if( cantidadAumentada > this.cantidadInicial() ) this.setCantidad(this.cantidadInicial());
		else this.setCantidad(cantidadAumentada);
	}
}
