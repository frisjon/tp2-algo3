package controlador.handlers;

import javafx.event.ActionEvent;
import javafx.scene.image.ImageView;
import vista.ListaDeRepresentaciones;
import vista.RepresentacionAlgoMon;


public class BotonCambiarDerechaEventHandler extends BotonHandler {
	private final ListaDeRepresentaciones lista;
    private final ImageView seleccion;
    private final ImageView tabla;
    private final BotonSeleccionarEventHandler botonSeleccionar;

    public BotonCambiarDerechaEventHandler(ListaDeRepresentaciones lista, ImageView seleccionJugador, ImageView tabla, BotonSeleccionarEventHandler botonSeleccionar) {
        this.seleccion = seleccionJugador;
        this.tabla = tabla;
        this.lista = lista;
        this.botonSeleccionar = botonSeleccionar;
    }

    @Override
    public void handle(ActionEvent event) {
    	super.handle(event);
    	RepresentacionAlgoMon actual = lista.siguienteALaDerecha();
    	seleccion.setImage(actual.getImagen());
    	tabla.setImage(actual.getTabla());
    	this.botonSeleccionar.setRepresentacion(actual);
    }
}
