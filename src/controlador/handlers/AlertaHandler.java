package controlador.handlers;

import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.stage.WindowEvent;

import java.util.Optional;

public class AlertaHandler implements EventHandler<WindowEvent>{

    @Override
    public void handle(WindowEvent event) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmacion de salida");
        alert.setHeaderText("¿Esta seguro que desea abandonar el juego?");

        ButtonType aceptar = new ButtonType("Aceptar");
        ButtonType cancelar = new ButtonType("Cancelar", ButtonBar.ButtonData.CANCEL_CLOSE);

        alert.getButtonTypes().setAll(aceptar,cancelar);

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() != aceptar) {
            event.consume();
        }
    }

}
