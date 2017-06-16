package vista;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.TextAlignment;
import modelo.Jugador;

public class DisplayAlgoMon extends VBox {

	private final ImageView imagenAlgomon;
	private RepresentacionAlgoMon representacion;
	private Label estados;
	private Label vidaActual;
	private BarraDeVida barraDeVida;
	private Jugador jugador;
	private static boolean primerJugador=true;

	public DisplayAlgoMon(Jugador jugador){
		FabricaDeRepresentaciones fabrica = new FabricaDeRepresentaciones();
		this.representacion = fabrica.crearRepresentacion(jugador.getAlgomonActivo());
		this.setJugador(jugador);

		Label nombreDelAlgomon = new Label(representacion.getNombre());
		nombreDelAlgomon.setAlignment(Pos.CENTER);
		nombreDelAlgomon.setTextAlignment(TextAlignment.CENTER);
		nombreDelAlgomon.setFont(Font.font("Cambria", FontWeight.BOLD, 25));
		nombreDelAlgomon.setTextFill(Color.WHITE);

		this.barraDeVida = new BarraDeVida(representacion.getAlgomon());

		this.vidaActual = representarVidaActual(representacion);

		this.estados = representarEstadosActuales();
		estados.setPadding(new Insets(0,0,40,0));

		this.imagenAlgomon = new ImageView(representacion.getImagen());
		if (primerJugador) girarImagen();
		imagenAlgomon.setFitWidth(250);
		imagenAlgomon.setFitHeight(250);

		this.setAlignment(Pos.CENTER);

		this.setPadding(new Insets(10,10,0,10));
		this.getChildren().addAll(nombreDelAlgomon,this.barraDeVida, vidaActual,this.estados, imagenAlgomon );
	}

	private Label representarVidaActual(RepresentacionAlgoMon representacion) {
		Label vidaActual = new Label(representacion.getAlgomon().getVida() + "/"
				+ representacion.getAlgomon().getVidaOriginal());
		vidaActual.setFont(Font.font("Cambria", FontWeight.BOLD, 18));
		vidaActual.setTextFill(Color.WHITE);
		return vidaActual;
	}

	private Label representarEstadosActuales() {
		String estadosParaVisualizar = "< " + this.representacion.getEstadoEfimero() + " , " +
				this.representacion.getEstadoPersistente() + " >";
		Label estados = new Label(estadosParaVisualizar);
		estados.setAlignment(Pos.CENTER);
		estados.setFont(Font.font("Cambria", FontWeight.BOLD, 18));
		estados.setTextFill(Color.WHITE);
		return estados;
	}

	public void girarImagen() {
		imagenAlgomon.setScaleX(-1);
		primerJugador =false;
	}

	private void actualizarEstados(){
		this.estados = representarEstadosActuales();
		estados.setPadding(new Insets(0,0,40,0));
		this.getChildren().set(3,estados);
	}

	private void actualizarVidaActual(){
		this.vidaActual = representarVidaActual(representacion);
		this.getChildren().set(2,vidaActual);
	}

	public void actualizar(){
		this.barraDeVida.actualizar();
		this.actualizarVidaActual();
		this.actualizarEstados();
	}

	public Jugador getJugador() {
		return jugador;
	}

	public void setJugador(Jugador jugador) {
		this.jugador = jugador;
	}

}
