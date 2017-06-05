package personajes.Goku;

import personajes.ConstantesPersonajes;
import personajes.Personaje;

public class Goku extends Personaje {
   public Goku() {
       this.estado = new GokuEstado1();
       this.ki = ConstantesPersonajes.CANTIDAD_KI_INICIAL;
       this.nombre = ConstantesPersonajes.GOKU_NOMBRE;
       this.vida = ConstantesPersonajes.GOKU_CANTIDAD_VIDA_INICIAL;
       this.ataqueEspecial = ConstantesPersonajes.GOKU_NOMBRE_ATAQUE_ESPECIAL;
   }


   public double danioAtaqueEspecial() {
       return this.danioAtaqueNormal() * ConstantesPersonajes.GOKU_FACTOR_ATAQUE_ESPECIAL;
   }

   public void cambiarEstado(int idEstado)
   //throws ErrorIdEstadoPersonajeInvalido
   {
       if (idEstado == 1) this.estado = new GokuEstado1();
       else if (idEstado == 2) this.estado = new GokuEstado2();
       else if (idEstado == 3) this.estado = new GokuEstado3();
       //else throw ErrorIdEstadoPersonajeInvalido;
   }
}