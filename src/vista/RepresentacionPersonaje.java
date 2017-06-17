package vista;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.media.AudioClip;
import modelo.personajes.Personaje;
import modelo.tablero.Casillero;

public class RepresentacionPersonaje {
    
    private Personaje personaje;
    private ImageView ivImagen;
    private Image imagenEstado1;
    private Image imagenEstado2;
    private Image imagenEstado3;
    //private AudioClip sonidoAtaqueEspecial;
    
    //public RepresentacionPersonaje(Personaje _personaje, Image _imagenEstado1, Image _imagenEstado2, Image _imagenEstado3, AudioClip _sonidoAtaqueEspecial)
    public RepresentacionPersonaje(Personaje _personaje, Image _imagenEstado1, Image _imagenEstado2, Image _imagenEstado3) {
        
        this.personaje = _personaje;
        this.imagenEstado1 = _imagenEstado1;
        this.imagenEstado2 = _imagenEstado2;
        this.imagenEstado3 = _imagenEstado3;
        
        //this.sonidoAtaqueEspecial = _sonidoAtaqueEspecial;

        this.ivImagen = new ImageView();
        this.ivImagen.setImage(this.imagenEstado1);
    }

    public Casillero getCasillero() {
        if (this.personaje != null) return this.personaje.getCasillero();
        return null;
    }
    
    public ImageView getImagen() {
        return this.ivImagen;
    }
    
    public void cambiarAEstado1() {
        this.ivImagen.setImage(this.imagenEstado1);
    }
    
    public void cambiarAEstado2() {
        this.ivImagen.setImage(this.imagenEstado2);
    }
    
    public void cambiarAEstado3() {
        this.ivImagen.setImage(this.imagenEstado3);
    }

}
