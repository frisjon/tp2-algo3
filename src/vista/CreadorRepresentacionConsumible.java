package vista;

import javafx.scene.image.Image;
import modelo.consumibles.*;

public class CreadorRepresentacionConsumible {
    
    private static final int ancho = 50;
    private static final int alto = 50;
    private static final boolean preserveRatio = true;
    private static final boolean smooth = true;
    
    private static final Image imagenEsfera = new Image("file:src/vista/imagenes/esfera.png",ancho,alto,preserveRatio,smooth);
    private static final Image imagenSemilla = new Image("file:src/vista/imagenes/semilla.png",ancho,alto,preserveRatio,smooth);
    private static final Image imagenNube = new Image("file:src/vista/imagenes/nube.png",ancho,alto,preserveRatio,smooth);
    
    public RepresentacionConsumible crearRepresentacionDe(Consumible consumible) {
        
        if (consumible.equals(new Nube()))
            return new RepresentacionConsumible(consumible,imagenNube);
        
        if (consumible.equals(new Semilla()))
            return new RepresentacionConsumible(consumible,imagenSemilla);
        
        if (consumible.equals(new Esfera()))
            return new RepresentacionConsumible(consumible,imagenEsfera);
        
        return null;
      }
}
