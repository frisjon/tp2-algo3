package vista.contenedores;

import java.util.ArrayList;
import java.util.List;

import controlador.handlers.BotonSeleccionMoverEventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Separator;
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
import modelo.personajes.Goku;
import modelo.personajes.Personaje;
import modelo.tablero.Casillero;
import modelo.tablero.Coordenada;
import modelo.tablero.Tablero;
import vista.BarraDeMenu;
import vista.CreadorRepresentacionConsumible;
import vista.CreadorRepresentacionPersonaje;
import vista.RepresentacionConsumible;
import vista.RepresentacionJugador;
import vista.RepresentacionPersonaje;
import modelo.consumibles.Consumible;
import modelo.equipo.Equipo;


public class ContenedorJuego extends BorderPane {
    
    private Stage stage;
    private Juego juego;
    private OrganizadorJuego organizador;
    
    private VistaConsola panelConsola;
    private Consola consola;
    
    // puede que esto no sea necesario
    private ContenedorTablero contenedorTablero;
    private ContenedorOpcionesJuego contenedorOpcionesJuego;
    private ContenedorEstadisticas contenedorEstadisticas;
    private VBox vbox;
    
    //private Jugador jugador1, jugador2;
    //private Jugador jugadorDeTurno;
    
    private CreadorRepresentacionConsumible crc;
    private List<RepresentacionConsumible> consumibles;
    
    private List<RepresentacionJugador> representacionJugadores;
    
    private RepresentacionJugador representacionJugadorDeTurno;
    private RepresentacionJugador representacionJugadorEsperando;
    private RepresentacionJugador auxiliar;
    private Tablero tablero;
    
    //private AudioClip musicaDeFondo;
    
