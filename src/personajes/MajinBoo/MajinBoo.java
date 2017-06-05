package personajes.MajinBoo;

import personajes.ConstantesPersonajes;
import personajes.Personaje;

public class MajinBoo extends Personaje {
   public MajinBoo() {
       this.nombre = ConstantesPersonajes.MAJINBOO_NOMBRE;
       this.vida = ConstantesPersonajes.MAJINBOO_CANTIDAD_VIDA_INICIAL;
       this.ki = ConstantesPersonajes.CANTIDAD_KI_INICIAL;
       this.estado = new MajinBooEstado1();
       this.ataqueEspecial = ConstantesPersonajes.MAJINBOO_NOMBRE_ATAQUE_ESPECIAL;
   }

   public double calcularDanoAtaqueEspecial() {
       return this.danioAtaqueNormal();
   }
}