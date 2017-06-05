package personajes.Freezer;

import personajes.ConstantesPersonajes;
import personajes.Personaje;

public class Freezer extends Personaje {
   public Freezer() {
       this.nombre = ConstantesPersonajes.FREEZER_NOMBRE;
       this.vida = ConstantesPersonajes.FREEZER_CANTIDAD_VIDA_INICIAL;
       this.ki = ConstantesPersonajes.CANTIDAD_KI_INICIAL;
       this.estado = new FreezerEstado1();
       this.ataqueEspecial = ConstantesPersonajes.FREEZER_NOMBRE_ATAQUE_ESPECIAL;
   }

   public double calcularDanoAtaqueEspecial() {
       return this.danioAtaqueNormal();
   }
}