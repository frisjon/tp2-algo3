package controlador.handlers;

import javafx.event.ActionEvent;
import vista.contenedores.ContenedorJuego;

public class BotonPasarTurnoEventHandler extends BotonHandler{
    private ContenedorJuego contenedorJuego;

    public BotonPasarTurnoEventHandler(ContenedorJuego _contenedorJuego){
        this.contenedorJuego = _contenedorJuego;
    }
    
    @Override
    public void handle(ActionEvent event){
        super.handle(event);
        this.contenedorJuego.setRight(null);
        this.contenedorJuego.siguienteTurno();
    }
}
