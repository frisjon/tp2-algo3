package vista;

import javafx.scene.image.Image;
import javafx.scene.media.AudioClip;
import modelo.personajes.*;

public class CreadorRepresentacionPersonaje {
    
    private static final int ancho = 50;
    private static final int alto = 50;
    private static final boolean preserveRatio = true;
    private static final boolean smooth = true;
    
    private static final Image imagenGokuEstado1 = new Image("file:src/vista/imagenes/gokuEstado1.png",ancho,alto,preserveRatio,smooth);
    private static final Image imagenGokuEstado2 = new Image("file:src/vista/imagenes/gokuEstado2.png",ancho,alto,preserveRatio,smooth);
    private static final Image imagenGokuEstado3 = new Image("file:src/vista/imagenes/gokuEstado3.png",ancho,alto,preserveRatio,smooth);
    private static final Image imagenGohanEstado1 = new Image("file:src/vista/imagenes/gohanEstado1.png",ancho,alto,preserveRatio,smooth);
    private static final Image imagenGohanEstado2 = new Image("file:src/vista/imagenes/gohanEstado2.png",ancho,alto,preserveRatio,smooth);
    private static final Image imagenGohanEstado3 = new Image("file:src/vista/imagenes/gohanEstado3.png",ancho,alto,preserveRatio,smooth);
    private static final Image imagenPiccoloEstado1 = new Image("file:src/vista/imagenes/piccoloEstado1.png",ancho,alto,preserveRatio,smooth);
    private static final Image imagenPiccoloEstado2 = new Image("file:src/vista/imagenes/piccoloEstado2.png",ancho,alto,preserveRatio,smooth);
    private static final Image imagenPiccoloEstado3 = new Image("file:src/vista/imagenes/piccoloEstado3.png",ancho,alto,preserveRatio,smooth);
    private static final Image imagenFreezerEstado1 = new Image("file:src/vista/imagenes/freezerEstado1.png",ancho,alto,preserveRatio,smooth);
    private static final Image imagenFreezerEstado2 = new Image("file:src/vista/imagenes/freezerEstado2.png",ancho,alto,preserveRatio,smooth);
    private static final Image imagenFreezerEstado3 = new Image("file:src/vista/imagenes/freezerEstado3.png",ancho,alto,preserveRatio,smooth);
    private static final Image imagenCellEstado1 = new Image("file:src/vista/imagenes/cellEstado1.png",ancho,alto,preserveRatio,smooth);
    private static final Image imagenCellEstado2 = new Image("file:src/vista/imagenes/cellEstado2.png",ancho,alto,preserveRatio,smooth);
    private static final Image imagenCellEstado3 = new Image("file:src/vista/imagenes/cellEstado3.png",ancho,alto,preserveRatio,smooth);
    private static final Image imagenMajinBooEstado1 = new Image("file:src/vista/imagenes/majinbooEstado1.png",ancho,alto,preserveRatio,smooth);
    private static final Image imagenMajinBooEstado2 = new Image("file:src/vista/imagenes/majinbooEstado2.png",ancho,alto,preserveRatio,smooth);
    private static final Image imagenMajinBooEstado3 = new Image("file:src/vista/imagenes/majinbooEstado3.png",ancho,alto,preserveRatio,smooth);

    /*
    private static final AudioClip sonidoGoku = new AudioClip("file:src/vista/sonidos/Goku.mp3");
    private static final AudioClip sonidoGohan = new AudioClip("file:src/vista/sonidos/Gohan.mp3");
    private static final AudioClip sonidoPiccolo = new AudioClip("file:src/vista/sonidos/Piccolo.mp3");
    private static final AudioClip sonidoFreezer = new AudioClip("file:src/vista/sonidos/Freezer.mp3");
    private static final AudioClip sonidoCell = new AudioClip("file:src/vista/sonidos/Cell.mp3");
    private static final AudioClip sonidoMajinBoo = new AudioClip("file:src/vista/sonidos/MajinBoo.mp3");*/
  
  public RepresentacionPersonaje crearRepresentacionDe(Personaje personaje) {
    
    if (personaje.equals(new Goku("Guerreros")))
        return new RepresentacionPersonaje(personaje,imagenGokuEstado1, imagenGokuEstado2, imagenGokuEstado3);
        //return new RepresentacionPersonaje(personaje,imagenGokuEstado1, imagenGokuEstado2, imagenGokuEstado3, sonidoGoku);
    
    if (personaje.equals(new Gohan("Guerreros")))
        return new RepresentacionPersonaje(personaje,imagenGohanEstado1, imagenGohanEstado2, imagenGohanEstado3);
        //return new RepresentacionPersonaje(personaje,imagenGohanEstado1, imagenGohanEstado2, imagenGohanEstado3, sonidoGohan);
    
    if (personaje.equals(new Piccolo("Guerreros")))
        return new RepresentacionPersonaje(personaje,imagenPiccoloEstado1, imagenPiccoloEstado2, imagenPiccoloEstado3);
        //return new RepresentacionPersonaje(personaje,imagenPiccoloEstado1, imagenPiccoloEstado2, imagenPiccoloEstado3, sonidoPiccolo);
    
    if (personaje.equals(new Freezer("Enemigos")))
        return new RepresentacionPersonaje(personaje,imagenFreezerEstado1, imagenFreezerEstado2, imagenFreezerEstado3);
        //return new RepresentacionPersonaje(personaje,imagenFreezerEstado1, imagenFreezerEstado2, imagenFreezerEstado3, sonidoFreezer);
    
    if (personaje.equals(new Cell("Enemigos")))
        return new RepresentacionPersonaje(personaje,imagenCellEstado1, imagenCellEstado2, imagenCellEstado3);
        //return new RepresentacionPersonaje(personaje,imagenCellEstado1, imagenCellEstado2, imagenCellEstado3, sonidoCell);
    
    if (personaje.equals(new MajinBoo("Enemigos")))
        return new RepresentacionPersonaje(personaje,imagenMajinBooEstado1, imagenMajinBooEstado2, imagenMajinBooEstado3);
        //return new RepresentacionPersonaje(personaje,imagenMajinBooEstado1, imagenMajinBooEstado2, imagenMajinBooEstado3, sonidoMajinBoo);
    
    return null;
  }
  
}
