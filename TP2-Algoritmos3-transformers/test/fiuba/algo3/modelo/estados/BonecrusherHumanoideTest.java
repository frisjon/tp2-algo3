package fiuba.algo3.modelo.estados;

import org.junit.Assert;
import org.junit.Test;

public class BonecrusherHumanoideTest {
	
	@Test
	public void crearBonecrusherHumanoideTest(){
		BonecrusherHumanoide bonecrusher = new BonecrusherHumanoide();
		Assert.assertEquals(30, bonecrusher.getAtaque());
		Assert.assertEquals(3, bonecrusher.getDistanciaDeAtaque());
		Assert.assertEquals(1, bonecrusher.getVelocidad());
		Assert.assertTrue(bonecrusher.esHumanoide());
		Assert.assertFalse(bonecrusher.esAlterno());
		Assert.assertFalse(bonecrusher.esUnico());
		Assert.assertFalse(bonecrusher.esUnidadAerea());
		Assert.assertTrue(bonecrusher.esUnidadTerrestre());
	}
	
	@Test
	public void bonecrusherAtraviesaPantanoTest(){
		BonecrusherHumanoide bonecrusher = new BonecrusherHumanoide();
		Assert.assertFalse(bonecrusher.puedeAtravesarPantano());
	}
	
	@Test
	public void bonecrusherPantanoReduceVelocidadTest(){
		BonecrusherHumanoide bonecrusher = new BonecrusherHumanoide();
		Assert.assertFalse(bonecrusher.pantanoReduceVelocidad());
	}
	
	@Test
	public void bonecrusherReestableceLaVelocidad(){
		BonecrusherHumanoide bonecrusher = new BonecrusherHumanoide();
		Assert.assertEquals(1, bonecrusher.getVelocidad());
		
		bonecrusher.reducirVelocidad();
		Assert.assertEquals(0, bonecrusher.getVelocidad());
		
		bonecrusher.reestablecerVelocidad();
		Assert.assertEquals(1, bonecrusher.getVelocidad());
	}
	
	@Test
	public void bonecrusherReduceLaVelocidad(){
		BonecrusherHumanoide bonecrusher = new BonecrusherHumanoide();
		Assert.assertEquals(1, bonecrusher.getVelocidad());
		bonecrusher.reducirVelocidad();
		Assert.assertEquals(0, bonecrusher.getVelocidad());		
	}
}
