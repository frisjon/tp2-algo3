package testPersonajes;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import modelo.equipo.PosibleEquipo;
import modelo.personajes.ErrorNoPuedeCambiarEstado;
import modelo.personajes.Freezer;

public class TestFreezer{
    
    private Freezer freezer;

    @Before
    public void setUp() {
        freezer = new Freezer(PosibleEquipo.enemigos);
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
    	freezer.cambiarAEstado2();

        assertEquals(2, freezer.getIdEstado());
    }

    @Test (expected=ErrorNoPuedeCambiarEstado.class)
    public void test05CambiarFreezerAEstado2KiInsuficienteLanzaExcepcion() throws ErrorNoPuedeCambiarEstado {
        freezer.cambiarAEstado2();
    }

    @Test
    public void test06CambiarFreezerAEstado3() {
    	freezer.agregarKi(50);
        freezer.cambiarAEstado3();

        assertEquals(3, freezer.getIdEstado());
    }

    @Test (expected=ErrorNoPuedeCambiarEstado.class)
    public void test07CambiarFreezerAEstado3KiInsuficienteLanzaExcepcion() throws ErrorNoPuedeCambiarEstado {
        freezer.cambiarAEstado3();
    }

    @Test
    public void test08() {

    }
}

