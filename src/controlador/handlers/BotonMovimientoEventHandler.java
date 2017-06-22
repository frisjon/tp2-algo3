package controlador.handlers;

import java.util.ArrayList;
import java.util.List;

import javafx.event.ActionEvent;
import modelo.personajes.Personaje;
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
        
        Personaje personaje = this.personaje.getPersonaje(); 

        Casillero pos = personaje.getCasillero();
        Casillero destino = null;
        
        try {
            destino = this.contenedorJuego.getCasilleroEn(pos, this.direccion);
        } catch (ErrorMovimientoInvalido e) {
            this.contenedorJuego.mostrarConsola(personaje.getNombre()+" no se puede mover en esa direccion.");
            return;
        }
        
        camino.add(destino);

        try {
            this.contenedorJuego.moverPersonaje(personaje, camino);
        } catch (ErrorMovimientoInvalido e) {
            this.contenedorJuego.mostrarConsola(personaje.getNombre()+" no se puede mover en esa direccion.");
            return;
        } catch (ErrorCasilleroYaOcupado e) {
            this.contenedorJuego.mostrarConsola(personaje.getNombre()+" no se puede mover en esa direccion. Casillero ocupado");
            return;
        }
        
        this.personaje.decrementarMovimientosRestantes();
        
        if (0 < this.personaje.getMovimientosRestantes()) {
            //el personaje puede seguir moviendose
            this.contenedorJuego.continuarMovimiento(this.personaje);
        } else {
            //fin del turno. no mas movimientos restantes.
            this.contenedorJuego.mostrarConsola(personaje.getNombre()+" se mueve.");
            this.contenedorJuego.desactivarBotonMover();
            this.contenedorJuego.setRight(null);
        }
        
        this.contenedorJuego.actualizarRepresentacionPersonaje(this.personaje);
    }
}
