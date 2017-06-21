package vista.contenedores;

import controlador.handlers.BotonMovimientoEventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import vista.RepresentacionPersonaje;

public class ContenedorMover extends VBox {
    
    private final boolean preserveRatio = true, smooth = false;
    private final int ancho = 15;
    
    public ContenedorMover(ContenedorJuego contenedorJuego, RepresentacionPersonaje personaje) {
        
        this.setPadding(new Insets(130, 50, 50, 50));
        this.setSpacing(15);
        this.setAlignment(Pos.CENTER);
        
        ImageView imUp = new ImageView(new Image("file:src/vista/imagenes/up.png", ancho, ancho, preserveRatio, smooth));
        Button up = new Button("", imUp);
        up.setOnAction(new BotonMovimientoEventHandler(contenedorJuego, personaje, "arriba"));
        //up.setOnAction(new BotonArribaEventHandler(contenedorJuego, personaje));
        
        ImageView imDown = new ImageView(new Image("file:src/vista/imagenes/down.png", ancho, ancho, preserveRatio, smooth));
        Button down = new Button("", imDown);
        down.setOnAction(new BotonMovimientoEventHandler(contenedorJuego, personaje, "abajo"));
        //down.setOnAction(new BotonAbajoEventHandler(contenedorJuego, personaje));
        
        ImageView imRight = new ImageView(new Image("file:src/vista/imagenes/right.png", ancho, ancho, preserveRatio, smooth));
        Button right = new Button("", imRight);
        right.setOnAction(new BotonMovimientoEventHandler(contenedorJuego, personaje, "derecha"));
        //right.setOnAction(new BotonDerechaEventHandler(contenedorJuego, personaje));
        
        ImageView imLeft = new ImageView(new Image("file:src/vista/imagenes/left.png", ancho, ancho, preserveRatio, smooth));
        Button left = new Button("", imLeft);
        left.setOnAction(new BotonMovimientoEventHandler(contenedorJuego, personaje, "izquierda"));
        //left.setOnAction(new BotonIzquierdaEventHandler(contenedorJuego, personaje));
        
        ImageView imUpRight = new ImageView(new Image("file:src/vista/imagenes/upRight.png", ancho, ancho, preserveRatio, smooth));
        Button upRight = new Button("", imUpRight);
        upRight.setOnAction(new BotonMovimientoEventHandler(contenedorJuego, personaje, "arribaDerecha"));
        //upRight.setOnAction(new BotonArribaDerechaEventHandler(contenedorJuego, personaje));
        
        ImageView imUpLeft = new ImageView(new Image("file:src/vista/imagenes/upLeft.png", ancho, ancho, preserveRatio, smooth));
        Button upLeft = new Button("", imUpLeft);
        upLeft.setOnAction(new BotonMovimientoEventHandler(contenedorJuego, personaje, "arribaIzquierda"));
        //upLeft.setOnAction(new BotonArribaIzquierdaEventHandler(contenedorJuego, personaje));
        
        ImageView imDownRight = new ImageView(new Image("file:src/vista/imagenes/downRight.png", ancho, ancho, preserveRatio, smooth));
        Button downRight = new Button("", imDownRight);
        downRight.setOnAction(new BotonMovimientoEventHandler(contenedorJuego, personaje, "abajoDerecha"));
        //downRight.setOnAction(new BotonAbajoDerechaEventHandler(contenedorJuego, personaje));
        
        ImageView imDownLeft = new ImageView(new Image("file:src/vista/imagenes/downLeft.png", ancho, ancho, preserveRatio, smooth));
        Button downLeft = new Button("", imDownLeft);
        downLeft.setOnAction(new BotonMovimientoEventHandler(contenedorJuego, personaje, "abajoIzquierda"));
        //downLeft.setOnAction(new BotonAbajoIzquierdaEventHandler(contenedorJuego, personaje));
        
        ImageView imMid = new ImageView(new Image("file:src/vista/imagenes/circle.png", ancho, ancho, preserveRatio, smooth));
        Button none = new Button("", imMid);
        
        HBox top = new HBox();
        top.getChildren().addAll(upLeft, up, upRight);
        
        HBox bottom = new HBox();
        bottom.getChildren().addAll(downLeft, down, downRight);
        
        HBox sides = new HBox();
        sides.getChildren().addAll(left, none, right);
        
        this.getChildren().addAll(top, sides, bottom);
    }

}
