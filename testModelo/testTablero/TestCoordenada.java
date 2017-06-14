package testTablero;

import org.junit.Test;
import org.junit.Assert;
import junit.framework.*;
import modelo.tablero.Coordenada;

public class TestCoordenada extends TestCase {
	
	@Test
	public void test01VerificarCoordenadaX() {
		Coordenada coordenada = new Coordenada(20, 25);
		Assert.assertEquals(coordenada.getX(), 20);
		
	}
	
	@Test
	public void test02VerificarCoordenadaY() {
		Coordenada coordenada = new Coordenada(20, 25);
		Assert.assertEquals(coordenada.getY(), 25);
	}
}
