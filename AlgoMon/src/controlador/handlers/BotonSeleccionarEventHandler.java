package controlador.handlers;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import modelo.Jugador;
import modelo.algomones.AlgoMon;
import vista.RepresentacionAlgoMon;

import java.util.ArrayList;
import java.util.List;


public class BotonSeleccionarEventHandler extends BotonHandler {
    private ImageView seleccion;
    private HBox seleccionados;
    private Jugador jugador;
    private RepresentacionAlgoMon representacion;
    private Button botonSeleccion;
    private int contador = 0;
    private List<AlgoMon> algomonesEnUso = new ArrayList<AlgoMon>();

    public BotonSeleccionarEventHandler(ImageView seleccionJugador, HBox seleccionados, Jugador jugador, RepresentacionAlgoMon representacionActual) {
        this.seleccion = seleccionJugador;
        this.seleccionados = seleccionados;
        this.jugador = jugador;
        this.representacion = representacionActual;
    }
    
    public void setRepresentacion(RepresentacionAlgoMon representacionAlgoMon){
    	this.representacion = representacionAlgoMon;
    }
    
    public void setBotonSeleccion(Button botonSeleccion){
    	this.botonSeleccion = botonSeleccion;
    }
    

    @Override
    public void handle(ActionEvent event) {
        super.handle(event);
        
        if (algomonDisponible(representacion.getAlgomon())) {
            jugador.agregarAlgomon(representacion.getAlgomon());
            this.algomonElegido(representacion.getAlgomon());
            representacion.getSonido().play();
            if (jugador.cantidadAlgomones() == 3) botonSeleccion.setDisable(true);
        }
        else {
        	return;
        }

        ImageView seleccionActual= new ImageView(seleccion.getImage());
        seleccionActual.setFitHeight(120);
        seleccionActual.setFitWidth(120);
        try {
            seleccionados.getChildren().set(contador++,seleccionActual);
        }catch (IndexOutOfBoundsException ignored) {}
    }

	private void algomonElegido(AlgoMon algomon) {
		algomonesEnUso.add(algomon);
	}

	private boolean algomonDisponible(AlgoMon algomonDeseado) {
		boolean disponible = true;
		for (AlgoMon algomon : algomonesEnUso) {
			if (algomon.equals(algomonDeseado)) disponible = false;
		}
		return disponible;
	}
}
