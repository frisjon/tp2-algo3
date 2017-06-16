package aplicacion;

import javafx.application.Application;
import javafx.stage.Stage;
import vista.AplicacionPrincipal;

public class Aplicacion extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        AplicacionPrincipal mainApp = new AplicacionPrincipal();
        mainApp.start(primaryStage);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
