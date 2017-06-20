package controlador.handlers;

import java.util.ArrayList;
import java.util.List;

import javafx.event.ActionEvent;
import modelo.tablero.Casillero;
import modelo.tablero.Coordenada;
import modelo.tablero.ErrorCasilleroYaOcupado;
import modelo.tablero.ErrorMovimientoInvalido;
import modelo.tablero.Tablero;
import vista.RepresentacionPersonaje;
import vista.contenedores.ContenedorJuego;

public class BotonMovimientoEventHandler extends BotonHandler {
    
    private ContenedorJuego contenedorJuego;
    private Tablero tablero;
    private RepresentacionPersonaje personaje;
    private String direccion;

    public BotonMovimientoEventHandler(ContenedorJuego _contenedorJuego, Tablero _tablero, RepresentacionPersonaje _personaje, String _direccion) {
        this.contenedorJuego = _contenedorJuego;
        this.tablero = _tablero;
        this.personaje = _personaje;
        this.direccion = _direccion;
    }

    @Override
    public void handle(ActionEvent event) {
        super.handle(event);

        List<Casillero> camino = new ArrayList<Casillero>();

        Casillero pos = this.personaje.getPersonaje().getCasillero();
        Coordenada coord = pos.getCoordenada();
        Casillero movimiento = null;
        
        switch (this.direccion) {
            case "q": movimiento = new Casillero(coord.getX()-1, coord.getY()-1); break;
            case "w": movimiento = new Casillero(coord.getX(), coord.getY()-1); break;
            case "e": movimiento = new Casillero(coord.getX()+1, coord.getY()-1); break;
            case "a": movimiento = new Casillero(coord.getX()-1, coord.getY()); break;
            case "s": movimiento = new Casillero(coord.getX(), coord.getY()+1); break;
            case "d": movimiento = new Casillero(coord.getX()+1, coord.getY()); break;
            case "z": movimiento = new Casillero(coord.getX()-1, coord.getY()+1); break;
            case "c": movimiento = new Casillero(coord.getX()+1, coord.getY()+1); break;
        }

        camino.add(movimiento);

        try {
            this.tablero.moverPersonaje(this.personaje.getPersonaje(), camino);
        } catch (ErrorMovimientoInvalido e) {
            this.contenedorJuego.mostrarConsola(this.personaje.getPersonaje().getNombre()+" no se puede mover en esa direccion. Fin del mapa.");
            return;
        } catch (ErrorCasilleroYaOcupado e) {
            this.contenedorJuego.mostrarConsola(this.personaje.getPersonaje().getNombre()+" no se puede mover en esa direccion. Casillero ocupado");
            return;
        }
        this.contenedorJuego.actualizarRepresentacionPersonaje(this.personaje);
        this.contenedorJuego.mostrarConsola(this.personaje.getPersonaje().getNombre()+" se mueve.");
    }
}
