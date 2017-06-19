package vista.contenedores;

import controlador.handlers.BotonOpcionAtacarEventHandler;
import controlador.handlers.BotonOpcionMoverEventHandler;
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
    
    //InformacionParaJugador informacionParaJugador
    //Partida partida, ContenedorPelea contenedor, Jugador jugador
    
    public ContenedorOpcionesJuego(ContenedorJuego _contenedorJuego) {
        super();
        // usar lo que esta en AlgoM para poder hacer que se mueva y ataque, la idea es la misma

        this.contenedorJuego = _contenedorJuego;
        this.setPadding(new Insets(130, 50,0,50));
        this.setSpacing(15);
        this.setAlignment(Pos.CENTER);
        
        Button botonAtacar = new Button();
        botonAtacar.setText("Atacar");
        botonAtacar.setTextFill(Color.GRAY);
        botonAtacar.setFont(Font.font("Cooper Black", FontWeight.NORMAL,15));
        botonAtacar.setStyle("-fx-base: #b6e7c9;; -fx-border-color: rgb(249,219,189)");
        botonAtacar.setOnAction(new BotonOpcionAtacarEventHandler(this.contenedorJuego));
        botonAtacar.setMinSize(100.0, 50.0);
        
        Button botonMover = new Button();
        botonMover.setText("Mover");
        botonMover.setTextFill(Color.GRAY);
        botonMover.setFont(Font.font("Cooper Black", FontWeight.NORMAL,15));
        botonMover.setStyle("-fx-base: #b6e7c9;; -fx-border-color: rgb(249,219,189)");
        botonMover.setOnAction(new BotonOpcionMoverEventHandler(this.contenedorJuego));
        botonMover.setMinSize(100.0, 50.0);
        
        Button botonPasarTurno = new Button();
        botonPasarTurno.setText("Pasar Turno");
        botonPasarTurno.setTextFill(Color.GRAY);
        botonPasarTurno.setFont(Font.font("Cooper Black", FontWeight.NORMAL,15));
        botonPasarTurno.setStyle("-fx-base: #b6e7c9;; -fx-border-color: rgb(249,219,189)");
        botonPasarTurno.setOnAction(new BotonPasarTurnoEventHandler(this.contenedorJuego));
        botonPasarTurno.setMinSize(100.0, 50.0);
        
        this.getChildren().addAll(botonAtacar, botonMover, botonPasarTurno);
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
