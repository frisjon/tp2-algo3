package personajes.Cell;

import personajes.EstadoPersonaje;
import personajes.Ataque;
import personajes.Personaje;

public class Cell extends Personaje {
   public Cell() {
       this.nombre = "Cell";
       this.vida = 500;
       this.estado = new CellEstado1();
       this.ataqueEspecial = null;
   }
}