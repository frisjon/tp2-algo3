package vista;

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


/* ejemplo de uso:

public boolean estanCompletosLosCampos(){
if (this.nombreJugador1.getText().isEmpty()){
	CajaAlerta.mostrar("Datos Invalidos", "El casillero de los autobots esta vacio. Completar para jugar...");
	return false;
}
if (this.nombreJugador2.getText().isEmpty()){
	CajaAlerta.mostrar("Datos Invalidos", "El casillero de los decepticons esta vacio. Completar para jugar...");
	return false;
}
return true;

}

*/