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
        this.cantidadTurnosRestantes = Constantes.SEMILLA_CANTIDAD_TURNOS_RESTANTES;
    }
    
    public int getCantidadUsosRestantes() throws ErrorNoTieneCantidadUsos{
        throw new ErrorNoTieneCantidadUsos("Semilla no posee cantidad usos");
    }
    
    public int getCantidadTurnosRestantes(){
        return this.cantidadTurnosRestantes;
    }
    
    public void decrementarTurno() throws ErrorNoHayUsosRestantes{
    	if (this.cantidadTurnosRestantes == 0)
            throw new ErrorNoHayTurnosDisponibles("El consumible no tiene mas turnos.");
       
    	
    	this.cantidadTurnosRestantes -= 1;   	
    }
    
    public void decrementarUso() throws ErrorNoTieneCantidadUsos {
    	throw new ErrorNoTieneCantidadUsos("Semilla no posee cantidad usos");
    }
}
