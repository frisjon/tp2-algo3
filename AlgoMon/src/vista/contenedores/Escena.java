package vista.contenedores;

import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Escena extends Scene{
    private static int ancho_minimo = 1280;
    private static int alto_minimo = 720;
	
    public Escena(Pane contenedor, Stage stage) {
        super(contenedor, ancho_minimo, alto_minimo);
        this.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.F11) stage.setFullScreen(!stage.isFullScreen());
            if (event.getCode() == KeyCode.ESCAPE) stage.setMaximized(true);
        });
    }

    public int getAnchoMinimo(){
        return ancho_minimo;
    }

    public int getAlto_minimo(){
        return alto_minimo;
    }
}
