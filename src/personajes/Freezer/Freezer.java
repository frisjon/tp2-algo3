package personajes.Freezer;

import personajes.EstadoPersonaje;
import personajes.Ataque;
import personajes.Personaje;

public class Freezer extends Personaje {
   public Freezer() {
       this.nombre = "Freezer";
       this.vida = 400;
       this.estado = new FreezerEstado1();
       this.ataqueEspecial = null;
   }
}