package personajes.MajinBoo;

import personajes.ConstantesPersonajes;
import personajes.Personaje;

public class MajinBoo extends Personaje {
   public MajinBoo() {
       this.estado = new MajinBooEstado1();
       this.ki = ConstantesPersonajes.CANTIDAD_KI_INICIAL;
       this.nombre = ConstantesPersonajes.MAJINBOO_NOMBRE;
       this.vida = ConstantesPersonajes.MAJINBOO_CANTIDAD_VIDA_INICIAL;
       this.ataqueEspecial = ConstantesPersonajes.MAJINBOO_NOMBRE_ATAQUE_ESPECIAL;
   }


   public double danioAtaqueEspecial() {
       return 0;
   }

   public void cambiarEstado(int idEstado)
   //throws ErrorIdEstadoPersonajeInvalido
   {
       if (idEstado == 1) this.estado = new MajinBooEstado1();
       else if (idEstado == 2) this.estado = new MajinBooEstado2();
       else if (idEstado == 3) this.estado = new MajinBooEstado3();
       //else throw ErrorIdEstadoPersonajeInvalido;
   }
}