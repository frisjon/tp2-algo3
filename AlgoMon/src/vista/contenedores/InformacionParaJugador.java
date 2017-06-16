package vista.contenedores;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.TextAlignment;
import modelo.Jugador;

import java.util.ArrayList;
import java.util.List;

public class InformacionParaJugador extends VBox {
	
	private Jugador jugador;
	private Color color;
	
    public InformacionParaJugador(Jugador jugador, Color color) {
    	
    	this.jugador = jugador;
    	this.color = color;
    	this.setPadding(new Insets(0,20,40,20));
    	this.actualizar();
    }

	public Jugador getJugador() {
		return jugador;
	}

	public void setJugador(Jugador jugador) {
		this.jugador = jugador;
	}
	
	public void actualizar(){
		
		this.getChildren().clear();
		
		List<Label> lista = new ArrayList<Label>();
		
		Label nombreDelJugador = new Label(this.jugador.getNombre() + "\n" );
        nombreDelJugador.setAlignment(Pos.CENTER);
        nombreDelJugador.setTextAlignment(TextAlignment.CENTER);
        nombreDelJugador.setFont(Font.font("Cambria", FontWeight.BOLD, 40));
        nombreDelJugador.setTextFill(color);
        
        lista.add(nombreDelJugador);    	
    	this.getChildren().addAll(lista);   
	}
}
