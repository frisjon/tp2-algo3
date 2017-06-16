package controlador.handlers;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class OpcionAcercaDeEventHandler implements EventHandler<ActionEvent> {

    @Override
    public void handle(ActionEvent actionEvent) {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Acerca de Dragon Algo Ball");
        alert.setHeaderText("Ejemplo de mensaje de alerta");
        String mensaje = "Desarrollado por Thodrimarami Companys";
        alert.setContentText(mensaje);
        alert.show();
    }
}
