package testPersonajes;

import personajes.ErrorCambiarEstadoCondicionesNoCumplidas;
import personajes.MajinBoo;

import org.junit.Test;

import static org.junit.Assert.*;

import org.junit.Before;

public class TestMajinBoo{
    private MajinBoo majinboo;

    @Before
    public void setUp() {
        majinboo = new MajinBoo();
    }

    @Test
    public void test01CrearMajinBoo() {
        assertEquals("MajinBoo", majinboo.getNombre());
    }

    @Test
    public void test02MajinBooEmpiezaEnEstado1() {
        assertEquals(1, majinboo.getIdEstado());
    }

    @Test
    public void test03CambiarMajinBooAEstado1() {
        majinboo.cambiarAEstado1();
        assertEquals(1, majinboo.getIdEstado());
    }

    @Test
    public void test04CambiarMajinBooAEstado2() {
    	majinboo.agregarKi(20);
        try {
            majinboo.cambiarAEstado2();
        } catch (ErrorCambiarEstadoCondicionesNoCumplidas e1) {
            fail("Error Inesperado");
        }
        assertEquals(2, majinboo.getIdEstado());
    }

    @Test (expected=ErrorCambiarEstadoCondicionesNoCumplidas.class)
    public void test05CambiarMajinBooAEstado2KiInsuficienteLanzaExcepcion() throws ErrorCambiarEstadoCondicionesNoCumplidas {
        majinboo.cambiarAEstado2();
    }

    @Test
    public void test06CambiarMajinBooAEstado3() {
    	majinboo.agregarKi(50);
        try {
            majinboo.cambiarAEstado3();
        } catch (ErrorCambiarEstadoCondicionesNoCumplidas e1) {
            fail("Error Inesperado");
        }
        assertEquals(3, majinboo.getIdEstado());
    }

    @Test (expected=ErrorCambiarEstadoCondicionesNoCumplidas.class)
    public void test07CambiarMajinBooAEstado3KiInsuficienteLanzaExcepcion() throws ErrorCambiarEstadoCondicionesNoCumplidas {
        majinboo.cambiarAEstado3();
    }

    @Test
    public void test08() {

    }
}

