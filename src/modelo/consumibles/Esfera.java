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
public class Esfera extends Consumible{
    public Esfera(){
        this.nombre = Constantes.ESFERA_NOMBRE;
        //this.atributo = Constantes.ESFERA_ATRIBUTO;
        this.cantidadAtributo = Constantes.ESFERA_CANTIDAD_ATRIBUTO;
        this.instantaneo = Constantes.ESFERA_INSTANTANEO;
        this.cantidadUsosRestantes = Constantes.ESFERA_CANTIDAD_USOS_RESTANTES;
        //this.cantidadTurnosRestantes = Constantes.ESFERA_CANTIDAD_TURNOS_RESTANTES;
    }
    
    public int getCantidadUsosRestantes(){
        return this.cantidadUsosRestantes;
    }
    
    public int getCantidadTurnosRestantes() throws ErrorNoHayTurnosDeDuracion {
        throw new ErrorNoHayTurnosDeDuracion("Esfera no tiene cantidad de turnos de duracion");
    }
    
    public void decrementarTurno() throws ErrorNoHayTurnosDeDuracion {
    	throw new ErrorNoHayTurnosDeDuracion("Esfera no tiene cantidad de turnos de duracion");   	   	
    }
    
    public void decrementarUso() throws ErrorNoHayUsosRestantes{
        if (this.cantidadUsosRestantes == 0){
            throw new ErrorNoHayUsosRestantes("El consumible no tiene mas usos.");
        }

        this.cantidadUsosRestantes -= 1;
    }
    
    public int sumarACantidadEsferas(){
    	return 1;
    }
    
    public double getCantidadAtributoHP(){
    	return 0;
    }
    
    public double getCantidadAtributoVelocidad(){
    	return 1;
    }
    
    public double getCantidadAtributoAtaque(){
    	return this.cantidadAtributo;
    }
    
    
}
