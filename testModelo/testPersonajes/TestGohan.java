package testPersonajes;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

import modelo.personajes.ErrorNoPuedeCambiarEstado;
import modelo.personajes.Gohan;
import modelo.personajes.Goku;
import modelo.personajes.Piccolo;

public class TestGohan {
    
    private Gohan gohan;
    private Goku goku;
    private Piccolo piccolo;

    @Before
    public void setUp() {
        gohan = new Gohan();
        goku = new Goku();
        piccolo = new Piccolo();
        
        gohan.setAliado1(goku);
        gohan.setAliado2(piccolo);
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
        gohan.agregarKi(10);
        try {
            gohan.cambiarAEstado2();
        } catch (ErrorNoPuedeCambiarEstado e1) {
            fail("Error Inesperado");
        }
        assertEquals(2, gohan.getIdEstado());
    }

    @Test (expected=ErrorNoPuedeCambiarEstado.class)
    public void test05CambiarGohanAEstado2KiInsuficienteLanzaExcepcion() throws ErrorNoPuedeCambiarEstado {
        gohan.agregarKi(9);
    	gohan.cambiarAEstado2();
    }

    @Test
    public void test06CambiarGohanAEstado3() {
    	gohan.agregarKi(30);
    	goku.quitarVida(351);
    	piccolo.quitarVida(351);
        try {
            gohan.cambiarAEstado3();
        } catch (ErrorNoPuedeCambiarEstado e1) {
            fail("Error Inesperado");
        }
        assertEquals(3, gohan.getIdEstado());
    }

    @Test (expected=ErrorNoPuedeCambiarEstado.class)
    public void test07CambiarGohanAEstado3KiInsuficienteLanzaExcepcion() throws ErrorNoPuedeCambiarEstado {
        gohan.agregarKi(29);
        gohan.cambiarAEstado3();
    }
    
    @Test (expected=ErrorNoPuedeCambiarEstado.class)
    public void test08CambiarGohanAEstado3AliadosNoDaniadosLanzaExcepcion() throws ErrorNoPuedeCambiarEstado {
        gohan.agregarKi(30);
        goku.quitarVida(350);
        piccolo.quitarVida(350);
        gohan.cambiarAEstado3();
    }
    
    @Test (expected=ErrorNoPuedeCambiarEstado.class)
    public void test09CambiarAPiccoloAEstado1YGohanNoPuedeCambiar () throws ErrorNoPuedeCambiarEstado {
        piccolo.agregarKi(10);
        piccolo.cambiarAEstado1();
        gohan.cambiarAEstado2();
    }
    
    @Test (expected=ErrorNoPuedeCambiarEstado.class)
    public void test10CambiarAPiccoloAEstado2YGohanNoPuedeCambiar () throws ErrorNoPuedeCambiarEstado {
        piccolo.agregarKi(20);
        piccolo.cambiarAEstado2();
        gohan.cambiarAEstado2();
    }

}

