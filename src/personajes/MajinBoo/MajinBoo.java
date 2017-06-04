package personajes.MajinBoo;

import personajes.EstadoPersonaje;
import personajes.Ataque;
import personajes.Personaje;

public class MajinBoo extends Personaje {
   public MajinBoo() {
       this.nombre = "Majin Boo";
       this.vida = 300;
       this.estado = new MajinBooEstado1();
       this.ataqueEspecial = null;
   }
}