package vista.contenedores;

import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.media.AudioClip;
import vista.BarraDeVolumen;


public class ContenedorVolumen extends HBox{
    private AudioClip musica;


    public ContenedorVolumen(javafx.scene.media.AudioClip musicaDeFondo) {
        BarraDeVolumen volumen = new BarraDeVolumen();

        Image musicaEncendida = new Image("file:src/vista/imagenes/musicaEncendida.png");
        Image musicaApagada = new Image("file:src/vista/imagenes/musicaApagada.png");

        ImageView imagenVolumen = new ImageView(musicaEncendida);
        imagenVolumen.setFitWidth(50);
        imagenVolumen.setFitHeight(50);

        this.getChildren().addAll(imagenVolumen,volumen);
        this.setAlignment(Pos.CENTER);
        musica = musicaDeFondo;

        volumen.valueProperty().addListener((observadorDeValor, valorAnterior, valorActual) -> {
            if (volumen.getValue() == 0.0) {
                imagenVolumen.setImage(musicaApagada);
                // musicaEstaReproduciendo(false);
            } else {
                imagenVolumen.setImage(musicaEncendida);
                // musicaEstaReproduciendo(true);
            }
            musica.stop();
            musica.play(valorActual.doubleValue());
        });
    }
}
