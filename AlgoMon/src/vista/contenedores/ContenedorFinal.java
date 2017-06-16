package vista.contenedores;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.media.AudioClip;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.TextAlignment;

public class ContenedorFinal extends BorderPane {
	
	public ContenedorFinal(String nombreGanador) {
		
		AudioClip musicaGanador = new AudioClip("file:src/vista/sonidos/victoria.mp3");
		musicaGanador.play();
		musicaGanador.setCycleCount(5);
		
		Image fondo = new Image("file:src/vista/imagenes/fondosEleccion/pokefacha.jpg");
		BackgroundImage imagenDeFondo =
				new BackgroundImage(fondo, BackgroundRepeat.REPEAT,
						BackgroundRepeat.REPEAT, BackgroundPosition.CENTER,
						BackgroundSize.DEFAULT);
		this.setBackground(new Background(imagenDeFondo));
		
		VBox contenedor = this.contenedorGanador(nombreGanador);
		this.setCenter(contenedor);
		
	}
	
	private VBox contenedorGanador(String nombreGanador){
		
		VBox contenedorGanador = new VBox();
		contenedorGanador.setSpacing(30);

		Label felicitaciones = new Label(" Felicitaciones " + nombreGanador + " !!!!");
		felicitaciones.setAlignment(Pos.CENTER);
		felicitaciones.setTextAlignment(TextAlignment.CENTER);
		felicitaciones.setFont(Font.font("Courier New",FontWeight.BOLD, 56));
		felicitaciones.setTextFill(Color.DARKGREY);
		
		ImageView imagenAlgomon = new ImageView("file:src/vista/imagenes/fondosPelea/ash.png");
		imagenAlgomon.setFitWidth(450);
		imagenAlgomon.setFitHeight(500);
		
		Label jugadorGanador = new Label("Ha ganado la batalla AlgoMon !!!!");
		jugadorGanador.setAlignment(Pos.CENTER);
		jugadorGanador.setTextAlignment(TextAlignment.CENTER);
		jugadorGanador.setFont(Font.font("Courier New",FontWeight.BOLD, 56));
		jugadorGanador.setTextFill(Color.DARKGREY);
		
		contenedorGanador.getChildren().addAll(felicitaciones,imagenAlgomon,jugadorGanador);
		contenedorGanador.setAlignment(Pos.CENTER);
		
		return contenedorGanador;
	}
	
	

}
