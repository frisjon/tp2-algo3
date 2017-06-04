package personajes.Piccolo;

import personajes.EstadoPersonaje;
import personajes.Ataque;
import personajes.Personaje;

public class Piccolo extends Personaje {
   public Piccolo() {
       this.nombre = "Piccolo";
       this.vida = 500;
       this.estado = new PiccoloEstado1();
       this.ataqueEspecial = null;
   }
}