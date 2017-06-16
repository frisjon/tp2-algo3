package controlador.handlers;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.media.AudioClip;
import modelo.Partida;
import modelo.algomones.AlgoMon;
import modelo.excepciones.AlgoMonMuertoException;
import vista.contenedores.ContenedorPelea;

public class OpcionCambiarAlgomonEventHandler implements EventHandler<ActionEvent> {
	private ContenedorPelea contenedor;
	private Partida partida;
    private AlgoMon algomon;

	public OpcionCambiarAlgomonEventHandler(Partida partida, AlgoMon algomon, 
			 ContenedorPelea contenedor){
		this.contenedor = contenedor;
		this.partida = partida;
        this.algomon = algomon;
	}
	
	@Override
	public void handle(ActionEvent event) {
		 try {
			 contenedor.notificarPanel(this.notificacionCambioAlgomon());
			 partida.jugarTurnoActual(algomon);
			 AudioClip sonido = new AudioClip("file:src/vista/sonidos/cambiarPokemon.mp3");
			 sonido.play();
			 Thread.sleep(500); // para que el sonido se sincronize con el cambio
			 contenedor.cambiarAlgomon();
	         contenedor.nuevoTurno();
	         if (partida.juegoTerminado())
	        	 contenedor.peleaFinalizada(partida.nombreGanador());
	        }
		 	catch (AlgoMonMuertoException e) {
		 		Alert alert = new Alert(AlertType.WARNING);
	        	alert.setTitle("Warning");
	        	alert.setHeaderText("No es posible realizar la accion");
	        	alert.setContentText("El algomon que escogio esta muerto!");
	        	alert.showAndWait();
	        	
		 	} 
		 	catch (InterruptedException e) {
		 		e.printStackTrace();
		 }
	}
	
	public String notificacionCambioAlgomon(){
    	return this.partida.jugadorActual().getNombre() + " ha cambiado su AlgoMon actual por " 
    			+ this.algomon.getClass().getSimpleName() + "\n";
    }

}
