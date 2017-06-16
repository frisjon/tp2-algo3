package vista.contenedores;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.media.AudioClip;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import modelo.Partida;
import modelo.juego.Juego;
import vista.BarraDeMenu;

public class ContenedorPelea extends BorderPane{
	private AudioClip musicaDeFondo;
	private Stage stage;
	private ContenedorDeAlgomones contenedorDeAlgomones;
	private Juego juego;
	private ZonaJugador zonaJugador1;
	private ZonaJugador zonaJugador2;
	private VistaConsola panelNotificaciones;
	private Consola consola = new Consola();

	public ContenedorPelea(Stage primaryStage) {
		stage = primaryStage;

		Image fondo = new Image("file:src/vista/imagenes/fondosPelea/estadiopoke.jpg");
		BackgroundImage imagenDeFondo =
				new BackgroundImage(fondo, BackgroundRepeat.NO_REPEAT,
						BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER,
						BackgroundSize.DEFAULT);
		setBackground(new Background(imagenDeFondo));
		
		BarraDeMenu menu = new BarraDeMenu(stage);
		this.setTop(menu);
	}

	public void inicializarJuego(Juego juego){
		this.juego = juego;

		AudioClip sonidoInicial = new AudioClip("file:src/vista/sonidos/cambiarPokemon.mp3");
		sonidoInicial.play();
		musicaDeFondo = new AudioClip("file:src/vista/sonidos/pelea2.mp3");
		musicaDeFondo.setCycleCount(5);
		musicaDeFondo.play();


		ContenedorDeAlgomones contenedorDeAlgomones = new ContenedorDeAlgomones(partida.jugadorActual(),partida.jugadorOponente());
		
		this.zonaJugador1 = new ZonaJugador(new Botonera(partida,this,partida.jugadorActual()),
				new InformacionParaJugador(partida.jugadorActual(),Color.DARKRED));
		this.zonaJugador2 = new ZonaJugador(new Botonera(partida,this,partida.jugadorOponente()),
				new InformacionParaJugador(partida.jugadorOponente(),Color.AQUA));

		this.setLeft(zonaJugador1);
		this.setRight(zonaJugador2);

		this.panelNotificaciones = new VistaConsola(consola);
		this.setBottom(panelNotificaciones);
		this.setAlignment(panelNotificaciones,Pos.BOTTOM_CENTER);


		this.contenedorDeAlgomones = contenedorDeAlgomones;
		this.setCenter(contenedorDeAlgomones);
	}

	private void actualizar(){
		contenedorDeAlgomones.actualizar();
		if(this.zonaJugador1.getJugador() == this.partida.jugadorActual()) zonaJugador2.actualizar();
		else zonaJugador1.actualizar();	
	}
	
	public void notificarPanel(String mensaje){
		this.consola.agregarMensaje(mensaje);
	}
	
	public void cambiarAlgomon(){
		contenedorDeAlgomones.cambiarAlgomon(partida.jugadorOponente());
		Botonera botoneraNueva = new Botonera(partida,this,partida.jugadorOponente());
		if(this.zonaJugador1.getJugador() == this.partida.jugadorOponente()) zonaJugador1.setBotonera(botoneraNueva);
		else zonaJugador2.setBotonera(botoneraNueva);
		
	}
	
	public void nuevoTurno(){
		this.actualizar();
		this.zonaJugador2.bloquearBotonera(this.zonaJugador1.getJugador() == this.partida.jugadorActual());
		this.zonaJugador1.bloquearBotonera(!(this.zonaJugador1.getJugador() == this.partida.jugadorActual()));
		if(this.zonaJugadorActual().getJugador().getAlgomonActivo().estaMuerto()) this.manejarCasoAlgoMonActivoMuerto();
	}
	
	private ZonaJugador zonaJugadorActual(){
		if(this.zonaJugador1.getJugador() == this.partida.jugadorActual()) return zonaJugador1;
		return zonaJugador2;
	}
	
	private void manejarCasoAlgoMonActivoMuerto(){
		Alert alert = new Alert(AlertType.INFORMATION);
    	alert.setTitle("Atencion!");
    	alert.setHeaderText("Su AlgoMon ha muerto " + this.zonaJugadorActual().getNombreJugador());
    	alert.setContentText("Escoja el Algomon a utilizar!");
    	alert.showAndWait();
		this.zonaJugadorActual().habilitarSoloCambiarAlgoMon();
	}
	
	public void peleaFinalizada(String ganador) {
		musicaDeFondo.stop();
		ContenedorFinal contenedorFinal = new ContenedorFinal(ganador);
		Scene scene = new Scene(contenedorFinal);
		boolean enPantallaCompletaAntesDeCambiarEscena = stage.isFullScreen();
        stage.hide();
        stage.setScene(scene);
        stage.setFullScreen(enPantallaCompletaAntesDeCambiarEscena);
        stage.show();
	}
}