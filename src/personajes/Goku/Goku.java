package personajes.Goku;

import personajes.ConstantesPersonajes;
import personajes.Personaje;

public class Goku extends Personaje {
   public Goku() {
       this.nombre = ConstantesPersonajes.GOKU_NOMBRE;
       this.vida = ConstantesPersonajes.GOKU_CANTIDAD_VIDA_INICIAL;
       this.ki = ConstantesPersonajes.CANTIDAD_KI_INICIAL;
       this.estado = new GokuEstado1();
       this.ataqueEspecial = ConstantesPersonajes.GOKU_NOMBRE_ATAQUE_ESPECIAL;
   }

   public double calcularDanoAtaqueEspecial() {
       return this.danioAtaqueNormal();
   }
}