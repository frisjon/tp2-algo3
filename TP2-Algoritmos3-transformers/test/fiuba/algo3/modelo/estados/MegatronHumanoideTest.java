package fiuba.algo3.modelo.estados;

import org.junit.Assert;
import org.junit.Test;

public class MegatronHumanoideTest {
	
	@Test
	public void crearMegatronHumanoideTest(){
		MegatronHumanoide megatron = new MegatronHumanoide();
		Assert.assertEquals(10, megatron.getAtaque());
		Assert.assertEquals(3, megatron.getDistanciaDeAtaque());
		Assert.assertEquals(1, megatron.getVelocidad());
		Assert.assertTrue(megatron.esHumanoide());
		Assert.assertFalse(megatron.esAlterno());
		Assert.assertFalse(megatron.esUnico());
		Assert.assertFalse(megatron.esUnidadAerea());
		Assert.assertTrue(megatron.esUnidadTerrestre());
	}
	
	@Test
	public void megatronAtraviesaPantanoTest(){
		MegatronHumanoide megatron = new MegatronHumanoide();
		Assert.assertFalse(megatron.puedeAtravesarPantano());
	}
	
	@Test
	public void megatronPantanoReduceVelocidadTest(){
		MegatronHumanoide megatron = new MegatronHumanoide();
		Assert.assertFalse(megatron.pantanoReduceVelocidad());
	}
	
	@Test
	public void megatronReestableceLaVelocidad(){
		MegatronHumanoide megatron = new MegatronHumanoide();
		Assert.assertEquals(1, megatron.getVelocidad());
		
		megatron.reducirVelocidad();
		Assert.assertEquals(0, megatron.getVelocidad());
		
		megatron.reestablecerVelocidad();
		Assert.assertEquals(1, megatron.getVelocidad());
	}
	
	@Test
	public void megatronReduceLaVelocidad(){
		MegatronHumanoide megatron = new MegatronHumanoide();
		Assert.assertEquals(1, megatron.getVelocidad());
		megatron.reducirVelocidad();
		Assert.assertEquals(0, megatron.getVelocidad());
	}
}
