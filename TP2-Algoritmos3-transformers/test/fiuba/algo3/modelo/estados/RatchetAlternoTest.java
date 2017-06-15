package fiuba.algo3.modelo.estados;

import org.junit.Assert;
import org.junit.Test;

public class RatchetAlternoTest {
	
	@Test
	public void crearRatchetAlternoTest(){
		RatchetAlterno ratchet = new RatchetAlterno();
		Assert.assertEquals(35, ratchet.getAtaque());
		Assert.assertEquals(2, ratchet.getDistanciaDeAtaque());
		Assert.assertEquals(8, ratchet.getVelocidad());
		Assert.assertTrue(ratchet.esAlterno());
		Assert.assertFalse(ratchet.esHumanoide());
		Assert.assertFalse(ratchet.esUnico());
		Assert.assertTrue(ratchet.esUnidadAerea());
		Assert.assertFalse(ratchet.esUnidadTerrestre());
	}
	
	@Test
	public void ratchetAtraviesaPantanoTest(){
		RatchetAlterno ratchet = new RatchetAlterno();
		Assert.assertTrue(ratchet.puedeAtravesarPantano());
	}
	
	@Test
	public void ratchetPantanoReduceVelocidadTest(){
		RatchetAlterno ratchet = new RatchetAlterno();
		Assert.assertFalse(ratchet.pantanoReduceVelocidad());
	}
	
	@Test
	public void ratchetReestableceLaVelocidad(){
		RatchetAlterno ratchet = new RatchetAlterno();
		Assert.assertEquals(8, ratchet.getVelocidad());
		
		ratchet.reducirVelocidad();
		Assert.assertEquals(7, ratchet.getVelocidad());
		ratchet.reducirVelocidad();
		Assert.assertEquals(6, ratchet.getVelocidad());
		
		ratchet.reestablecerVelocidad();
		Assert.assertEquals(8, ratchet.getVelocidad());
	}
	
	@Test
	public void ratchetReduceLaVelocidad(){
		RatchetAlterno ratchet = new RatchetAlterno();
		Assert.assertEquals(8, ratchet.getVelocidad());
		ratchet.reducirVelocidad();
		Assert.assertEquals(7, ratchet.getVelocidad());
		ratchet.reducirVelocidad();
		Assert.assertEquals(6, ratchet.getVelocidad());
		ratchet.reducirVelocidad();
		Assert.assertEquals(5, ratchet.getVelocidad());
		ratchet.reducirVelocidad();
		Assert.assertEquals(4, ratchet.getVelocidad());
		ratchet.reducirVelocidad();
		Assert.assertEquals(3, ratchet.getVelocidad());
		ratchet.reducirVelocidad();
		Assert.assertEquals(2, ratchet.getVelocidad());
		ratchet.reducirVelocidad();
		Assert.assertEquals(1, ratchet.getVelocidad());
		ratchet.reducirVelocidad();
		Assert.assertEquals(0, ratchet.getVelocidad());
	}
}
