package personajes.Goku;

import personajes.EstadoPersonaje;
import personajes.Ataque;
import personajes.Personaje;

public class Goku extends Personaje {
   public Goku() {
       this.nombre = "Goku";
       this.vida = 500;
       this.estado = new GokuEstado1();
       this.ataqueEspecial = null;
   }
}