package controlador.handlers;

import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class BotonReglasEventHandler extends BotonHandler {
	
	private Alert alerta;
	
    public BotonReglasEventHandler() {
    	
    	alerta = new Alert(Alert.AlertType.INFORMATION);
        alerta.setResizable(true);
        alerta.getDialogPane().setPrefSize(600,400);

    }

    @Override
    public void handle(ActionEvent event) {
        super.handle(event);
        this.alerta.setTitle("Reglas del juego:");
        this.alerta.setHeaderText("REGLAS DEL JUEGO:");
        this.alerta.setContentText(
        "Cada jugador debe elegir 3 AlgoMones con los cuales batallara hasta el final de la partida.\n\n" +
        "Cada uno de los AlgoMones tiene una serie de ataques y una cantidad de vida. Elegilos con cuidado! .\n\n" +
        "En cada turno el jugador puede atacar con su AlgoMon activo, cambiarlo o aplicarle un elemento.\n\n" +
        "Cada AlgoMon tiene dos estados, uno temporal y uno permanente. Tene cuidado: si tu AlgoMon está dormido, no podrá" +
        "atacar por 3 turnos. Mientras que si tu AlgoMon está quemado, al atacar a otro se producirá daño a sí mismo.\n\n" +
        "La batalla AlgoMon finaliza cuando los 3 AlgoMones de algún jugador estan muertos.\n\n" +
        "Buena suerte!");
        
        alerta.setResizable(false);
        Image imagen = new Image("file:src/vista/imagenes/fondo-dbz.jpg", 50, 50, true, true);
        ImageView imageview = new ImageView(imagen);
        alerta.setGraphic(imageview);
        alerta.setHeight(400);
        this.alerta.showAndWait();
    }
}
