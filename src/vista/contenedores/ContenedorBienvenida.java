package vista.contenedores;

import controlador.handlers.BotonEntrarEventHandler;
import controlador.handlers.BotonReglasEventHandler;
import controlador.handlers.BotonSalirEventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.media.AudioClip;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class ContenedorBienvenida extends VBox{

    //public ContenedorBienvenida(Stage primaryStage, AudioClip musicaDeFondo) {
	public ContenedorBienvenida(Stage primaryStage) {
        super();
        this.setAlignment(Pos.TOP_LEFT);
        this.setSpacing(70);
        primaryStage.setFullScreen(true);

        Label titulo = new Label("Dragon Ball Z");
        titulo.setFont(Font.font("",FontWeight.NORMAL, 76));
        titulo.setTextFill(Color.RED);
        

        Image imagen = new Image("file:src/vista/imagenes/dbz-inicio.jpg");

        BackgroundImage imagenDeFondo =new BackgroundImage(imagen, BackgroundRepeat.REPEAT,BackgroundRepeat.REPEAT, BackgroundPosition.CENTER,
        BackgroundSize.DEFAULT);
        this.setBackground(new Background(imagenDeFondo));

        Button botonEntrar = new Button();
        botonEntrar.setMinSize(260, 100);
        botonEntrar.setText("Jugar");
        botonEntrar.setTextFill(Color.GRAY);
        botonEntrar.setFont(Font.font("Cooper Black", FontWeight.NORMAL,40));
        botonEntrar.setStyle("-fx-base: #b6e7c9;; -fx-border-color: rgb(249,219,189)");

      
       // BotonEntrarEventHandler botonEntrarHandler = new BotonEntrarEventHandler(primaryStage,musicaDeFondo);
        BotonEntrarEventHandler botonEntrarHandler = new BotonEntrarEventHandler(primaryStage);
        botonEntrar.setOnAction(botonEntrarHandler);

        Button botonReglas = new Button();
        botonReglas.setMinSize(200, 60);
        botonReglas.setText("Reglas del juego");
        botonReglas.setTextFill(Color.GRAY);
        botonReglas.setFont(Font.font("Cooper Black", 30));
        botonReglas.setStyle("-fx-base: #b6e7c9; -fx-border-color: rgb(249,219,189)");

        BotonReglasEventHandler botonReglasHandler = new BotonReglasEventHandler();
        botonReglas.setOnAction(botonReglasHandler);

        Button botonSalir = new Button();
        botonSalir.setMinSize(200, 60);
        botonSalir.setText("Salir");
        botonSalir.setTextFill(Color.GRAY);
        botonSalir.setFont(Font.font("Cooper Black", 20));
        botonSalir.setStyle("-fx-base: #b6e7c9; -fx-border-color: rgb(249,219,189)");

        BotonSalirEventHandler botonSalirHandler = new BotonSalirEventHandler();
        botonSalir.setOnAction(botonSalirHandler);

        //ContenedorVolumen contenedorVolumen = new ContenedorVolumen(musicaDeFondo);
        //contenedorVolumen.setAlignment(Pos.CENTER_LEFT);
        //contenedorVolumen.setPadding(new Insets(30, 0, 30, 0));

        //this.getChildren().addAll(titulo, botonEntrar,contenedorVolumen, botonReglas, botonSalir);
        this.getChildren().addAll(titulo, botonEntrar, botonReglas, botonSalir);
        this.setPadding(new Insets(30, 0, 30, 220));
        this.setSpacing(50);
    }
}
