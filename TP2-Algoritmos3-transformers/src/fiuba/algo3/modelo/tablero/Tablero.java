package fiuba.algo3.modelo.tablero;

import java.util.HashMap;
import java.util.Map;

import fiuba.algo3.modelo.bonus.Bonus;
import fiuba.algo3.modelo.bonus.BurbujaInmaculada;
import fiuba.algo3.modelo.bonus.DobleCanion;
import fiuba.algo3.modelo.bonus.Flash;
import fiuba.algo3.modelo.excepciones.AlgoformerNoPuedeMoverseException;
import fiuba.algo3.modelo.excepciones.PosicionInvalidaException;
import fiuba.algo3.modelo.personajes.*;
import fiuba.algo3.modelo.superficies.SuperficieDeCampo;
import fiuba.algo3.modelo.superficies.SuperficieDeCampoProvider;
import fiuba.algo3.modelo.utils.RandomUtils;

public class Tablero {
	public static final String config = "config.properties";

	public static final int alto = 50;
	public static final int largo = 50;

	private Map<Posicion,Casillero> tablero;

	public Tablero(){
		this.tablero = new HashMap<Posicion,Casillero>();

		for (int x = 0 ; x <= alto ; x++){
			for (int y = 0; y <= largo; y++){
				Posicion coordenada = new Posicion(x,y);
				Casillero casillero = new Casillero(coordenada,SuperficieDeCampoProvider.generarSerficieDeCampoComun());
				this.tablero.put(coordenada, casillero);
			}
		}
	}

	public Tablero(boolean alAzar){
		new Tablero(alAzar,alto,largo);
	}

	public Tablero(boolean alAzar, int alto, int largo){

		this.tablero = new HashMap<Posicion,Casillero>();
		for (int x = 0 ; x <= alto ; x++){
			for (int y = 0; y <= largo; y++){
				Posicion coordenada = new Posicion(x,y);
				Casillero casillero = new Casillero(coordenada,SuperficieDeCampoProvider.generarSerficieDeCampoComun());
				this.tablero.put(coordenada, casillero);
			}
		}

		if (alAzar){
			for (int z = 0 ; z <= 1500 ; z++){
				// Dejo margenes de 2 casilleros por todo le borde
				int coordenadaX = RandomUtils.generaNumeroAleatorio(2,alto-2);
				int coordenadaY = RandomUtils.generaNumeroAleatorio(2,largo-2);

				Posicion coordenada = new Posicion(coordenadaX,coordenadaY);
				Casillero casillero = this.tablero.get(coordenada);
				SuperficieDeCampo supDeCampo = SuperficieDeCampoProvider.generarSuperficieDeCampoAleatoria();
				casillero.setSuperficies(supDeCampo);

			}

		}

		this.inicializarBonus(this.tablero,alto,largo);
	}

	public void ingresarCasillero(Casillero casillero){
		this.tablero.put(casillero.getPosicion(),casillero);

	}

	private void inicializarBonus(Map<Posicion,Casillero> tablero, int alto,int largo){
		for (int i = 0; i < RandomUtils.generaNumeroAleatorio(0,20); i++) {
			Bonus bonus = null;
			int value = RandomUtils.generaNumeroAleatorio(1,3);

			switch(value){
				case 1: bonus = new BurbujaInmaculada();
						break;
				case 2: bonus = new DobleCanion();
						break;
				case 3: bonus = new Flash();
						break;
			}

			int coordenadaX = RandomUtils.generaNumeroAleatorio(2,alto-2);
			int coordenadaY = RandomUtils.generaNumeroAleatorio(2,largo-2);
			Posicion coordenada = new Posicion(coordenadaX,coordenadaY);
			Casillero casillero = tablero.get(coordenada);
			casillero.setBonus(bonus);
		}

	}

	public boolean estaOcupado(Posicion posicion){
		if (this.posicionValida(posicion)){
			Casillero casillero = this.tablero.get(posicion);
			return casillero.estaOcupado();
		}
		return false;
	}

	public boolean posicionValida(Posicion posicion) {
		return (this.tablero.containsKey(posicion));
	}

	public void agregarPersonaje(Personaje personaje , Posicion posicionInicial){
		if (this.posicionValida(posicionInicial) && !this.estaOcupado(posicionInicial)){
			this.tablero.get(posicionInicial).agregarPosicionable(personaje);
		}
	}

	public Personaje obtenerPersonaje(Posicion posicionInicial){
		Personaje personaje = null;
		if (this.posicionValida(posicionInicial) && this.estaOcupado(posicionInicial)){
			personaje = this.tablero.get(posicionInicial).getPersonaje();
		}
		return personaje;
	}

	public Casillero obtenerCasillero(Posicion posicionInicial){
		return (this.tablero.get(posicionInicial));
	}

	public ChispaSuprema obtenerChispaSuprema(Posicion posicion){
		ChispaSuprema chispa = null;
		if (this.posicionValida(posicion)){
			chispa = this.tablero.get(posicion).getChispaSuprema();
		}
		return chispa;
	}

	public void moverPersonaje(Personaje personaje, Posicion posicionDestino){
		if (this.posicionValida(posicionDestino) && !this.estaOcupado(posicionDestino)){
			SuperficieDeCampo superficiesDestino = this.tablero.get(posicionDestino).getSuperficies();
			if(personaje.puedeMoverse(posicionDestino) && (superficiesDestino.puedeAtravesarlo(personaje))){
				Posicion posicionInicial = personaje.getPosicion();
				this.tablero.get(posicionInicial).retirarPersonaje();
				this.tablero.get(posicionDestino).agregarPosicionable(personaje);
				if (this.tablero.get(posicionDestino).getBonus() != null){
					personaje.agregarBonusPersonaje(this.tablero.get(posicionDestino).getBonus());
					this.tablero.get(posicionDestino).quitarBonus();
				}
				superficiesDestino.aplicarEfecto(personaje);
				personaje.reducirVelocidad();
			} else {
				throw new AlgoformerNoPuedeMoverseException();
			}
		} else {
			throw new PosicionInvalidaException("La posicion en X:" + posicionDestino.getCoordenadaX() + " e Y:" + posicionDestino.getCoordenadaY() + " es invalida");
		}
	}

	public void atacarConAlgoformerA(Personaje algoformerAtacante, Personaje algoformerDestino){
		algoformerAtacante.atacar(algoformerDestino);

	}

	public void transformarAlgoformer(Personaje algoformer){
		algoformer.transformar();
		//Agregar efectos de el casillero donde se transforma
	}

}
