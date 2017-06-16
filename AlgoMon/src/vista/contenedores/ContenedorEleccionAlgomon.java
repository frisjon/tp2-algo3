package vista.contenedores;

import controlador.handlers.BotonEmpezarEventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.media.AudioClip;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import modelo.Jugador;
import vista.BarraDeMenu;

public class ContenedorEleccionAlgomon extends BorderPane{

    public ContenedorEleccionAlgomon(Stage primaryStage, String nombreJugador1, String nombreJugador2, AudioClip musicaDeFondo) {

        Image fondo = new Image("file:src/vista/imagenes/fondosEleccion/pokefacha.jpg");
        BackgroundImage imagenDeFondo =
                new BackgroundImage(fondo, BackgroundRepeat.REPEAT,
                        BackgroundRepeat.REPEAT, BackgroundPosition.CENTER,
                        BackgroundSize.DEFAULT);
        this.setBackground(new Background(imagenDeFondo));
        		
        Jugador jugador1 = new Jugador(0,nombreJugador1);
        Jugador jugador2 = new Jugador(1,nombreJugador2);

        VBox espacioParaJugador1 = new EspacioEleccionParaJugador(nombreJugador1,jugador1);
        VBox espacioParaJugador2 = new EspacioEleccionParaJugador(nombreJugador2,jugador2);
        
        Button botonEmpezar = new Button("Empezar Partida");
        BotonEmpezarEventHandler botonEmpezarHandler = new BotonEmpezarEventHandler(
                primaryStage, jugador1, jugador2,musicaDeFondo);
        botonEmpezar.setOnAction(botonEmpezarHandler);
        botonEmpezar.setFont(Font.font("Lucida Console", FontWeight.BOLD,20));
        botonEmpezar.setStyle("-fx-base: rgb(249,219,189)");


        BarraDeMenu barraDeMenu = new BarraDeMenu(primaryStage);

        this.setTop(barraDeMenu);
        this.setLeft(espacioParaJugador1);
        this.setRight(espacioParaJugador2);
        this.setCenter(botonEmpezar);
        this.setMargin(botonEmpezar,new Insets(300,0,0,0));
        this.setMargin(espacioParaJugador1, new Insets(0,0,0,100));
        this.setMargin(espacioParaJugador2, new Insets(0,100,0,0));
        
    }


}