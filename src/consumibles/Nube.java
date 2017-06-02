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
public class Nube extends Consumible{
    public Nube(){
        this.nombre = Constantes.NUBE_NOMBRE;
        this.atributo = Constantes.NUBE_ATRIBUTO;
        this.cantidadAtributo = Constantes.NUBE_CANTIDAD_ATRIBUTO;
        this.instantaneo = Constantes.NUBE_INSTANTANEO;
        this.cantidadUsosRestantes = Constantes.NUBE_CANTIDAD_USOS_RESTANTES;
    }
}
