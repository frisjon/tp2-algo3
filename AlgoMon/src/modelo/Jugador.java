package modelo;

import modelo.algomones.AlgoMon;
import modelo.ataques.Ataque;
import modelo.elementos.Elemento;
import modelo.elementos.Elementos;
import modelo.excepciones.*;

import java.util.ArrayList;
import java.util.List;

public class Jugador {

	private String nombre;
	private int indiceTurno;
	private AlgoMon algomonActivo;
	private ArrayList<AlgoMon> algomones;
	private Elementos elementos;
	
	
	public Jugador(int indice,String nombre) {
		this.setNombre(nombre);
		this.setIndiceTurno(indice);
		this.algomones = new ArrayList<AlgoMon>();
		this.elementos = new Elementos();
	}
	
	private void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public AlgoMon getAlgomonActivo() {
		return algomonActivo;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void actualizarEstados() {
		algomonActivo.nuevoTurno();
	}
	
	public ArrayList<AlgoMon> getListaDeAlgomones() {
		return this.algomones;
	}
	
	private void setIndiceTurno(int indice){
		this.indiceTurno = indice;
	}
	
	public int getIndiceTurno() {
		return indiceTurno;
	}
	
	public int cantidadAlgomones(){
		return this.algomones.size();
	}
	
	public void agregarAlgomon(AlgoMon algomon) {
		int cantMaxAlgomones = 3;
		if (algomones.size() >= cantMaxAlgomones) throw new CantidadMaximaAlgoMonesException();
		if (algomones.size() == 0) this.setAlgomonActivo(algomon);
		algomones.add(algomon);
	}
	
	public void cambiarDeAlgoMon(AlgoMon algomon) {
		if(!this.tieneAlgomon(algomon)) throw new AlgoMonInexistenteException();
		if(algomon.equals(algomonActivo)) throw new AlgoMonACambiarEsElActualException();
		if(algomon.estaMuerto()) throw new AlgoMonMuertoException();
		for(AlgoMon algomonUser: algomones){
			if(algomonUser.equals(algomon)) this.setAlgomonActivo(algomonUser);
		}
	}
	
	private void setAlgomonActivo(AlgoMon algomon) {
		this.algomonActivo = algomon;
	}
	
	public boolean tieneAlgomon(AlgoMon algomon) {
		boolean tiene = false;
		for(AlgoMon algomonUser: algomones){
			if(algomonUser.equals(algomon)) tiene = true;
		}
		return tiene;
	}
	
	public AlgoMon primeraEleccion(){
		return this.algomones.get(0);
	}
	
	public boolean perdio(){
		for(AlgoMon algomon: algomones){
			if(!algomon.estaMuerto()) return false;
		}
		return true;
	}
	
	public void atacar(AlgoMon oponente, Ataque ataque) throws AtaquesAgotadosException {
		this.algomonActivo.atacar(oponente, ataque);
		this.actualizarEstados();
	}
	
	public void aplicarElemento(Elemento elemento) {
		this.elementos.aplicar(elemento,this.algomonActivo);
	}
	
	public int vidaAlgomonActivo(){
		return algomonActivo.getVida();
	}
	
	public Elemento getElemento(Elemento elemento) {
		return this.elementos.getElemento(elemento);
	}

	public List<Elemento> getElementos() {
		return this.elementos.getListaDeElementos();
	}
}