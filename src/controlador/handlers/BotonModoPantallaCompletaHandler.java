package controlador.handlers;

import javafx.event.ActionEvent;
import javafx.stage.Stage;

public class BotonModoPantallaCompletaHandler extends BotonHandler {
	
	private Stage stage;
	
	public BotonModoPantallaCompletaHandler(Stage primaryStage) {
		super();
		this.stage = primaryStage;
	}

	public void handle(ActionEvent event) {
		super.handle(event);
		
		if (stage.isFullScreen()) {
			stage.setFullScreen(false);
			stage.setMaximized(true);
			return;
		}
		if (!stage.isFullScreen()) {
			stage.setFullScreen(true);
			stage.setMaximized(false);
		}
	}
}
