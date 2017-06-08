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
        try {
            freezer.agregarKi(20);
            freezer.cambiarAEstado2();
        } catch (ErrorCambiarEstadoCondicionesNoCumplidas e1) {
            fail("Error Inesperado");
        }
        assertEquals(2, freezer.getIdEstado());
    }

    @Test (expected=ErrorCambiarEstadoCondicionesNoCumplidas.class)
    public void test05CambiarFreezerAEstado2KiInsuficienteLanzaExcepcion() throws ErrorCambiarEstadoCondicionesNoCumplidas {
        try {
            freezer.cambiarAEstado2();
        } catch (ErrorCambiarEstadoCondicionesNoCumplidas e1) {
            throw e1;
        }
        fail("Error Inesperado");
    }

    @Test
    public void test06CambiarFreezerAEstado3() {
        try {
            freezer.agregarKi(50);
            freezer.cambiarAEstado3();
        } catch (ErrorCambiarEstadoCondicionesNoCumplidas e1) {
            fail("Error Inesperado");
        }
        assertEquals(3, freezer.getIdEstado());
    }

    @Test (expected=ErrorCambiarEstadoCondicionesNoCumplidas.class)
    public void test07CambiarFreezerAEstado3KiInsuficienteLanzaExcepcion() throws ErrorCambiarEstadoCondicionesNoCumplidas {
        try {
            freezer.cambiarAEstado3();
        } catch (ErrorCambiarEstadoCondicionesNoCumplidas e1) {
            throw e1;
        }
        fail("Error Inesperado");
    }

    @Test
    public void test08() {

    }
}

