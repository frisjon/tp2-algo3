package fiuba.algo3.vistas;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;

public class CajaAlerta {

	public static void mostrar(String titulo, String mensaje){
		Alert error = new Alert(AlertType.ERROR,mensaje,ButtonType.OK);
		error.setTitle(titulo);
		
		error.showAndWait();
		
		if(error.getResult() == ButtonType.OK){
			error.close();
		}
	}
}
