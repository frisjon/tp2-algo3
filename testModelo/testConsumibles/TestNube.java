package testConsumibles;

import junit.framework.*;
import modelo.consumibles.*;


public class TestNube extends TestCase {
    private Nube nube1;
    private Nube nube2;
    
    @Override
    protected void setUp() throws Exception{
        super.setUp();
        this.nube1 = new Nube();
        this.nube2 = new Nube();
    }

    public void test01NubeAtributoEsVelocidad(){
        assertEquals(nube1.getAtributo(), "Velocidad");
    }
    
    public void test02NubeCantidadAtributoEs2(){
        assertEquals(nube1.getCantidadAtributo(), 2.0);
    }
    
    public void test03NubeCantidadTurnosRestantesEs2(){
        assertEquals(nube1.getCantidadTurnosRestantes(), 2);
    }
    
    public void test04NubeInstantaneoEsFalse(){
        assertFalse(nube1.getInstantaneo());
    }
    
    public void test05NubeDecrementarTurnoCantidadUso(){
        try {
            nube1.decrementarTurno();
            if ((nube1.getCantidadTurnosRestantes() != 1) || (nube2.getCantidadTurnosRestantes() != 2)){
                fail("No se actualizo la cantida de usos.");
            }
                
        }
        catch (ErrorConsumibleInstantaneo e1){
            fail("No es un consumible instantaneo.");
        }
        catch (ErrorNoHayUsosRestantes e2){
            fail("Quedan usos restantes.");
        }
        
    }
    
    public void test06NubeNombre(){
        assertEquals(nube1.getNombre(), "Nube voladora");
    }

    public void test07NubeDecrementarTurno3VecesExcepcion(){
        try{
            nube1.decrementarTurno();
            nube1.decrementarTurno();
            nube1.decrementarTurno();
        }
        catch (ErrorNoHayTurnosDisponibles e1){}

    }
}