package fiuba.algo3.vistas.controllers;

import fiuba.algo3.MainApp;
import fiuba.algo3.modelo.jugabilidad.Jugador;
import fiuba.algo3.modelo.jugabilidad.Partida;
import fiuba.algo3.modelo.personajes.Personaje;
import fiuba.algo3.vistas.CajaAlerta;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.Button;

public class VentanaDeAccionesController {

	@FXML
	private Label nombreJugador;

	@FXML
	private Button botonAtacar;
	@FXML
	private Button botonTransformar;
	@FXML
	private Button botonModoUnico;
	@FXML
	private Button botonMover;


	private Partida partida;
	private MainApp mainApp;


	public void validarBotonesSiEsUnico(){
		if (this.esUnico()){
			this.botonTransformar.setDisable(true);
			this.botonModoUnico.setDisable(true);
			
			if(this.partida.getJugadorActual().getPersonajeModoUnico().estaInmovilizado()){
				this.botonAtacar.setDisable(true);
				this.botonMover.setDisable(true);
			}
		}else{
			if (this.hayPersonajesMuertos()){
				this.botonModoUnico.setDisable(true);
			}
		}
	}

	private boolean hayPersonajesMuertos() {
		boolean personaje1EstaVivo = this.partida.getJugadorActual().getPersonaje1().estaVivo();
		boolean personaje2EstaVivo = this.partida.getJugadorActual().getPersonaje2().estaVivo();
		boolean personaje3EstaVivo = this.partida.getJugadorActual().getPersonaje3().estaVivo();
		return (!personaje1EstaVivo || !personaje2EstaVivo || !personaje3EstaVivo);
	}

	public void clickBotonMovimiento(){
		if (this.esUnico()){
			Personaje personaje = this.partida.getJugadorActual().getPersonajeModoUnico();
			this.mainApp.showMovimientoDePersonaje(personaje);
		}else{
			this.mainApp.showSeleccionPersonajeMovimiento();
		}
	}

	public void clickBotonAtaque(){
		if (this.esUnico()){
			Personaje personaje = this.partida.getJugadorActual().getPersonajeModoUnico();
			this.mainApp.showAtaqueDePersonaje(personaje);
		}else{
			this.mainApp.showSeleccionPersonajeAtaque();
		}
	}

	public void clickBotonTransformacion(){
		if (this.esUnico()){
		}else{
			this.mainApp.showSeleccionPersonajeTransformacion();
		}
	}

	public void clickBotonTransformacionModoUnico(){
		Jugador jugadorActual = this.partida.getJugadorActual();
		try{
			this.partida.transformarAlgoformerAModoUnico(jugadorActual);

			this.mainApp.getControladorTablero().fusionarPersonajes(jugadorActual);

			this.clickBotonTerminarTurno();
		}catch(Exception e){
			CajaAlerta.mostrar("Error", "Error en transformacion");
		}
	}

	public void clickBotonTerminarTurno(){
		this.mainApp.terminarTurno();
	}

	public void setMainApp(MainApp mainApp){
		this.mainApp = mainApp;
	}

	private boolean esUnico(){
		Jugador jugador = this.partida.getJugadorActual();
		return jugador.getPersonajeModoUnico() != null;
	}

	public void setPartida(Partida partida) {
		this.partida = partida;
		this.esUnico();

	}

	public void setNombreJugador(String nombre){
		this.nombreJugador.setText(nombre);
	}
}
