package vista;

import javafx.scene.media.AudioClip;

public class Reproductor {
    private static AudioClip BUZZ = new AudioClip("file:src/vista/sonidos/Buzz.wav");
    private static AudioClip SELECCION = new AudioClip("file:src/vista/sonidos/seleccion.mp3");
    private static AudioClip GOLPE = new AudioClip("file:src/vista/sonidos/Punch.mp3");
    private static AudioClip MUERTE = new AudioClip("file:src/vista/sonidos/Death.mp3");
    private static AudioClip INTRO = new AudioClip("file:src/vista/sonidos/Tema_Inicio.mp3");
    private static AudioClip GANADORFINAL = new AudioClip("file:src/vista/sonidos/audioganador.wav");
    private static AudioClip GOLPEESPECIAL = new AudioClip("file:src/vista/sonidos/audioataqueespecial.wav");
    private static AudioClip TRANSFORMACION = new AudioClip("file:src/vista/sonidos/audiotransformacion.wav");
    private static AudioClip TRANSFORMACION2 = new AudioClip("file:src/vista/sonidos/sonidotransformacion2.wav");
    
    public static void buzz(){
        BUZZ.play();
    }
    
    public static void seleccion(){
        SELECCION.setVolume(0.3);
        SELECCION.play();
    }
    
    public static void golpe(){
        GOLPE.setVolume(0.3);
        GOLPE.play();
    }
    
    public static void golpeEspecial(){
    	GOLPEESPECIAL.play();
    }
    
    public static void muerte(){
        MUERTE.play();
    }
    
    public static void intro(){
        INTRO.setVolume(0.4);
        INTRO.play();
    }
    
    public static void finalJuego(){
    	GANADORFINAL.play();
    }
    
    public static void transformacion(){
    	TRANSFORMACION.play();
    }
    
    public static void transformacion2(){
    	TRANSFORMACION2.play();
    }
    
    
    public static void stopAll(){
        BUZZ.stop();
        SELECCION.stop();
        GOLPE.stop();
        MUERTE.stop();
        INTRO.stop();
    }
}
