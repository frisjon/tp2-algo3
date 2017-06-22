package controlador.handlers;

import java.util.ArrayList;
import java.util.List;

import javafx.event.ActionEvent;
import modelo.tablero.Casillero;
import modelo.tablero.ErrorCasilleroYaOcupado;
import modelo.tablero.ErrorMovimientoInvalido;
import vista.RepresentacionPersonaje;
import vista.contenedores.ContenedorJuego;

public class BotonMovimientoEventHandler extends BotonHandler {
    
    private ContenedorJuego contenedorJuego;
    private RepresentacionPersonaje personaje;
    private String direccion;

    public BotonMovimientoEventHandler(ContenedorJuego _contenedorJuego, RepresentacionPersonaje _personaje, String _direccion) {
        this.contenedorJuego = _contenedorJuego;
        this.personaje = _personaje;
        this.direccion = _direccion;
    }

    @Override
    public void handle(ActionEvent event) {
        super.handle(event);

        List<Casillero> camino = new ArrayList<Casillero>();

        Casillero pos = this.personaje.getPersonaje().getCasillero();
        //Casillero destino = this.tablero.getCasilleroEn(pos, this.direccion);
        Casillero destino = this.contenedorJuego.getCasilleroEn(pos, this.direccion);
        
        camino.add(destino);

        try {
            //trata de mover al personaje en el tablero
            //  this.tablero.moverPersonaje(this.personaje.getPersonaje(), camino);
            this.contenedorJuego.moverPersonaje(this.personaje.getPersonaje(), camino);
        } catch (ErrorMovimientoInvalido e) {
            this.contenedorJuego.mostrarConsola(this.personaje.getPersonaje().getNombre()+" no se puede mover en esa direccion. Fin del mapa.");
            return;
        } catch (ErrorCasilleroYaOcupado e) {
            this.contenedorJuego.mostrarConsola(this.personaje.getPersonaje().getNombre()+" no se puede mover en esa direccion. Casillero ocupado");
            return;
        }
        
        this.personaje.decrementarMovimientosRestantes();
        
        if (0 < this.personaje.getMovimientosRestantes()) {
            //el personaje puede seguir moviendose
            this.contenedorJuego.continuarMovimiento(this.personaje);
        } else {
            //fin del turno. no mas movimientos restantes.
            this.contenedorJuego.mostrarConsola(this.personaje.getPersonaje().getNombre()+" se mueve.");
            this.contenedorJuego.desactivarBotonMover();
            this.contenedorJuego.setRight(null);
        }
        
        this.contenedorJuego.actualizarRepresentacionPersonaje(this.personaje);
    }
}
