package vista.contenedores;

import controlador.handlers.BotonAbajoDerechaEventHandler;
import controlador.handlers.BotonAbajoEventHandler;
import controlador.handlers.BotonAbajoIzquierdaEventHandler;
import controlador.handlers.BotonArribaDerechaEventHandler;
import controlador.handlers.BotonArribaEventHandler;
import controlador.handlers.BotonArribaIzquierdaEventHandler;
import controlador.handlers.BotonDerechaEventHandler;
import controlador.handlers.BotonIzquierdaEventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import modelo.tablero.Tablero;
import vista.RepresentacionPersonaje;

public class ContenedorMover extends VBox {
    
    public ContenedorMover(ContenedorJuego contenedorJuego, Tablero tablero, RepresentacionPersonaje personaje) {
        
        //this.setAlignment(Pos.CENTER);

        Button upRight = new Button();
        upRight.setText("E");
        upRight.setOnAction(new BotonArribaDerechaEventHandler(contenedorJuego, tablero, personaje));
        
        Button upLeft = new Button();
        upLeft.setText("Q");
        upLeft.setOnAction(new BotonArribaIzquierdaEventHandler(contenedorJuego, tablero, personaje));
        
        Button downRight = new Button();
        downRight.setText("C");
        downRight.setOnAction(new BotonAbajoDerechaEventHandler(contenedorJuego, tablero, personaje));

        Button downLeft = new Button();
        downLeft.setText("Z");
        downLeft.setOnAction(new BotonAbajoIzquierdaEventHandler(contenedorJuego, tablero, personaje));
        
        Button up = new Button();
        up.setText("W");
        up.setOnAction(new BotonArribaEventHandler(contenedorJuego, tablero, personaje));
        
        Button down = new Button();
        down.setText("S");
        down.setOnAction(new BotonAbajoEventHandler(contenedorJuego, tablero, personaje));
        
        Button right = new Button();
        right.setText("D");
        right.setOnAction(new BotonDerechaEventHandler(contenedorJuego, tablero, personaje));
        
        Button left = new Button();
        left.setText("A");
        left.setOnAction(new BotonIzquierdaEventHandler(contenedorJuego, tablero, personaje));
        
        
        HBox top = new HBox();
        top.getChildren().addAll(upLeft, up, upRight);
        
        HBox bottom = new HBox();
        top.getChildren().addAll(downLeft, down, downRight);
        
        HBox sides = new HBox();
        top.getChildren().addAll(left, right);
        
        this.getChildren().addAll(top, sides, bottom);;
    }

}
