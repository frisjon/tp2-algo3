package vista.contenedores;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.media.AudioClip;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import modelo.juego.Juego;
import modelo.jugador.Jugador;
import vista.BarraDeMenu;
import modelo.equipo.Equipo;


public class ContenedorJuego extends BorderPane {
    
    private Stage stage;
    private Juego juego;
    private VistaConsola panelConsola;
    private Consola consola;
    
    public ContenedorJuego(Stage stage, String nombreJugador1, String nombreJugador2) {
        super();
        
        this.stage = stage;
        
        Image fondo = new Image("file:src/vista/imagenes/fondo-dbz.jpg");
        BackgroundImage imagenDeFondo = new BackgroundImage(fondo, 
                                                            BackgroundRepeat.REPEAT, 
                                                            BackgroundRepeat.REPEAT, BackgroundPosition.CENTER,
                                                            BackgroundSize.DEFAULT);
        this.setBackground(new Background(imagenDeFondo));
        
        BarraDeMenu menu = new BarraDeMenu(stage);
        this.setTop(menu);
        
        this.consola = new Consola();
        this.panelConsola = new VistaConsola(this.consola);
        this.setBottom(panelConsola);
        
        // esto es para probar que aparezca algo en el borderPane en el centro
        // en vez de agregar un boton, hay que agregar un grid pane (o algo asi. hay que ver como esta en transformers)
        // me fije, pero como esta un toque desordenado, no lo encontre
        Button test = new Button();
        test.setText("test");
        test.setMinSize(640, 480);
        this.setCenter(test);
    }

    public void inicializarJuego(Juego juego) {
        this.juego = juego;
    }

}
