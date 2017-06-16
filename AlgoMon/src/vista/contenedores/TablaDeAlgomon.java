package vista.contenedores;

import javafx.scene.image.ImageView;
import vista.ListaDeRepresentaciones;

public class TablaDeAlgomon extends ImageView{
    public TablaDeAlgomon(ListaDeRepresentaciones lista) {
        this.setImage(lista.getActual().getTabla());
        this.setFitHeight(175);
        this.setFitWidth(400);
    }
}
