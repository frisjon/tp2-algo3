package fiuba.algo3.vistas.controllers;

import fiuba.algo3.MainApp;
import fiuba.algo3.modelo.jugabilidad.Partida;
import fiuba.algo3.modelo.personajes.Personaje;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class MenuDeAtaqueController {
	
	@FXML
	private Button botonPersonaje1;
	@FXML
	private Button botonPersonaje2;
	@FXML
	private Button botonPersonaje3;
	
	@FXML
	private Label nombreJugador;
	@FXML
	private Label tipoDeAlgoformers;
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
	private MainApp mainApp;

	public void clickBotonAtacarConPersonaje1(){

		Personaje personaje1 = this.partida.getJugadorActual().getPersonaje1();
		this.mainApp.showAtaqueDePersonaje(personaje1);
	}

	public void clickBotonAtacarConPersonaje2(){

		Personaje personaje2 = this.partida.getJugadorActual().getPersonaje2();
		this.mainApp.showAtaqueDePersonaje(personaje2);

		}

	public void clickBotonAtacarConPersonaje3(){

		Personaje personaje3 = this.partida.getJugadorActual().getPersonaje3();
		this.mainApp.showAtaqueDePersonaje(personaje3);

		}

	public void clickBotonVolverAtras(){
		this.mainApp.showMenuDeOpciones();
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

		Personaje personaje1 = this.partida.getJugadorActual().getPersonaje1();
		this.actualizarDatosIndividual(personaje1, this.ptosDeVidaPersonaje1, this.ataquePersonaje1, this.distDeAtaquePersonaje1, this.velocidadPersonaje1);
		Personaje personaje2 = this.partida.getJugadorActual().getPersonaje2();
		this.actualizarDatosIndividual(personaje2, this.ptosDeVidaPersonaje2, this.ataquePersonaje2, this.distDeAtaquePersonaje2, this.velocidadPersonaje2);
		Personaje personaje3 = this.partida.getJugadorActual().getPersonaje3();
		this.actualizarDatosIndividual(personaje3, this.ptosDeVidaPersonaje3, this.ataquePersonaje3, this.distDeAtaquePersonaje3, this.velocidadPersonaje3);
		
		this.botonPersonaje1.setText("1-"+personaje1.toString());
		this.botonPersonaje2.setText("2-"+personaje2.toString());
		this.botonPersonaje3.setText("3-"+personaje3.toString());
		
		this.nombreJugador.setText(this.partida.getJugadorActual().getNombre());
		if (this.partida.getJugadorActual() == this.partida.getPlayer1()){
			this.tipoDeAlgoformers.setText("Autobots");
		}else{
			this.tipoDeAlgoformers.setText("Decepticons");
		}
		
		if (personaje1.estaInmovilizado() || !personaje1.estaVivo()){
			this.botonPersonaje1.setDisable(true);
		} 
		if (personaje2.estaInmovilizado() || !personaje2.estaVivo()){
			this.botonPersonaje2.setDisable(true);
		}
		if (personaje3.estaInmovilizado() || !personaje3.estaVivo()){
			this.botonPersonaje3.setDisable(true);
		}
		
	}

	public void setPartida(Partida partida) {
		this.partida = partida;
		this.actualizarDatos();
	}

	public void setMainApp(MainApp mainApp) {
		this.mainApp = mainApp;
	}
}
