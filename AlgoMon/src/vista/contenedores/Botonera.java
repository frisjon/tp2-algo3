package vista.contenedores;

import controlador.handlers.BotonMenuEventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.MenuButton;
import javafx.scene.layout.VBox;
import modelo.Jugador;
import modelo.Partida;
import vista.botones.BotonMenuAplicarElemento;
import vista.botones.BotonMenuAtacar;
import vista.botones.BotonMenuCambiarAlgomon;

public class Botonera extends VBox {
	
	private MenuButton botonAtacar;
	private MenuButton botonUsarElemento;
	private MenuButton botonCambiarAlgomon;
	
    public Botonera(Partida partida, ContenedorPelea contenedor, Jugador jugador) {

        this.setSpacing(15);
        this.setAlignment(Pos.CENTER);

        VBox opciones = new VBox();
        opciones.setSpacing(15);
        opciones.setAlignment(Pos.CENTER);

        botonAtacar = new BotonMenuAtacar(partida,jugador,opciones,contenedor);
        BotonMenuEventHandler botonMenuAtacarEventHandler = new BotonMenuEventHandler(botonAtacar);
        botonAtacar.setOnAction(botonMenuAtacarEventHandler);

        botonUsarElemento = new BotonMenuAplicarElemento(partida,jugador,opciones,contenedor);
        BotonMenuEventHandler botonUsarElementoEventHandler = new BotonMenuEventHandler(botonUsarElemento);
        botonUsarElemento.setOnAction(botonUsarElementoEventHandler);

        botonCambiarAlgomon = new BotonMenuCambiarAlgomon(partida,jugador,opciones,contenedor);
        BotonMenuEventHandler botonCambiarAlgomonEventHandler = new BotonMenuEventHandler(botonCambiarAlgomon);
        botonCambiarAlgomon.setOnAction(botonCambiarAlgomonEventHandler);

        botonAtacar.setMaxWidth(175);
        botonUsarElemento.setMaxWidth(175);
        botonCambiarAlgomon.setMaxWidth(175);

        this.getChildren().addAll(botonAtacar,botonUsarElemento,botonCambiarAlgomon,opciones);
        this.setAlignment(Pos.CENTER);
        this.bloquear(jugador != partida.jugadorActual());

    }

	public void bloquear(boolean bloqueo) {
		this.botonAtacar.setDisable(bloqueo);
		this.botonCambiarAlgomon.setDisable(bloqueo);
		this.botonUsarElemento.setDisable(bloqueo);
		
	}
	
	public void habilitarSoloCambiarAlgoMon(){
		this.botonAtacar.setDisable(true);
		this.botonCambiarAlgomon.setDisable(false);
		this.botonUsarElemento.setDisable(true);
	}
}
