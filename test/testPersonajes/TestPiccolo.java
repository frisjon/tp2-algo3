package testPersonajes;

import personajes.ErrorCambiarEstadoCondicionesNoCumplidas;
import personajes.Piccolo;
import personajes.Gohan;

import org.junit.Test;

import static org.junit.Assert.*;

import org.junit.Before;

public class TestPiccolo{
    private Piccolo piccolo;

    @Before
    public void setUp() {
        piccolo = new Piccolo();
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
        } catch (ErrorCambiarEstadoCondicionesNoCumplidas e1) {
            fail("Error Inesperado");
        }
        assertEquals(2, piccolo.getIdEstado());
    }

    @Test (expected=ErrorCambiarEstadoCondicionesNoCumplidas.class)
    public void test05CambiarPiccoloAEstado2KiInsuficienteLanzaExcepcion() throws ErrorCambiarEstadoCondicionesNoCumplidas {
        piccolo.cambiarAEstado2();
    }

    @Test
    public void test06CambiarPiccoloAEstado3() {
    	Gohan gohan = new Gohan();
    	piccolo.setProtegido(gohan);
    	gohan.quitarVida(211);
        try {
            piccolo.cambiarAEstado3();
        } catch (ErrorCambiarEstadoCondicionesNoCumplidas e1) {
            fail("Error Inesperado");
        }
        assertEquals(3, piccolo.getIdEstado());
    }

    @Test (expected=ErrorCambiarEstadoCondicionesNoCumplidas.class)
    public void test07CambiarPiccoloAEstado3KiInsuficienteLanzaExcepcion() throws ErrorCambiarEstadoCondicionesNoCumplidas {
        piccolo.cambiarAEstado3();
    }
}

