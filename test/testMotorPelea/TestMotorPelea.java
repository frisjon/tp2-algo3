package testMotorPelea;

import junit.framework.*;
import motor.Pelea;
import personajes.*;

public class TestMotorPelea extends TestCase{
    private Gohan gohan1;
    private Freezer freezer1;
    private Pelea pelea;
    private Esfera esfera;
    
    @Override
    protected void setUp() throws Exception{
        super.setUp();
        this.pelea = new Pelea();
        this.gohan1 = new Gohan();
        this.freezer1 = new Freezer();
        this.esfera = new Esfera();
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
        assertEquals(freezer1.getVida(), 381.25);
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
        try{
            Pelea.ataqueEspecial(gohan1, freezer1);
            fail("No lanzo la excepcion esperada.");
        }
        catch (ErrorNoHayKi e1){
        }
    }
    
    public void test06PeleaGohanAtacaBasicoAFreezerConEsfera(){
        gohan1.agregarConsumible(esfera);
        Pelea.ataqueBasico(gohan1, freezer1);
        assertEquals(gohan1.getVida(), 300.0);
        assertEquals(gohan1.getKi(), 0.0);
        assertEquals(freezer1.getVida(), 385.0);
        assertEquals(freezer1.getKi(), 0.0);
    }
    
    public void test07PeleaFreezerAtacaEspecialAGohanConEsfera(){
        freezer1.agregarConsumible(esfera);
        freezer.agregarKi(20.0);
        Pelea.ataqueEspecial(freezer1, gohan1);
        assertEquals(freezer1.getVida(), 400.0);
        assertEquals(freezer1.getKi(), 0.0);
        assertEquals(gohan1.getVida(), 262.5);
        assertEquals(gohan1.getKi(), 0.0);
    }
    
    public void test08PeleaGohanSSJAtacaEspecialAFreezer(){
        gohan1.agregarKi(10.0);
        gohan1.transformar();
        Pelea.ataqueEspecial(gohan1, freezer1);
        assertEquals(gohan1.getVida(), 300.0);
        assertEquals(gohan1.getKi(), 0.0);
        assertEquals(freezer1.getVida(), 362.5);
        assertEquals(freezer1.getKi(), 0.0);
    }
}
