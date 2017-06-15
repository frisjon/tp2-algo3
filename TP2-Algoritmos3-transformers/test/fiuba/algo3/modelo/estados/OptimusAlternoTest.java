package fiuba.algo3.modelo.estados;

import org.junit.Assert;
import org.junit.Test;

public class OptimusAlternoTest {
	
	@Test
	public void crearOptimusAlternoTest(){
		OptimusAlterno optimus = new OptimusAlterno();
		Assert.assertEquals(15, optimus.getAtaque());
		Assert.assertEquals(4, optimus.getDistanciaDeAtaque());
		Assert.assertEquals(5, optimus.getVelocidad());
		Assert.assertTrue(optimus.esAlterno());
		Assert.assertFalse(optimus.esHumanoide());
		Assert.assertFalse(optimus.esUnico());
		Assert.assertFalse(optimus.esUnidadAerea());
		Assert.assertTrue(optimus.esUnidadTerrestre());
	}
	
	@Test
	public void optimusAtraviesaPantanoTest(){
		OptimusAlterno optimus = new OptimusAlterno();
		Assert.assertTrue(optimus.puedeAtravesarPantano());
	}
	
	@Test
	public void optimusPantanoReduceVelocidadTest(){
		OptimusAlterno optimus = new OptimusAlterno();
		Assert.assertTrue(optimus.pantanoReduceVelocidad());
	}
	
	@Test
	public void optimusReestableceLaVelocidad(){
		OptimusAlterno optimus = new OptimusAlterno();
		Assert.assertEquals(5, optimus.getVelocidad());
		
		optimus.reducirVelocidad();
		Assert.assertEquals(4, optimus.getVelocidad());
		optimus.reducirVelocidad();
		Assert.assertEquals(3, optimus.getVelocidad());
		
		optimus.reestablecerVelocidad();
		Assert.assertEquals(5, optimus.getVelocidad());
	}
	
	@Test
	public void optimusReduceLaVelocidad(){
		OptimusAlterno optimus = new OptimusAlterno();
		Assert.assertEquals(5, optimus.getVelocidad());
		optimus.reducirVelocidad();
		Assert.assertEquals(4, optimus.getVelocidad());
		optimus.reducirVelocidad();
		Assert.assertEquals(3, optimus.getVelocidad());
		optimus.reducirVelocidad();
		Assert.assertEquals(2, optimus.getVelocidad());
		optimus.reducirVelocidad();
		Assert.assertEquals(1, optimus.getVelocidad());
		optimus.reducirVelocidad();
		Assert.assertEquals(0, optimus.getVelocidad());
		
	}
}