    public ContenedorJuego(Stage stage, Jugador jugador1, Jugador jugador2) {
        super();
        
        this.consumibles = new ArrayList<RepresentacionConsumible>();
        this.crc = new CreadorRepresentacionConsumible();
        
        this.representacionJugadores = new ArrayList<RepresentacionJugador>();
        this.representacionJugadores.add(new RepresentacionJugador(jugador1));
        this.representacionJugadores.add(new RepresentacionJugador(jugador2));
        
        this.representacionJugadorDeTurno = this.representacionJugadores.get(0);
        this.representacionJugadorEsperando = this.representacionJugadores.get(1);
        
        
        //Inicializamos la musica de fondo
        //this.musicaDeFondo = new AudioClip("file:src/vista/sonidos/.mp3");
        //this.musicaDeFondo.setCycleCount(5);
        
        //Fondo
        Image fondo = new Image("file:src/vista/imagenes/arena.jpg");
        BackgroundImage imagenDeFondo = new BackgroundImage(fondo, 
                                                            BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, 
                                                            BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
        this.setBackground(new Background(imagenDeFondo));
    }

    public void inicializarJuego(Juego juego) {
        this.juego = juego;
        
        //this.musicaDeFondo.play();
        
        //Inicializo a los personajes en el tablero
        this.juego.distribuirPersonajesEquipos();
        this.juego.inicializarJuegoAdjudicandoPrimerTurno();
        
        //Esta clase (ContenedorJuego) maneja lo de los turnos (la parte de la vista)
        //Por lo tanto debe tener una referencia al organizadorJuego (que maneja los turnos, en el modelo)
        this.organizador = this.juego.getOrganizadorJuego();
        
        
        //Menu (top)
        BarraDeMenu menu = new BarraDeMenu(stage);
        this.setTop(menu);
        
        //Consola (bottom)
        this.consola = new Consola();
        this.panelConsola = new VistaConsola(this.consola);
        this.setBottom(panelConsola);
        
        //Referencia al tablero. Lo necesita ContenedorTablero.
        //Para saber en donde esta cada personaje.
        //this.tablero = this.organizador.getTablero();
        
        //this.siguienteTurno();
        /*
        CreadorRepresentacionConsumible crc = new CreadorRepresentacionConsumible();
        //
        for (Consumible consumible: tablero.getConsumibles()) {
            consumibles.add(crc.crearRepresentacionDe(consumible));
        }*/
        
        //Centro (center) (esto es lo que se va a ver como un tablero. aca van los personajes y consumibles, etc)
        ContenedorTablero contendorTablero = new ContenedorTablero(this.organizador.getAlto(), this.organizador.getAncho(), this.representacionJugadores, this.consumibles); 
        this.contenedorTablero = contendorTablero;
        this.setCenter(contendorTablero);
        
        //Panel de Opciones (left) (aca van las opciones del juego. Seleccionar personaje, mover, atacar, stats de los personajes (del jugador de turno), opcion para cancelar)
        //(utilizar consumible no deberia ser opcion porque 2 de 3 consumibles son instantaneos y por ultimo, las esferas no se pueden consumir, solo se tienen y ya)
        this.crearPanelIzquierdo();
    }
    
    private void crearPanelIzquierdo(){
        this.setLeft(null);
        this.vbox = new VBox();
        this.contenedorOpcionesJuego = new ContenedorOpcionesJuego(this);
        this.contenedorEstadisticas = new ContenedorEstadisticas(this);
        this.vbox.getChildren().addAll(this.contenedorOpcionesJuego, new Separator(), this.contenedorEstadisticas);
        this.setLeft(this.vbox);
    }
    
    private void actualizarRepresentacionConsumibles(){
        for(RepresentacionConsumible repCons: this.consumibles){
            //Caso en el cual el consumible ya fue eliminado del tablero pero debe actualizarse
            //la vista.
            if (repCons.getCasillero() == null){
                this.contenedorTablero.removerRepresentacionConsumible(repCons);
            }
        }
        
        this.consumibles.removeIf(cons -> cons.getCasillero() == null);
    }
    
    public RepresentacionJugador getRepresentacionJugador(){
        return this.representacionJugadorDeTurno;
    }
    
    public RepresentacionJugador getRepresentacionJugadorEsperando(){
        return this.representacionJugadorEsperando;
    }
    
    public Tablero getTablero(){
        return this.tablero;
    }
    
    public OrganizadorJuego getOrganizadorJuego() {
    	return this.organizador;
    }
    
    public void mostrarConsola(String mensaje){
        this.consola.agregarMensaje(mensaje);
    }
    
    public void siguienteTurno() {
        
        //Reestablece la cantidad de movimientos de cada personaje
        for (RepresentacionJugador jugador: representacionJugadores) {
            for (RepresentacionPersonaje personaje: jugador.getRepresentacionesDePersonajes())
                personaje.reestablecerMovimientosRestantes();
        }
        
        //necesario para que el jugador no haga movimientos infinitos. Se aplica tambien a ataques y (creo que tambien) transformaciones 
        this.setRight(null);
        this.contenedorOpcionesJuego.reestablecerBotones();
        
        Consumible nuevoConsumible = this.organizador.empezarSiguienteTurno();
        if (nuevoConsumible != null){
            RepresentacionConsumible nuevaRepConsumible = this.crc.crearRepresentacionDe(nuevoConsumible);
            this.consumibles.add(nuevaRepConsumible);
            this.contenedorTablero.actualizarRepresentacionConsumible(nuevaRepConsumible);
        }
        
        this.auxiliar = this.representacionJugadorDeTurno;
        this.representacionJugadorDeTurno = this.representacionJugadorEsperando;
        this.representacionJugadorEsperando = this.auxiliar;
        this.crearPanelIzquierdo();
        this.mostrarConsola("Turno: " + Integer.toString(this.organizador.getTurno()) + ". Mueve " + this.representacionJugadorDeTurno.getNombreJugador());
    }

    public void actualizarRepresentacionPersonaje(RepresentacionPersonaje personaje) {
        this.contenedorTablero.actualizarRepresentacionPersonaje(personaje);
    }
    
    public void continuarMovimiento(RepresentacionPersonaje personaje) {
        //trigger del evento para seguir moviendo al personaje
        new BotonSeleccionMoverEventHandler(this, personaje);
    }

    public void moverPersonaje(Personaje personaje, List<Casillero> camino) {
        //el organizador le debe decir al tablero que mueva al personaje
        this.organizador.moverPersonaje(personaje, camino);
        this.actualizarRepresentacionConsumibles();
    }

    public Casillero getCasilleroEn(Casillero pos, String direccion) {
        return this.organizador.getCasilleroEn(pos, direccion);
    }
    
    public void desactivarBotonAtaque() {
    	this.contenedorOpcionesJuego.deshabilitarBotonAtaque();
    }
    
    public void eliminarPersonajeDelJuego(RepresentacionPersonaje personaje) {
    	this.contenedorTablero.removerRepresentacionPersonaje(personaje);
    }
    
    public void desactivarBotonMover() {
    	this.contenedorOpcionesJuego.deshabilitarBotonMover();
    }
    
    public void resetearPanelEstadisitcas () {
    	this.crearPanelIzquierdo();
    }
    
}
