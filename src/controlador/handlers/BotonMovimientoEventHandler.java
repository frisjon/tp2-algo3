package controlador.handlers;

import java.util.ArrayList;
import java.util.List;

import javafx.event.ActionEvent;
import modelo.personajes.ErrorPersonajeInutilizado;
import modelo.personajes.Personaje;
import modelo.tablero.Casillero;
import modelo.tablero.ErrorCasilleroYaOcupado;
import modelo.tablero.ErrorMovimientoInvalido;
import vista.RepresentacionPersonaje;
import vista.Reproductor;
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
        int cantidadEsferas = 0;
        
        try {
            destino = this.contenedorJuego.getCasilleroEn(pos, this.direccion);
        } catch (ErrorMovimientoInvalido e) {
            this.contenedorJuego.mostrarConsola(personaje.getNombre()+" no se puede mover en esa direccion. Movimiento invalido.");
            Reproductor.buzz();
            return;
        }
        
        camino.add(destino);

        try {
        	if (camino.get(0) != null)
        	    cantidadEsferas = this.contenedorJuego.moverPersonaje(personaje, camino);
        	
        	if (0 < cantidadEsferas)
        	    this.contenedorJuego.mostrarConsola(personaje.getNombreEquipo()+" tienen "+Integer.toString(cantidadEsferas)+" esfera/s.");
        } catch (ErrorPersonajeInutilizado e) {
            this.contenedorJuego.mostrarConsola("No se pudo realizar el movimiento porque el personaje esta inutilizado.");
            Reproductor.buzz();
            return;
        } catch (ErrorMovimientoInvalido e) {
            this.contenedorJuego.mostrarConsola(personaje.getNombre()+" no se puede mover en esa direccion. Movimiento invalido.");
            Reproductor.buzz();
            return;
        } catch (ErrorCasilleroYaOcupado e) {
            this.contenedorJuego.mostrarConsola(personaje.getNombre()+" no se puede mover en esa direccion. Casillero ocupado");
            Reproductor.buzz();
            return;
        }
        
        this.personaje.actualizarMovimientosTotales();
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
