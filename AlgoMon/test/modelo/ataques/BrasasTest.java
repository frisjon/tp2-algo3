package modelo.ataques;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;


public class BrasasTest {
    @Test
    public void testCrearNoDevuelveNull() {
        Brasas brasas = new Brasas();
        assertNotNull(brasas);
    }

    @Test
    public void testCantidadInicial() {
        Brasas brasas = new Brasas();
        assertEquals(10,brasas.cantidadInicial());
    }

}