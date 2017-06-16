package vista.botones;

import controlador.handlers.OpcionAplicarElementoEventHandler;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import modelo.Jugador;
import modelo.Partida;
import modelo.elementos.Elemento;
import vista.contenedores.ContenedorPelea;

public class BotonMenuAplicarElemento extends MenuButton {
	private ContenedorPelea contenedor;

    public BotonMenuAplicarElemento(Partida partida, Jugador jugador, VBox opciones,  ContenedorPelea contenedor) {
    	super("Aplicar Elemento");
        this.contenedor = contenedor;
        this.setFont(Font.font("Lucida Console", 13));
        this.getStylesheets().add("file:src/vista/fuentes/styleSheet.css");
        opciones.getChildren().add(this);
        for(Elemento elemento : jugador.getElementos()) {
            MenuItem opcion = new MenuItem(elemento.getClass().getSimpleName());
            opcion.setOnAction(new OpcionAplicarElementoEventHandler(partida,elemento,this.contenedor,opcion));
            opcion.setText(elemento.getClass().getSimpleName() + " (" + elemento.cantidadElemento() + "/" + elemento.cantidadInicial() + ")");
            this.getItems().add(opcion);
        }
    }
}
 