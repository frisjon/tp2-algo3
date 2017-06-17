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

public class ContenedorOpcionesJuego extends VBox {
    
    private Jugador jugador;
    private MenuButton botonUsarConsumible;
    private MenuButton botonAtacar;
    private MenuButton botonSeleccionarPersonaje;

    //InformacionParaJugador informacionParaJugador
    //Partida partida, ContenedorPelea contenedor, Jugador jugador
    
    public ContenedorOpcionesJuego(Jugador jugadorDeTurno) {
        super();
        
        this.setPadding(new Insets(130, 50,0,50));
        this.setSpacing(15);
        this.setAlignment(Pos.CENTER);

        /*botonAtacar = new BotonMenuAtacar(partida,jugador,contenedor);
        BotonMenuEventHandler botonMenuAtacarEventHandler = new BotonMenuEventHandler(botonAtacar);
        botonAtacar.setOnAction(botonMenuAtacarEventHandler);
        botonAtacar.setMaxWidth(175);

        botonUsarConsumible = new BotonMenuUsarConsumible(partida,jugador,contenedor);
        BotonMenuEventHandler botonUsarElementoEventHandler = new BotonMenuEventHandler(botonUsarConsumible);
        botonUsarConsumible.setOnAction(botonUsarElementoEventHandler);
        botonUsarConsumible.setMaxWidth(175);

        botonSeleccionarPersonaje = new BotonMenuSeleccionarPersonaje(partida,jugador,contenedor);
        BotonMenuEventHandler botonSeleccionarPersonajeEventHandler = new BotonMenuEventHandler(botonSeleccionarPersonaje);
        botonSeleccionarPersonaje.setOnAction(botonSeleccionarPersonajeEventHandler);        
        botonSeleccionarPersonaje.setMaxWidth(175);

        this.getChildren().addAll(botonAtacar,botonUsarConsumible,botonSeleccionarPersonaje);
        this.setAlignment(Pos.CENTER);
        this.bloquear(jugador != partida.jugadorActual());
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
