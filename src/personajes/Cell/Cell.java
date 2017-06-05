package personajes.Cell;

import personajes.ConstantesPersonajes;
import personajes.Personaje;

public class Cell extends Personaje {
   public Cell() {
       this.nombre = ConstantesPersonajes.CELL_NOMBRE;
       this.vida = ConstantesPersonajes.CELL_CANTIDAD_VIDA_INICIAL;
       this.ki = ConstantesPersonajes.CANTIDAD_KI_INICIAL;
       this.estado = new CellEstado1();
       this.ataqueEspecial = ConstantesPersonajes.CELL_NOMBRE_ATAQUE_ESPECIAL;
   }

   public double calcularDanoAtaqueEspecial() {
       return this.danioAtaqueNormal();
   }
}