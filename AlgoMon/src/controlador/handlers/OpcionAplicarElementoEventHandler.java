package controlador.handlers;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.MenuItem;
import javafx.scene.media.AudioClip;
import modelo.Partida;
import modelo.elementos.Elemento;
import modelo.excepciones.CantidadElementoAgotadaException;
import vista.contenedores.ContenedorPelea;

public class OpcionAplicarElementoEventHandler implements EventHandler<ActionEvent> {

    private final MenuItem opcion;
    private Partida partida;
    private Elemento elemento;
    private ContenedorPelea contenedor;
    
    public OpcionAplicarElementoEventHandler(Partida partida, Elemento elemento, ContenedorPelea contenedor, MenuItem opcion) {
        this.partida = partida;
        this.elemento = elemento;
        this.contenedor = contenedor;
        this.opcion = opcion;
    }

    @Override
    public void handle(ActionEvent event) {
    	try {
            contenedor.notificarPanel(this.notificacionElemento());
    		partida.jugarTurnoActual(this.elemento);
        	contenedor.nuevoTurno();
        	if (partida.juegoTerminado())
        		contenedor.peleaFinalizada(partida.nombreGanador());
            AudioClip sonido = new AudioClip("file:src/vista/sonidos/elemento.wav");
            sonido.play();
            this.actualizarOpcionElemento();
        } 
        catch (CantidadElementoAgotadaException e) {
        	Alert alert = new Alert(AlertType.WARNING);
        	alert.setTitle("Warning");
        	alert.setHeaderText("Elemento Agotado");
        	alert.setContentText("No puede utilizar mas este elemento!");
        	alert.showAndWait();
        }
    }
    
    public String notificacionElemento(){
    	return this.partida.jugadorActual().getNombre() + " ha utilizado " 
    			+ this.elemento.getClass().getSimpleName() + "\n";
    }
    
    public void actualizarOpcionElemento(){
    	opcion.setText(elemento.getClass().getSimpleName() + " (" + elemento.cantidadElemento() + "/" + elemento.cantidadInicial() + ")");
    }

}
