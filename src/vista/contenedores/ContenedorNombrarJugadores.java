package vista.contenedores;

import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.util.ArrayList;

import controlador.handlers.BotonHandler;

public class ContenedorNombrarJugadores {
	
	private TextField nombreJugador1;
    private TextField nombreJugador2;
    private Boolean nombresIngresados;
    
    public ContenedorNombrarJugadores(){

        nombreJugador1 = new TextField("Jugador 1");
        nombreJugador1.setMinSize(50, 40);
        nombreJugador1.setMaxWidth(250);
        nombreJugador2 = new TextField("Jugador 2");
        nombreJugador2.setMinSize(50, 40);
        nombreJugador2.setMaxWidth(250);
        nombresIngresados = false;

    }
    
    public Boolean jugadoresFueronIngresados(){
        return nombresIngresados;

    }
    
    public void mostrar() {
        Stage window = new Stage();
        
       
        window.setTitle("Nombre Jugadores");
        window.setWidth(1000);
        window.setHeight(600);
        window.centerOnScreen();
        
        ImageView imagen_ingreso_nombre_jugador1 = new ImageView();
        imagen_ingreso_nombre_jugador1.setImage(new Image("file:src/vista/imagenes/jugador1ingresarnombre.png"));
        
        ImageView imagen_ingreso_nombre_jugador2 = new ImageView();
        imagen_ingreso_nombre_jugador2.setImage(new Image("file:src/vista/imagenes/jugador2ingresarnombre.png"));

        Button aceptar = new Button("A jugar!");
        aceptar.setTextFill(Color.CHOCOLATE);
        aceptar.setFont(Font.font("Rockwell", 40));
        aceptar.setStyle("-fx-base: rgb(249,219,189)");
        aceptar.setMinSize(180, 40);

        BotonHandler aceptarHandler = new BotonHandler() {
            @Override
            public void handle(ActionEvent event) {
                super.handle(event);
                nombresIngresados = true;
                window.close();

            }
        };
        aceptar.setOnAction(aceptarHandler);
        
        ArrayList<Node> lista = new ArrayList<Node>();
        lista.add(imagen_ingreso_nombre_jugador1);
        lista.add(nombreJugador1);
        lista.add(imagen_ingreso_nombre_jugador2);
        lista.add(nombreJugador2);
        lista.add(aceptar);
        
		VBox contenedor = crearContenedorVentanaNombrarJugadores(lista);
        VBox.setMargin(aceptar,new Insets(0,0,10,0));

        Scene scene = new Scene(contenedor);
        window.setScene(scene);
        window.showAndWait();
        
    }
    
    private VBox crearContenedorVentanaNombrarJugadores(ArrayList<Node> lista) {
        VBox contenedor = new VBox(20);
        contenedor.getChildren().addAll(lista);
        contenedor.setAlignment(Pos.CENTER);
        
        Image imagen = new Image("file:src/vista/imagenes/imageneleccionnombre.jpg");
        BackgroundSize tamano = new BackgroundSize(1000, 600, true, true, true, true);
        BackgroundImage imagenDeFondo = new BackgroundImage(imagen, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER,
        tamano);
        contenedor.setBackground(new Background(imagenDeFondo)); 
		return contenedor;
	}
    
    public String getNombreJugador1 (){
        return nombreJugador1.getText();

    }

    public String getNombreJugador2 (){
        return nombreJugador2.getText();

    }
}
