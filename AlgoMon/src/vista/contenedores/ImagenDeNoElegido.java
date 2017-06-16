package vista.contenedores;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class ImagenDeNoElegido extends ImageView {
    public ImagenDeNoElegido() {
        this.setImage(new Image("file:src/vista/imagenes/signoPreguntaTransparente.png"));
        this.setFitWidth(120);
        this.setFitHeight(120);
    }
}
