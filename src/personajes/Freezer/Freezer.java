package personajes.Freezer;

import personajes.ConstantesPersonajes;
import personajes.Personaje;

public class Freezer extends Personaje {
    public Freezer() {
         this.estado = new FreezerEstado1();
         this.ki = ConstantesPersonajes.CANTIDAD_KI_INICIAL;
         this.nombre = ConstantesPersonajes.FREEZER_NOMBRE;
         this.vida = ConstantesPersonajes.FREEZER_CANTIDAD_VIDA_INICIAL;
         this.ataqueEspecial = ConstantesPersonajes.FREEZER_NOMBRE_ATAQUE_ESPECIAL;
    }


    public double danioAtaqueEspecial() {
         return this.danioAtaqueNormal() * ConstantesPersonajes.FREEZER_FACTOR_ATAQUE_ESPECIAL;
    }

    public void cambiarEstado(int idEstado)
    //throws ErrorIdEstadoPersonajeInvalido
    {
         if (idEstado == 1) 
             this.estado = new FreezerEstado1();
         else if (idEstado == 2) {
              if (this.kiSuficiente(20))
                  this.estado = new FreezerEstado2();
         }
         else if (idEstado == 3) {
             if (this.kiSuficiente(50))
                 this.estado = new FreezerEstado3();
         }
         //else throw ErrorIdEstadoPersonajeInvalido;
    }

    public boolean puedeRealizarAtaqueEspecial() {
        return this.kiSuficiente(30);
    }
}