package personajes.Piccolo;

import personajes.ConstantesPersonajes;
import personajes.Personaje;

public class Piccolo extends Personaje {
   public Piccolo() {
       this.estado = new PiccoloEstado1();
       this.ki = ConstantesPersonajes.CANTIDAD_KI_INICIAL;
       this.nombre = ConstantesPersonajes.PICCOLO_NOMBRE;
       this.vida = ConstantesPersonajes.PICCOLO_CANTIDAD_VIDA_INICIAL;
       this.ataqueEspecial = ConstantesPersonajes.PICCOLO_NOMBRE_ATAQUE_ESPECIAL;
   }


   public double danioAtaqueEspecial() {
       return this.danioAtaqueNormal() * ConstantesPersonajes.PICCOLO_FACTOR_ATAQUE_ESPECIAL;
   }

   public void cambiarEstado(int idEstado)
   //throws ErrorIdEstadoPersonajeInvalido
   {
       if (idEstado == 1) this.estado = new PiccoloEstado1();
       else if (idEstado == 2) this.estado = new PiccoloEstado2();
       else if (idEstado == 3) this.estado = new PiccoloEstado3();
       //else throw ErrorIdEstadoPersonajeInvalido;
   }
}