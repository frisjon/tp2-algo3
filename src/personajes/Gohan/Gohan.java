package personajes.Gohan;

import personajes.ConstantesPersonajes;
import personajes.Personaje;

public class Gohan extends Personaje {
   public Gohan() {
       this.nombre = ConstantesPersonajes.GOHAN_NOMBRE;
       this.vida = ConstantesPersonajes.GOHAN_CANTIDAD_VIDA_INICIAL;
       this.ki = ConstantesPersonajes.CANTIDAD_KI_INICIAL;
       this.estado = new GohanEstado1();
       this.ataqueEspecial = ConstantesPersonajes.GOHAN_NOMBRE_ATAQUE_ESPECIAL;
   }

   public double calcularDanoAtaqueEspecial() {
       return this.danioAtaqueNormal();
   }
}