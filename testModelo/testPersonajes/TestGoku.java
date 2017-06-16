package testPersonajes;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import modelo.consumibles.ErrorConsumibleInstantaneo;
import modelo.pelea.Pelea;
import modelo.personajes.Cell;
import modelo.personajes.ErrorNoPuedeCambiarEstado;
import modelo.personajes.Goku;

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
        goku.cambiarAEstado2();
        assertEquals(2, goku.getIdEstado());
    }

    @Test (expected=ErrorNoPuedeCambiarEstado.class)
    public void test05CambiarGokuAEstado2KiInsuficienteLanzaExcepcion() throws ErrorNoPuedeCambiarEstado {
    	goku.cambiarAEstado2();
    }

    @Test
    public void test06CambiarGokuAEstado3() {
    	goku.agregarKi(50);
    	goku.cambiarAEstado3();

        assertEquals(3, goku.getIdEstado());
    }

    @Test (expected=ErrorNoPuedeCambiarEstado.class)
    public void test07CambiarGokuAEstado3KiInsuficienteLanzaExcepcion() throws ErrorNoPuedeCambiarEstado {
        goku.cambiarAEstado3();
    }
    
    @Test
    public void test08GokuHaceDanioConAtaqueBasico() {
    	Cell cell = new Cell();
    	int vida_cell;
		
		Pelea.ataqueBasico(goku, cell);

		vida_cell = (int) cell.getVida();
		Assert.assertEquals(vida_cell, 480);
    }
}

