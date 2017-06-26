package vista.contenedores;

import java.util.List;

import controlador.handlers.BotonSeleccionAtacarEventHandler;
import controlador.handlers.BotonSeleccionMoverEventHandler;
import controlador.handlers.BotonSeleccionTransformarEventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.control.Label;
import modelo.personajes.Personaje;
import vista.RepresentacionJugador;
import vista.RepresentacionPersonaje;

public class ContenedorSeleccionPersonaje extends VBox {
    private ContenedorJuego contenedorJuego;
    private RepresentacionJugador jugadorTurno;
    private List<RepresentacionPersonaje> personajesDeTurno;
    private Personaje pj1;
    private Personaje pj2;
    private Personaje pj3;
    private String modo;

    public ContenedorSeleccionPersonaje(ContenedorJuego _contenedorJuego, String _modo) {
        super();

        this.setPadding(new Insets(0, 50,0,50));
        this.setSpacing(15);
        this.setAlignment(Pos.CENTER);
        this.modo = _modo;
        this.contenedorJuego = _contenedorJuego;
        this.jugadorTurno = contenedorJuego.getRepresentacionJugador();
        this.personajesDeTurno = jugadorTurno.getRepresentacionesDePersonajes();
        this.pj1 = personajesDeTurno.get(0).getPersonaje();
        this.pj2 = personajesDeTurno.get(1).getPersonaje();
        this.pj3 = personajesDeTurno.get(2).getPersonaje();

        Button botonSeleccionarPersonaje1 = new Button();
        botonSeleccionarPersonaje1.setText(pj1.getNombre());
        botonSeleccionarPersonaje1.setTextFill(Color.GRAY);
        botonSeleccionarPersonaje1.setFont(Font.font("Cooper Black", FontWeight.NORMAL,15));
        botonSeleccionarPersonaje1.setStyle("-fx-base: #b6e7c9;; -fx-border-color: rgb(249,219,189)");
        botonSeleccionarPersonaje1.setMinSize(100.0, 50.0);
        _deshabilitarBotonPersonajeMuerto(pj1, botonSeleccionarPersonaje1); //desactiva el boton si el pj murio
        
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
        _deshabilitarBotonPersonajeMuerto(pj2, botonSeleccionarPersonaje2); 
        
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
        _deshabilitarBotonPersonajeMuerto(pj3, botonSeleccionarPersonaje3); 
        
        Label atributosPj3 = new Label();
        atributosPj3.setText("Vida: " + String.valueOf(pj3.getVida()) + "\n" + "Ataque : " + String.valueOf(pj3.getPoderPelea()) + "\n" + 
        "Ki: " + String.valueOf(pj3.getKi()) + "\n");
        atributosPj3.setFont(Font.font("Cooper Black", FontWeight.NORMAL,15));
        atributosPj3.setStyle("-fx-base: #b6e7c9;; -fx-border-color: rgb(249,219,189)");
        atributosPj3.setMinSize(75.0, 75.0);
        
        if (modo == "mover"){
            botonSeleccionarPersonaje1.setOnAction(new BotonSeleccionMoverEventHandler(this.contenedorJuego, this.personajesDeTurno.get(0)));
            botonSeleccionarPersonaje2.setOnAction(new BotonSeleccionMoverEventHandler(this.contenedorJuego, this.personajesDeTurno.get(1)));
            botonSeleccionarPersonaje3.setOnAction(new BotonSeleccionMoverEventHandler(this.contenedorJuego, this.personajesDeTurno.get(2)));
        } else if (modo == "atacar") {
        	
            botonSeleccionarPersonaje1.setOnAction(new BotonSeleccionAtacarEventHandler(this.contenedorJuego, this.pj1));
            botonSeleccionarPersonaje2.setOnAction(new BotonSeleccionAtacarEventHandler(this.contenedorJuego, this.pj2));
            botonSeleccionarPersonaje3.setOnAction(new BotonSeleccionAtacarEventHandler(this.contenedorJuego, this.pj3));
        } else {
        	botonSeleccionarPersonaje1.setOnAction(new BotonSeleccionTransformarEventHandler(this.contenedorJuego, this.personajesDeTurno.get(0),this.pj1));
            botonSeleccionarPersonaje2.setOnAction(new BotonSeleccionTransformarEventHandler(this.contenedorJuego, this.personajesDeTurno.get(1),this.pj2));
            botonSeleccionarPersonaje3.setOnAction(new BotonSeleccionTransformarEventHandler(this.contenedorJuego, this.personajesDeTurno.get(2),this.pj3));
        }
        
        this.getChildren().addAll(botonSeleccionarPersonaje1, atributosPj1, botonSeleccionarPersonaje2, atributosPj2, botonSeleccionarPersonaje3,
                atributosPj3);
        this.setAlignment(Pos.CENTER);
    }
    
    private void _deshabilitarBotonPersonajeMuerto(Personaje personaje, Button botonpersonaje) {
    	if(personaje.getVida() == 0.0) {
    		botonpersonaje.setDisable(true);
    	}
    }
}
