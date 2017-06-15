package fiuba.algo3.modelo.estados;

import org.junit.Assert;
import org.junit.Test;

public class RatchetHumanoideTest {
	
	@Test
	public void crearRatchetHumanoideTest(){
		RatchetHumanoide ratchet = new RatchetHumanoide();
		Assert.assertEquals(5, ratchet.getAtaque());
		Assert.assertEquals(5, ratchet.getDistanciaDeAtaque());
		Assert.assertEquals(1, ratchet.getVelocidad());
		Assert.assertTrue(ratchet.esHumanoide());
		Assert.assertFalse(ratchet.esAlterno());
		Assert.assertFalse(ratchet.esUnico());
		Assert.assertFalse(ratchet.esUnidadAerea());
		Assert.assertTrue(ratchet.esUnidadTerrestre());
	}
	
	@Test
	public void ratchetAtraviesaPantanoTest(){
		RatchetHumanoide ratchet = new RatchetHumanoide();
		Assert.assertFalse(ratchet.puedeAtravesarPantano());
	}
	
	@Test
	public void ratchetPantanoReduceVelocidadTest(){
		RatchetHumanoide ratchet = new RatchetHumanoide();
		Assert.assertFalse(ratchet.pantanoReduceVelocidad());
	}
	
	@Test
	public void ratchetReestableceLaVelocidad(){
		RatchetHumanoide ratchet = new RatchetHumanoide();
		Assert.assertEquals(1, ratchet.getVelocidad());
		
		ratchet.reducirVelocidad();
		Assert.assertEquals(0, ratchet.getVelocidad());
		
		ratchet.reestablecerVelocidad();
		Assert.assertEquals(1, ratchet.getVelocidad());
	}
	
	@Test
	public void ratchetReduceLaVelocidad(){
		RatchetHumanoide ratchet = new RatchetHumanoide();
		Assert.assertEquals(1, ratchet.getVelocidad());
		ratchet.reducirVelocidad();
		Assert.assertEquals(0, ratchet.getVelocidad());
	}
}
