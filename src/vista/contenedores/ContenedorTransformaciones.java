package vista.contenedores;

import controlador.handlers.BotonTransformacionEventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import modelo.personajes.Personaje;
import vista.RepresentacionPersonaje;

public class ContenedorTransformaciones extends VBox{
	//supuesto de q no se puede volver a transformar en estado 1 (no conlleva ninguna ventaja)
	public ContenedorTransformaciones(ContenedorJuego contenedorJuego, RepresentacionPersonaje representacionPersonaje,Personaje personaje_a_convertir) {
		super();
		this.setPadding(new Insets(0, 50,0,50));
		this.setSpacing(15);
	    this.setAlignment(Pos.CENTER);
		
		Button botonTransformarEnEstado2 = new Button();
		botonTransformarEnEstado2.setText("Transformar a "+ personaje_a_convertir.getNombre()+ " "+ personaje_a_convertir.getNombrePrimeraTransformacion());
		botonTransformarEnEstado2.setTextFill(Color.GRAY);
		botonTransformarEnEstado2.setFont(Font.font("Cooper Black", FontWeight.NORMAL,15));
		botonTransformarEnEstado2.setStyle("-fx-base: #b6e7c9;; -fx-border-color: rgb(249,219,189)");
		botonTransformarEnEstado2.setMinSize(100.0, 50.0);
		
		BotonTransformacionEventHandler botonTransformarEnEstado2Handler = new BotonTransformacionEventHandler(contenedorJuego, representacionPersonaje, personaje_a_convertir, "Transformacion 1");
		botonTransformarEnEstado2.setOnAction(botonTransformarEnEstado2Handler);
		
		Button botonTransformarEnEstado3 = new Button();
		botonTransformarEnEstado3.setText("Transformar a "+ personaje_a_convertir.getNombre()+ " "+ personaje_a_convertir.getNombreSegundaTransformacion());
		botonTransformarEnEstado3.setTextFill(Color.GRAY);
		botonTransformarEnEstado3.setFont(Font.font("Cooper Black", FontWeight.NORMAL,15));
		botonTransformarEnEstado3.setStyle("-fx-base: #b6e7c9;; -fx-border-color: rgb(249,219,189)");
		botonTransformarEnEstado3.setMinSize(100.0, 50.0);
		
		BotonTransformacionEventHandler botonTransformarEnEstado3Handler = new BotonTransformacionEventHandler(contenedorJuego, representacionPersonaje, personaje_a_convertir, "Transformar 2");
		botonTransformarEnEstado3.setOnAction(botonTransformarEnEstado3Handler);
        
		this.getChildren().addAll(botonTransformarEnEstado2, botonTransformarEnEstado3);
	    this.setAlignment(Pos.CENTER);
	}
}
