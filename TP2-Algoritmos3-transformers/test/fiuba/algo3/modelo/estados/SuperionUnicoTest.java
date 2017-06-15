package fiuba.algo3.modelo.estados;

import org.junit.Assert;
import org.junit.Test;

public class SuperionUnicoTest {

	@Test
	public void crearSuperionUnicoTest(){
		SuperionUnico superion = new SuperionUnico();
		Assert.assertEquals(100, superion.getAtaque());
		Assert.assertEquals(2, superion.getDistanciaDeAtaque());
		Assert.assertEquals(3, superion.getVelocidad());
		Assert.assertFalse(superion.esHumanoide());
		Assert.assertFalse(superion.esAlterno());
		Assert.assertTrue(superion.esUnico());
		Assert.assertFalse(superion.esUnidadAerea());
		Assert.assertTrue(superion.esUnidadTerrestre());
	}
	
	@Test
	public void superionAtraviesaPantanoTest(){
		SuperionUnico superion = new SuperionUnico();
		Assert.assertTrue(superion.puedeAtravesarPantano());
	}
	
	@Test
	public void superionPantanoReduceVelocidadTest(){
		SuperionUnico superion = new SuperionUnico();
		Assert.assertFalse(superion.pantanoReduceVelocidad());
	}
	
	@Test
	public void superionReestableceLaVelocidad(){
		SuperionUnico superion = new SuperionUnico();
		Assert.assertEquals(3, superion.getVelocidad());
		
		superion.reducirVelocidad();
		Assert.assertEquals(2, superion.getVelocidad());
		
		superion.reestablecerVelocidad();
		Assert.assertEquals(3, superion.getVelocidad());
	}
	
	@Test
	public void superionReduceLaVelocidad(){
		SuperionUnico superion = new SuperionUnico();
		Assert.assertEquals(3, superion.getVelocidad());
		superion.reducirVelocidad();
		Assert.assertEquals(2, superion.getVelocidad());
		superion.reducirVelocidad();
		Assert.assertEquals(1, superion.getVelocidad());
		superion.reducirVelocidad();
		Assert.assertEquals(0, superion.getVelocidad());
	}
}
