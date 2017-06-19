package controlador.handlers;

import javafx.event.ActionEvent;
import vista.contenedores.ContenedorJuego;
import vista.contenedores.ContenedorSeleccionPersonaje;

public class BotonOpcionMoverEventHandler extends BotonHandler{
    private ContenedorJuego contenedorJuego;
    private ContenedorSeleccionPersonaje contenedorSeleccion;

    public BotonOpcionMoverEventHandler(ContenedorJuego _contenedorJuego){
        this.contenedorJuego = _contenedorJuego;
        this.contenedorSeleccion = new ContenedorSeleccionPersonaje(contenedorJuego, "mover");
    }
    
    @Override
    public void handle(ActionEvent event){
        super.handle(event);
        this.contenedorJuego.setRight(null);
        this.contenedorJuego.setRight(contenedorSeleccion);
    }
}
