package fiuba.algo3.vistas.controllers;

import fiuba.algo3.MainApp;
import fiuba.algo3.modelo.jugabilidad.Jugador;
import fiuba.algo3.modelo.jugabilidad.Partida;
import fiuba.algo3.modelo.personajes.Personaje;
import fiuba.algo3.vistas.CajaAlerta;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class MenuSeleccionDeEnemigoAAtacarController {
	@FXML
	private Label nombrePersonajeAtacante;
	@FXML
	private Label ataquePersonajeAtacante;
	@FXML
	private Label distDeAtaquePersonajeAtacante;
	
	@FXML
	private Button botonPersonaje1;
	@FXML
	private Button botonPersonaje2;
	@FXML
	private Button botonPersonaje3;
	
	@FXML
	private Label ptosDeVidaPersonaje1;
	@FXML
	private Label ataquePersonaje1;
	@FXML
	private Label distDeAtaquePersonaje1;
	@FXML
	private Label velocidadPersonaje1;

	@FXML
	private Label ptosDeVidaPersonaje2;
	@FXML
	private Label ataquePersonaje2;
	@FXML
	private Label distDeAtaquePersonaje2;
	@FXML
	private Label velocidadPersonaje2;

	@FXML
	private Label ptosDeVidaPersonaje3;
	@FXML
	private Label ataquePersonaje3;
	@FXML
	private Label distDeAtaquePersonaje3;
	@FXML
	private Label velocidadPersonaje3;

	private Partida partida;
	private Personaje personajeAtacante;
	private MainApp mainApp;

	public void clickBotonAtacarAPersonaje1(){
		Jugador jugadorEnEspera = this.partida.getJugadorEnEspera();
		try{
			this.partida.atacarConAlgoformerA(this.personajeAtacante, jugadorEnEspera.getPersonaje1());
			this.clickBotonTerminarTurno();

		}catch(Exception ex){
			CajaAlerta.mostrar("Error en ataque", "El oponente elegido es imposible de atacar. Elija otro.");
		}

	}

	public void clickBotonAtacarAPersonaje2(){
		Jugador jugadorEnEspera = this.partida.getJugadorEnEspera();
		try{
			this.partida.atacarConAlgoformerA(this.personajeAtacante, jugadorEnEspera.getPersonaje2());
			this.clickBotonTerminarTurno();

		}catch(Exception ex){
			CajaAlerta.mostrar("Error en ataque", "El oponente elegido es imposible de atacar. Elija otro.");
		}
	}

	public void clickBotonAtacarAPersonaje3(){
		Jugador jugadorEnEspera = this.partida.getJugadorEnEspera();
		try{
			this.partida.atacarConAlgoformerA(this.personajeAtacante, jugadorEnEspera.getPersonaje3());
			this.clickBotonTerminarTurno();

		}catch(Exception ex){
			CajaAlerta.mostrar("Error en ataque", "El oponente elegido es imposible de atacar. Elija otro.");
		}

	}

	public void clickBotonVolverAtras(){
		Jugador jugadorActual = this.partida.getJugadorActual();
		if (jugadorActual == this.partida.getPlayer1()){
			this.mainApp.showMenuAutobots();
		}else{
			this.mainApp.showMenuDecepticons();
		}
		if (this.personajeAtacante.esUnico()){
			this.mainApp.showMenuDeOpciones();
		}else{
			this.mainApp.showSeleccionPersonajeAtaque();
		}
	}

	public void clickBotonTerminarTurno(){
		this.mainApp.terminarTurno();
	}

	private void actualizarDatosIndividual(Personaje personaje, Label vida,Label ataque, Label alcance, Label velocidad){
		vida.setText(String.valueOf(personaje.getPuntosDeVida()));
		ataque.setText(String.valueOf(personaje.getAtaque()));
		alcance.setText(String.valueOf(personaje.getDistanciaDeAtaque()));
		velocidad.setText(String.valueOf(personaje.getVelocidad()));
	}

	private void actualizarDatos() {

		Personaje personaje1 = this.partida.getJugadorEnEspera().getPersonaje1();
		this.actualizarDatosIndividual(personaje1, this.ptosDeVidaPersonaje1, this.ataquePersonaje1, this.distDeAtaquePersonaje1, this.velocidadPersonaje1);
		Personaje personaje2 = this.partida.getJugadorEnEspera().getPersonaje2();
		this.actualizarDatosIndividual(personaje2, this.ptosDeVidaPersonaje2, this.ataquePersonaje2, this.distDeAtaquePersonaje2, this.velocidadPersonaje2);
		Personaje personaje3 = this.partida.getJugadorEnEspera().getPersonaje3();
		this.actualizarDatosIndividual(personaje3, this.ptosDeVidaPersonaje3, this.ataquePersonaje3, this.distDeAtaquePersonaje3, this.velocidadPersonaje3);
		
		this.botonPersonaje1.setText("1-"+personaje1.toString());
		this.botonPersonaje2.setText("2-"+personaje2.toString());
		this.botonPersonaje3.setText("3-"+personaje3.toString());
		
		if (!personaje1.estaVivo()){
			this.botonPersonaje1.setDisable(true);
		} 
		if (!personaje2.estaVivo()){
			this.botonPersonaje2.setDisable(true);
		}
		if (!personaje3.estaVivo()){
			this.botonPersonaje3.setDisable(true);
		}
		
	}

	public void setPartida(Partida partida) {
		this.partida = partida;
		this.actualizarDatos();
	}

	public void setPersonajeAtacante(Personaje personajeAtacante) {
		this.personajeAtacante = personajeAtacante;
		this.nombrePersonajeAtacante.setText(this.personajeAtacante.toString());
		this.ataquePersonajeAtacante.setText(String.valueOf(personajeAtacante.getAtaque()));
		this.distDeAtaquePersonajeAtacante.setText(String.valueOf(personajeAtacante.getDistanciaDeAtaque()));
	}

	public void setMainApp(MainApp mainApp) {
		this.mainApp = mainApp;
	}

}
