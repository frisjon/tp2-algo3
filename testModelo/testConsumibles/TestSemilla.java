package testConsumibles;

import junit.framework.*;
import modelo.consumibles.*;


public class TestSemilla extends TestCase {
    private Semilla nuevaSemilla;
    
    @Override
    protected void setUp() throws Exception{
        super.setUp();
        this.nuevaSemilla = new Semilla();
    }

    public void test02SemillaCantidadAtributoEs100(){
        assertEquals(nuevaSemilla.getCantidadAtributoHP(), 100.0);
    }
    
    public void test03SemillaCantidadTurnosRestantesEs0(){
        assertEquals(nuevaSemilla.getCantidadTurnosRestantes(), 0);
    }
    
    public void test04SemillaInstantaneoEsTrue(){
        assertTrue(nuevaSemilla.getInstantaneo());
    }
    
    public void test05SemillaDecrementarUsoLanzaExcepcion(){
        try {
            nuevaSemilla.decrementarUso();
        }catch (ErrorNoTieneCantidadUsos e1){}
  
    }
    
    public void test06SemillaNombre(){
        assertEquals(nuevaSemilla.getNombre(), "Semilla del ermitaño");
    }
}