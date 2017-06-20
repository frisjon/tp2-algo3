package vista.contenedores;

import java.util.List;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import modelo.personajes.Personaje;
import vista.RepresentacionJugador;
import vista.RepresentacionPersonaje;

public class ContenedorEstadisticas extends VBox {
    private ContenedorJuego contenedorJuego;
    private RepresentacionJugador jugadorTurno;
    private List<RepresentacionPersonaje> personajesDeTurno;
    private Personaje pj1;
    private Personaje pj2;
    private Personaje pj3;
    private ImageView imPj1;
    private ImageView imPj2;
    private ImageView imPj3;
    
    public ContenedorEstadisticas(ContenedorJuego _contenedorJuego){
        super();

        this.setAlignment(Pos.CENTER);
        
        this.contenedorJuego = _contenedorJuego;
        this.jugadorTurno = this.contenedorJuego.getRepresentacionJugador();
        this.personajesDeTurno = this.jugadorTurno.getRepresentacionesDePersonajes();
        this.pj1 = this.personajesDeTurno.get(0).getPersonaje();
        this.pj2 = this.personajesDeTurno.get(1).getPersonaje();
        this.pj3 = this.personajesDeTurno.get(2).getPersonaje();
        this.imPj1 = this.personajesDeTurno.get(0).getImagenEst();
        this.imPj2 = this.personajesDeTurno.get(1).getImagenEst();
        this.imPj3 = this.personajesDeTurno.get(2).getImagenEst();
        
        Label atributosPj1 = new Label();
        atributosPj1.setText("Vida: " + String.valueOf(pj1.getVida()) + "\n" + "Ataque : " + String.valueOf(pj1.getPoderPelea()) + "\n" + 
        "Ki: " + String.valueOf(pj1.getKi()) + "\n");
        atributosPj1.setFont(Font.font("Cooper Black", FontWeight.NORMAL,15));
        atributosPj1.setMinSize(75.0, 75.0);
        
        Label atributosPj2 = new Label();
        atributosPj2.setText("Vida: " + String.valueOf(pj2.getVida()) + "\n" + "Ataque : " + String.valueOf(pj2.getPoderPelea()) + "\n" + 
        "Ki: " + String.valueOf(pj2.getKi()) + "\n");
        atributosPj2.setFont(Font.font("Cooper Black", FontWeight.NORMAL,15));
        atributosPj2.setMinSize(75.0, 75.0);
        
        Label atributosPj3 = new Label();
        atributosPj3.setText("Vida: " + String.valueOf(pj3.getVida()) + "\n" + "Ataque : " + String.valueOf(pj3.getPoderPelea()) + "\n" + 
        "Ki: " + String.valueOf(pj3.getKi()) + "\n");
        atributosPj3.setFont(Font.font("Cooper Black", FontWeight.NORMAL,15));
        atributosPj3.setMinSize(75.0, 75.0);
        
        this.getChildren().addAll(this.imPj1, atributosPj1, this.imPj2, atributosPj2, this.imPj3, atributosPj3);
    }
}
