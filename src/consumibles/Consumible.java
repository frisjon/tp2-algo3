package consumibles;

import consumibles.ErrorConsumibleInstantaneo;
import consumibles.ErrorNoHayUsosRestantes;


/**
 * Clase abstracta que representa un Consumible del juego.
 * 
 * @author Thomas
 */
public abstract class Consumible implements ObjetoJuego {
    protected String nombre;
    protected String atributo;
    /**
     * cantidadAtributo es double porque toma en cuenta los casos en los cuales debe incrementar porcentajes o 
     * incrementar por un cociente.
     */
    protected double cantidadAtributo;
    /**
     * Si instantaneo es true, la cantidad de turnos restantes no sera tenida en cuenta.
     */
    protected Boolean instantaneo;
    protected int cantidadUsosRestantes;
    protected Casillero casillero;
    
    
    public String getNombre(){
        return this.nombre;
    }
    
    public String getAtributo(){
        return this.atributo;
    }
    
    public double getCantidadAtributo(){
        return this.cantidadAtributo;
    }
    
    public Boolean getInstantaneo(){
        return this.instantaneo;
    }
    
    public int getCantidadUsosRestantes(){
        return this.cantidadUsosRestantes;
    }
    
    /**
     * Decrementa la cantidad de usos restantes del consumible por 1 uso.
     * Si el consumible es instanteo lanzara una excepcion.
     * Si el consumible no tiene usos restantes lanzara una excepcion.
     * @throws ErrorConsumibleInstantaneo
     * @throws ErrorNoHayUsosRestantes
     */
    public void decrementarUso() throws ErrorConsumibleInstantaneo, ErrorNoHayUsosRestantes{
        if (this.instantaneo){
            throw new ErrorConsumibleInstantaneo("El consumible es instantaneo.");
        }
        
        if (this.cantidadUsosRestantes == 0){
            throw new ErrorNoHayUsosRestantes("El consumible no tiene mas turnos.");
        }

        this.cantidadUsosRestantes -= 1;
    }
    
     public void setCasillero(Casillero casillero){
    	this.casillero = casillero;
     }
    
    public Casillero getCasillero(){
    	return this.casillero;
    }
}
