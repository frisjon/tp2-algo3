package fiuba.algo3.modelo.estados;

import org.junit.Assert;
import org.junit.Test;


public class EstadosAlternosTests {

	@Test
	public void crearBonecrusherAlternoTest(){
		BonecrusherAlterno bonecrusher = new BonecrusherAlterno();
		Assert.assertEquals(30, bonecrusher.getAtaque());
		Assert.assertEquals(3, bonecrusher.getDistanciaDeAtaque());
		Assert.assertEquals(8, bonecrusher.getVelocidad());
		Assert.assertTrue(bonecrusher.esAlterno());
		Assert.assertFalse(bonecrusher.esHumanoide());
		Assert.assertFalse(bonecrusher.esUnico());
		Assert.assertFalse(bonecrusher.esUnidadAerea());
		Assert.assertTrue(bonecrusher.esUnidadTerrestre());
	}
	
	@Test
	public void bonecrusherAtraviesaPantanoTest(){
		BonecrusherAlterno bonecrusher = new BonecrusherAlterno();
		Assert.assertTrue(bonecrusher.puedeAtravesarPantano());
	}
	
	@Test
	public void bonecrusherPantanoReduceVelocidadTest(){
		BonecrusherAlterno bonecrusher = new BonecrusherAlterno();
		Assert.assertTrue(bonecrusher.pantanoReduceVelocidad());
	}
	
	@Test
	public void bonecrusherReestableceLaVelocidad(){
		BonecrusherAlterno bonecrusher = new BonecrusherAlterno();
		Assert.assertEquals(8, bonecrusher.getVelocidad());
		
		bonecrusher.reducirVelocidad();
		Assert.assertEquals(7, bonecrusher.getVelocidad());
		bonecrusher.reducirVelocidad();
		Assert.assertEquals(6, bonecrusher.getVelocidad());
		
		bonecrusher.reestablecerVelocidad();
		Assert.assertEquals(8, bonecrusher.getVelocidad());
	}
	
	@Test
	public void bonecrusherReduceLaVelocidad(){
		BonecrusherAlterno bonecrusher = new BonecrusherAlterno();
		Assert.assertEquals(8, bonecrusher.getVelocidad());
		bonecrusher.reducirVelocidad();
		Assert.assertEquals(7, bonecrusher.getVelocidad());
		bonecrusher.reducirVelocidad();
		Assert.assertEquals(6, bonecrusher.getVelocidad());
		bonecrusher.reducirVelocidad();
		Assert.assertEquals(5, bonecrusher.getVelocidad());
		bonecrusher.reducirVelocidad();
		Assert.assertEquals(4, bonecrusher.getVelocidad());
		bonecrusher.reducirVelocidad();
		Assert.assertEquals(3, bonecrusher.getVelocidad());
		bonecrusher.reducirVelocidad();
		Assert.assertEquals(2, bonecrusher.getVelocidad());
		bonecrusher.reducirVelocidad();
		Assert.assertEquals(1, bonecrusher.getVelocidad());
		bonecrusher.reducirVelocidad();
		Assert.assertEquals(0, bonecrusher.getVelocidad());
	}
}
