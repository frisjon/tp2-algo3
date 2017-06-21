package controlador.handlers;

import javafx.event.ActionEvent;
import modelo.personajes.ErrorNoPuedeCambiarEstado;
import modelo.personajes.Personaje;
import vista.RepresentacionPersonaje;
import vista.contenedores.ContenedorJuego;

public class BotonTransformacionEventHandler extends BotonHandler {
	
	private Personaje personaje;
	private RepresentacionPersonaje representacionPersonaje;
	private String transformacion;
	private ContenedorJuego contenedorjuego;
	
	public BotonTransformacionEventHandler(ContenedorJuego contenedorJuego, RepresentacionPersonaje representacion_pj, Personaje personaje_a_transformar, String tipoDeTransformacion) {
		this.personaje = personaje_a_transformar;
		this.representacionPersonaje = representacion_pj;
		this.transformacion = tipoDeTransformacion;
		this.contenedorjuego = contenedorJuego;
	}
	@Override
    public void handle(ActionEvent event) {
		super.handle(event);
		if(this.transformacion == "Transformacion 1") {
			try{
				this.personaje.cambiarAEstado2();
				this.representacionPersonaje.cambiarAEstado2();
				this.contenedorjuego.mostrarConsola(this.personaje.getNombre() + "ha realizado la transformacion a " + personaje.getNombrePrimeraTransformacion());
			} catch (ErrorNoPuedeCambiarEstado e1) {
				this.contenedorjuego.mostrarConsola(this.personaje.getNombre()+ " no puede realizar la tranformacion a " + personaje.getNombrePrimeraTransformacion());
			}
		} else {
			try{
				this.personaje.cambiarAEstado3();
				this.representacionPersonaje.cambiarAEstado3();
				this.contenedorjuego.mostrarConsola(this.personaje.getNombre() + "ha realizado la transformacion a " + personaje.getNombreSegundaTransformacion());
			} catch (ErrorNoPuedeCambiarEstado e2) {
				this.contenedorjuego.mostrarConsola(this.personaje.getNombre()+ " no puede realizar la tranformacion a " + personaje.getNombreSegundaTransformacion());
			}
		}
	}
}
