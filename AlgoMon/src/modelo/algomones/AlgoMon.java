package modelo.algomones;

import modelo.Tipo;
import modelo.ataques.Ataque;
import modelo.estados.Estado;
import modelo.estados.Estados;
import modelo.excepciones.AtaqueInvalidoException;
import modelo.excepciones.AtaquesAgotadosException;

import java.util.ArrayList;
import java.util.List;

public abstract class AlgoMon {
	
	private int vida;
	private List<Ataque> ataques;
	private Tipo tipo;
	private Estados estados;
	
	public AlgoMon(int vida, Tipo tipo){
		this.setAtaques(new ArrayList<Ataque>());
		this.setVida(vida);
		this.setAtaques(ataques);
		this.setTipo(tipo);
		this.setEstados(new Estados());
	}
	
	public void atacar(AlgoMon otro, Ataque otroAtaque) throws AtaquesAgotadosException{
		if(!this.tieneAtaque(otroAtaque)) throw new AtaqueInvalidoException();
		if(!this.puedeAtacar()) return;
		for(Ataque ataque: ataques){
			if(ataque.equals(otroAtaque)){
				ataque.atacar(this, otro);
			}
		}
	}
	
	public boolean puedeAtacar() {
		return this.getEstados().puedeAtacar();
	}

	public boolean tieneAtaque(Ataque unAtaque) {
		boolean tiene = false;
		for(Ataque ataque: ataques){
			if(ataque.getClass().equals(unAtaque.getClass())) tiene = true;
		}
		return tiene;
	}
	
	public void disminuirVida(int puntos){
		this.setVida(this.getVida() - puntos);
		if(this.getVida()<0) this.setVida(0);
	}
	
	public void aumentarVida(int puntos){
		int vidaAumentada = this.getVida() + puntos;
		if( vidaAumentada > this.getVidaOriginal() ) this.setVida(this.getVidaOriginal());
		else this.setVida(vidaAumentada);
	}
	
	public void nuevoTurno(){
		this.getEstados().nuevoTurno(this);
	}
	
	public boolean equals(AlgoMon otroAlgoMon){
		return this.getClass().equals(otroAlgoMon.getClass());
	}
	
	public Estado getEstadoPersistente(){
		return this.getEstados().getEstadoPersistente();
	}

	public Estado getEstadoEfimero(){
		return this.getEstados().getEstadoEfimero();
	}
	
	public void setEstadoEfimero(Estado estadoEfimero){
		this.getEstados().setEstadoEfimero(estadoEfimero);
	}
	
	public void setEstadoPersistente(Estado estadoPersistente){
		this.getEstados().setEstadoPersistente(estadoPersistente);
	}

	public int getVida() {
		return vida;
	}

	private void setVida(int vida) {
		this.vida = vida;
	}
	
	public List<Ataque> getAtaques() {
		return ataques;
	}

	private void setAtaques(List<Ataque> ataques) {
		this.ataques = ataques;
	}
	
	public void agregarAtaque(Ataque unAtaque) {
		this.ataques.add(unAtaque);
	}

	public Tipo getTipo() {
		return tipo;
	}

	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}

	public Estados getEstados() {
		return estados;
	}
	
	/*public List<Estado> getListaDeEstados(){
		return estados.getListaDeEstados();
	}*/

	private void setEstados(Estados estados) {
		this.estados = estados;
	}
	
	public boolean estaMuerto(){
		return this.getVida() <= 0;
	}
	
	public abstract int getVidaOriginal();

}