package controlador.handlers;

import javafx.event.ActionEvent;
import modelo.personajes.Personaje;
import vista.RepresentacionPersonaje;

public class BotonTransformacionEventHandler extends BotonHandler {
	
	private Personaje personaje;
	private RepresentacionPersonaje representacionPersonaje;
	private String transformacion;
	
	public BotonTransformacionEventHandler(RepresentacionPersonaje representacion_pj, Personaje personaje_a_transformar, String tipoDeTransformacion) {
		this.personaje = personaje_a_transformar;
		this.representacionPersonaje = representacion_pj;
		this.transformacion = tipoDeTransformacion;
	}
	//falta atrapar excepciones, en caso de q no se pueda no hay q cambiar imagen
	@Override
    public void handle(ActionEvent event) {
		super.handle(event);
		if(this.transformacion == "Transformacion 1") {
			this.personaje.cambiarAEstado2();
			this.representacionPersonaje.cambiarAEstado2();
		} else {
			this.personaje.cambiarAEstado3();
			this.representacionPersonaje.cambiarAEstado3();
		}
	}
}
