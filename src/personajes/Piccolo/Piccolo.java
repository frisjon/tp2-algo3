package personajes.Piccolo;

import personajes.ConstantesPersonajes;
import personajes.Personaje;

public class Piccolo extends Personaje {
   public Piccolo() {
       this.nombre = ConstantesPersonajes.PICCOLO_NOMBRE;
       this.vida = ConstantesPersonajes.PICCOLO_CANTIDAD_VIDA_INICIAL;
       this.ki = ConstantesPersonajes.CANTIDAD_KI_INICIAL;
       this.estado = new PiccoloEstado1();
       this.ataqueEspecial = ConstantesPersonajes.PICCOLO_NOMBRE_ATAQUE_ESPECIAL;
   }

   public double calcularDanoAtaqueEspecial() {
       return this.danioAtaqueNormal();
   }
}