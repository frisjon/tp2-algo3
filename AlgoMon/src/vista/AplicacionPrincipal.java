package vista;

import javafx.application.Application;
import javafx.scene.image.Image;
import javafx.scene.media.AudioClip;
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
        AudioClip musicaDeFondo = new AudioClip("file:src/vista/sonidos/Pokemonentrada.mp3");
        musicaDeFondo.setCycleCount(5);
        musicaDeFondo.play();
        

        stagePrincipal.setTitle("AlgoMon");
        stagePrincipal.getIcons().add(new Image("file:src/vista/imagenes/pokebola.png"));

        ContenedorBienvenida contenedorBienvenidos =
                new ContenedorBienvenida(stagePrincipal, musicaDeFondo);
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
