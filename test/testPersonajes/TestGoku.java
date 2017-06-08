package testPersonajes;

import personajes.ErrorCambiarEstadoCondicionesNoCumplidas;
import personajes.Goku;

import org.junit.Test;

import static org.junit.Assert.*;

import org.junit.Before;

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
        } catch (ErrorCambiarEstadoCondicionesNoCumplidas e1) {
            fail("Error Inesperado");
        }
        assertEquals(2, goku.getIdEstado());
    }

    @Test (expected=ErrorCambiarEstadoCondicionesNoCumplidas.class)
    public void test05CambiarGokuAEstado2KiInsuficienteLanzaExcepcion() throws ErrorCambiarEstadoCondicionesNoCumplidas {
    	goku.cambiarAEstado2();
    }

    @Test
    public void test06CambiarGokuAEstado3() {
    	goku.agregarKi(50);
        try {
            goku.cambiarAEstado3();
        } catch (ErrorCambiarEstadoCondicionesNoCumplidas e1) {
            fail("Error Inesperado");
        }
        assertEquals(3, goku.getIdEstado());
    }

    @Test (expected=ErrorCambiarEstadoCondicionesNoCumplidas.class)
    public void test07CambiarGokuAEstado3KiInsuficienteLanzaExcepcion() throws ErrorCambiarEstadoCondicionesNoCumplidas {
        goku.cambiarAEstado3();
    }

    @Test
    public void test08() {

    }
}

