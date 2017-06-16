package vista.botones;

import controlador.handlers.OpcionAtacarEventHandler;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import modelo.Jugador;
import modelo.Partida;
import modelo.ataques.Ataque;
import vista.FabricaDeRepresentaciones;
import vista.RepresentacionAlgoMon;
import vista.contenedores.ContenedorPelea;

public class BotonMenuAtacar extends MenuButton {
    private ContenedorPelea contenedor;

    public BotonMenuAtacar(Partida partida, Jugador jugador, VBox opciones,  ContenedorPelea contenedor) {
    	super("Atacar");
        this.contenedor = contenedor;
        this.setFont(Font.font("Lucida Console", 13));
        this.getStylesheets().add("file:src/vista/fuentes/styleSheet.css");
        opciones.getChildren().add(this);
        FabricaDeRepresentaciones fabrica = new FabricaDeRepresentaciones();
        RepresentacionAlgoMon representacion = fabrica.crearRepresentacion(jugador.getAlgomonActivo());
        for(Ataque ataque : jugador.getAlgomonActivo().getAtaques()) {
            MenuItem opcion = new MenuItem(representacion.getNombreDeAtaque(ataque));
            opcion.setOnAction(new OpcionAtacarEventHandler(partida,ataque,this.contenedor,opcion));
            opcion.setText(ataque.getClass().getSimpleName() + " (" + ataque.getCantidad() + "/"+ ataque.cantidadInicial() + ")");
            this.getItems().add(opcion);
        }
    }
}
