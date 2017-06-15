package vista;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import vista.eventos.BotonEntrarEventHandler;

public class ContenedorMenu extends VBox {
    Stage stage;

    public ContenedorMenu(Stage stage, Scene proximaEscena) {
        super();

        this.stage = stage;

        this.setAlignment(Pos.CENTER);
        this.setSpacing(20);
        this.setPadding(new Insets(50));
        Image imagen = new Image("file:src/vista/imagenes/dbz-inicio.jpg");
        BackgroundImage imagenDeFondo = new BackgroundImage(imagen, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
        this.setBackground(new Background(imagenDeFondo));

        Button botonEquipoGuerreros = new Button();
        botonEquipoGuerreros.setText("Guerreros Z");
        Button botonEquipoGuerreros2 = new Button();
        botonEquipoGuerreros.setText("Guerreros Z");
        Button botonEquipoEnemigos = new Button();
        botonEquipoEnemigos.setText("Enemigos de la Tierra");
        Button botonEquipoEnemigos2 = new Button();
        botonEquipoEnemigos2.setText("Enemigos de la Tierra");

        Label etiqueta = new Label();
        etiqueta.setFont(Font.font("Tahoma", FontWeight.BOLD, 50));

        etiqueta.setText("Elijan sus equipos:");
        etiqueta.setAlignment(Pos.TOP_LEFT);
        etiqueta.setTextFill(Color.BLUE); // http://www.color-hex.com/
        //etiqueta.setPrefSize(350, 80);
        
        BotonEntrarEventHandler botonEntrarHandler = new BotonEntrarEventHandler(stage, proximaEscena);
        botonEquipoGuerreros.setOnAction(botonEntrarHandler);

        this.getChildren().addAll(etiqueta, botonEquipoGuerreros, botonEquipoGuerreros2, botonEquipoEnemigos, botonEquipoEnemigos2);
    }

}

