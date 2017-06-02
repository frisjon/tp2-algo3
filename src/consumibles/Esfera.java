package consumibles;

import consumibles.Consumible;
import consumibles.Constantes;

/**
 * Clase que representa una Esfera del dragon.
 * Es un consumible que dura 2 ataques y otorga 25% mas de daño.
 * 
 * @author Thomas
 *
 */
public class Esfera extends Consumible{
    public Esfera(){
        this.nombre = Constantes.ESFERA_NOMBRE;
        this.atributo = Constantes.ESFERA_ATRIBUTO;
        this.cantidadAtributo = Constantes.ESFERA_CANTIDAD_ATRIBUTO;
        this.instantaneo = Constantes.ESFERA_INSTANTANEO;
        this.cantidadUsosRestantes = Constantes.ESFERA_CANTIDAD_USOS_RESTANTES;
    }
}
