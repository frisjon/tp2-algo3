package modelo.ataques;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class FogonazoTest {

    @Test
    public void testCrearNoDevuelveNull() {
        Fogonazo fogonazo = new Fogonazo();
        assertNotNull(fogonazo);
    }

    @Test
    public void testCantidadInicial() {
        Fogonazo fogonazo = new Fogonazo();
        assertEquals(4,fogonazo.cantidadInicial());
    }

}