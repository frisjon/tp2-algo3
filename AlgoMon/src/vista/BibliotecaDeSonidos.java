package vista;

import javafx.scene.media.AudioClip;

import java.util.HashMap;

public class BibliotecaDeSonidos extends HashMap<String,AudioClip>{
    public BibliotecaDeSonidos() {
        put("Charmander",new AudioClip("file:src/vista/sonidos/charmander.wav"));
        put("Chansey",new AudioClip("file:src/vista/sonidos/chansey.wav"));
        put("Squirtle",new AudioClip("file:src/vista/sonidos/squirtle.wav"));
        put("Rattata",new AudioClip("file:src/vista/sonidos/rattata.wav"));
        put("Jigglypuff",new AudioClip("file:src/vista/sonidos/jigglypuff.wav"));
        put("Bulbasaur",new AudioClip("file:src/vista/sonidos/bulbasaur.wav"));
    }
}
