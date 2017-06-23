package vista.contenedores;

import controlador.handlers.BotonOpcionAtacarEventHandler;
import controlador.handlers.BotonOpcionMoverEventHandler;
import controlador.handlers.BotonOpcionTransformarEventHandler;
import controlador.handlers.BotonPasarTurnoEventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class ContenedorOpcionesJuego extends VBox {
    
    private ContenedorJuego contenedorJuego;
    private Button botonAtacar;
    private Button botonMover;
    
    //InformacionParaJugador informacionParaJugador
    //Partida partida, ContenedorPelea contenedor, Jugador jugador
    
    public ContenedorOpcionesJuego(ContenedorJuego _contenedorJuego) {
        super();
        // usar lo que esta en AlgoM para poder hacer que se mueva y ataque, la idea es la misma

        this.contenedorJuego = _contenedorJuego;
        this.setPadding(new Insets(10, 10,10,10));
        this.setSpacing(15);
        this.setAlignment(Pos.CENTER);
        
        this.botonAtacar = new Button();
        this.botonAtacar.setText("Atacar");
        this.botonAtacar.setTextFill(Color.GRAY);
        this.botonAtacar.setFont(Font.font("Cooper Black", FontWeight.NORMAL,15));
        this.botonAtacar.setStyle("-fx-base: #b6e7c9;; -fx-border-color: rgb(249,219,189)");
        this.botonAtacar.setOnAction(new BotonOpcionAtacarEventHandler(this.contenedorJuego));
        this.botonAtacar.setMinSize(100.0, 50.0);
        
        this.botonMover = new Button();
        this.botonMover.setText("Mover");
        this.botonMover.setTextFill(Color.GRAY);
        this.botonMover.setFont(Font.font("Cooper Black", FontWeight.NORMAL,15));
        this.botonMover.setStyle("-fx-base: #b6e7c9; -fx-border-color: rgb(249,219,189)");
        this.botonMover.setOnAction(new BotonOpcionMoverEventHandler(this.contenedorJuego));
        this.botonMover.setMinSize(100.0, 50.0);
        
        Button botonTransformar = new Button();
        botonTransformar.setText("Transformar");
        botonTransformar.setTextFill(Color.GRAY);
        botonTransformar.setFont(Font.font("Cooper Black", FontWeight.NORMAL,15));
        botonTransformar.setStyle("-fx-base: #b6e7c9;; -fx-border-color: rgb(249,219,189)");
        botonTransformar.setOnAction(new BotonOpcionTransformarEventHandler(this.contenedorJuego));
        botonTransformar.setMinSize(100.0, 50.0);
        
        
        Button botonPasarTurno = new Button();
        botonPasarTurno.setText("Pasar Turno");
        botonPasarTurno.setTextFill(Color.GRAY);
        botonPasarTurno.setFont(Font.font("Cooper Black", FontWeight.NORMAL,15));
        botonPasarTurno.setStyle("-fx-base: #b6e7c9;; -fx-border-color: rgb(249,219,189)");
        botonPasarTurno.setOnAction(new BotonPasarTurnoEventHandler(this.contenedorJuego));
        botonPasarTurno.setMinSize(100.0, 50.0);
        
        this.getChildren().addAll(botonAtacar, botonMover,botonTransformar, botonPasarTurno);
    }
    
    public void deshabilitarBotonAtaque() {
    	this.botonAtacar.setDisable(true);
    	
    }
    
    public void deshabilitarBotonMover() {
    	this.botonMover.setDisable(true);
    	
    }
    
	public void reestablecerBotones() {
		this.botonAtacar.setDisable(false);
		this.botonMover.setDisable(false);
		
	}
    
    public void bloquearBotonera(boolean bloqueo) {
        //this.getBotonera().bloquear(bloqueo);       
    }
    
    public void actualizar(){
        //informacionParaJugador.actualizar();
    }


    /*public void bloquear(boolean bloqueo) {
        this.botonAtacar.setDisable(bloqueo);
        this.botonSeleccionarPersonaje.setDisable(bloqueo);
        this.botonUsarConsumible.setDisable(bloqueo);
    }
    
    public void habilitarSoloSeleccionarPersonaje(){
        this.botonAtacar.setDisable(true);
        this.botonSeleccionarPersonaje.setDisable(false);
        this.botonUsarConsumible.setDisable(true);
    }
    
    public void habilitarSoloUsarConsumible(){
        this.botonAtacar.setDisable(true);
        this.botonSeleccionarPersonaje.setDisable(true);
        this.botonUsarConsumible.setDisable(false);
    }*/
}
