package personajes.Cell;

import personajes.ConstantesPersonajes;
import personajes.Personaje;

public class Cell extends Personaje {    
    private int cantidadDeAtaquesEspeciales;
    
    public Cell() {
         this.estado = new CellEstado1();
         this.ki = ConstantesPersonajes.CANTIDAD_KI_INICIAL;
         this.nombre = ConstantesPersonajes.CELL_NOMBRE;
         this.vida = ConstantesPersonajes.CELL_CANTIDAD_VIDA_INICIAL;
         this.ataqueEspecial = ConstantesPersonajes.CELL_NOMBRE_ATAQUE_ESPECIAL;
         
         this.cantidadDeAtaquesEspeciales = 0;
    }


    public void cambiarEstado(int idEstado)
    //throws ErrorIdEstadoPersonajeInvalido
    {
         if (idEstado == 1) this.estado = new CellEstado1();
         else if (idEstado == 2) this.estado = new CellEstado2();
         else if (idEstado == 3) this.estado = new CellEstado3();
         //else throw ErrorIdEstadoPersonajeInvalido;
    }

    public boolean puedeRealizarAtaqueEspecial() {
        if (5 <= this.ki) return true;
        return false;
    }

}