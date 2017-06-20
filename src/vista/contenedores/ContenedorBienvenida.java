package vista.contenedores;

import controlador.handlers.BotonJugarEventHandler;
import controlador.handlers.BotonReglasEventHandler;
import controlador.handlers.BotonSalirEventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
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
        this.setAlignment(Pos.TOP_CENTER);
        this.setSpacing(100);
        primaryStage.setFullScreen(true);
        
        Image imagen = new Image("file:src/vista/imagenes/imagen_inicio.jpg");

        BackgroundImage imagenDeFondo =new BackgroundImage(imagen, BackgroundRepeat.REPEAT,BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT,
        BackgroundSize.DEFAULT);
        this.setBackground(new Background(imagenDeFondo));
        
        ImageView imagent = new ImageView();
        imagent.setImage(new Image("file:src/vista/imagenes/Titulo_inicio.png"));

        Button botonEntrar = new Button();
        botonEntrar.setMinSize(260, 100);
        botonEntrar.setText("Jugar");
        botonEntrar.setTextFill(Color.KHAKI);
        botonEntrar.setFont(Font.font("Cooper Black"));
        botonEntrar.setStyle("-fx-padding: 8 15 15 15;  -fx-background-insets: 0,0 0 5 0, 0 0 6 0, 0 0 7 0; -fx-background-radius: 8;"
        		+ "-fx-background-color: linear-gradient(from 0% 93% to 0% 100%, #a34313 0%, #903b12 100%),#9d4024,#d86e3a,radial-gradient(center 50% 50%, radius 100%, #d86e3a, #c54e2c);"
        		+ " -fx-effect: dropshadow( gaussian , rgba(0,0,0,0.75) , 4,0,0,1 );-fx-font-weight: bold;-fx-font-size: 3.3em");

      
       // BotonEntrarEventHandler botonEntrarHandler = new BotonEntrarEventHandler(primaryStage,musicaDeFondo);
        BotonJugarEventHandler botonEntrarHandler = new BotonJugarEventHandler(primaryStage);
        botonEntrar.setOnAction(botonEntrarHandler);

        Button botonReglas = new Button();
        botonReglas.setMinSize(200, 60);
        botonReglas.setText("Reglas del juego");
        botonReglas.setTextFill(Color.KHAKI);
        botonReglas.setFont(Font.font("Cooper Black"));
        botonReglas.setStyle("-fx-padding: 8 15 15 15;  -fx-background-insets: 0,0 0 5 0, 0 0 6 0, 0 0 7 0; -fx-background-radius: 8;"
        		+ "-fx-background-color: linear-gradient(from 0% 93% to 0% 100%, #a34313 0%, #903b12 100%),#9d4024,#d86e3a,radial-gradient(center 50% 50%, radius 100%, #d86e3a, #c54e2c);"
        		+ " -fx-effect: dropshadow( gaussian , rgba(0,0,0,0.75) , 4,0,0,1 );-fx-font-weight: bold;-fx-font-size: 3.3em");

        BotonReglasEventHandler botonReglasHandler = new BotonReglasEventHandler();
        botonReglas.setOnAction(botonReglasHandler);

        Button botonSalir = new Button();
        botonSalir.setMinSize(200, 60);
        botonSalir.setText("Salir");
        botonSalir.setTextFill(Color.KHAKI);
        botonSalir.setFont(Font.font("Cooper Black"));
        botonSalir.setStyle("-fx-padding: 8 15 15 15;  -fx-background-insets: 0,0 0 5 0, 0 0 6 0, 0 0 7 0; -fx-background-radius: 8;"
        		+ "-fx-background-color: linear-gradient(from 0% 93% to 0% 100%, #a34313 0%, #903b12 100%),#9d4024,#d86e3a,radial-gradient(center 50% 50%, radius 100%, #d86e3a, #c54e2c);"
        		+ " -fx-effect: dropshadow( gaussian , rgba(0,0,0,0.75) , 4,0,0,1 );-fx-font-weight: bold;-fx-font-size: 3.0em");

        BotonSalirEventHandler botonSalirHandler = new BotonSalirEventHandler();
        botonSalir.setOnAction(botonSalirHandler);

        //ContenedorVolumen contenedorVolumen = new ContenedorVolumen(musicaDeFondo);
        //contenedorVolumen.setAlignment(Pos.CENTER_LEFT);
        //contenedorVolumen.setPadding(new Insets(30, 0, 30, 0));

        //this.getChildren().addAll(titulo, botonEntrar,contenedorVolumen, botonReglas, botonSalir);
        this.getChildren().addAll(imagent, botonEntrar, botonReglas, botonSalir);
        this.setPadding(new Insets(30, 0, 30, 220));
        this.setSpacing(50);
    }
}
