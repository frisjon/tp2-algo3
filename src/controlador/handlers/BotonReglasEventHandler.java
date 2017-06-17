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
        "Cada jugador deberá elegir un equipo. El quipo Guerreros Z contendrá a Goku, Piccolo y Gohan, mientras que " +
        "el equipo Enemigos de la Tierra contrendrá a Freezer, MajinBoo y Cell.\n\n" +
        "Por cada turno el jugador correspondiente podrá realizar una acción de ataque y una acción de movilidad, no " + 
        "necesariamente del mismo personaje. Tanto el movimiento como el ataque hacia un personaje del contrincante " +
        "deberá respetar los atributos impuestos por el personaje en cuestión. El ki, cuyo aumento será de 5 por turno, " +
        "permitirá a la gran mayoría de los personajes tanto realizar su ataque especial como cambiar de modo (transformarse) " +
        "-tener en cuenta que otros personajes necesitan de otras cosas para poder transformarse y en el caso de Goku su poder " +
        "de ataque aumentará al tener menos del 30% de vida-. Y será que al atacar a un enemigo de mayor poder de pelea " +
        "el daño se reduce un 20%. \n\n" +
        "También habrá en el tablero varios consumibles distribuidos aleatoriamente, que pueden llegar a ser: una esfera del  " +
        "dragón, una semilla del hermitaño y una nube voladora. Cada uno con una ventaja diferente. \n\n" +
        "El juego finalizará cuando uno de los dos jugadores elimine a los personajes del oponente o cuando uno obtenga las 7 " +
        "esferas del dragón.");
        
        alerta.setResizable(false);
        Image imagen = new Image("file:src/vista/imagenes/DBZ.png", 50, 50, true, true);
        ImageView imageview = new ImageView(imagen);
        alerta.setGraphic(imageview);
        alerta.setHeight(500);
        this.alerta.showAndWait();
    }
}
