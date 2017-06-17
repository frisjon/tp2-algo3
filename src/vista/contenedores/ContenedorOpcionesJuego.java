package vista.contenedores;

import java.awt.Button;

import controlador.handlers.BotonMenuEventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.MenuButton;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import modelo.jugador.Jugador;
import modelo.tablero.Tablero;
import vista.BotonMenu;
import vista.RepresentacionJugador;

public class ContenedorOpcionesJuego extends VBox {
    
    private Jugador jugador;
    private MenuButton botonUsarConsumible;
    private MenuButton botonAtacar;
    private MenuButton botonSeleccionarPersonaje;

    //InformacionParaJugador informacionParaJugador
    //Partida partida, ContenedorPelea contenedor, Jugador jugador
    
    public ContenedorOpcionesJuego(RepresentacionJugador representacionJugadorDeTurno) {
        super();
        
        this.setPadding(new Insets(130, 50,0,50));
        this.setSpacing(15);
        this.setAlignment(Pos.CENTER);

        //boton que abre el menu de atacar
        botonAtacar = new BotonMenu(new BotonMenuEventHandler(botonAtacar));
        
        botonUsarConsumible = new BotonMenu(new BotonMenuEventHandler(botonUsarConsumible));
        botonSeleccionarPersonaje = new BotonMenu(new BotonMenuEventHandler(botonSeleccionarPersonaje));

        this.getChildren().addAll(botonAtacar,botonUsarConsumible,botonSeleccionarPersonaje);
        this.setAlignment(Pos.CENTER);
        /*this.bloquear(jugador != partida.jugadorActual());
         */
    }
    
    public Jugador getJugador(){
        return this.jugador;
    }
    
    public String getNombreJugador() {
        return this.getJugador().getNombre();
    }

    public void bloquearBotonera(boolean bloqueo) {
        //this.getBotonera().bloquear(bloqueo);       
    }
    
    public void actualizar(){
        //informacionParaJugador.actualizar();
    }

    public void bloquear(boolean bloqueo) {
        this.botonAtacar.setDisable(bloqueo);
        this.botonSeleccionarPersonaje.setDisable(bloqueo);
        this.botonUsarConsumible.setDisable(bloqueo);
    }
    
    public void habilitarSoloSeleccionarPersonaje(){
        this.botonAtacar.setDisable(true);
        this.botonSeleccionarPersonaje.setDisable(false);
        this.botonUsarConsumible.setDisable(true);
    }
    
    public void habilitarSoloUsarConsumible(){
        this.botonAtacar.setDisable(true);
        this.botonSeleccionarPersonaje.setDisable(true);
        this.botonUsarConsumible.setDisable(false);
    }
}
