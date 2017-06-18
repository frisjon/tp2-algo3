package controlador.handlers;

import java.util.ArrayList;
import java.util.List;

import javafx.event.ActionEvent;
import javafx.stage.Stage;
import modelo.personajes.Personaje;
import modelo.tablero.Casillero;
import modelo.tablero.Coordenada;
import modelo.tablero.Tablero;
import vista.RepresentacionPersonaje;

public class BotonArribaEventHandler extends BotonHandler {

    private Stage stage;
    private Tablero tablero;
    private RepresentacionPersonaje personaje;

    public BotonArribaEventHandler(Stage _stage, Tablero _tablero, RepresentacionPersonaje _personaje) {
        this.stage = _stage;
        this.tablero = _tablero;
        this.personaje = _personaje;
    }

    @Override
    public void handle(ActionEvent event) {
        super.handle(event);

        List<Casillero> camino = new ArrayList<Casillero>();

        Personaje _personaje = this.personaje.getPersonaje();

        Casillero pos = personaje.getCasillero();
        Coordenada coord = pos.getCoordenada();
        Casillero movimiento = new Casillero(coord.getX(), coord.getY()+1);

        camino.add(movimiento);

        this.tablero.moverPersonaje(_personaje, camino);

    }

}
