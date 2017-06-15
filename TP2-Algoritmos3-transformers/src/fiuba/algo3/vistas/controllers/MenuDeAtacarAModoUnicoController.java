package fiuba.algo3.vistas.controllers;

import fiuba.algo3.MainApp;
import fiuba.algo3.modelo.jugabilidad.Jugador;
import fiuba.algo3.modelo.jugabilidad.Partida;
import fiuba.algo3.modelo.personajes.Personaje;
import fiuba.algo3.vistas.CajaAlerta;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class MenuDeAtacarAModoUnicoController {
	@FXML
	private Label nombrePersonajeAtacante;
	@FXML
	private Label ataquePersonajeAtacante;
	@FXML
	private Label distDeAtaquePersonajeAtacante;
	
	@FXML
	private Button botonPersonje;
	@FXML
	private Label ptosDeVidaPersonaje;
	@FXML
	private Label ataquePersonaje;
	@FXML
	private Label distDeAtaquePersonaje;
	@FXML
	private Label velocidadPersonaje;

	private Partida partida;
	private Personaje personajeAtacante;
	private MainApp mainApp;

	public void clickBotonAtacarAPersonajeUnico(){
		Jugador jugadorEnEspera = this.partida.getJugadorEnEspera();
		try{
			this.partida.atacarConAlgoformerA(this.personajeAtacante, jugadorEnEspera.getPersonajeModoUnico());
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
		
		Personaje personaje = this.partida.getJugadorEnEspera().getPersonajeModoUnico();
		this.actualizarDatosIndividual(personaje, this.ptosDeVidaPersonaje, this.ataquePersonaje, this.distDeAtaquePersonaje, this.velocidadPersonaje);
		
		this.botonPersonje.setText(personaje.toString());
	}

	public void setPartida(Partida partida) {
		this.partida = partida;
		this.actualizarDatos();
	}

	public void setPersonajeAtacante(Personaje personajeAtacante) {
		this.personajeAtacante = personajeAtacante;
		this.nombrePersonajeAtacante.setText(this.personajeAtacante.toString());
		this.ataquePersonajeAtacante.setText(String.valueOf(this.personajeAtacante.getAtaque()));
		this.distDeAtaquePersonajeAtacante.setText(String.valueOf(this.personajeAtacante.getDistanciaDeAtaque()));
	}

	public void setMainApp(MainApp mainApp) {
		this.mainApp = mainApp;
	}

}

