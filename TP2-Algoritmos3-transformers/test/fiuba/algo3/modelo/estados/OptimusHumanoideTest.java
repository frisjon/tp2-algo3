package fiuba.algo3.modelo.estados;

import org.junit.Assert;
import org.junit.Test;

public class OptimusHumanoideTest {
	
	@Test
	public void crearOptimusHumanoideTest(){
		OptimusHumanoide otimus = new OptimusHumanoide();
		Assert.assertEquals(50, otimus.getAtaque());
		Assert.assertEquals(2, otimus.getDistanciaDeAtaque());
		Assert.assertEquals(2, otimus.getVelocidad());
		Assert.assertTrue(otimus.esHumanoide());
		Assert.assertFalse(otimus.esAlterno());
		Assert.assertFalse(otimus.esUnico());
		Assert.assertFalse(otimus.esUnidadAerea());
		Assert.assertTrue(otimus.esUnidadTerrestre());
	}
	
	@Test
	public void otimusAtraviesaPantanoTest(){
		OptimusHumanoide otimus = new OptimusHumanoide();
		Assert.assertFalse(otimus.puedeAtravesarPantano());
	}
	
	@Test
	public void otimusPantanoReduceVelocidadTest(){
		OptimusHumanoide otimus = new OptimusHumanoide();
		Assert.assertFalse(otimus.pantanoReduceVelocidad());
	}
	
	@Test
	public void otimusReestableceLaVelocidad(){
		OptimusHumanoide otimus = new OptimusHumanoide();
		Assert.assertEquals(2, otimus.getVelocidad());
		
		otimus.reducirVelocidad();
		Assert.assertEquals(1, otimus.getVelocidad());
		otimus.reducirVelocidad();
		Assert.assertEquals(0, otimus.getVelocidad());
		
		otimus.reestablecerVelocidad();
		Assert.assertEquals(2, otimus.getVelocidad());
	}
	
	@Test
	public void otimusReduceLaVelocidad(){
		OptimusHumanoide otimus = new OptimusHumanoide();
		Assert.assertEquals(2, otimus.getVelocidad());
		otimus.reducirVelocidad();
		Assert.assertEquals(1, otimus.getVelocidad());
		otimus.reducirVelocidad();
		Assert.assertEquals(0, otimus.getVelocidad());
	}
}
