package controlador.handlers;

import javafx.event.ActionEvent;
import modelo.pelea.ErrorNoHayKi;
import modelo.pelea.ErrorNoSePuedeRealizarAtaqueEspecial;
import modelo.personajes.Personaje;
import modelo.tablero.ErrorAtaqueInvalido;
import modelo.tablero.ErrorMovimientoInvalido;
import vista.RepresentacionPersonaje;
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
				this.contenedorjuego.mostrarConsola(this.atacante.getNombre() + " efectuo Ataque Simple sobre " + this.defensor.getNombre());
			}else {
				murioContrincante = this.contenedorjuego.getOrganizadorJuego().ataque(this.atacante, this.defensor);
				this.contenedorjuego.mostrarConsola(this.atacante.getNombre() + " efectuo "+ this.atacante.getAtaqueEspecial()+ " sobre " + this.defensor.getNombre());
			}
			if(murioContrincante) {
				this.contenedorjuego.mostrarConsola(this.defensor + " ha sido eliminado.");
				this.contenedorjuego.eliminarPersonajeDelJuego(this.representacionDefensor);
			}
			this.contenedorjuego.decrementarAccionDeTurno();
		        
		    if (0 == this.contenedorjuego.getCantidadAccionesRestantesDelTurno()) {
		    	//fin del turno (se realizaron todas las acciones posibles), pasa a jugar del otro equipo
		    	this.contenedorjuego.siguienteTurno();
		    }	
		} catch (ErrorNoHayKi e1){
			this.contenedorjuego.mostrarConsola("El ataque no se pudo realizar debido a la falta de Ki");
		} catch (ErrorNoSePuedeRealizarAtaqueEspecial e2) {
			this.contenedorjuego.mostrarConsola("El ataque no se pudo efectuar.");
		} catch (ErrorAtaqueInvalido e3) {
			this.contenedorjuego.mostrarConsola("El ataque no se pudo ejecutar debido a la distancia del personaje atacado");
		} 
	}
}
