package testPersonajes;

import personajes.ErrorCambiarEstadoCondicionesNoCumplidas;
import personajes.Gohan;

import org.junit.Test;

import static org.junit.Assert.*;

import org.junit.Before;

public class TestGohan {
    private Gohan gohan;

    @Before
    public void setUp() {
        gohan = new Gohan();
    }

    @Test
    public void test01CrearGohan() {
        assertEquals("Gohan", gohan.getNombre());
    }

    @Test
    public void test02GohanEmpiezaEnEstado1() {
        assertEquals(1, gohan.getIdEstado());
    }

    @Test
    public void test03CambiarGohanAEstado1() {
        gohan.cambiarAEstado1();
        assertEquals(1, gohan.getIdEstado());
    }

    @Test
    public void test04CambiarGohanAEstado2() {
        try {
            gohan.agregarKi(10);
            gohan.cambiarAEstado2();
        } catch (ErrorCambiarEstadoCondicionesNoCumplidas e1) {
            fail("Error Inesperado");
        }
        assertEquals(2, gohan.getIdEstado());
    }

    @Test (expected=ErrorCambiarEstadoCondicionesNoCumplidas.class)
    public void test05CambiarGohanAEstado2KiInsuficienteLanzaExcepcion() throws ErrorCambiarEstadoCondicionesNoCumplidas {
        try {
            gohan.cambiarAEstado2();
        } catch (ErrorCambiarEstadoCondicionesNoCumplidas e1) {
            throw e1;
        }
        fail("Error Inesperado");
    }

    @Test
    public void test06CambiarGohanAEstado3() {
        try {
            gohan.agregarKi(30);
            gohan.cambiarAEstado3();
        } catch (ErrorCambiarEstadoCondicionesNoCumplidas e1) {
            fail("Error Inesperado");
        }
        assertEquals(3, gohan.getIdEstado());
    }

    @Test (expected=ErrorCambiarEstadoCondicionesNoCumplidas.class)
    public void test07CambiarGohanAEstado3KiInsuficienteLanzaExcepcion() throws ErrorCambiarEstadoCondicionesNoCumplidas {
        try {
            gohan.cambiarAEstado3();
        } catch (ErrorCambiarEstadoCondicionesNoCumplidas e1) {
            throw e1;
        }
        fail("Error Inesperado");
    }

    @Test
    public void test08() {

    }
}

