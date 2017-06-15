package fiuba.algo3.modelo.estados;

import org.junit.Assert;
import org.junit.Test;

public class MenasorUnicoTest {

	@Test
	public void crearMenasorUnicoTest(){
		MenasorUnico menasor = new MenasorUnico();
		Assert.assertEquals(115, menasor.getAtaque());
		Assert.assertEquals(2, menasor.getDistanciaDeAtaque());
		Assert.assertEquals(2, menasor.getVelocidad());
		Assert.assertFalse(menasor.esHumanoide());
		Assert.assertFalse(menasor.esAlterno());
		Assert.assertTrue(menasor.esUnico());
		Assert.assertFalse(menasor.esUnidadAerea());
		Assert.assertTrue(menasor.esUnidadTerrestre());
	}
	
	@Test
	public void menasorAtraviesaPantanoTest(){
		MenasorUnico menasor = new MenasorUnico();
		Assert.assertTrue(menasor.puedeAtravesarPantano());
	}
	
	@Test
	public void menasorPantanoReduceVelocidadTest(){
		MenasorUnico menasor = new MenasorUnico();
		Assert.assertFalse(menasor.pantanoReduceVelocidad());
	}
	
	@Test
	public void menasorReestableceLaVelocidad(){
		MenasorUnico menasor = new MenasorUnico();
		Assert.assertEquals(2, menasor.getVelocidad());
		
		menasor.reducirVelocidad();
		Assert.assertEquals(1, menasor.getVelocidad());
		
		menasor.reestablecerVelocidad();
		Assert.assertEquals(2, menasor.getVelocidad());
	}
	
	@Test
	public void menasorReduceLaVelocidad(){
		MenasorUnico menasor = new MenasorUnico();
		Assert.assertEquals(2, menasor.getVelocidad());
		menasor.reducirVelocidad();
		Assert.assertEquals(1, menasor.getVelocidad());
		menasor.reducirVelocidad();
		Assert.assertEquals(0, menasor.getVelocidad());
	}
}
