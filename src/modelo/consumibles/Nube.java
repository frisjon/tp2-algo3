package modelo.consumibles;

import modelo.consumibles.Constantes;
import modelo.consumibles.Consumible;

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
        //this.atributo = Constantes.NUBE_ATRIBUTO;
        this.cantidadAtributo = Constantes.NUBE_CANTIDAD_ATRIBUTO;
        this.instantaneo = Constantes.NUBE_INSTANTANEO;
        this.cantidadTurnosRestantes = Constantes.NUBE_CANTIDAD_TURNOS_RESTANTES;
    }
    
    public int getCantidadUsosRestantes() throws ErrorNoTieneCantidadUsos{
        throw new ErrorNoTieneCantidadUsos("Nube no posee cantidad usos");
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
    	throw new ErrorNoTieneCantidadUsos("Nube no posee cantidad usos");
    }
    
    public int sumarACantidadEsferas(){
    	return 0;
    }
    
    public double getCantidadAtributoHP(){
    	return 0;
    }
    
    public double getCantidadAtributoVelocidad(){
    	return this.cantidadAtributo;
    }
    
    public double getCantidadAtributoAtaque(){
    	return 0;
    }
}
