package vista.contenedores;

import controlador.handlers.BotonOpcionAtacarEventHandler;
import controlador.handlers.BotonOpcionMoverEventHandler;
import controlador.handlers.BotonOpcionTransformarEventHandler;
import controlador.handlers.BotonPasarTurnoEventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class ContenedorOpcionesJuego extends VBox {
    
    private Button botonAtacar;
    private Button botonMover;
    private Button botonTransformar;
    private Button botonPasarTurno;
    
    public ContenedorOpcionesJuego(ContenedorJuego _contenedorJuego) {
        super();

        this.setPadding(new Insets(10, 10,10,10));
        this.setSpacing(15);
        this.setAlignment(Pos.CENTER);
        
        this.botonAtacar = new Button();
        this.botonAtacar.setText("Atacar");
        this.botonAtacar.setTextFill(Color.GRAY);
        this.botonAtacar.setFont(Font.font("Cooper Black", FontWeight.NORMAL,15));
        this.botonAtacar.setStyle("-fx-base: #b6e7c9;; -fx-border-color: rgb(249,219,189)");
        this.botonAtacar.setOnAction(new BotonOpcionAtacarEventHandler(_contenedorJuego));
        this.botonAtacar.setMinSize(100.0, 50.0);
        
        this.botonMover = new Button();
        this.botonMover.setText("Mover");
        this.botonMover.setTextFill(Color.GRAY);
        this.botonMover.setFont(Font.font("Cooper Black", FontWeight.NORMAL,15));
        this.botonMover.setStyle("-fx-base: #b6e7c9; -fx-border-color: rgb(249,219,189)");
        this.botonMover.setOnAction(new BotonOpcionMoverEventHandler(_contenedorJuego));
        this.botonMover.setMinSize(100.0, 50.0);
        
        this.botonTransformar = new Button();
        this.botonTransformar.setText("Transformar");
        this.botonTransformar.setTextFill(Color.GRAY);
        this.botonTransformar.setFont(Font.font("Cooper Black", FontWeight.NORMAL,15));
        this.botonTransformar.setStyle("-fx-base: #b6e7c9;; -fx-border-color: rgb(249,219,189)");
        this.botonTransformar.setOnAction(new BotonOpcionTransformarEventHandler(_contenedorJuego));
        this.botonTransformar.setMinSize(100.0, 50.0);
        
        
        this.botonPasarTurno = new Button();
        this.botonPasarTurno.setText("Pasar Turno");
        this.botonPasarTurno.setTextFill(Color.GRAY);
        this.botonPasarTurno.setFont(Font.font("Cooper Black", FontWeight.NORMAL,15));
        this.botonPasarTurno.setStyle("-fx-base: #b6e7c9;; -fx-border-color: rgb(249,219,189)");
        this.botonPasarTurno.setOnAction(new BotonPasarTurnoEventHandler(_contenedorJuego));
        this.botonPasarTurno.setMinSize(100.0, 50.0);
        
        this.getChildren().addAll(this.botonAtacar, this.botonMover,this.botonTransformar, this.botonPasarTurno);
    }
    
    public void deshabilitarBotonAtaque() {
    	this.botonAtacar.setDisable(true);
    	
    }
    
    public void deshabilitarBotonMover() {
    	this.botonMover.setDisable(true);
    	
    }
    
	public void reestablecerBotones() {
		this.botonAtacar.setDisable(false);
		this.botonMover.setDisable(false);
		
	}
    
}
