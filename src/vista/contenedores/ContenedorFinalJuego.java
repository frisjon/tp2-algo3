package vista.contenedores;

import controlador.handlers.BotonJugarEventHandler;
import controlador.handlers.BotonReglasEventHandler;
import controlador.handlers.BotonSalirEventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import modelo.jugador.Jugador;
import vista.Reproductor;

public class ContenedorFinalJuego extends BorderPane{
	private Stage scene;
	
	public ContenedorFinalJuego(Stage scene, Jugador jugadorGanador) {
		this.scene = scene;
	 	
		//AudioClip musicaGanador = new AudioClip("file:src/vista/sonidos/victoria.mp3");
		//musicaGanador.play();
		//musicaGanador.setCycleCount(5);
			
		Image imagen = new Image("file:src/vista/imagenes/imagen_final.jpg");
	    BackgroundImage imagenDeFondo = new BackgroundImage(imagen, BackgroundRepeat.REPEAT,BackgroundRepeat.REPEAT, BackgroundPosition.CENTER,
	    BackgroundSize.DEFAULT);
	    this.setBackground(new Background(imagenDeFondo));
			
		VBox contenedor = this.contenedorGanador(jugadorGanador.getNombre());
		this.setCenter(contenedor); 
		Reproductor.finaljuego();
	}
	
	private VBox contenedorGanador(String nombreGanador) {
		
		VBox contenedorGanador = new VBox();
		contenedorGanador.setSpacing(30);

		Label textoGanador = new Label(" Felicidades " + nombreGanador + "! Has ganado.");
		textoGanador.setAlignment(Pos.TOP_CENTER);
		textoGanador.setTextAlignment(TextAlignment.CENTER);
		textoGanador.setFont(Font.font("Courier New",FontWeight.BOLD, 56));
		textoGanador.setTextFill(Color.RED);
     
        Button botonReiniciarJuego = new Button();
        botonReiniciarJuego.setMinSize(260, 100);
        botonReiniciarJuego.setText("Volver a jugar");
        botonReiniciarJuego.setTextFill(Color.KHAKI);
        botonReiniciarJuego.setFont(Font.font("Cooper Black"));
        botonReiniciarJuego.setStyle(" -fx-background-color:linear-gradient(#ffd65b, #e68400),linear-gradient(#ffef84, #f2ba44),linear-gradient(#ffea6a, #efaa22),linear-gradient(#ffe657 0%, #f8c202 50%, #eea10b 100%),linear-gradient(from 0% 0% to 15% 50%, rgba(255,255,255,0.9), rgba(255,255,255,0));" +
        "-fx-background-radius: 30;-fx-background-insets: 0,1,2,3,0;-fx-text-fill: #654b00;-fx-font-weight: bold;-fx-font-size: 30px;-fx-padding: 10 20 10 20;");

        BotonJugarEventHandler botonEntrarHandler = new BotonJugarEventHandler(this.scene);
        botonReiniciarJuego.setOnAction(botonEntrarHandler);
       
        Button botonSalir = new Button();
        botonSalir.setMinSize(200, 60);
        botonSalir.setText("Salir");
        botonSalir.setTextFill(Color.KHAKI);
        botonSalir.setFont(Font.font("Cooper Black"));
        botonSalir.setStyle(" -fx-background-color:linear-gradient(#ffd65b, #e68400),linear-gradient(#ffef84, #f2ba44),linear-gradient(#ffea6a, #efaa22),linear-gradient(#ffe657 0%, #f8c202 50%, #eea10b 100%),linear-gradient(from 0% 0% to 15% 50%, rgba(255,255,255,0.9), rgba(255,255,255,0));" +
                "-fx-background-radius: 30;-fx-background-insets: 0,1,2,3,0;-fx-text-fill: #654b00;-fx-font-weight: bold;-fx-font-size: 30px;-fx-padding: 10 20 10 20;");

        BotonSalirEventHandler botonSalirHandler = new BotonSalirEventHandler();
        botonSalir.setOnAction(botonSalirHandler);
        
    	contenedorGanador.getChildren().addAll(textoGanador,botonReiniciarJuego,botonSalir);
		contenedorGanador.setAlignment(Pos.CENTER);
		
		return contenedorGanador;
    }
}
