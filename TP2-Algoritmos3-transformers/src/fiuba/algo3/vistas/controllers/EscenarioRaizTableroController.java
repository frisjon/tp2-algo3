package fiuba.algo3.vistas.controllers;

import java.util.HashMap;

import fiuba.algo3.MainApp;
import fiuba.algo3.modelo.bonus.Bonus;
import fiuba.algo3.modelo.bonus.TipoBonus;
import fiuba.algo3.modelo.jugabilidad.Jugador;
import fiuba.algo3.modelo.personajes.Personaje;
import fiuba.algo3.modelo.superficies.*;
import fiuba.algo3.modelo.tablero.Casillero;
import fiuba.algo3.modelo.tablero.Posicion;
import fiuba.algo3.modelo.tablero.Tablero;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.Glow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class EscenarioRaizTableroController {
	
	@FXML
	private GridPane tablero;
	@FXML
	private ImageView optimus;
	@FXML
	private ImageView bumblebee;
	@FXML
	private ImageView ratchet;
	@FXML
	private ImageView megatron;
	@FXML
	private ImageView bonecrusher;
	@FXML
	private ImageView frenzy;
	
	private MainApp mainApp;
	private HashMap<Posicion,Circle> mapaDeBonus;
	private int dimensionEnAlto;
	private int dimensionEnLargo;
	
	private Image imagenChispa = new Image("fiuba/algo3/vistas/imagenes/ImagenChispa.png",74,65,false,true);
	private Image imagenRocosaNube = new Image("fiuba/algo3/vistas/imagenes/ImagenRocosa.jpg",74,65,false,true);
	private Image imagenRocosaNebulosa = new Image("fiuba/algo3/vistas/imagenes/ImagenRocosaNebulosa.png",74,65,false,true);
	private Image imagenRocosaTormenta = new Image("fiuba/algo3/vistas/imagenes/ImagenRocosaTormenta.png",74,65,false,true);
	private Image imagenPantanoNube = new Image("fiuba/algo3/vistas/imagenes/ImagenPantano.jpg",74,65,false,true);
	private Image imagenPantanoNebulosa = new Image("fiuba/algo3/vistas/imagenes/ImagenPantanoNebulosa.png",74,65,false,true);
	private Image imagenPantanoTormenta = new Image("fiuba/algo3/vistas/imagenes/ImagenPantanoTormenta.png",74,65,false,true);
	private Image imagenEspinasNube = new Image("fiuba/algo3/vistas/imagenes/ImagenEspinas.jpg",74,65,false,true);
	private Image imagenEspinasNebulosa = new Image("fiuba/algo3/vistas/imagenes/ImagenEspinasNebulosa.png",74,65,false,true);
	private Image imagenEspinasTormenta = new Image("fiuba/algo3/vistas/imagenes/ImagenEspinasTormenta.png",74,65,false,true);
	
	public EscenarioRaizTableroController(){

	}
	
	@FXML
	private void initialize(){
		
		this.mapaDeBonus = new HashMap<Posicion,Circle>();
		
		this.crearBordesDeColores(this.optimus, Color.RED);
		this.crearBordesDeColores(this.bumblebee, Color.RED);
		this.crearBordesDeColores(this.ratchet, Color.RED);
		this.crearBordesDeColores(this.megatron, Color.DARKVIOLET);
		this.crearBordesDeColores(this.bonecrusher, Color.DARKVIOLET);
		this.crearBordesDeColores(this.frenzy, Color.DARKVIOLET);
		
	}
	
	public void actualizarPosicionesIndividualmente(Personaje personaje, ImageView autobotVisual){
		autobotVisual.setOpacity(1.00);
		if (personaje.estaInmovilizado()){
			autobotVisual.setOpacity(0.40);
		}else if(!personaje.estaVivo()){
			autobotVisual.setOpacity(0.00);
		} 
		
		if (personaje.esUnidadAerea()){
			this.personajeAereo(autobotVisual);
		}else if (personaje.esUnico()){
			DropShadow efecto = (DropShadow) autobotVisual.getEffect();
			efecto.setInput(new Glow(1.00));
		}else{
			DropShadow efecto = (DropShadow) autobotVisual.getEffect();
			efecto.setInput(null);
		}
		
		Posicion posicion = personaje.getPosicion();
		this.tablero.getChildren().remove(autobotVisual);
		this.tablero.add(autobotVisual, posicion.getCoordenadaY(), posicion.getCoordenadaX());
	}
	
	public void actualizarPosicionesGenerales(){
		Jugador jugador1 = this.mainApp.getPartida().getPlayer1();
		Jugador jugador2 = this.mainApp.getPartida().getPlayer2();
		
		if (jugador1.getPersonajeModoUnico() == null){
			this.actualizarPosicionesIndividualmente(jugador1.getPersonaje1(), this.optimus);
			this.actualizarPosicionesIndividualmente(jugador1.getPersonaje2(), this.bumblebee);
			this.actualizarPosicionesIndividualmente(jugador1.getPersonaje3(), this.ratchet);
		}else{
			this.actualizarPosicionesIndividualmente(jugador1.getPersonajeModoUnico(), this.optimus);
		}
		
		if (jugador2.getPersonajeModoUnico() == null){
			this.actualizarPosicionesIndividualmente(jugador2.getPersonaje1(), this.megatron);
			this.actualizarPosicionesIndividualmente(jugador2.getPersonaje2(), this.bonecrusher);
			this.actualizarPosicionesIndividualmente(jugador2.getPersonaje3(), this.frenzy);
		}else{
			this.actualizarPosicionesIndividualmente(jugador2.getPersonajeModoUnico(), this.megatron);
		}
		
	}
	
	public void actualizarCampos(){
		
		SuperficieRocosa rocosa = new SuperficieRocosa();
		SuperficiePantano pantano = new SuperficiePantano();
		SuperficieEspinas espinas = new SuperficieEspinas();
		
		SuperficieNube nube = new SuperficieNube();
		SuperficieNebulosaDeAndromeda nebulosa = new SuperficieNebulosaDeAndromeda();
		SuperficieTormentaPsionica tormenta = new SuperficieTormentaPsionica();
		
		SuperficieDeCampo campoNubeRoca = new SuperficieDeCampo(nube,rocosa);
		SuperficieDeCampo campoNubePantano = new SuperficieDeCampo(nube,pantano);
		SuperficieDeCampo campoNubeEspinas = new SuperficieDeCampo(nube,espinas);
		
		SuperficieDeCampo campoNebulosaRoca = new SuperficieDeCampo(nebulosa,rocosa);
		SuperficieDeCampo campoNebulosaPantano = new SuperficieDeCampo(nebulosa,pantano);
		SuperficieDeCampo campoNebulosaEspinas = new SuperficieDeCampo(nebulosa,espinas);
		
		SuperficieDeCampo campoTormentaRoca = new SuperficieDeCampo(tormenta,rocosa);
		SuperficieDeCampo campoTormentaPantano = new SuperficieDeCampo(tormenta,pantano);
		SuperficieDeCampo campoTormentaEspinas = new SuperficieDeCampo(tormenta,espinas);
		
		
		for (int i= 0; i <= this.dimensionEnAlto; i++){
			for (int j=0; j <= this.dimensionEnLargo; j++){
				
				ImageView imagen = new ImageView();
				Posicion posicionActual = new Posicion(j,i);
				Tablero tablero = this.mainApp.getPartida().getTablero();
				Casillero casillero = tablero.obtenerCasillero(posicionActual);
				
				if (casillero.getChispaSuprema() != null){
					imagen.setImage(this.imagenChispa);
				}else if (casillero.getSuperficies().equals(campoNubeRoca)){
					imagen.setImage(this.imagenRocosaNube);
				}else if (casillero.getSuperficies().equals(campoNubePantano)){
					imagen.setImage(this.imagenPantanoNube);
				}else if (casillero.getSuperficies().equals(campoNubeEspinas)){
					imagen.setImage(this.imagenEspinasNube);
				}else if (casillero.getSuperficies().equals(campoNebulosaRoca)){
					imagen.setImage(this.imagenRocosaNebulosa);
				}else if (casillero.getSuperficies().equals(campoNebulosaPantano)){
					imagen.setImage(this.imagenPantanoNebulosa);
				}else if (casillero.getSuperficies().equals(campoNebulosaEspinas)){
					imagen.setImage(this.imagenEspinasNebulosa);
				}else if (casillero.getSuperficies().equals(campoTormentaRoca)){
					imagen.setImage(this.imagenRocosaTormenta);
				}else if (casillero.getSuperficies().equals(campoTormentaPantano)){
					imagen.setImage(this.imagenPantanoTormenta);
				}else if (casillero.getSuperficies().equals(campoTormentaEspinas)){
					imagen.setImage(this.imagenEspinasTormenta);
				}
				this.tablero.add(imagen, i, j);
				
				if (casillero.getBonus() != null){
					Bonus bonus = casillero.getBonus();
					Circle circleBonus = new Circle();
					this.mapaDeBonus.put(posicionActual, circleBonus);
					
					this.tablero.add(circleBonus, i, j);
					
					if (bonus.getType() == TipoBonus.DobleCanion){
						circleBonus.setFill(Color.GOLD);
					}else if (bonus.getType() == TipoBonus.Flash){
						circleBonus.setFill(Color.RED);
					}else if (bonus.getType() == TipoBonus.BurbujaInmaculada){
						circleBonus.setFill(Color.BLUE);
					}
					
					circleBonus.setStroke(Color.BLACK);
					circleBonus.setRadius(25);
					circleBonus.setOpacity(0.80);
					circleBonus.setTranslateX(10);
				}
			}
		}
	}
	
	public void consumirBonus(Posicion posicionBonus){
		if (this.mapaDeBonus.containsKey(posicionBonus)){
			Circle bonus = this.mapaDeBonus.get(posicionBonus);
			bonus.setOpacity(0.00);
		}
	}
	
	public void personajeAereo(ImageView imagenPersonaje){
		DropShadow shadow = new DropShadow();
		shadow.setColor(Color.BLACK);
		shadow.setOffsetX(8f);
		shadow.setOffsetY(8f);
		
		DropShadow efecto = (DropShadow) imagenPersonaje.getEffect();
		efecto.setInput(shadow);
	}
	
	public void crearBordesDeColores(ImageView imagenPersonaje, Color color){

		int depth = 50;
		DropShadow borderGlow= new DropShadow();
		borderGlow.setOffsetY(1f);
		borderGlow.setOffsetX(1f);
		borderGlow.setWidth(depth);
		borderGlow.setHeight(depth);
		borderGlow.setColor(color);
		
		imagenPersonaje.setEffect(borderGlow);
		
	}
	
	public void fusionarPersonajes(Jugador jugadorActual){
		Jugador jugadorAutobots = this.mainApp.getPartida().getPlayer1();
		if(jugadorActual == jugadorAutobots){
			this.bumblebee.setOpacity(0.00);
			this.ratchet.setOpacity(0.00);
		}else{
			this.bonecrusher.setOpacity(0.00);
			this.frenzy.setOpacity(0.00);
		}
	}
	
	public void clickBotonClose(){
		Alert confirmacionCerrar = new Alert(AlertType.CONFIRMATION, "Esta seguro que desea salir?", ButtonType.YES, ButtonType.NO);
		confirmacionCerrar.setTitle("Salida del programa");
		confirmacionCerrar.showAndWait();
		if (confirmacionCerrar.getResult() == ButtonType.YES) {
		   this.mainApp.cerrarAplicacion();
		}else{
			confirmacionCerrar.close();
		}
	}
	
	public void clickBotonAbout(){
		String informacion = "Juego De Algoformers\nTP2 de Algoritmos y Programacion III\n";
		String integrantes = "\nIntegrantes:\nAparicio, Axel\nCampanella, Martin\nRossi, Ignacio\nSosa, Leandro";
		Alert about = new Alert(AlertType.INFORMATION,informacion+integrantes, ButtonType.OK);
		about.setTitle("Informacion");
		about.setHeaderText("Informacion");
		about.showAndWait();
		if (about.getResult() == ButtonType.OK){
			about.close();
		}
	}
	
	public void setDimensiones(int alto, int largo){
		this.dimensionEnAlto = alto;
		this.dimensionEnLargo = largo;
	}
	
	public void setMainApp(MainApp mainApp){
		this.mainApp = mainApp;
		this.actualizarCampos();
	}
	
}
