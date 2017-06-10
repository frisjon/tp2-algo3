package testTablero;

import org.junit.Test;
import org.junit.Assert;
import junit.framework.*;
import tablero.Tablero;

public class TestTablero extends TestCase {
	
	@Test
	public void test01BuscarExtremoIzquierdo() {
		Tablero tablero = new Tablero(20,20);
		Assert.assertEquals(tablero.buscarExtremo(0).getCoordenada().getX(), 0);
		Assert.assertEquals(tablero.buscarExtremo(0).getCoordenada().getY(), 0);
	}
	
	@Test
	public void test01BuscarExtremoDerecho() {
		Tablero tablero = new Tablero(20,20);
		Assert.assertEquals(tablero.buscarExtremo(1).getCoordenada().getX(), 19);
		Assert.assertEquals(tablero.buscarExtremo(1).getCoordenada().getY(), 0);
	}
}
