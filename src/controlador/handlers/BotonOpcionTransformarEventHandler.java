package controlador.handlers;

import javafx.event.ActionEvent;
import vista.contenedores.ContenedorJuego;
import vista.contenedores.ContenedorSeleccionPersonaje;

public class BotonOpcionTransformarEventHandler extends BotonHandler{
    private ContenedorJuego contenedorJuego;
    private ContenedorSeleccionPersonaje contenedorSeleccion;

    public BotonOpcionTransformarEventHandler(ContenedorJuego _contenedorJuego){
        this.contenedorJuego = _contenedorJuego;
        this.contenedorSeleccion = new ContenedorSeleccionPersonaje(contenedorJuego, "transformar");
    }
    
    @Override
    public void handle(ActionEvent event){
        super.handle(event);
        this.contenedorJuego.setRight(null);
        this.contenedorJuego.setRight(contenedorSeleccion);
    }
}
