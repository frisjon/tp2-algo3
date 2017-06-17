package controlador.handlers;

import javafx.event.ActionEvent;
import javafx.scene.media.AudioClip;
import javafx.stage.Stage;
import modelo.equipo.Equipo;
import modelo.equipo.PosibleEquipo;
import modelo.juego.Juego;
import modelo.jugador.Jugador;
import vista.contenedores.Escena;
import vista.contenedores.ContenedorJuego;
import vista.contenedores.ContenedorNombrarJugadores;

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
        	
        	//se asignan personajes a los equipos
        	guerreros.asignarEquipoGuerreros();
        	enemigos.asignarEquipoEnemigos();
        	
    		Jugador jugadorGuerreros = new Jugador(nombreJugador1, guerreros);
    		Jugador jugadorEnemigos = new Jugador(nombreJugador2, enemigos);
    		
    		Juego juego = new Juego();
            juego.agregarJugador(jugadorGuerreros);
            juego.agregarJugador(jugadorEnemigos);
            
            //Se crea un contenedorJuego con jugadores (no los nombres)
            ContenedorJuego contenedorJuego = new ContenedorJuego(stage, jugadorGuerreros, jugadorEnemigos);
            Escena escenaEleccion = new Escena(contenedorJuego, stage);
            contenedorJuego.inicializarJuego(juego);

            stage.setFullScreenExitHint("");
            boolean enPantallaCompletaAntesDeCambiarEscena = stage.isFullScreen();
            stage.hide();
            stage.setScene(escenaEleccion);
            stage.setFullScreen(enPantallaCompletaAntesDeCambiarEscena);
            stage.show();
        }
    }




}
