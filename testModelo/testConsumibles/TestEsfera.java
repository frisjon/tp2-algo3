package testConsumibles;

import junit.framework.*;
import modelo.consumibles.*;


public class TestEsfera extends TestCase {
    private Esfera esfera1;
    private Esfera esfera2;
    
    @Override
    protected void setUp() throws Exception{
        super.setUp();
        this.esfera1 = new Esfera();
        this.esfera2 = new Esfera();
    }

    public void test01EsferaAtributoEsAtaque(){
        assertEquals(esfera1.getAtributo(), "Ataque");
    }
    
    public void test02EsferaCantidadAtributoEs025(){
        assertEquals(esfera1.getCantidadAtributo(), 0.25);
    }
    
    public void test03EsferaCantidadUsosRestantesEs2(){
        assertEquals(esfera1.getCantidadUsosRestantes(), 2);
    }
    
    public void test04EsferaInstantaneoEsFalse(){
        assertFalse(esfera1.getInstantaneo());
    }
    
    public void test05EsferaDecrementarTurnoCantidadUso(){
        try {
            esfera1.decrementarUso();
            if ((esfera1.getCantidadUsosRestantes() != 1) || (esfera2.getCantidadUsosRestantes() != 2)){
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
    
    public void test06EsferaNombre(){
        assertEquals(esfera1.getNombre(), "Esfera del dragon");
    }

    public void test07EsferaDecrementarUso3VecesExcepcion(){
        try{
            esfera1.decrementarUso();
            esfera1.decrementarUso();
            esfera1.decrementarUso();
            fail("No se lanzo ErrorNoHayUsosRestantes");
        }
        catch (ErrorConsumibleInstantaneo e1){
            fail("Se lanzo la excepcion equivocada.");
        }
    }
}