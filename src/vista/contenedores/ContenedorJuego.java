package vista.contenedores;

import java.util.ArrayList;

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
    private Jugador jugador1, jugador2;
    private Jugador jugadorDeTurno;
    
    public ContenedorJuego(Stage stage, Jugador jugador1, Jugador jugador2) {
        super();
        
        this.jugador1 = jugador1;
        this.jugador2 = jugador2;
        
        this.jugadorDeTurno = jugador1;
        
        //Fondo
        Image fondo = new Image("file:src/vista/imagenes/fondo-dbz.jpg");
        BackgroundImage imagenDeFondo = new BackgroundImage(fondo, 
                                                            BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, 
                                                            BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
        this.setBackground(new Background(imagenDeFondo));
    }

    public void inicializarJuego(Juego juego) {
        this.juego = juego;
        
        //Inicializo a los personajes en el tablero
        this.juego.distribuirPersonajesEquipos();
        
        //Esta clase (ContenedorJuego) maneja lo de los turnos (la parte de la vista)
        //Por lo tanto debe tener una referencia al organizadorJuego (que maneja los turnos en el modelo)
        this.organizador = this.juego.getOrganizadorJuego();
        
        //Referencia al tablero. Lo necesita ContenedorTablero.
        //Para saber en donde esta cada personaje
        Tablero tablero = this.organizador.getTablero();
        
        //Menu (top)
        BarraDeMenu menu = new BarraDeMenu(stage);
        this.setTop(menu);
        
        //Consola (bottom)
        this.consola = new Consola();
        this.panelConsola = new VistaConsola(this.consola);
        this.setBottom(panelConsola);
        
        //Centro (center) (esto es lo que se va a ver como un tablero. aca van los personajes y consumibles, etc)
        ContenedorTablero contendorTablero = new ContenedorTablero(tablero, jugador1.getEquipo(), jugador2.getEquipo()); 
        this.contenedorTablero = contendorTablero;
        this.setCenter(contendorTablero);
        
        //Panel de Opciones (left) (aca van las opciones del juego. Seleccionar personaje, mover, atacar)
        //(utilizar consumibler no deberia ser opcion porque 2 de 3 consumibles son instantaneos y por ultimo, las esferas no se pueden consumir)
        ContenedorOpcionesJuego contenedorOpcionesJuego = new ContenedorOpcionesJuego(this.jugadorDeTurno);
        this.contenedorOpcionesJuego = contenedorOpcionesJuego;
        this.setLeft(contenedorOpcionesJuego);
    }
}
