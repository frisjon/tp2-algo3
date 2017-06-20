package controlador.handlers;

import javafx.event.ActionEvent;
import modelo.pelea.ErrorNoHayKi;
import modelo.pelea.ErrorNoSePuedeRealizarAtaqueEspecial;
import modelo.pelea.Pelea;
import modelo.personajes.Personaje;
import modelo.tablero.ErrorMovimientoInvalido;
import vista.contenedores.ContenedorJuego;

public class BotonAtaqueEventHandler extends BotonHandler {
	private Personaje atacante;
	private Personaje defensor;
	String tipoDeAtaque;
	ContenedorJuego contenedorjuego;

	public BotonAtaqueEventHandler(ContenedorJuego contenedorJuego, Personaje pj_atacante, Personaje pj_defensor, String ataque) {
		// TODO Auto-generated constructor stub
		this.atacante = pj_atacante;
		this.defensor = pj_defensor;
		this.tipoDeAtaque = ataque;
		this.contenedorjuego = contenedorJuego;
	}
	
	@Override
    public void handle(ActionEvent event) {
		super.handle(event);
		try {
			if(this.tipoDeAtaque == "Ataque Basico") Pelea.ataqueBasico(this.atacante, this.defensor);
			else Pelea.ataqueEspecial(this.atacante, this.defensor);
		} catch (ErrorNoHayKi e1){
			this.contenedorjuego.mostrarConsola("El ataque no se pudo realizar debido a la falta de Ki");
		} catch (ErrorNoSePuedeRealizarAtaqueEspecial e2) {
			this.contenedorjuego.mostrarConsola("El ataque no se pudo efectuar.");
		} catch (ErrorMovimientoInvalido e3) {
			this.contenedorjuego.mostrarConsola("El ataque no se pudo ejecutar debido a la distancia del pj atacado");
		}
	}
}
