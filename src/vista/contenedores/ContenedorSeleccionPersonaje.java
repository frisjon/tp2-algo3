package vista.contenedores;

import java.util.List;

import controlador.handlers.BotonHandler;
import controlador.handlers.BotonMenuEventHandler;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.MenuButton;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.scene.control.Label;
import modelo.jugador.Jugador;
import modelo.personajes.Personaje;
import modelo.tablero.Tablero;
import vista.BotonMenu;
import vista.RepresentacionJugador;
import vista.RepresentacionPersonaje;

public class ContenedorSeleccionPersonaje extends VBox {
    private RepresentacionJugador jugadorTurno;
    private List<RepresentacionPersonaje> personajesDeTurno;
    private Personaje pj1;
    private Personaje pj2;
    private Personaje pj3;
    private BotonHandler handler;

    public ContenedorSeleccionPersonaje(RepresentacionJugador representacionJugadorDeTurno, BotonHandler _handler) {
        super();

        this.setPadding(new Insets(0, 50,0,50));
        this.setSpacing(15);
        this.setAlignment(Pos.CENTER);
        this.jugadorTurno = representacionJugadorDeTurno;
        this.personajesDeTurno = representacionJugadorDeTurno.getRepresentacionesDePersonajes();
        this.pj1 = personajesDeTurno.get(0).getPersonaje();
        this.pj2 = personajesDeTurno.get(1).getPersonaje();
        this.pj3 = personajesDeTurno.get(2).getPersonaje();
        /**
         * Handler que se va a ultizar al apretar un boton. Va a varias entre Mover y Atacar.
         */
        this.handler = _handler;
        
        Button botonSeleccionarPersonaje1 = new Button();
        botonSeleccionarPersonaje1.setText(pj1.getNombre());
        botonSeleccionarPersonaje1.setTextFill(Color.GRAY);
        botonSeleccionarPersonaje1.setFont(Font.font("Cooper Black", FontWeight.NORMAL,15));
        botonSeleccionarPersonaje1.setStyle("-fx-base: #b6e7c9;; -fx-border-color: rgb(249,219,189)");
        botonSeleccionarPersonaje1.setMinSize(100.0, 50.0);
        
        Label atributosPj1 = new Label();
        atributosPj1.setText("Vida: " + String.valueOf(pj1.getVida()) + "\n" + "Ataque : " + String.valueOf(pj1.getPoderPelea()) + "\n" + 
        "Ki: " + String.valueOf(pj1.getKi()) + "\n");
        atributosPj1.setFont(Font.font("Cooper Black", FontWeight.NORMAL,15));
        atributosPj1.setStyle("-fx-base: #b6e7c9;; -fx-border-color: rgb(249,219,189)");
        atributosPj1.setMinSize(75.0, 75.0);

        Button botonSeleccionarPersonaje2 = new Button();
        botonSeleccionarPersonaje2.setText(pj2.getNombre());
        botonSeleccionarPersonaje2.setTextFill(Color.GRAY);
        botonSeleccionarPersonaje2.setFont(Font.font("Cooper Black", FontWeight.NORMAL,15));
        botonSeleccionarPersonaje2.setStyle("-fx-base: #b6e7c9;; -fx-border-color: rgb(249,219,189)");
        botonSeleccionarPersonaje2.setMinSize(100.0, 50.0);
        
        Label atributosPj2 = new Label();
        atributosPj2.setText("Vida: " + String.valueOf(pj2.getVida()) + "\n" + "Ataque : " + String.valueOf(pj2.getPoderPelea()) + "\n" + 
        "Ki: " + String.valueOf(pj2.getKi()) + "\n");
        atributosPj2.setFont(Font.font("Cooper Black", FontWeight.NORMAL,15));
        atributosPj2.setStyle("-fx-base: #b6e7c9;; -fx-border-color: rgb(249,219,189)");
        atributosPj2.setMinSize(75.0, 75.0);
        
        Button botonSeleccionarPersonaje3 = new Button();
        botonSeleccionarPersonaje3.setText(pj3.getNombre());
        botonSeleccionarPersonaje3.setTextFill(Color.GRAY);
        botonSeleccionarPersonaje3.setFont(Font.font("Cooper Black", FontWeight.NORMAL,15));
        botonSeleccionarPersonaje3.setStyle("-fx-base: #b6e7c9;; -fx-border-color: rgb(249,219,189)");
        botonSeleccionarPersonaje3.setMinSize(100.0, 50.0);
        
        Label atributosPj3 = new Label();
        atributosPj3.setText("Vida: " + String.valueOf(pj3.getVida()) + "\n" + "Ataque : " + String.valueOf(pj3.getPoderPelea()) + "\n" + 
        "Ki: " + String.valueOf(pj3.getKi()) + "\n");
        atributosPj3.setFont(Font.font("Cooper Black", FontWeight.NORMAL,15));
        atributosPj3.setStyle("-fx-base: #b6e7c9;; -fx-border-color: rgb(249,219,189)");
        atributosPj3.setMinSize(75.0, 75.0);
        
        this.getChildren().addAll(botonSeleccionarPersonaje1, atributosPj1, botonSeleccionarPersonaje2, atributosPj2, botonSeleccionarPersonaje3,
                atributosPj3);
        this.setAlignment(Pos.CENTER);
    }
}
