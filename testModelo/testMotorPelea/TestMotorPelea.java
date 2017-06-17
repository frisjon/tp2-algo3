package testMotorPelea;

import junit.framework.*;
import modelo.consumibles.Esfera;
import modelo.consumibles.Nube;
import modelo.pelea.ErrorNoHayKi;
import modelo.pelea.ErrorNoSePuedeRealizarAtaqueEspecial;
import modelo.pelea.Pelea;
import modelo.personajes.*;

public class TestMotorPelea extends TestCase{
    private Gohan gohan1;
    private Freezer freezer1;
    private Esfera esfera;
    private Nube nube;

    @Override
    protected void setUp() throws Exception{
        super.setUp();
        this.gohan1 = new Gohan();
        this.freezer1 = new Freezer();
        this.esfera = new Esfera();
        this.nube = new Nube();
    }
    
    public void test01PeleaGohanAtacaBasicoAFreezerSinModificadores(){
        Pelea.ataqueBasico(gohan1, freezer1);
        
        assertEquals(gohan1.getVida(), 300.0);
        assertEquals(gohan1.getKi(), 0.0);
        assertEquals(freezer1.getVida(), 388.0);
        assertEquals(freezer1.getKi(), 0.0);
    }
    
    public void test02PeleaFreezerAtacaBasicoAGohanSinModificadores(){
        Pelea.ataqueBasico(freezer1, gohan1);

        assertEquals(freezer1.getVida(), 400.0);
        assertEquals(freezer1.getKi(), 0.0);
        assertEquals(gohan1.getVida(), 280.0);
        assertEquals(gohan1.getKi(), 0.0);
    }
    
    public void test03PeleaGohanAtacaEspecialAFreezerSinModificadores(){
        gohan1.agregarKi(20.0);

        Pelea.ataqueEspecial(gohan1, freezer1);
        assertEquals(gohan1.getVida(), 300.0);
        assertEquals(gohan1.getKi(), 10.0);
        assertEquals(freezer1.getVida(), 385.0);
        assertEquals(freezer1.getKi(), 0.0);
    }
    
    public void test04PeleaFreezerAtacaEspecialAGohanSinModificadores(){
        freezer1.agregarKi(20.0);
        Pelea.ataqueEspecial(freezer1, gohan1);

        assertEquals(freezer1.getVida(), 400.0);
        assertEquals(freezer1.getKi(), 0.0);
        assertEquals(gohan1.getVida(), 270.0);
        assertEquals(gohan1.getKi(), 0.0);
    }
    
    public void test05PeleaGohanAtacaEspecialAFreezerSinKi(){
        try {
            Pelea.ataqueEspecial(gohan1, freezer1);
            fail("No lanzo la excepcion esperada.");
        }
        catch (ErrorNoSePuedeRealizarAtaqueEspecial e1){
            fail("No se lanzo la excepcion esperada.");
        }
        catch (ErrorNoHayKi e2) {}
        
    }
    
    public void test06PeleaGohanAtacaBasicoAFreezerConEsfera(){
        gohan1.setObjeto(esfera);
        Pelea.ataqueBasico(gohan1, freezer1);
      
        assertEquals(gohan1.getVida(), 300.0);
        assertEquals(gohan1.getKi(), 0.0);
        assertEquals(freezer1.getVida(), 385.0);
        assertEquals(freezer1.getKi(), 0.0);
    }
    
    public void test07PeleaFreezerAtacaEspecialAGohanConEsfera(){
        freezer1.setObjeto(esfera);
        freezer1.agregarKi(20.0);
        Pelea.ataqueEspecial(freezer1, gohan1);
      
        assertEquals(freezer1.getVida(), 400.0);
        assertEquals(freezer1.getKi(), 0.0);
        assertEquals(gohan1.getVida(), 262.5);
        assertEquals(gohan1.getKi(), 0.0);
    }
    
    public void test08PeleaGohanSSJAtacaEspecialAFreezer(){
        gohan1.agregarKi(20.0);
        gohan1.cambiarAEstado2();
       
        Pelea.ataqueEspecial(gohan1, freezer1);
     
        assertEquals(gohan1.getVida(), 300.0);
        assertEquals(gohan1.getKi(), 0.0);
        assertEquals(freezer1.getVida(), 362.5);
        assertEquals(freezer1.getKi(), 0.0);
    }
    
    public void test09PeleaFreezerConEsferaDecrementaUso(){
        freezer1.setObjeto(esfera);
        Pelea.ataqueBasico(freezer1, gohan1);
        
        assertEquals(freezer1.getObjetos().getCantidadUsosRestantes(), 1);
    }
    
    public void test10PeleaFreezerConEsferaAtaca2VecesEliminaConsumible(){
        freezer1.setObjeto(esfera);
        Pelea.ataqueBasico(freezer1, gohan1);
        Pelea.ataqueBasico(freezer1, gohan1);
        
        assertEquals(freezer1.tieneObjeto(), false);
    }
    
    public void test11PeleaFreezerConNubeNoDecrementaUso(){
        freezer1.setObjeto(nube);
        Pelea.ataqueBasico(freezer1, gohan1);
        
        assertEquals(freezer1.getObjetos().getCantidadUsosRestantes(), 2);
    }
}
