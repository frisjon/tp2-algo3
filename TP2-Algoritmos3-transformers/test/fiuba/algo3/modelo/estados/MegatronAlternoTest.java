package fiuba.algo3.modelo.estados;

import org.junit.Assert;
import org.junit.Test;

public class MegatronAlternoTest {
	
	@Test
	public void crearMegatronAlternoTest(){
		MegatronAlterno megatron = new MegatronAlterno();
		Assert.assertEquals(55, megatron.getAtaque());
		Assert.assertEquals(2, megatron.getDistanciaDeAtaque());
		Assert.assertEquals(8, megatron.getVelocidad());
		Assert.assertTrue(megatron.esAlterno());
		Assert.assertFalse(megatron.esHumanoide());
		Assert.assertFalse(megatron.esUnico());
		Assert.assertTrue(megatron.esUnidadAerea());
		Assert.assertFalse(megatron.esUnidadTerrestre());
	}
	
	@Test
	public void megatronAtraviesaPantanoTest(){
		MegatronAlterno megatron = new MegatronAlterno();
		Assert.assertTrue(megatron.puedeAtravesarPantano());
	}
	
	@Test
	public void megatronPantanoReduceVelocidadTest(){
		MegatronAlterno megatron = new MegatronAlterno();
		Assert.assertFalse(megatron.pantanoReduceVelocidad());
	}
	
	@Test
	public void megatronReestableceLaVelocidad(){
		MegatronAlterno megatron = new MegatronAlterno();
		Assert.assertEquals(8, megatron.getVelocidad());
		
		megatron.reducirVelocidad();
		Assert.assertEquals(7, megatron.getVelocidad());
		megatron.reducirVelocidad();
		Assert.assertEquals(6, megatron.getVelocidad());
		
		megatron.reestablecerVelocidad();
		Assert.assertEquals(8, megatron.getVelocidad());
	}
	
	@Test
	public void megatronReduceLaVelocidad(){
		MegatronAlterno megatron = new MegatronAlterno();
		Assert.assertEquals(8, megatron.getVelocidad());
		megatron.reducirVelocidad();
		Assert.assertEquals(7, megatron.getVelocidad());
		megatron.reducirVelocidad();
		Assert.assertEquals(6, megatron.getVelocidad());
		megatron.reducirVelocidad();
		Assert.assertEquals(5, megatron.getVelocidad());
		megatron.reducirVelocidad();
		Assert.assertEquals(4, megatron.getVelocidad());
		megatron.reducirVelocidad();
		Assert.assertEquals(3, megatron.getVelocidad());
		megatron.reducirVelocidad();
		Assert.assertEquals(2, megatron.getVelocidad());
		megatron.reducirVelocidad();
		Assert.assertEquals(1, megatron.getVelocidad());
		megatron.reducirVelocidad();
		Assert.assertEquals(0, megatron.getVelocidad());
	}
}
