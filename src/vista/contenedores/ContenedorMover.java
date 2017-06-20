package vista.contenedores;
import controlador.handlers.BotonMovimientoEventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import modelo.tablero.Tablero;
import vista.RepresentacionPersonaje;

public class ContenedorMover extends VBox {
    
    public ContenedorMover(ContenedorJuego contenedorJuego, Tablero tablero, RepresentacionPersonaje personaje) {
        
        this.setPadding(new Insets(130, 50,50,50));
        this.setSpacing(15);
        this.setAlignment(Pos.CENTER);
        
        int ancho = 10, btnAncho = 20, btnAlto = 20;
        boolean preserveRatio = true, smooth=false;
        
        ImageView imUp = new ImageView(new Image("file:src/vista/imagenes/up.png", ancho, ancho, preserveRatio, smooth));
        Button up = new Button("", imUp);
        up.setOnAction(new BotonMovimientoEventHandler(contenedorJuego, tablero, personaje, "w"));
        
        ImageView imDown = new ImageView(new Image("file:src/vista/imagenes/down.png", ancho, ancho, preserveRatio, smooth));
        Button down = new Button("", imDown);
        down.setOnAction(new BotonMovimientoEventHandler(contenedorJuego, tablero, personaje, "s"));
        
        ImageView imRight = new ImageView(new Image("file:src/vista/imagenes/right.png", ancho, ancho, preserveRatio, smooth));
        Button right = new Button("", imRight);
        right.setOnAction(new BotonMovimientoEventHandler(contenedorJuego, tablero, personaje, "d"));
        
        ImageView imLeft = new ImageView(new Image("file:src/vista/imagenes/left.png", ancho, ancho, preserveRatio, smooth));
        Button left = new Button("", imLeft);
        left.setOnAction(new BotonMovimientoEventHandler(contenedorJuego, tablero, personaje, "a"));
        
        ImageView imUpRight = new ImageView(new Image("file:src/vista/imagenes/upRight.png", ancho, ancho, preserveRatio, smooth));
        Button upRight = new Button("", imUpRight);
        upRight.setOnAction(new BotonMovimientoEventHandler(contenedorJuego, tablero, personaje, "e"));
        
        ImageView imUpLeft = new ImageView(new Image("file:src/vista/imagenes/upLeft.png", ancho, ancho, preserveRatio, smooth));
        Button upLeft = new Button("", imUpLeft);
        upLeft.setOnAction(new BotonMovimientoEventHandler(contenedorJuego, tablero, personaje, "q"));
        
        ImageView imDownRight = new ImageView(new Image("file:src/vista/imagenes/downRight.png", ancho, ancho, preserveRatio, smooth));
        Button downRight = new Button("", imDownRight);
        downRight.setOnAction(new BotonMovimientoEventHandler(contenedorJuego, tablero, personaje, "c"));
        
        ImageView imDownLeft = new ImageView(new Image("file:src/vista/imagenes/downLeft.png", ancho, ancho, preserveRatio, smooth));
        Button downLeft = new Button("", imDownLeft);
        downLeft.setOnAction(new BotonMovimientoEventHandler(contenedorJuego, tablero, personaje, "z"));
        
        Button none = new Button();
        none.setMinSize(btnAncho, btnAlto);
        
        HBox top = new HBox();
        top.getChildren().addAll(upLeft, up, upRight);
        
        HBox bottom = new HBox();
        bottom.getChildren().addAll(downLeft, down, downRight);
        
        HBox sides = new HBox();
        sides.getChildren().addAll(left, none, right);
        
        this.getChildren().addAll(top, sides, bottom);
    }

}
