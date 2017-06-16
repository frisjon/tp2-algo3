package vista.contenedores;

import javafx.geometry.Pos;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;


public class ListaDeElegidos extends HBox {

    public ListaDeElegidos() {
        ImageView primerSeleccion = new ImagenDeNoElegido();
        ImageView segundaSeleccion = new ImagenDeNoElegido();
        ImageView terceraSeleccion = new ImagenDeNoElegido();

        this.getChildren().addAll(primerSeleccion,segundaSeleccion,terceraSeleccion);
        this.setAlignment(Pos.CENTER);
    }

}
