package testPersonajes;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

import personajes.ErrorNoPuedeCambiarEstado;
import personajes.Goku;

public class TestGoku{
    
    private Goku goku;

    @Before
    public void setUp() {
        goku = new Goku();
    }

    @Test
    public void test01CrearGoku() {
        assertEquals("Goku", goku.getNombre());
    }

    @Test
    public void test02GokuEmpiezaEnEstado1() {
        assertEquals(1, goku.getIdEstado());
    }

    @Test
    public void test03CambiarGokuAEstado1() {
        goku.cambiarAEstado1();
        assertEquals(1, goku.getIdEstado());
    }

    @Test
    public void test04CambiarGokuAEstado2() {
    	goku.agregarKi(20);
        try {
            goku.cambiarAEstado2();
        } catch (ErrorNoPuedeCambiarEstado e1) {
            fail("Error Inesperado");
        }
        assertEquals(2, goku.getIdEstado());
    }

    @Test (expected=ErrorNoPuedeCambiarEstado.class)
    public void test05CambiarGokuAEstado2KiInsuficienteLanzaExcepcion() throws ErrorNoPuedeCambiarEstado {
    	goku.cambiarAEstado2();
    }

    @Test
    public void test06CambiarGokuAEstado3() {
    	goku.agregarKi(50);
        try {
            goku.cambiarAEstado3();
        } catch (ErrorNoPuedeCambiarEstado e1) {
            fail("Error Inesperado");
        }
        assertEquals(3, goku.getIdEstado());
    }

    @Test (expected=ErrorNoPuedeCambiarEstado.class)
    public void test07CambiarGokuAEstado3KiInsuficienteLanzaExcepcion() throws ErrorNoPuedeCambiarEstado {
        goku.cambiarAEstado3();
    }

    @Test
    public void test08() {

    }
}

