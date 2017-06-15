package fiuba.algo3.vistas.controllers;

import fiuba.algo3.MainApp;
import fiuba.algo3.vistas.CajaAlerta;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class PantallaDeInicioController {
	@FXML
	private TextField nombreJugador1;
	@FXML
	private TextField nombreJugador2;
	
	private MainApp mainApp;
	
	public PantallaDeInicioController(){
		
	}
	
	@FXML
	private void HandleTeclaPresionada(KeyEvent tecla){
		if (tecla.getCode() == KeyCode.ENTER){
			this.handleInicioDePartida();
		}
	}
	
	@FXML 
	private void handleInicioDePartida(){
		if (this.estanCompletosLosCampos()){
			String jugadorAutobots = nombreJugador1.getText();
			String jugadorDecepticons = nombreJugador2.getText();
			this.mainApp.comenzarPartida(jugadorAutobots, jugadorDecepticons);
			this.mainApp.showTableroRaiz();
			this.mainApp.getControladorTablero().actualizarPosicionesGenerales();
			this.mainApp.showMenuDeOpciones();
			this.mainApp.showMenuAutobots();
		}
	}
	
	public boolean estanCompletosLosCampos(){
		if (this.nombreJugador1.getText().isEmpty()){
			CajaAlerta.mostrar("Datos Invalidos", "El casillero de los autobots esta vacio. Completar para jugar...");
			return false;
		}
		if (this.nombreJugador2.getText().isEmpty()){
			CajaAlerta.mostrar("Datos Invalidos", "El casillero de los decepticons esta vacio. Completar para jugar...");
			return false;
		}
		return true;

	}
	
	public void setMainApp(MainApp mainApp){
		this.mainApp = mainApp;
	}
}
