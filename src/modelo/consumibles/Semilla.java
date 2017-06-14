package modelo.consumibles;

import modelo.consumibles.Constantes;
import modelo.consumibles.Consumible;

/**
 * Clase que representa a la semilla del ermitaño.
 * Es un consumible instantaneo que otorga 100 de HP al personaje.
 * 
 * @author Thomas
 *
 */
public class Semilla extends Consumible{
    public Semilla(){
        this.nombre = Constantes.SEMILLA_NOMBRE;
        this.atributo = Constantes.SEMILLA_ATRIBUTO;
        this.cantidadAtributo = Constantes.SEMILLA_CANTIDAD_ATRIBUTO;
        this.instantaneo = Constantes.SEMILLA_INSTANTANEO;
        this.cantidadUsosRestantes = Constantes.SEMILLA_CANTIDAD_USOS_RESTANTES;
    }
}
