package personajes.Gohan;

import personajes.EstadoPersonaje;
import personajes.Ataque;
import personajes.Personaje;

public class Gohan extends Personaje {
   public Gohan() {
       this.nombre = "Gohan";
       this.vida = 300;
       this.estado = new GohanEstado1();
       this.ataqueEspecial = null;
   }
}