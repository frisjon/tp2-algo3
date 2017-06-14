package vista;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import modelo.juego.Juego;
import vista.eventos.AplicacionOnKeyPressEventHandler;

public class Aplicacion extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(final Stage stage) throws Exception {

        stage.setTitle("Dragon Ball Z");

        //Juego juego = new Juego(); de aca se empieza a crear el modelo

        ContenedorPrincipal contenedorPrincipal = new ContenedorPrincipal(stage);
        Scene escenaJuego = new Scene(contenedorPrincipal, 640, 480);

        AplicacionOnKeyPressEventHandler AplicacionOnKeyPressEventHandler = new AplicacionOnKeyPressEventHandler(stage, contenedorPrincipal.getBarraDeMenu());
        escenaJuego.setOnKeyPressed(AplicacionOnKeyPressEventHandler);

        ContenedorBienvenidos contenedorBienvenidos = new ContenedorBienvenidos(stage, escenaJuego);
        Scene escenaBienvenidos = new Scene(contenedorBienvenidos, 640, 480);

        // add handler to this:
        // stage.setOnCloseRequest()

        stage.setScene(escenaBienvenidos);
        stage.setFullScreen(true);

        stage.show();

    }
}
