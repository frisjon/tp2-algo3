package testMotorPelea;

import consumibles.ErrorConsumibleInstantaneo;
import consumibles.Esfera;
import junit.framework.*;
import motor.ErrorNoHayKi;
import motor.ErrorNoSePuedeRealizarAtaqueEspecial;
import motor.Pelea;
import personajes.*;

public class TestMotorPelea extends TestCase{
    private Gohan gohan1;
    private Freezer freezer1;
    private Esfera esfera;
    
    @Override
    protected void setUp() throws Exception{
        super.setUp();
        this.gohan1 = new Gohan();
        this.freezer1 = new Freezer();
        this.esfera = new Esfera();
    }
    
    public void test01PeleaGohanAtacaBasicoAFreezerSinModificadores(){
        try {
            Pelea.ataqueBasico(gohan1, freezer1);
        } catch (ErrorConsumibleInstantaneo e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        assertEquals(gohan1.getVida(), 300.0);
        assertEquals(gohan1.getKi(), 0.0);
        assertEquals(freezer1.getVida(), 388.0);
        assertEquals(freezer1.getKi(), 0.0);
    }
    
    public void test02PeleaFreezerAtacaBasicoAGohanSinModificadores(){
        try {
            Pelea.ataqueBasico(freezer1, gohan1);
        } catch (ErrorConsumibleInstantaneo e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        assertEquals(freezer1.getVida(), 400.0);
        assertEquals(freezer1.getKi(), 0.0);
        assertEquals(gohan1.getVida(), 280.0);
        assertEquals(gohan1.getKi(), 0.0);
    }
    
    public void test03PeleaGohanAtacaEspecialAFreezerSinModificadores(){
        gohan1.agregarKi(20.0);
        try {
            Pelea.ataqueEspecial(gohan1, freezer1);
        } catch (ErrorNoHayKi e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ErrorNoSePuedeRealizarAtaqueEspecial e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ErrorConsumibleInstantaneo e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        assertEquals(gohan1.getVida(), 300.0);
        assertEquals(gohan1.getKi(), 10.0);
        assertEquals(freezer1.getVida(), 385.0);
        assertEquals(freezer1.getKi(), 0.0);
    }
    
    public void test04PeleaFreezerAtacaEspecialAGohanSinModificadores(){
        freezer1.agregarKi(20.0);
        try {
            Pelea.ataqueEspecial(freezer1, gohan1);
        } catch (ErrorNoHayKi e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ErrorNoSePuedeRealizarAtaqueEspecial e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ErrorConsumibleInstantaneo e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        assertEquals(freezer1.getVida(), 400.0);
        assertEquals(freezer1.getKi(), 0.0);
        assertEquals(gohan1.getVida(), 270.0);
        assertEquals(gohan1.getKi(), 0.0);
    }
    
    public void test05PeleaGohanAtacaEspecialAFreezerSinKi(){
        try {
            Pelea.ataqueEspecial(gohan1, freezer1);
            fail("No lanzo la excepcion esperada.");
        } catch (ErrorNoHayKi e) {
        } catch (ErrorNoSePuedeRealizarAtaqueEspecial e) {
            fail("No lanzo la excepcion correcta.");
        } catch (ErrorConsumibleInstantaneo e) {
            fail("No lanzo la excepcion correcta.");
        }
    }
    
    public void test06PeleaGohanAtacaBasicoAFreezerConEsfera(){
        gohan1.setConsumible(esfera);
        try {
            Pelea.ataqueBasico(gohan1, freezer1);
        } catch (ErrorConsumibleInstantaneo e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        assertEquals(gohan1.getVida(), 300.0);
        assertEquals(gohan1.getKi(), 0.0);
        assertEquals(freezer1.getVida(), 385.0);
        assertEquals(freezer1.getKi(), 0.0);
    }
    
    public void test07PeleaFreezerAtacaEspecialAGohanConEsfera(){
        freezer1.setConsumible(esfera);
        freezer1.agregarKi(20.0);
        try {
            Pelea.ataqueEspecial(freezer1, gohan1);
        } catch (ErrorNoHayKi e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ErrorNoSePuedeRealizarAtaqueEspecial e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ErrorConsumibleInstantaneo e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        assertEquals(freezer1.getVida(), 400.0);
        assertEquals(freezer1.getKi(), 0.0);
        assertEquals(gohan1.getVida(), 262.5);
        assertEquals(gohan1.getKi(), 0.0);
    }
    
    public void test08PeleaGohanSSJAtacaEspecialAFreezer(){
        gohan1.agregarKi(20.0);
        try {
            gohan1.cambiarAEstado2();
        } catch (ErrorNoPuedeCambiarEstado e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        try {
            Pelea.ataqueEspecial(gohan1, freezer1);
        } catch (ErrorNoHayKi e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ErrorNoSePuedeRealizarAtaqueEspecial e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ErrorConsumibleInstantaneo e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        assertEquals(gohan1.getVida(), 300.0);
        assertEquals(gohan1.getKi(), 0.0);
        assertEquals(freezer1.getVida(), 362.5);
        assertEquals(freezer1.getKi(), 0.0);
    }
}
