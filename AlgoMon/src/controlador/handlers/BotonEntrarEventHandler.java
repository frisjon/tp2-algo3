package controlador.handlers;

import javafx.event.ActionEvent;
import javafx.scene.media.AudioClip;
import javafx.stage.Stage;
import vista.contenedores.ContenedorEleccionAlgomon;
import vista.contenedores.Escena;
import vista.contenedores.ContenedorNombrarJugadores;

public class BotonEntrarEventHandler extends BotonHandler {

    private final AudioClip musicaDeFondo;
    private Stage stage;
    private ContenedorNombrarJugadores contenedorNombres;

    public BotonEntrarEventHandler(Stage stage, AudioClip musicaDeFondo) {
        this.stage = stage;
        this.contenedorNombres = new ContenedorNombrarJugadores();
        this.musicaDeFondo = musicaDeFondo;
        
    }

    @Override
    public void handle(ActionEvent event) {
    	super.handle(event);
    	
    	if (!contenedorNombres.jugadoresFueronIngresados()) {
    		contenedorNombres.mostrar();
        }
    	
    	if (contenedorNombres.jugadoresFueronIngresados()) { //esto evita que se empiece la eleccion si no se puso aceptar
            String nombreJugador1 = contenedorNombres.getNombreJugador1();
            String nombreJugador2 = contenedorNombres.getNombreJugador2();

            ContenedorEleccionAlgomon contenedorEleccion = new ContenedorEleccionAlgomon(stage, nombreJugador1, nombreJugador2,musicaDeFondo);
            Escena escenaEleccion = new Escena(contenedorEleccion, stage);

            stage.setFullScreenExitHint("");
            boolean enPantallaCompletaAntesDeCambiarEscena = stage.isFullScreen();
            stage.hide();
            stage.setScene(escenaEleccion);
            stage.setFullScreen(enPantallaCompletaAntesDeCambiarEscena);
            stage.show();
        }
    }




}
