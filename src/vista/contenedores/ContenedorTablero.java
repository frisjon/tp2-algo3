package vista.contenedores;

import java.util.List;
import javafx.geometry.Insets;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import modelo.tablero.Coordenada;
import vista.RepresentacionConsumible;
import vista.RepresentacionJugador;
import vista.RepresentacionPersonaje;

public class ContenedorTablero extends ScrollPane {
    
    private final int IMAGEN_ANCHO = 50;
    private final int IMAGEN_ALTO = 50;
    private int ALTO;
    private int ANCHO;
    
    private GridPane grid;
    
    //private RepresentacionJugador representacionJugador;
    private List<RepresentacionJugador> jugadores;
    private List<RepresentacionConsumible> consumibles;
    
    public ContenedorTablero(int _ALTO, int _ANCHO, List<RepresentacionJugador> _jugadores, List<RepresentacionConsumible> _consumibles) {
        super();
        
        this.ALTO = _ALTO;
        this.ANCHO = _ANCHO;
        
        //this.tablero = _tablero;
        this.jugadores = _jugadores;
        this.consumibles = _consumibles;
        
        this.iniciarTableroDeJuego();
        
        this.actualizarTablero();
        
        this.setContent(this.grid);
    }
    
    public void iniciarTableroDeJuego() {
        // Configuracion del grid pane (tablero)
        this.grid = new GridPane();
        this.grid.setPadding(new Insets(10,10,10,10));
        this.grid.setVgap(0);
        this.grid.setHgap(0);
        
        Image pasto = new Image("file:src/vista/imagenes/grass.jpg",this.IMAGEN_ANCHO,this.IMAGEN_ALTO,false,false);
        for (int i = 0; i < this.ALTO; i++) {
            for (int j = 0; j < this.ANCHO; j++) {
                ImageView iv = new ImageView();
                iv.setImage(pasto);
                this.grid.add(iv, i, j);
            }
        }
    }
    
    public void removerRepresentacionConsumible(RepresentacionConsumible consumible){
        this.grid.getChildren().remove(consumible.getImagen());
    }
    
    public void removerRepresentacionPersonaje(RepresentacionPersonaje personaje) {
    	this.grid.getChildren().remove(personaje.getImagen());
    }
    
    public void actualizarRepresentacionPersonaje(RepresentacionPersonaje personaje) {
        Coordenada coordenada = personaje.getCasillero().getCoordenada();
        
        this.removerRepresentacionPersonaje(personaje);
        this.grid.add(personaje.getImagen(), coordenada.getX(), coordenada.getY());
    }
    
    public void actualizarRepresentacionConsumible(RepresentacionConsumible consumible) {
        Coordenada coordenada = consumible.getCasillero().getCoordenada();
        
        this.grid.getChildren().remove(consumible.getImagen());
        this.grid.add(consumible.getImagen(), coordenada.getX(), coordenada.getY());
    }
    
    public void actualizarTablero() {
        
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
