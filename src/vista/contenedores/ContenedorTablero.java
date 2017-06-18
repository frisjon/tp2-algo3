package vista.contenedores;

import java.util.ArrayList;
import java.util.List;
import javafx.geometry.Insets;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import modelo.tablero.Coordenada;
import modelo.tablero.Tablero;
import vista.RepresentacionConsumible;
import vista.RepresentacionJugador;
import vista.RepresentacionPersonaje;

public class ContenedorTablero extends BorderPane {
    
    private final int IMAGEN_ANCHO = 50;
    private final int IMAGEN_ALTO = 50;
    
    // el tablero sabe donde estan los personajes
    private Tablero tablero;
    
    // representacion del tablero
    private GridPane grid;
    
    //private RepresentacionJugador representacionJugador;
    private List<RepresentacionJugador> jugadores;
    private List<RepresentacionConsumible> consumibles;
    
    public ContenedorTablero(Tablero _tablero, List<RepresentacionJugador> _jugadores, List<RepresentacionConsumible> _consumibles) {
        super();
        
        this.tablero = _tablero;
        this.jugadores = _jugadores;
        this.consumibles = _consumibles;
        
        // inicializa el grid
        this.iniciarTableroDeJuego();
        
        this.actualizarTablero();
    }
    
    public void iniciarTableroDeJuego() {
        // Configuracion del grid pane (tablero)
        this.grid = new GridPane();
        this.grid.setPadding(new Insets(10,10,10,10));
        this.grid.setVgap(0);
        this.grid.setHgap(0);
        
        Image pasto = new Image("file:src/vista/imagenes/grass.jpg",this.IMAGEN_ANCHO,this.IMAGEN_ALTO,false,false);
        
        // coloca imagenes de pasto
        // GridPane no acepta solo Image, por algun motivo. 
        // Cada celda de GridPane tiene un ImageView que tiene una referencia al Image del pasto.
        // Si no se coloca nada en el grid, no va a aparecer despues en la imagen, por eso pongo pasto.
        for (int i = 0; i < this.tablero.getAlto(); i++) {
            for (int j = 0; j < this.tablero.getAncho(); j++) {
                ImageView iv = new ImageView();
                iv.setImage(pasto);
                this.grid.add(iv, i, j);
            }
        }
        
        // Coloca al GridPane en el centro de esta clase
        this.setCenter(this.grid);
    }
    
    // modifica la posicion del personaje en el grid.
    // por ahora no hacer nada, porque los personajes no se pueden mover por ahora.
    public void actualizarRepresentacionPersonaje(RepresentacionPersonaje personaje) {
        // coordenada del personaje
        Coordenada coordenada = personaje.getCasillero().getCoordenada();
        
        // se borra a la imagen que existe en el grid
        // como no se mueven los personajes, esto no lo probe. puede tirar error. nose.
        //this.grid.getChildren().remove(personaje.getImagen());
        
        // se coloca a la imagen en el grid
        this.grid.add(personaje.getImagen(), coordenada.getX(), coordenada.getY());
    }
    
    public void actualizarRepresentacionConsumible(RepresentacionConsumible consumible) {
        Coordenada coordenada = consumible.getCasillero().getCoordenada();
        //this.grid.getChildren().remove(personaje.getImagen());
        this.grid.add(consumible.getImagen(), coordenada.getX(), coordenada.getY());
    }
    
    // por ahora solo actualiza las posiciones de cada personaje.
    // falta que tambien lo haga para los consumibles.
    // puede que la forma en la que esta, no sea bueno despues. Lo dejo asi para que se vea algo.
    // (me refiero a que si tal vez esta mal usar ImageView en vez de botonoes, por ejemplo)
    public void actualizarTablero() {
        
        // por cada personaje del jugador actual
        for (RepresentacionJugador jugador: this.jugadores) {
            for (RepresentacionPersonaje personaje: jugador.getRepresentacionesDePersonajes()) {
                this.actualizarRepresentacionPersonaje(personaje);
            }
        }
        
        for (RepresentacionConsumible consumible: this.consumibles) {
            this.actualizarRepresentacionConsumible(consumible);
        }
    }
}
