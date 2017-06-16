package vista.contenedores;


import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Flecha extends ImageView{
    public Flecha(String origen) {
        Image flecha = new Image(origen);
        this.setImage(flecha);
        this.setFitHeight(50);
        this.setFitWidth(50);
    }
}
