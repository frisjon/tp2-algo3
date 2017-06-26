package vista;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import modelo.consumibles.Consumible;
import modelo.tablero.Casillero;

public class RepresentacionConsumible {
    
    private Consumible consumible;
    private ImageView ivImagen;
    private Image imagen;
    
    public RepresentacionConsumible(Consumible _consumible, Image _imagen) {
        
        this.consumible = _consumible;
        this.imagen = _imagen;

        this.ivImagen = new ImageView();
        this.ivImagen.setImage(this.imagen);
    }

    public Casillero getCasillero() {
        if (this.consumible != null) return this.consumible.getCasillero();
        return null;
    }
    
    public ImageView getImagen() {
        return this.ivImagen;
    }

}
