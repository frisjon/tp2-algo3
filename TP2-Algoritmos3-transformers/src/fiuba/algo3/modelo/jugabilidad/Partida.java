package fiuba.algo3.modelo.jugabilidad;

import fiuba.algo3.modelo.excepciones.JugadorGanoException;
import fiuba.algo3.modelo.excepciones.NoEsValidaLaTransformacionAModoUnico;

//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;

import fiuba.algo3.modelo.personajes.Menasor;
import fiuba.algo3.modelo.personajes.Personaje;
import fiuba.algo3.modelo.personajes.Superion;
import fiuba.algo3.modelo.tablero.Casillero;
import fiuba.algo3.modelo.tablero.ChispaSuprema;
import fiuba.algo3.modelo.tablero.Posicion;
import fiuba.algo3.modelo.tablero.Tablero;

public class Partida {

//	private static Logger logger = LoggerFactory.getLogger(Partida.class);

	private Jugador player1;
	private Jugador player2;
	private Tablero juego;
	private Posicion posicionChispaSuprema;
	private Turno turno;

	public Partida(Jugador p1, Jugador p2){
		this.juego = new Tablero();
		this.player1 = p1;
		this.player2 = p2;
		this.turno = new Turno(p1,p2);

		//Inicializo ChispaSuprema
		ChispaSuprema chispaSuprema = new ChispaSuprema();
		this.posicionChispaSuprema = chispaSuprema.getPosicion();
		Casillero casilleroChispaSuprema = new Casillero(posicionChispaSuprema);
		casilleroChispaSuprema.agregarPosicionable(chispaSuprema);

		//Posicion inicial de Autobots
		Posicion posicionDeOptimus = new Posicion(0,0);
		Posicion posicionDeBumblebee = new Posicion(0,1);
		Posicion posicionDeRatchet = new Posicion(1,0);

		//Posicion inicial de Decepticons
		Posicion posicionDeMegatron = new Posicion(50,50);
		Posicion posicionDeBonecrusher = new Posicion(50,49);
		Posicion posicionDeFrenzy = new Posicion(49,50);

		this.juego.agregarPersonaje(this.player1.getPersonaje1(),posicionDeOptimus);
		this.juego.agregarPersonaje(this.player1.getPersonaje2(),posicionDeBumblebee);
		this.juego.agregarPersonaje(this.player1.getPersonaje3(),posicionDeRatchet);

		this.juego.agregarPersonaje(this.player2.getPersonaje1(),posicionDeMegatron);
		this.juego.agregarPersonaje(this.player2.getPersonaje2(),posicionDeBonecrusher);
		this.juego.agregarPersonaje(this.player2.getPersonaje3(),posicionDeFrenzy);

		//Setea la chispa y campo
		this.juego.ingresarCasillero(casilleroChispaSuprema);
	}

	public Partida(Jugador p1, Jugador p2,int alto, int largo){
		this.juego = new Tablero(true,alto,largo);
		this.player1 = p1;
		this.player2 = p2;
		this.turno = new Turno(p1,p2);

		//Inicializo ChispaSuprema
		ChispaSuprema chispaSuprema = new ChispaSuprema(alto,largo);
		this.posicionChispaSuprema = chispaSuprema.getPosicion();
		Casillero casilleroChispaSuprema = new Casillero(posicionChispaSuprema);
		casilleroChispaSuprema.agregarPosicionable(chispaSuprema);

		//Posicion inicial de Autobots
		Posicion posicionDeOptimus = new Posicion(0,0);
		Posicion posicionDeBumblebee = new Posicion(0,1);
		Posicion posicionDeRatchet = new Posicion(1,0);

		//Posicion inicial de Decepticons
		Posicion posicionDeMegatron = new Posicion(alto,largo);
		Posicion posicionDeBonecrusher = new Posicion(alto,largo-1);
		Posicion posicionDeFrenzy = new Posicion(alto-1,largo);

		this.juego.agregarPersonaje(this.player1.getPersonaje1(),posicionDeOptimus);
		this.juego.agregarPersonaje(this.player1.getPersonaje2(),posicionDeBumblebee);
		this.juego.agregarPersonaje(this.player1.getPersonaje3(),posicionDeRatchet);

		this.juego.agregarPersonaje(this.player2.getPersonaje1(),posicionDeMegatron);
		this.juego.agregarPersonaje(this.player2.getPersonaje2(),posicionDeBonecrusher);
		this.juego.agregarPersonaje(this.player2.getPersonaje3(),posicionDeFrenzy);

		//Setea la chispa y campo
		this.juego.ingresarCasillero(casilleroChispaSuprema);
	}

	public Tablero getTablero(){
		return this.juego;
	}
	public Posicion getPosicionChispaSuprema(){
		return (this.posicionChispaSuprema);
	}

	public void moverAlgoformerA(Personaje algoformer, Posicion direccion){
		Posicion posicion = algoformer.getPosicion().devolverSuma(direccion);
		this.juego.moverPersonaje(algoformer, posicion);
//		logger.info("El personaje se movio a la posicion: " + algoformer.getPosicion().toString());
		if (this.partidaTerminada()){
			throw new JugadorGanoException(this.getJugadorActual());
		}
	}

