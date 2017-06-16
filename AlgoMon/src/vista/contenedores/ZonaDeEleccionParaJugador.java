package vista.contenedores;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;


public class ZonaDeEleccionParaJugador extends BorderPane {
    public ZonaDeEleccionParaJugador(Button botonCambiarIzquierda, Button botonCambiarDerecha, Button botonSeleccion,
                                     HBox seleccionados, ImagenDeAlgomonAElegir seleccionJugador, TablaDeAlgomon tabla) {
        
        this.setTop(seleccionados);
        this.setLeft(botonCambiarIzquierda);
        this.setRight(botonCambiarDerecha);
        this.setCenter(seleccionJugador);
        BorderPane.setAlignment(botonCambiarIzquierda, Pos.CENTER);
        BorderPane.setAlignment(botonCambiarDerecha,Pos.CENTER);
        this.setPadding(new Insets(0,0,0,10));

        VBox zonaInferior = new VBox();
        zonaInferior.getChildren().addAll(tabla,botonSeleccion);
        zonaInferior.setAlignment(Pos.CENTER);

        this.setBottom(zonaInferior);
    }
}
