package vista.contenedores;

import java.util.ArrayList;
import java.util.List;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import modelo.equipo.Equipo;
import modelo.jugador.Jugador;
import modelo.personajes.Personaje;
import modelo.tablero.Coordenada;
import modelo.tablero.Tablero;

public class ContenedorTablero extends BorderPane {
    
    private final int IMAGEN_ANCHO = 30;
    private final int IMAGEN_ALTO = 30;
    
    //el tablero sabe donde estan los personajes
    private Tablero tablero;
    
    //muestra al tablero
    private GridPane grid;
    private List<Equipo> equipos;
    
    public ContenedorTablero(Tablero _tablero, Equipo equipo1, Equipo equipo2) {
        super();
        
        this.tablero = _tablero;
        
        //inicializa el grid
        this.iniciarTableroDeJuego();
        
        this.equipos = new ArrayList<Equipo>();
        this.equipos.add(equipo1);
        this.equipos.add(equipo2);
        
        this.actualizarTablero();
    }
    
    public void iniciarTableroDeJuego() {
        //Configuracion del grid pane (tablero)
        this.grid = new GridPane();
        this.grid.setPadding(new Insets(10,10,10,10));
        this.grid.setVgap(0);
        this.grid.setHgap(0);
        
        Image pasto = new Image("file:src/vista/imagenes/grass.jpg",this.IMAGEN_ANCHO,this.IMAGEN_ALTO,false,false);
        
        // coloca imagenes
        for (int i=0;i<this.tablero.getAlto();i++){
            for (int j=0;j<this.tablero.getAncho();j++){
                ImageView iv = new ImageView();
                iv.setImage(pasto);
                this.grid.add(iv, i, j);
            }
        }
        
        this.setCenter(this.grid);
    }
    
    //modifica la posicion del personaje en el grid.
    //por ahora no hacer nada, porque los personajes no se pueden mover por ahora.
    public void actualizarPosicionDePersonaje(Personaje personaje, ImageView personajeImagen) {
        //personajeImagen.setOpacity(1.00);
        
        Coordenada coordenada = personaje.getCasillero().getCoordenada();
        //this.grid.getChildren().remove(personajeImagen);
        this.grid.add(personajeImagen, coordenada.getY(), coordenada.getX());
        this.setCenter(this.grid);
    }
    
    //por ahora solo actualiza las posiciones de cada personaje.
    //falta que tambien lo haga para los consumibles.
    //puede que la forma en la que esta, no sea bueno despues. Lo dejo asi para que se vea algo.
    //(me refiero a que si tal vez esta mal usar ImageView en vez de botonoes, por ejemplo)
    public void actualizarTablero() {
        
        Image img = new Image("file:src/vista/imagenes/goku.png",this.IMAGEN_ANCHO,this.IMAGEN_ALTO,false,false);
        
        for (Equipo e: equipos) {
            for (Personaje p: e.pedirListaPersonajes()) {
                ImageView iv = new ImageView();
                iv.setImage(img);
                this.actualizarPosicionDePersonaje(p, iv);
            }
        }
    }
}