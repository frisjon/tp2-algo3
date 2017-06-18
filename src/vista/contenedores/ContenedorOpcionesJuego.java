package vista.contenedores;

import controlador.handlers.BotonMenuEventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.MenuButton;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import modelo.jugador.Jugador;
import modelo.tablero.Tablero;
import vista.BotonMenu;
import vista.RepresentacionJugador;

public class ContenedorOpcionesJuego extends VBox {
    
    private Jugador jugador;
    
    //InformacionParaJugador informacionParaJugador
    //Partida partida, ContenedorPelea contenedor, Jugador jugador
    
    public ContenedorOpcionesJuego(RepresentacionJugador representacionJugadorDeTurno) {
        super();
        // usar lo que esta en AlgoM para poder hacer que se mueva y ataque, la idea es la misma
        
        this.setPadding(new Insets(130, 50,0,50));
        this.setSpacing(15);
        this.setAlignment(Pos.CENTER);

        Button botonSeleccionarPersonajeaEquipoEnemigo = new Button();
        botonSeleccionarPersonajeaEquipoEnemigo.setText("Seleccionar personaje a atacar");
        botonSeleccionarPersonajeaEquipoEnemigo.setTextFill(Color.GRAY);
        botonSeleccionarPersonajeaEquipoEnemigo.setFont(Font.font("Cooper Black", FontWeight.NORMAL,10));
        botonSeleccionarPersonajeaEquipoEnemigo.setStyle("-fx-base: #b6e7c9;; -fx-border-color: rgb(249,219,189)");
        
        Button botonAtacar = new Button();
        botonAtacar.setText("Atacar");
        botonAtacar.setTextFill(Color.GRAY);
        botonAtacar.setFont(Font.font("Cooper Black", FontWeight.NORMAL,10));
        botonAtacar.setStyle("-fx-base: #b6e7c9;; -fx-border-color: rgb(249,219,189)");
        
        Button botonSeleccionarPersonajeMiEquipo = new Button();
        botonSeleccionarPersonajeMiEquipo.setText("Seleccionar personaje de mi equipo");
        botonSeleccionarPersonajeMiEquipo.setTextFill(Color.GRAY);
        botonSeleccionarPersonajeMiEquipo.setFont(Font.font("Cooper Black", FontWeight.NORMAL,10));
        botonSeleccionarPersonajeMiEquipo.setStyle("-fx-base: #b6e7c9;; -fx-border-color: rgb(249,219,189)");
        
        Button botonMoverArriba = new Button();
        botonMoverArriba.setText("Mover arriba");
        botonMoverArriba.setTextFill(Color.GRAY);
        botonMoverArriba.setFont(Font.font("Cooper Black", FontWeight.NORMAL,10));
        botonMoverArriba.setStyle("-fx-base: #b6e7c9;; -fx-border-color: rgb(249,219,189)");
        
        Button botonMoverAbajo = new Button();
        botonMoverAbajo.setText("Mover abajo");
        botonMoverAbajo.setTextFill(Color.GRAY);
        botonMoverAbajo.setFont(Font.font("Cooper Black", FontWeight.NORMAL,10));
        botonMoverAbajo.setStyle("-fx-base: #b6e7c9;; -fx-border-color: rgb(249,219,189)");
        
        Button botonMoverIzquierda = new Button();
        botonMoverIzquierda.setText("Mover izquierda");
        botonMoverIzquierda.setTextFill(Color.GRAY);
        botonMoverIzquierda.setFont(Font.font("Cooper Black", FontWeight.NORMAL,10));
        botonMoverIzquierda.setStyle("-fx-base: #b6e7c9;; -fx-border-color: rgb(249,219,189)");
        
        Button botonMoverDerecha = new Button();
        botonMoverDerecha.setText("Mover derecha");
        botonMoverDerecha.setTextFill(Color.GRAY);
        botonMoverDerecha.setFont(Font.font("Cooper Black", FontWeight.NORMAL,10));
        botonMoverDerecha.setStyle("-fx-base: #b6e7c9;; -fx-border-color: rgb(249,219,189)");
        
        Button botonMovimientoCargado = new Button();
        botonMovimientoCargado.setText("Movimiento cargado");
        botonMovimientoCargado.setTextFill(Color.GRAY);
        botonMovimientoCargado.setFont(Font.font("Cooper Black", FontWeight.NORMAL,10));
        botonMovimientoCargado.setStyle("-fx-base: #b6e7c9;; -fx-border-color: rgb(249,219,189)");
        
        this.getChildren().addAll(botonSeleccionarPersonajeaEquipoEnemigo, botonAtacar, botonSeleccionarPersonajeMiEquipo,
        		botonMoverArriba, botonMoverAbajo, botonMoverIzquierda, botonMoverDerecha, 
        		botonMovimientoCargado);
        this.setAlignment(Pos.CENTER);
        /*this.bloquear(jugador != partida.jugadorActual());
         */
    }
    
    public Jugador getJugador(){
        return this.jugador;
    }
    
    public String getNombreJugador() {
        return this.getJugador().getNombre();
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
