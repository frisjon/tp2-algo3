package controlador.handlers;

import javafx.event.ActionEvent;
import modelo.juego.ErrorPersonajeMuerto;
import modelo.pelea.ErrorNoHayKi;
import modelo.pelea.ErrorNoSePuedeRealizarAtaqueEspecial;
import modelo.personajes.ErrorPersonajeInutilizado;
import modelo.personajes.Personaje;
import modelo.tablero.ErrorAtaqueInvalido;
import vista.RepresentacionPersonaje;
import vista.Reproductor;
import vista.contenedores.ContenedorJuego;
//TOMO SUPUESTO QIUE LUEGO DE REALIZAR LA ULTIMA ACCION DEL TURNO NO SE PUEDE TRASNFORMAR UN PJ YA QUE DIRECTAMENTE PASA AL OTRO EQUIPO
public class BotonAtaqueEventHandler extends BotonHandler {
	private Personaje atacante;
	private Personaje defensor;
	String tipoDeAtaque;
	ContenedorJuego contenedorjuego;
	RepresentacionPersonaje representacionDefensor;

	public BotonAtaqueEventHandler(ContenedorJuego contenedorJuego, RepresentacionPersonaje repr_defensor, Personaje pj_atacante, Personaje pj_defensor, String ataque) {
		// TODO Auto-generated constructor stub
		this.atacante = pj_atacante;
		this.defensor = pj_defensor;
		this.tipoDeAtaque = ataque;
		this.contenedorjuego = contenedorJuego;
		this.representacionDefensor = repr_defensor;
	}
	
	@Override
    public void handle(ActionEvent event) {
		super.handle(event);
		boolean murioContrincante;
		try {
			if(this.tipoDeAtaque == "Ataque Basico") {
				murioContrincante = this.contenedorjuego.getOrganizadorJuego().ataque(this.atacante, this.defensor);
				Reproductor.golpe();
				this.contenedorjuego.mostrarConsola(this.atacante.getNombre() + " efectuo Ataque Simple sobre " + this.defensor.getNombre());
			}else {
				murioContrincante = this.contenedorjuego.getOrganizadorJuego().ataqueEspecial(this.atacante, this.defensor);
				Reproductor.golpeEspecial();
				this.contenedorjuego.resetearPanelEstadisitcas();
				this.contenedorjuego.mostrarConsola(this.atacante.getNombre() + " efectuo "+ this.atacante.getAtaqueEspecial()+ " sobre " + this.defensor.getNombre());
			}
			if(murioContrincante) {
			    Reproductor.muerte();
				this.contenedorjuego.mostrarConsola(this.defensor.getNombre() + " ha sido eliminado.");
				this.contenedorjuego.eliminarPersonajeDelJuego(this.representacionDefensor);
			}
			this.contenedorjuego.desactivarBotonAtaque();
			this.contenedorjuego.setRight(null);
		} catch (ErrorPersonajeInutilizado e1) {
		    this.contenedorjuego.mostrarConsola("El ataque no se pudo realizar porque tu personaje esta inutilizado.");
		    Reproductor.buzz();
		} catch (ErrorNoHayKi e2){
			this.contenedorjuego.mostrarConsola("El ataque no se pudo realizar debido a la falta de Ki.");
            Reproductor.buzz();
		} catch (ErrorNoSePuedeRealizarAtaqueEspecial e3) {
			this.contenedorjuego.mostrarConsola("El ataque no se pudo efectuar.");
            Reproductor.buzz();
		} catch (ErrorAtaqueInvalido e4) {
			this.contenedorjuego.mostrarConsola("El ataque no se pudo ejecutar debido a la distancia del personaje atacado.");
            Reproductor.buzz();
		} catch (ErrorPersonajeMuerto e5) {
			this.contenedorjuego.mostrarConsola("El ataque no se pudo ejecutar debido a que el personaje atacado esta muerto." );
            Reproductor.buzz();
		}
	}
}
