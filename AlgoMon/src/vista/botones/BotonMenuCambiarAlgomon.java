package vista.botones;

import controlador.handlers.OpcionCambiarAlgomonEventHandler;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import modelo.Jugador;
import modelo.Partida;
import modelo.algomones.AlgoMon;
import vista.FabricaDeRepresentaciones;
import vista.RepresentacionAlgoMon;
import vista.contenedores.ContenedorPelea;

public class BotonMenuCambiarAlgomon extends MenuButton {

    public BotonMenuCambiarAlgomon(Partida partida, Jugador jugador, VBox opciones, ContenedorPelea contenedor) {
    	super("Cambiar Algomon");
        ContenedorPelea contenedor1 = contenedor;
        this.setFont(Font.font("Lucida Console", 13));
        this.getStylesheets().add("file:src/vista/fuentes/styleSheet.css");
        opciones.getChildren().add(this);
        FabricaDeRepresentaciones fabrica = new FabricaDeRepresentaciones();
        for(AlgoMon algomon : jugador.getListaDeAlgomones()) {
        	if(algomon.equals(jugador.getAlgomonActivo()) || algomon.estaMuerto()) continue;
        	RepresentacionAlgoMon representacion = fabrica.crearRepresentacion(algomon);
        	MenuItem opcion = new MenuItem(representacion.getNombre());
        	opcion.setOnAction(new OpcionCambiarAlgomonEventHandler(partida,algomon, contenedor1));
        	this.getItems().add(opcion);
        }
    }
}