	public boolean jugadoresEnEsperaSinVida(){
		
		if (this.getJugadorEnEspera().getPersonajeModoUnico() != null){
			boolean personajeConVidaUnico = this.getJugadorEnEspera().getPersonajeModoUnico().estaVivo();
			return (!personajeConVidaUnico);
		}
		
		boolean personajeConVida1 = this.getJugadorEnEspera().getPersonaje1().estaVivo();
		boolean personajeConVida2 = this.getJugadorEnEspera().getPersonaje2().estaVivo();
		boolean personajeConVida3 = this.getJugadorEnEspera().getPersonaje3().estaVivo();

		return ((!personajeConVida1) && (!personajeConVida2) && (!personajeConVida3));
	}

	public void atacarConAlgoformerA(Personaje algoformerAtacante, Personaje algoformerDestino){
		this.juego.atacarConAlgoformerA(algoformerAtacante,algoformerDestino);
	}

	public void transformarAlgoformer(Personaje algoformer){
		this.juego.transformarAlgoformer(algoformer);
	}

	public Turno getTurno() {
		return turno;
	}

	public boolean partidaTerminada(){
		ChispaSuprema chispa = this.juego.obtenerChispaSuprema(this.posicionChispaSuprema);
		if (chispa != null){
			return chispa.chispaCapturada();
		} // Sino tendria que tirar una excepcion
		return false;
	}

	public Jugador obtenerJugadorDelTurno(){
		return this.turno.getJugadorActual();
	}

	public void finalizarTurno(){
		Jugador jugadorActual = this.obtenerJugadorDelTurno();
		jugadorActual.finalizarTurno();
		this.verificarSaludDePersonajes(this.getJugadorEnEspera());
		this.turno.cambioDeTurno();

	}

	private void verificarSaludDePersonajes(Jugador jugadorActual){
		if (jugadorActual.getPersonajeModoUnico() != null){
			this.retirarPersonajeSiEstaMuerto(jugadorActual.getPersonajeModoUnico());
		} else {
			this.retirarPersonajeSiEstaMuerto(jugadorActual.getPersonaje1());
			this.retirarPersonajeSiEstaMuerto(jugadorActual.getPersonaje2());
			this.retirarPersonajeSiEstaMuerto(jugadorActual.getPersonaje3());
		}
	}

	private void retirarPersonajeSiEstaMuerto(Personaje personaje){
		if (!personaje.estaVivo()){
			Casillero casilleroPersonajeModoUnico = this.juego.obtenerCasillero(personaje.getPosicion());
			casilleroPersonajeModoUnico.retirarPersonaje();
		}
	}



	public void transformarAlgoformerAModoUnico(Jugador jugador){

		Posicion posicionPersonaje1 = jugador.getPersonaje1().getPosicion();
		Posicion posicionPersonaje2 = jugador.getPersonaje2().getPosicion();
		Posicion posicionPersonaje3 = jugador.getPersonaje3().getPosicion();

		Casillero casilleroPersonaje1 = this.juego.obtenerCasillero(posicionPersonaje1);
		casilleroPersonaje1.retirarPersonaje();
		Casillero casilleroPersonaje2 = this.juego.obtenerCasillero(posicionPersonaje2);
		casilleroPersonaje2.retirarPersonaje();
		Casillero casilleroPersonaje3 = this.juego.obtenerCasillero(posicionPersonaje3);
		casilleroPersonaje3.retirarPersonaje();

		int MayorDistanciaEntreLosPuntos = Posicion.distanciaEntreTresPuntos(posicionPersonaje1,posicionPersonaje2,posicionPersonaje3);
		if (MayorDistanciaEntreLosPuntos <= 2){
			int vidaTotal = jugador.getPersonaje1().getPuntosDeVida();
			vidaTotal = vidaTotal + jugador.getPersonaje2().getPuntosDeVida();
			vidaTotal = vidaTotal + jugador.getPersonaje3().getPuntosDeVida();

			Personaje algoformerModoUnico = null;
			if (jugador.getTipo().equals(TipoTransformer.AUTOBOT)){
				algoformerModoUnico = new Superion(vidaTotal,posicionPersonaje1);
			} else {
				algoformerModoUnico = new Menasor(vidaTotal,posicionPersonaje1);
			}
			algoformerModoUnico.setTurnosInmovilizado(3);
			jugador.setPersonajeModoUnico(algoformerModoUnico);

		} else {
			throw new NoEsValidaLaTransformacionAModoUnico("La distancia entre los algoformers no es valida para la transformacion");
		}

	}

	public Jugador getPlayer1() {
		return player1;
	}

	public Jugador getPlayer2() {
		return player2;
	}

	public Jugador getJugadorActual(){
		return this.turno.getJugadorActual();
	}

	public Jugador getJugadorEnEspera(){
		return this.turno.getJugadorEnEspera();
	}


}
