package vista;

import java.util.ArrayList;
import java.util.List;

import modelo.jugador.Jugador;
import modelo.personajes.Personaje;

public class RepresentacionJugador {
    
    private Jugador jugador;
    private List<RepresentacionPersonaje> representacionPersonajes;
    private int Acciones;
    
    public RepresentacionJugador(Jugador _jugador) {
        this.jugador = _jugador;
        
        this.representacionPersonajes = new ArrayList<RepresentacionPersonaje>();
        
        CreadorRepresentacionPersonaje creador = new CreadorRepresentacionPersonaje();
        for (Personaje p: this.jugador.getEquipo().pedirListaPersonajes()) {
            this.representacionPersonajes.add(creador.crearRepresentacionDe(p));
        }
    }

    public List<RepresentacionPersonaje> getRepresentacionesDePersonajes() {
        return this.representacionPersonajes;
    }
    
    public String getNombreJugador() {
        return this.jugador.getNombre();
    }
}
