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

    public void test01SemillaAtributoEsHP(){
        assertEquals(nuevaSemilla.getAtributo(), "HP");
    }
    
    public void test02SemillaCantidadAtributoEs100(){
        assertEquals(nuevaSemilla.getCantidadAtributo(), 100.0);
    }
    
    public void test03SemillaCantidadUsosRestantesEs0(){
        assertEquals(nuevaSemilla.getCantidadUsosRestantes(), 0);
    }
    
    public void test04SemillaInstantaneoEsTrue(){
        assertTrue(nuevaSemilla.getInstantaneo());
    }
    
    public void test05SemillaDecrementarTurnoLanzaExcepcion(){
        try {
            nuevaSemilla.decrementarUso();
            fail("No lanzo ErrorConsumibleInstantaneo");
        }
        catch (ErrorConsumibleInstantaneo e1){
        }
        catch (ErrorNoHayUsosRestantes e2){
            fail("Lanzo la excepcion equivocada.");
        }
    }
    
    public void test06SemillaNombre(){
        assertEquals(nuevaSemilla.getNombre(), "Semilla del ermitaño");
    }
}