package fiuba.algo3.modelo.personajes;

import java.util.Map;
import java.util.Stack;


import fiuba.algo3.modelo.estados.ModoAlgoformer;
import fiuba.algo3.modelo.excepciones.AlgoformerNoPuedeMoverseException;
import fiuba.algo3.modelo.tablero.Posicion;
import fiuba.algo3.modelo.bonus.*;

public abstract class Personaje implements Posicionable {
	protected int ptosDeVida;
	protected Map<TipoBonus,Bonus> listaBonus;
	protected ModoAlgoformer modoAlgoformer;
	protected Posicion posicion;
	protected Stack<ModoAlgoformer> distintosModos;
	protected int turnosInmovilizado = 0;
	protected boolean inmunidad = false;

	public abstract void atacar(Personaje personaje);
	public abstract void recibirAtaqueDe(Decepticon decepticon);
	public abstract void recibirAtaqueDe(Autobot autobot);
	public abstract void reducirVida();
	public abstract void reducirAtaque();
	public abstract void reducirVelocidad();

	public boolean estaVivo(){
		if (this.getPuntosDeVida() > 0){
			return true;
		}
		return false;
	}

	public void reestablecerEfectos(){
		if (this.turnosInmovilizado > 0){
			this.turnosInmovilizado = this.turnosInmovilizado -1;
		}
		this.modoAlgoformer.reestablecerVelocidad();

		if (this.listaBonus.containsKey(TipoBonus.Flash)){
			this.listaBonus.get(TipoBonus.Flash).aplicarEfecto(this);
		}
	}

	public void agregarBonusPersonaje(Bonus newBonus){
		if(!listaBonus.containsKey(newBonus.getType())){
			listaBonus.put(newBonus.getType(), newBonus);
			newBonus.aplicarEfecto(this);
		}

	}

	public void quitarBonusPersonaje(Bonus oldBonus){
		listaBonus.remove(oldBonus.getType());
	}

	public void setPosicion(Posicion posicion) {
		this.posicion = posicion;
	}

	public Posicion getPosicion() {
		return (this.posicion);
	}

	public ModoAlgoformer getModoAlgoformer() {
		return modoAlgoformer;
	}
	public void setModoAlgoformer(ModoAlgoformer modoAlgoformer) {
		this.modoAlgoformer = modoAlgoformer;
	}
	public int getTurnosInmovilizado() {
		return turnosInmovilizado;
	}
	public void setTurnosInmovilizado(int turnosInmovilizado) {
		this.turnosInmovilizado = turnosInmovilizado;
	}
	public boolean estaInmovilizado(){
		return (this.turnosInmovilizado > 0);
	}

	public boolean puedeMoverse(Posicion posicion){
		int distanciaDePosiciones = this.posicion.distanciaA(posicion);
		if (distanciaDePosiciones <= this.getVelocidad() && (!this.estaInmovilizado())){
			return true;
		} else {
			throw new AlgoformerNoPuedeMoverseException();
		}
	}

	public boolean puedeAtacar(Posicion posicion) {
		int distanciaDePosiciones = this.posicion.distanciaA(posicion);
		return (distanciaDePosiciones <= this.getDistanciaDeAtaque());
	}

	public int getAtaque() {
		return (this.modoAlgoformer.getAtaque());
	}

	public int getVelocidad() {
		return (this.modoAlgoformer.getVelocidad());
	}

	public int getDistanciaDeAtaque() {
		return (this.modoAlgoformer.getDistanciaDeAtaque());
	}

	public int getPuntosDeVida() {
		return (this.ptosDeVida) ;
	}

	public boolean esHumanoide() {
		return (this.modoAlgoformer.esHumanoide());
	}

	public boolean esAlterno() {
		return (this.modoAlgoformer.esAlterno());
	}
	
	public boolean esUnico(){
		return (this.modoAlgoformer.esUnico());
	}
	
	public boolean esUnidadTerrestre(){
		return (this.modoAlgoformer.esUnidadTerrestre());
	}
	
	public boolean esUnidadAerea(){
		return (this.modoAlgoformer.esUnidadAerea());
	}
	
	public void reducirVidaEspinas() {
		this.modoAlgoformer.quitarVidaEspinas(this);
	}

	//Validar implementacion
	public void transformar() {
		Bonus bonus;
		for (Map.Entry<TipoBonus,Bonus> entry : listaBonus.entrySet()) {
		    	bonus = entry.getValue();
		    	bonus.quitarEfecto(this);
		}
		ModoAlgoformer nuevoModo = this.distintosModos.pop();
		distintosModos.push(this.modoAlgoformer);
		this.modoAlgoformer = nuevoModo;

		for (Map.Entry<TipoBonus,Bonus> entry : listaBonus.entrySet()) {
	    	bonus = entry.getValue();
	    	bonus.aplicarEfecto(this);
		}

	}
	public boolean rocosaReduceVelocidad(){
		return false;
	}

	public boolean pantanoReduceVelocidad(){
		return (this.modoAlgoformer.pantanoReduceVelocidad());
	}

	public boolean espinasReduceVelocidad(){
		return false;
	}

	public boolean nubeReduceVelocidad(){
		return false;
	}

	public boolean tormentaReduceVelocidad(){
		return false;
	}

	public boolean nebulosaReduceVelocidad(){
		return false;
	}

	public boolean puedeAtravesarRocosa(){
		return true;
	}

	public boolean puedeAtravesarPantano(){
		return (this.modoAlgoformer.puedeAtravesarPantano());
	}

	public boolean puedeAtravesarEspinas(){
		return true;
	}

	public boolean puedeAtravesarNube(){
		return true;
	}

	public boolean puedeAtravesarTormenta(){
		return true;
	}

	public boolean puedeAtravesarNebulosa(){
		return true;
	}

	public void bonificarAtaque(int attack) {
		this.modoAlgoformer.setAtaque(attack);
	}

	public void aplicarInmunidad(boolean inmunidad) {
		this.modoAlgoformer.setInmunidad(inmunidad);
	}

	public void bonificarVelocidad(int velocidad) {
		this.modoAlgoformer.setVelocidad(velocidad);
	}

	public void actualizarBonus() {
		Bonus bonus;
		for (Map.Entry<TipoBonus,Bonus> entry : listaBonus.entrySet()) {
		    	bonus = entry.getValue();
		    	bonus.reducirTurno();

		    	if(bonus.getTurnos() == 0){
		    		this.quitarBonusPersonaje(bonus);
		    		bonus.quitarEfecto(this);
		    		bonus.reiniciarTurnos();
		    	}
		}
	}
	public void inmovilizacionDeNebulosa() {
		int TURNOS_DE_INMOVILIZACION = 3;

		if (this.modoAlgoformer.esUnidadAerea()){
			this.setTurnosInmovilizado(TURNOS_DE_INMOVILIZACION);
		}
	}
	public void reducirVelocidadPantano(){
		this.modoAlgoformer.reducirVelocidadPantano();
	}
}

