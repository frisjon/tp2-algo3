package fiuba.algo3.modelo.estados;

import org.junit.Assert;
import org.junit.Test;

public class FrenzyAlternoTest {
	
	@Test
	public void crearFrenzyAlternoTest(){
		FrenzyAlterno frenzy = new FrenzyAlterno();
		Assert.assertEquals(25, frenzy.getAtaque());
		Assert.assertEquals(2, frenzy.getDistanciaDeAtaque());
		Assert.assertEquals(6, frenzy.getVelocidad());
		Assert.assertTrue(frenzy.esAlterno());
		Assert.assertFalse(frenzy.esHumanoide());
		Assert.assertFalse(frenzy.esUnico());
		Assert.assertFalse(frenzy.esUnidadAerea());
		Assert.assertTrue(frenzy.esUnidadTerrestre());
	}
	
	@Test
	public void frenzyAtraviesaPantanoTest(){
		FrenzyAlterno frenzy = new FrenzyAlterno();
		Assert.assertTrue(frenzy.puedeAtravesarPantano());
	}
	
	@Test
	public void frenzyPantanoReduceVelocidadTest(){
		FrenzyAlterno frenzy = new FrenzyAlterno();
		Assert.assertTrue(frenzy.pantanoReduceVelocidad());
	}
	
	@Test
	public void frenzyReestableceLaVelocidad(){
		FrenzyAlterno frenzy = new FrenzyAlterno();
		Assert.assertEquals(6, frenzy.getVelocidad());
		
		frenzy.reducirVelocidad();
		Assert.assertEquals(5, frenzy.getVelocidad());
		frenzy.reducirVelocidad();
		Assert.assertEquals(4, frenzy.getVelocidad());
		
		frenzy.reestablecerVelocidad();
		Assert.assertEquals(6, frenzy.getVelocidad());
	}
	
	@Test
	public void frenzyReduceLaVelocidad(){
		FrenzyAlterno frenzy = new FrenzyAlterno();
		Assert.assertEquals(6, frenzy.getVelocidad());
		frenzy.reducirVelocidad();
		Assert.assertEquals(5, frenzy.getVelocidad());
		frenzy.reducirVelocidad();
		Assert.assertEquals(4, frenzy.getVelocidad());
		frenzy.reducirVelocidad();
		Assert.assertEquals(3, frenzy.getVelocidad());
		frenzy.reducirVelocidad();
		Assert.assertEquals(2, frenzy.getVelocidad());
		frenzy.reducirVelocidad();
		Assert.assertEquals(1, frenzy.getVelocidad());
		frenzy.reducirVelocidad();
		Assert.assertEquals(0, frenzy.getVelocidad());
		
	}
}
