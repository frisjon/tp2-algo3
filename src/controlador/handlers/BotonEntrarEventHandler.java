package controlador.handlers;

import javafx.event.ActionEvent;
import javafx.scene.media.AudioClip;
import javafx.stage.Stage;
import modelo.equipo.Equipo;
import modelo.equipo.PosibleEquipo;
import modelo.juego.Juego;
import modelo.jugador.Jugador;
import vista.contenedores.Escena;
import vista.contenedores.ContenedorNombrarJugadores;
import vista.contenedores.ContenedorPelea;

public class BotonEntrarEventHandler extends BotonHandler {

    //private final AudioClip musicaDeFondo;
    private Stage stage;
    private ContenedorNombrarJugadores contenedorNombres;

    public BotonEntrarEventHandler(Stage stage) {
        this.stage = stage;
        this.contenedorNombres = new ContenedorNombrarJugadores();
        //this.musicaDeFondo = musicaDeFondo;
        
    }

    @Override
    public void handle(ActionEvent event) {
    	super.handle(event);
    	
    	if (!contenedorNombres.jugadoresFueronIngresados()) {
    		contenedorNombres.mostrar();
        }
    	
    	if (contenedorNombres.jugadoresFueronIngresados()) { //esto evita que se empiece la eleccion si no se puso aceptar
            String nombreJugador1 = contenedorNombres.getNombreJugador1();
            String nombreJugador2 = contenedorNombres.getNombreJugador2();
            
            Equipo guerreros = new Equipo(PosibleEquipo.guerreros);
        	Equipo enemigos = new Equipo(PosibleEquipo.enemigos);   	
        	
    		Jugador jugadorGuerreros = new Jugador(nombreJugador1, guerreros);
    		Jugador jugadorEnemigos = new Jugador(nombreJugador2, enemigos);
    		
    		Juego juego = new Juego();
            juego.agregarJugador(jugadorGuerreros);
            juego.agregarJugador(jugadorEnemigos);
            
            // ver de referencia ContenedorPelea que sería el sinónimo de ese tp a la parte jugable
            // para más parecido a lo nuestro ver el tp transformers, aunque el código es peor
            ContenedorJuego contenedorJuego = new ContenedorJuego(stage, nombreJugador1, nombreJugador2);
            Escena escenaEleccion = new Escena(contenedorJuego, stage);
            contenedorJuego.inicializarJuego(juego);
            // ahora hay que crear un contenedorJuego y ahí meter el tablero y todas las demás boludeces
            // después de eso hay que unirlo con OrganizadorJuego para que se pueda empezar a "jugar"

            stage.setFullScreenExitHint("");
            boolean enPantallaCompletaAntesDeCambiarEscena = stage.isFullScreen();
            stage.hide();
            stage.setScene(escenaEleccion);
            stage.setFullScreen(enPantallaCompletaAntesDeCambiarEscena);
            stage.show();
        }
    }




}
