package vista;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.media.AudioClip;
import modelo.personajes.Personaje;
import modelo.tablero.Casillero;
import modelo.tablero.ObjetoJuego;

public class RepresentacionPersonaje {
    
    private Personaje personaje;
    private ImageView ivImagen;
    /**
     * Imagen utilizada para las estadisticas.
     */
    private ImageView ivImagenEst;
    private Image imagenEstado1;
    private Image imagenEstado2;
    private Image imagenEstado3;
    //private AudioClip sonidoAtaqueEspecial;
    
    private double movimientosTotales;
    private double movimientosRestantes;
    
    //public RepresentacionPersonaje(Personaje _personaje, Image _imagenEstado1, Image _imagenEstado2, Image _imagenEstado3, AudioClip _sonidoAtaqueEspecial)
    public RepresentacionPersonaje(Personaje _personaje, Image _imagenEstado1, Image _imagenEstado2, Image _imagenEstado3) {
        
        this.personaje = _personaje;
        this.imagenEstado1 = _imagenEstado1;
        this.imagenEstado2 = _imagenEstado2;
        this.imagenEstado3 = _imagenEstado3;
        
        //this.sonidoAtaqueEspecial = _sonidoAtaqueEspecial;

        this.ivImagen = new ImageView();
        this.ivImagenEst = new ImageView();
        this.ivImagen.setImage(this.imagenEstado1);
        this.ivImagenEst.setImage(this.imagenEstado1);
        
        this.movimientosTotales = this.personaje.getVelocidad();
        this.movimientosRestantes = this.personaje.getVelocidad();
    }

    public Casillero getCasillero() {
        if (this.personaje != null) return this.personaje.getCasillero();
        return null;
    }
    
    public ImageView getImagen() {
        return this.ivImagen;
    }
    
    public ImageView getImagenEst(){
        return this.ivImagenEst;
    }
    
    public Personaje getPersonaje(){
        return this.personaje;
    }
    
    public void cambiarAEstado1() {
        this.ivImagen.setImage(this.imagenEstado1);
        this.ivImagenEst.setImage(this.imagenEstado1);
    }
    
    public void cambiarAEstado2() {
        this.ivImagen.setImage(this.imagenEstado2);
        this.ivImagenEst.setImage(this.imagenEstado2);
    }
    
    public void cambiarAEstado3() {
        this.ivImagen.setImage(this.imagenEstado3);
        this.ivImagenEst.setImage(this.imagenEstado3);
    }
    
    public double getMovimientosRestantes() {
        return this.movimientosRestantes;
    }

    public void decrementarMovimientosRestantes() {
        this.movimientosRestantes -= 1;
    }
    
    public void reestablecerMovimientosRestantes() {
        this.movimientosRestantes = this.movimientosTotales;
    }
    
    public void actualizarMovimientosTotales() {
        /*this.movimientosTotales = this.personaje.getVelocidad();

        for (int i = 0; i < personaje.getObjetos().size(); i++){
            ObjetoJuego objeto = personaje.getObjetos().get(i);
            this.movimientosTotales = this.movimientosTotales * objeto.getCantidadAtributoVelocidad();           
        }*/
    	
    	this.movimientosTotales = this.personaje.getVelocidadFinal();    	
    }
    
    public void eliminarImagen() {
    	this.ivImagen.setImage(null);
    }

}
