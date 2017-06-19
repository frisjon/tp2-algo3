package controlador.handlers;

import javafx.event.ActionEvent;
import modelo.personajes.Personaje;
import vista.RepresentacionPersonaje;
import vista.contenedores.ContenedorJuego;
import vista.contenedores.ContenedorMover;
import vista.contenedores.ContenedorTransformaciones;

public class BotonSeleccionTransformarEventHandler extends BotonHandler{
    private ContenedorJuego contenedorJuego;
    private RepresentacionPersonaje representacionPersonaje;
    private Personaje personaje;

    public BotonSeleccionTransformarEventHandler(ContenedorJuego _contenedorJuego, RepresentacionPersonaje _reprpersonaje, Personaje personaje_a_convertir){
        this.contenedorJuego = _contenedorJuego;
        this.representacionPersonaje = _reprpersonaje;
        this.personaje = personaje_a_convertir;
    }
    
    @Override
    public void handle(ActionEvent event){
        super.handle(event);
        this.contenedorJuego.setRight(null);
        this.contenedorJuego.setRight(new ContenedorTransformaciones(this.representacionPersonaje,  this.personaje));
    }
}
