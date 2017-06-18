package vista.contenedores;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import modelo.tablero.Tablero;
import vista.RepresentacionPersonaje;
import controlador.handlers.*;

public class ContenedorMover extends VBox {
    
    public ContenedorMover(Stage stage, Tablero tablero, RepresentacionPersonaje personaje) {
        
        this.setAlignment(Pos.CENTER);
        
        Button up = new Button();
        up.setText("up");
        up.setOnAction(new BotonArribaEventHandler(stage, tablero, personaje));
                
        Button down = new Button();
        down.setText("down");
        down.setOnAction(new BotonAbajoEventHandler(stage, tablero, personaje));
        
        Button right = new Button();
        right.setText(">");
        right.setOnAction(new BotonDerechaEventHandler(stage, tablero, personaje));
        
        Button left = new Button();
        left.setText("<");
        left.setOnAction(new BotonIzquierdaEventHandler(stage, tablero, personaje));
        
        HBox costados = new HBox();
        costados.getChildren().addAll(left, right);
        
        this.getChildren().addAll(up,costados,down);
    }

}
