package controlador.handlers;

import javafx.event.ActionEvent;
import vista.contenedores.ContenedorJuego;
import vista.contenedores.ContenedorSeleccionPersonaje;

public class BotonOpcionAtacarEventHandler extends BotonHandler{
    private ContenedorJuego contenedorJuego;
    private ContenedorSeleccionPersonaje contenedorSeleccion;

    public BotonOpcionAtacarEventHandler(ContenedorJuego _contenedorJuego){
        this.contenedorJuego = _contenedorJuego;
        this.contenedorSeleccion = new ContenedorSeleccionPersonaje(contenedorJuego, "atacar");
    }
    
    @Override
    public void handle(ActionEvent event){
        super.handle(event);
        this.contenedorJuego.setRight(null);
        this.contenedorJuego.setRight(contenedorSeleccion);
    }
}
