package controlador.handlers;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import vista.Reproductor;

public abstract class BotonHandler implements EventHandler<ActionEvent>{

    @Override
    public void handle(ActionEvent event) {
        Reproductor.seleccion();
    }

}
