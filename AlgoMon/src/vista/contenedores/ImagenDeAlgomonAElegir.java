package vista.contenedores;

import javafx.scene.image.ImageView;
import vista.ListaDeRepresentaciones;


public class ImagenDeAlgomonAElegir extends ImageView{
    public ImagenDeAlgomonAElegir(ListaDeRepresentaciones algomones) {
        this.setImage(algomones.getActual().getImagen());
        this.setFitWidth(250);
        this.setFitHeight(250);
    }
}
