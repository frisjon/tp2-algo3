package vista.contenedores;

import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

import java.util.Observable;
import java.util.Observer;

class VistaConsola extends HBox implements Observer
{
    private Consola consola;

    public VistaConsola(Consola consola)
    {
        this.consola = consola;
        consola.addObserver(this);

        setMaxHeight(125);
        setMinHeight(getMaxHeight());
        setStyle("-fx-background-color: black;-fx-opacity: 0.8;");

        getChildren().add(new Label());
    }

    public void update(Observable observable, Object arg)
    {
        if (observable != consola)
            return;

        Label etiqueta = new Label();
        etiqueta.setText(consola.getMensaje());
        etiqueta.setTextFill(Color.WHITE);
        etiqueta.setFont(Font.font("Pokemon GB", FontWeight.BOLD, 12));

        getChildren().set(0, etiqueta);
    }
}