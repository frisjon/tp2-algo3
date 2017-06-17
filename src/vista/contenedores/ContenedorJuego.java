package vista.contenedores;

import java.util.ArrayList;

import controlador.handlers.BotonPasarTurnoEventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.Glow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
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
import modelo.juego.OrganizadorJuego;
import modelo.jugador.Jugador;
import modelo.personajes.Personaje;
import modelo.tablero.Coordenada;
import modelo.tablero.Tablero;
import vista.BarraDeMenu;
import modelo.equipo.Equipo;


public class ContenedorJuego extends BorderPane {
    
    private Stage stage;
    private Juego juego;
    private OrganizadorJuego organizador;
    private VistaConsola panelConsola;
    private Consola consola;
    private ContenedorTablero contenedorTablero;
    private ContenedorOpcionesJuego contenedorOpcionesJuego;
    private String nombreJugador1, nombreJugador2;
    private Jugador jugador1, jugador2;
    private Jugador jugadorDeTurno;
    
    public ContenedorJuego(Stage stage, Jugador jugador1, Jugador jugador2) {
        super();
        
        this.jugador1 = jugador1;
        this.jugador2 = jugador2;
        
        this.jugadorDeTurno = jugador1;
    }
    
    public ContenedorJuego(Stage stage, String nombreJugador1, String nombreJugador2) {
        super();
        
        this.stage = stage;
        this.nombreJugador1 = nombreJugador1;
        this.nombreJugador2 = nombreJugador2;
        
        //Fondo
        /*Image fondo = new Image("file:src/vista/imagenes/fondo-dbz.jpg");
        BackgroundImage imagenDeFondo = new BackgroundImage(fondo, 
                                                            BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, 
                                                            BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
        this.setBackground(new Background(imagenDeFondo));*/
    }

    public void inicializarJuego(Juego juego) {
        this.juego = juego;
        
        this.juego.distribuirPersonajesEquipos();
        
        this.organizador = this.juego.getOrganizadorJuego();
        
        Tablero tablero = this.organizador.getTablero();
        
        //Menu (top)
        BarraDeMenu menu = new BarraDeMenu(stage);
        this.setTop(menu);
        
        //Consola (bottom)
        this.consola = new Consola();
        this.panelConsola = new VistaConsola(this.consola);
        this.setBottom(panelConsola);
        
        //Centro (center)
        ContenedorTablero contendorTablero = new ContenedorTablero(tablero, jugador1.getEquipo(), jugador2.getEquipo()); 
        this.contenedorTablero = contendorTablero;
        //this.setAlignment(contendorTablero, Pos.TOP_LEFT);
        this.setCenter(contendorTablero);
        
        //Panel de Opciones (left)
        ContenedorOpcionesJuego contenedorOpcionesJuego = new ContenedorOpcionesJuego(this.jugadorDeTurno);
        this.contenedorOpcionesJuego = contenedorOpcionesJuego;
        this.setLeft(contenedorOpcionesJuego);
    }
}
