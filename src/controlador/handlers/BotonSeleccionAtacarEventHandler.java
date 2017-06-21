package controlador.handlers;

import javafx.event.ActionEvent;
import modelo.personajes.Personaje;
import vista.RepresentacionJugador;
import vista.RepresentacionPersonaje;
import vista.contenedores.ContenedorAtaque;
import vista.contenedores.ContenedorJuego;

public class BotonSeleccionAtacarEventHandler extends BotonHandler{
    private ContenedorJuego contenedorJuego;
    private RepresentacionJugador jugadorEsperando;
    private Personaje atacante;
    RepresentacionPersonaje representacionDefensor;

    public BotonSeleccionAtacarEventHandler(ContenedorJuego _contenedorJuego, RepresentacionPersonaje _repredefensor, Personaje _atacante){
        this.contenedorJuego = _contenedorJuego;
        this.jugadorEsperando = this.contenedorJuego.getRepresentacionJugadorEsperando();
        this.atacante = _atacante;
        this.representacionDefensor = _repredefensor;
    }
    
    @Override
    public void handle(ActionEvent event){
        super.handle(event);
        this.contenedorJuego.setRight(null);
        this.contenedorJuego.setRight(new ContenedorAtaque(this.contenedorJuego, this.representacionDefensor, this.jugadorEsperando, this.atacante));
    }
}
