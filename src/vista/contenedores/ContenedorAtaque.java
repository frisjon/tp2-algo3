package vista.contenedores;

import java.io.IOException;
import java.util.List;

import controlador.handlers.BotonAtaqueEventHandler;
import controlador.handlers.BotonReglasEventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import modelo.personajes.Personaje;
import vista.RepresentacionJugador;
import vista.RepresentacionPersonaje;

public class ContenedorAtaque extends VBox {
	private Personaje pj1contrincante;
	private Personaje pj2contrincante;
	private Personaje pj3contrincante;
	private RepresentacionJugador representacionJugadorEsperando;
	private List<RepresentacionPersonaje> personajesDeJugadorEsperando;
	public static final String ATAQUE_BASICO = "Ataque Basico";
	public static final String ATAQUE_ESPECIAL = "Ataque Especial";
	
	public ContenedorAtaque(RepresentacionJugador representacionJugadorEsperando, Personaje personajeAtacante) {
		super();
		this.setPadding(new Insets(0, 50,0,50));
		this.setSpacing(15);
	    this.setAlignment(Pos.CENTER);
	    this.representacionJugadorEsperando = representacionJugadorEsperando;
	    this.personajesDeJugadorEsperando = representacionJugadorEsperando.getRepresentacionesDePersonajes();
	    this.pj1contrincante = personajesDeJugadorEsperando.get(0).getPersonaje();
        this.pj2contrincante = personajesDeJugadorEsperando.get(1).getPersonaje();
        this.pj3contrincante = personajesDeJugadorEsperando.get(2).getPersonaje();
        
        Button botonAtacarBasicoContrincante1 = new Button();
        botonAtacarBasicoContrincante1.setText("Ataque simple a "+ pj1contrincante.getNombre());
        botonAtacarBasicoContrincante1.setTextFill(Color.GRAY);
        botonAtacarBasicoContrincante1.setFont(Font.font("Cooper Black", FontWeight.NORMAL,15));
        botonAtacarBasicoContrincante1.setStyle("-fx-base: #b6e7c9;; -fx-border-color: rgb(249,219,189)");
        botonAtacarBasicoContrincante1.setMinSize(100.0, 50.0);
        
        BotonAtaqueEventHandler botonAtacarBasicoContrincante1Handler = new BotonAtaqueEventHandler(personajeAtacante, this.pj1contrincante, ATAQUE_BASICO);
        botonAtacarBasicoContrincante1.setOnAction(botonAtacarBasicoContrincante1Handler);
        
        Button botonAtacarEspecialContrincante1 = new Button();
        botonAtacarEspecialContrincante1.setText(personajeAtacante.getAtaqueEspecial()+" a "+ pj1contrincante.getNombre());
        botonAtacarEspecialContrincante1.setTextFill(Color.GRAY);
        botonAtacarEspecialContrincante1.setFont(Font.font("Cooper Black", FontWeight.NORMAL,15));
        botonAtacarEspecialContrincante1.setStyle("-fx-base: #b6e7c9;; -fx-border-color: rgb(249,219,189)");
        botonAtacarEspecialContrincante1.setMinSize(100.0, 50.0);
        
        BotonAtaqueEventHandler botonAtacarEspecialContrincante1Handler = new BotonAtaqueEventHandler(personajeAtacante, this.pj1contrincante, ATAQUE_ESPECIAL);
        botonAtacarEspecialContrincante1.setOnAction(botonAtacarEspecialContrincante1Handler);
		
        Button botonAtacarBasicoContrincante2 = new Button();
        botonAtacarBasicoContrincante2.setText("Ataque simple a "+ pj2contrincante.getNombre());
        botonAtacarBasicoContrincante2.setTextFill(Color.GRAY);
        botonAtacarBasicoContrincante2.setFont(Font.font("Cooper Black", FontWeight.NORMAL,15));
        botonAtacarBasicoContrincante2.setStyle("-fx-base: #b6e7c9;; -fx-border-color: rgb(249,219,189)");
        botonAtacarBasicoContrincante2.setMinSize(100.0, 50.0);
        
        BotonAtaqueEventHandler botonAtacarBasicoContrincante2Handler = new BotonAtaqueEventHandler(personajeAtacante, this.pj2contrincante, ATAQUE_BASICO);
        botonAtacarBasicoContrincante2.setOnAction(botonAtacarBasicoContrincante2Handler);
        
        Button botonAtacarEspecialContrincante2 = new Button();
        botonAtacarEspecialContrincante2.setText(personajeAtacante.getAtaqueEspecial()+" a "+ pj2contrincante.getNombre());
        botonAtacarEspecialContrincante2.setTextFill(Color.GRAY);
        botonAtacarEspecialContrincante2.setFont(Font.font("Cooper Black", FontWeight.NORMAL,15));
        botonAtacarEspecialContrincante2.setStyle("-fx-base: #b6e7c9;; -fx-border-color: rgb(249,219,189)");
        botonAtacarEspecialContrincante2.setMinSize(100.0, 50.0);
        
        BotonAtaqueEventHandler botonAtacarEspecialContrincante2Handler = new BotonAtaqueEventHandler(personajeAtacante, this.pj2contrincante, ATAQUE_ESPECIAL);
        botonAtacarEspecialContrincante2.setOnAction(botonAtacarEspecialContrincante2Handler);
        
        Button botonAtacarBasicoContrincante3 = new Button();
        botonAtacarBasicoContrincante3.setText("Ataque simple a "+ pj3contrincante.getNombre());
        botonAtacarBasicoContrincante3.setTextFill(Color.GRAY);
        botonAtacarBasicoContrincante3.setFont(Font.font("Cooper Black", FontWeight.NORMAL,15));
        botonAtacarBasicoContrincante3.setStyle("-fx-base: #b6e7c9;; -fx-border-color: rgb(249,219,189)");
        botonAtacarBasicoContrincante3.setMinSize(100.0, 50.0);
        
        BotonAtaqueEventHandler botonAtacarBasicoContrincante3Handler = new BotonAtaqueEventHandler(personajeAtacante, this.pj3contrincante, ATAQUE_BASICO);
        botonAtacarBasicoContrincante3.setOnAction(botonAtacarBasicoContrincante3Handler);
        
        Button  botonAtacarEspecialContrincante3 = new Button();
        botonAtacarEspecialContrincante3.setText(personajeAtacante.getAtaqueEspecial()+" a "+ pj3contrincante.getNombre());
        botonAtacarEspecialContrincante3.setTextFill(Color.GRAY);
        botonAtacarEspecialContrincante3.setFont(Font.font("Cooper Black", FontWeight.NORMAL,15));
        botonAtacarEspecialContrincante3.setStyle("-fx-base: #b6e7c9;; -fx-border-color: rgb(249,219,189)");
        botonAtacarEspecialContrincante3.setMinSize(100.0, 50.0);
        
        BotonAtaqueEventHandler botonAtacarEspecialContrincante3Handler = new BotonAtaqueEventHandler(personajeAtacante, this.pj3contrincante, ATAQUE_ESPECIAL);
        botonAtacarEspecialContrincante3.setOnAction(botonAtacarEspecialContrincante3Handler);
        
        Button botonVolver = new Button();
        botonVolver.setText("Volver a seleccion de personaje");
        botonVolver.setTextFill(Color.GRAY);
        botonVolver.setFont(Font.font("Cooper Black", FontWeight.NORMAL,15));
        botonVolver.setStyle("-fx-base: #b6e7c9;; -fx-border-color: rgb(249,219,189)");
        botonVolver.setMinSize(100.0, 50.0);
        
        this.getChildren().addAll(botonAtacarBasicoContrincante1,botonAtacarEspecialContrincante1, botonAtacarBasicoContrincante2, botonAtacarEspecialContrincante2, botonAtacarBasicoContrincante3,botonAtacarEspecialContrincante3, botonVolver);
        this.setAlignment(Pos.CENTER);
	}
}
	