package fiuba.algo3.modelo.tablero;

import fiuba.algo3.modelo.bonus.Bonus;
import fiuba.algo3.modelo.personajes.Personaje;
import fiuba.algo3.modelo.personajes.Posicionable;
import fiuba.algo3.modelo.superficies.SuperficieAerea;
import fiuba.algo3.modelo.superficies.SuperficieDeCampo;
import fiuba.algo3.modelo.superficies.SuperficieNube;
import fiuba.algo3.modelo.superficies.SuperficieRocosa;
import fiuba.algo3.modelo.superficies.SuperficieTerrestre;

public class Casillero implements Posicionable {

	private boolean ocupado;
	private Personaje personaje;
	private ChispaSuprema chispa;
	private Posicion posicion;
	private SuperficieDeCampo superficies;
	private Bonus bonus;

	public Casillero(Posicion posicion){
		this.ocupado = false;
		this.posicion = posicion;
		this.personaje = null;
		this.chispa = null;
		this.bonus = null;
		this.superficies = new SuperficieDeCampo(new SuperficieNube(), new SuperficieRocosa());
	}

	public Casillero(Posicion posicion, SuperficieAerea superficieAerea, SuperficieTerrestre suerficieTerrestre){
		this.ocupado = false;
		this.posicion = posicion;
		this.personaje = null;
		this.chispa = null;
		this.bonus = null;
		this.superficies = new SuperficieDeCampo(superficieAerea, suerficieTerrestre);
	}

	public Casillero(Posicion posicion, SuperficieDeCampo superficie){
		this.ocupado = false;
		this.posicion = posicion;
		this.personaje = null;
		this.chispa = null;
		this.bonus = null;
		this.superficies = superficie;
	}

	@Override
	public Posicion getPosicion(){
		return (this.posicion);
	}

	@Override
	public void setPosicion(Posicion posicion){
		this.posicion = posicion;
	}

	public void agregarPosicionable(Personaje personaje){
		personaje.setPosicion(this.posicion);
		this.personaje = personaje;
		this.ocupado = true;
		if (this.chispa != null){
			this.chispa.capturar();
		}
	}

	public void agregarPosicionable(ChispaSuprema chispa){
		this.chispa = chispa;
		this.ocupado = false;
	}

	public void agregarPosicionable(Bonus bonus){
		this.ocupado = false;
		this.bonus = bonus;
	}

	public void retirarPersonaje(){
		this.personaje = null;
		this.ocupado = false;
	}

	public boolean estaOcupado() {
		return ocupado;
	}

	public ChispaSuprema getChispaSuprema() {
		return this.chispa;
	}

	public Personaje getPersonaje() {
		return this.personaje;
	}

	public SuperficieDeCampo getSuperficies() {
		return superficies;
	}

	public void setSuperficies(SuperficieDeCampo superficies) {
		this.superficies = superficies;
	}

	public Bonus getBonus() {
		return this.bonus;
	}

	public void setBonus(Bonus bonus) {
		this.bonus = bonus;
	}

	public boolean isOcupado() {
		return ocupado;
	}

	public void quitarBonus() {
		this.bonus = null;
	}

}
