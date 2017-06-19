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
import vista.contenedores.ContenedorJuego;

public class BotonIzquierdaEventHandler extends BotonHandler {

    private ContenedorJuego contenedorJuego;
    private Tablero tablero;
    private RepresentacionPersonaje personaje;

    public BotonIzquierdaEventHandler(ContenedorJuego _contenedorJuego, Tablero _tablero, RepresentacionPersonaje _personaje) {
        this.contenedorJuego = _contenedorJuego;
        this.tablero = _tablero;
        this.personaje = _personaje;
    }

    @Override
    public void handle(ActionEvent event) {
        super.handle(event);

        List<Casillero> camino = new ArrayList<Casillero>();

        Casillero pos = this.personaje.getPersonaje().getCasillero();
        Coordenada coord = pos.getCoordenada();
        Casillero movimiento = new Casillero(coord.getX()-1, coord.getY());

        camino.add(movimiento);

        this.tablero.moverPersonaje(this.personaje.getPersonaje(), camino);
        this.contenedorJuego.actualizarRepresentacionPersonaje(this.personaje);
        ////this.contenedorJuego.actualizarTablero();
        this.contenedorJuego.mostrarConsola(this.personaje.getPersonaje().getNombre()+" se mueve abajo");
    }

}
