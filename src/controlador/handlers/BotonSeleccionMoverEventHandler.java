package controlador.handlers;

import javafx.event.ActionEvent;
import vista.RepresentacionPersonaje;
import vista.contenedores.ContenedorJuego;
import vista.contenedores.ContenedorMover;

public class BotonSeleccionMoverEventHandler extends BotonHandler{
    private ContenedorJuego contenedorJuego;
    private RepresentacionPersonaje personaje;

    public BotonSeleccionMoverEventHandler(ContenedorJuego _contenedorJuego, RepresentacionPersonaje _personaje){
        this.contenedorJuego = _contenedorJuego;
        this.personaje = _personaje;
    }
    
    @Override
    public void handle(ActionEvent event){
        super.handle(event);
        this.contenedorJuego.setRight(null);
        this.contenedorJuego.setRight(new ContenedorMover(contenedorJuego, personaje));
    }
}
