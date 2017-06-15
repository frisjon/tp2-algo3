package fiuba.algo3.modelo.estados;

import org.junit.Assert;
import org.junit.Test;

public class BumblebeeHumanoideTest {
	
	@Test
	public void crearBumblebeeHumanoideTest(){
		BumblebeeHumanoide bumblebee = new BumblebeeHumanoide();
		Assert.assertEquals(40, bumblebee.getAtaque());
		Assert.assertEquals(1, bumblebee.getDistanciaDeAtaque());
		Assert.assertEquals(2, bumblebee.getVelocidad());
		Assert.assertTrue(bumblebee.esHumanoide());
		Assert.assertFalse(bumblebee.esAlterno());
		Assert.assertFalse(bumblebee.esUnico());
		Assert.assertFalse(bumblebee.esUnidadAerea());
		Assert.assertTrue(bumblebee.esUnidadTerrestre());
	}
	
	@Test
	public void bumblebeeAtraviesaPantanoTest(){
		BumblebeeHumanoide bumblebee = new BumblebeeHumanoide();
		Assert.assertFalse(bumblebee.puedeAtravesarPantano());
	}
	
	@Test
	public void bumblebeePantanoReduceVelocidadTest(){
		BumblebeeHumanoide bumblebee = new BumblebeeHumanoide();
		Assert.assertFalse(bumblebee.pantanoReduceVelocidad());
	}
	
	@Test
	public void bumblebeeReestableceLaVelocidad(){
		BumblebeeHumanoide bumblebee = new BumblebeeHumanoide();
		Assert.assertEquals(2, bumblebee.getVelocidad());
		
		bumblebee.reducirVelocidad();
		Assert.assertEquals(1, bumblebee.getVelocidad());
		bumblebee.reducirVelocidad();
		Assert.assertEquals(0, bumblebee.getVelocidad());
		
		bumblebee.reestablecerVelocidad();
		Assert.assertEquals(2, bumblebee.getVelocidad());
	}
	
	@Test
	public void bumblebeeReduceLaVelocidad(){
		BumblebeeHumanoide bumblebee = new BumblebeeHumanoide();
		Assert.assertEquals(2, bumblebee.getVelocidad());
		bumblebee.reducirVelocidad();
		Assert.assertEquals(1, bumblebee.getVelocidad());
		bumblebee.reducirVelocidad();
		Assert.assertEquals(0, bumblebee.getVelocidad());
	}
}
