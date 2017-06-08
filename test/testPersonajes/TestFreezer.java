package testPersonajes;

import personajes.ErrorCambiarEstadoCondicionesNoCumplidas;
import personajes.Freezer;

import org.junit.Test;

import static org.junit.Assert.*;

import org.junit.Before;

public class TestFreezer{
    private Freezer freezer;

    @Before
    public void setUp() {
        freezer = new Freezer();
    }

    @Test
    public void test01CrearFreezer() {
        assertEquals("Freezer", freezer.getNombre());
    }

    @Test
    public void test02FreezerEmpiezaEnEstado1() {
        assertEquals(1, freezer.getIdEstado());
    }

    @Test
    public void test03CambiarFreezerAEstado1() {
        freezer.cambiarAEstado1();
        assertEquals(1, freezer.getIdEstado());
    }

    @Test
    public void test04CambiarFreezerAEstado2() {
    	freezer.agregarKi(20);
        try {
            freezer.cambiarAEstado2();
        } catch (ErrorCambiarEstadoCondicionesNoCumplidas e1) {
            fail("Error Inesperado");
        }
        assertEquals(2, freezer.getIdEstado());
    }

    @Test (expected=ErrorCambiarEstadoCondicionesNoCumplidas.class)
    public void test05CambiarFreezerAEstado2KiInsuficienteLanzaExcepcion() throws ErrorCambiarEstadoCondicionesNoCumplidas {
        freezer.cambiarAEstado2();
    }

    @Test
    public void test06CambiarFreezerAEstado3() {
    	freezer.agregarKi(50);
        try {
            freezer.cambiarAEstado3();
        } catch (ErrorCambiarEstadoCondicionesNoCumplidas e1) {
            fail("Error Inesperado");
        }
        assertEquals(3, freezer.getIdEstado());
    }

    @Test (expected=ErrorCambiarEstadoCondicionesNoCumplidas.class)
    public void test07CambiarFreezerAEstado3KiInsuficienteLanzaExcepcion() throws ErrorCambiarEstadoCondicionesNoCumplidas {
        freezer.cambiarAEstado3();
    }

    @Test
    public void test08() {

    }
}

