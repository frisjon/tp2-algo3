package controlador.handlers;

import javafx.event.ActionEvent;

public class BotonSalirEventHandler extends BotonHandler {	
    @Override
    public void handle(ActionEvent event) {
        super.handle(event);
        System.exit(0);
    }
}
