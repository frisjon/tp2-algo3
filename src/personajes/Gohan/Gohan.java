package personajes.Gohan;

import personajes.ConstantesPersonajes;
import personajes.Personaje;

public class Gohan extends Personaje {
    public Gohan() {
         this.estado = new GohanEstado1();
         this.ki = ConstantesPersonajes.CANTIDAD_KI_INICIAL;
         this.nombre = ConstantesPersonajes.GOHAN_NOMBRE;
         this.vida = ConstantesPersonajes.GOHAN_CANTIDAD_VIDA_INICIAL;
         this.ataqueEspecial = ConstantesPersonajes.GOHAN_NOMBRE_ATAQUE_ESPECIAL;
    }


    public void cambiarEstado(int idEstado)
    //throws ErrorIdEstadoPersonajeInvalido
    {
         if (idEstado == 1) this.estado = new GohanEstado1();
         else if (idEstado == 2) this.estado = new GohanEstado2();
         else if (idEstado == 3) this.estado = new GohanEstado3();
         //else throw ErrorIdEstadoPersonajeInvalido;
    }


    public boolean puedeRealizarAtaqueEspecial() {
        return this.kiSuficiente(10);
    }
}