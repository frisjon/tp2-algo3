package fiuba.algo3.modelo.estados;

import org.junit.Assert;
import org.junit.Test;

public class BumblebeeAlternoTest {


	@Test
	public void crearBumblebeeAlternoTest(){
		BumblebeeAlterno bumblebee = new BumblebeeAlterno();
		Assert.assertEquals(20, bumblebee.getAtaque());
		Assert.assertEquals(3, bumblebee.getDistanciaDeAtaque());
		Assert.assertEquals(5, bumblebee.getVelocidad());
		Assert.assertTrue(bumblebee.esAlterno());
		Assert.assertFalse(bumblebee.esHumanoide());
		Assert.assertFalse(bumblebee.esUnico());
		Assert.assertFalse(bumblebee.esUnidadAerea());
		Assert.assertTrue(bumblebee.esUnidadTerrestre());
	}
	
	@Test
	public void bumblebeeAtraviesaPantanoTest(){
		BumblebeeAlterno bumblebee = new BumblebeeAlterno();
		Assert.assertTrue(bumblebee.puedeAtravesarPantano());
	}
	
	@Test
	public void bumblebeePantanoReduceVelocidadTest(){
		BumblebeeAlterno bumblebee = new BumblebeeAlterno();
		Assert.assertTrue(bumblebee.pantanoReduceVelocidad());
	}
	
	@Test
	public void bumblebeeReestableceLaVelocidad(){
		BumblebeeAlterno bumblebee = new BumblebeeAlterno();
		Assert.assertEquals(5, bumblebee.getVelocidad());
		
		bumblebee.reducirVelocidad();
		Assert.assertEquals(4, bumblebee.getVelocidad());
		bumblebee.reducirVelocidad();
		Assert.assertEquals(3, bumblebee.getVelocidad());
		
		bumblebee.reestablecerVelocidad();
		Assert.assertEquals(5, bumblebee.getVelocidad());
	}
	
	@Test
	public void bumblebeeReduceLaVelocidad(){
		BumblebeeAlterno bumblebee = new BumblebeeAlterno();
		Assert.assertEquals(5, bumblebee.getVelocidad());
		bumblebee.reducirVelocidad();
		Assert.assertEquals(4, bumblebee.getVelocidad());
		bumblebee.reducirVelocidad();
		Assert.assertEquals(3, bumblebee.getVelocidad());
		bumblebee.reducirVelocidad();
		Assert.assertEquals(2, bumblebee.getVelocidad());
		bumblebee.reducirVelocidad();
		Assert.assertEquals(1, bumblebee.getVelocidad());
		bumblebee.reducirVelocidad();
		Assert.assertEquals(0, bumblebee.getVelocidad());
		
	}
}
