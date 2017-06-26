package vista;

import javafx.application.Application;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import vista.contenedores.ContenedorBienvenida;
import vista.contenedores.Escena;
import controlador.handlers.AlertaHandler;

public class AplicacionPrincipal extends Application{

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stagePrincipal) throws Exception {
        stagePrincipal.setTitle("Dragon Ball Z");
        stagePrincipal.getIcons().add(new Image("file:src/vista/imagenes/dbz-inicio.jpg"));

        ContenedorBienvenida contenedorBienvenidos = new ContenedorBienvenida(stagePrincipal);
        Escena escenaBienvenidos = new Escena(contenedorBienvenidos, stagePrincipal);
       
        stagePrincipal.setScene(escenaBienvenidos);

        stagePrincipal.setFullScreenExitHint("Presione F11 para entrar o salir de la pantalla completa");
        stagePrincipal.setMinHeight(escenaBienvenidos.getAlto_minimo());
        stagePrincipal.setMinWidth(escenaBienvenidos.getAnchoMinimo());
        stagePrincipal.show();

        AlertaHandler alerta = new AlertaHandler();
        stagePrincipal.setOnCloseRequest(alerta);
    }
}
