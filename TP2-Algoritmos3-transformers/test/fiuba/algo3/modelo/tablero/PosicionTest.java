package fiuba.algo3.modelo.tablero;

import org.junit.Assert;
import org.junit.Test;

public class PosicionTest {

	@Test
	public void compararPosicionesTest(){
		Posicion posicion1 = new Posicion(0,0);
		Posicion posicion2 = new Posicion(40,20);
		Posicion posicion3 = new Posicion(0,0);
		
		Assert.assertTrue(posicion1.equals(posicion1));
		Assert.assertFalse(posicion1.equals(posicion2));
		Assert.assertTrue(posicion1.equals(posicion3));
		
	}
	
	@Test
	public void sumarDireccionesTest(){
		Posicion posicion1 = new Posicion(1,5);
		Posicion posicion2 = new Posicion(40,20);
		Posicion posicion3 = new Posicion(15,10);
		
		Assert.assertEquals(new Posicion(2,10),posicion1.devolverSuma(posicion1));
		Assert.assertEquals(new Posicion(41,25),posicion1.devolverSuma(posicion2));
		Assert.assertEquals(new Posicion(16,15),posicion1.devolverSuma(posicion3));
		
	}
	
	@Test
	public void devolverStringTest(){
		Posicion posicion1 = new Posicion(1,5);
		Posicion posicion2 = new Posicion(40,20);
		Posicion posicion3 = new Posicion(15,10);
		
		Assert.assertEquals("(1,5)",posicion1.toString());
		Assert.assertEquals("(40,20)",posicion2.toString());
		Assert.assertEquals("(15,10)",posicion3.toString());
		
	}
	
	@Test
	public void devolverDistanciaTest(){
		Posicion posicion1 = new Posicion(1,5);
		Posicion posicion2 = new Posicion(40,20);
		Posicion posicion3 = new Posicion(15,10);
		
		Assert.assertEquals(0,posicion1.distanciaA(posicion1));
		Assert.assertEquals(39,posicion1.distanciaA(posicion2));
		Assert.assertEquals(14,posicion1.distanciaA(posicion3));
		
		Assert.assertEquals(39,posicion2.distanciaA(posicion1));
		Assert.assertEquals(0,posicion2.distanciaA(posicion2));
		Assert.assertEquals(25,posicion2.distanciaA(posicion3));
		
		Assert.assertEquals(14,posicion3.distanciaA(posicion1));
		Assert.assertEquals(25,posicion3.distanciaA(posicion2));
		Assert.assertEquals(0,posicion3.distanciaA(posicion3));
		
	}
	
}
