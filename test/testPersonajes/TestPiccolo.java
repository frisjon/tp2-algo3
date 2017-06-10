package testPersonajes;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

import personajes.ErrorNoPuedeCambiarEstado;
import personajes.Piccolo;
import personajes.Gohan;

public class TestPiccolo{
    
    private Piccolo piccolo;
    private Gohan gohan;

    @Before
    public void setUp() {
        piccolo = new Piccolo();
        gohan = new Gohan();
        
        piccolo.setProtegido(gohan);
    }

    @Test
    public void test01CrearPiccolo() {
        assertEquals("Piccolo", piccolo.getNombre());
    }

    @Test
    public void test02PiccoloEmpiezaEnEstado1() {
        assertEquals(1, piccolo.getIdEstado());
    }

    @Test
    public void test03CambiarPiccoloAEstado1() {
        piccolo.cambiarAEstado1();
        assertEquals(1, piccolo.getIdEstado());
    }

    @Test
    public void test04CambiarPiccoloAEstado2() {
    	piccolo.agregarKi(20);
        try {
            piccolo.cambiarAEstado2();
        } catch (ErrorNoPuedeCambiarEstado e1) {
            fail("Error Inesperado");
        }
        assertEquals(2, piccolo.getIdEstado());
    }

    @Test (expected=ErrorNoPuedeCambiarEstado.class)
    public void test05CambiarPiccoloAEstado2KiInsuficienteLanzaExcepcion() throws ErrorNoPuedeCambiarEstado {
        piccolo.agregarKi(19);
        piccolo.cambiarAEstado2();
    }

    @Test
    public void test06CambiarPiccoloAEstado3() throws ErrorNoPuedeCambiarEstado {
    	gohan.quitarVida(241);
        try {
            piccolo.cambiarAEstado3();
        } catch (ErrorNoPuedeCambiarEstado e1) {
            fail("Error Inesperado");
        }
        assertEquals(3, piccolo.getIdEstado());
    }

    @Test (expected=ErrorNoPuedeCambiarEstado.class)
    public void test07CambiarPiccoloAEstado3KiInsuficienteLanzaExcepcion() throws ErrorNoPuedeCambiarEstado {
        piccolo.cambiarAEstado3();
    }
   
}

