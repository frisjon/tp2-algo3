package fiuba.algo3.modelo.estados;

import org.junit.Assert;
import org.junit.Test;

public class FrenzyHumanoideTest {
	
	@Test
	public void crearFrenzyHumanoideTest(){
		FrenzyHumanoide frenzy = new FrenzyHumanoide();
		Assert.assertEquals(10, frenzy.getAtaque());
		Assert.assertEquals(5, frenzy.getDistanciaDeAtaque());
		Assert.assertEquals(2, frenzy.getVelocidad());
		Assert.assertTrue(frenzy.esHumanoide());
		Assert.assertFalse(frenzy.esAlterno());
		Assert.assertFalse(frenzy.esUnico());
		Assert.assertFalse(frenzy.esUnidadAerea());
		Assert.assertTrue(frenzy.esUnidadTerrestre());
	}
	
	@Test
	public void frenzyAtraviesaPantanoTest(){
		FrenzyHumanoide frenzy = new FrenzyHumanoide();
		Assert.assertFalse(frenzy.puedeAtravesarPantano());
	}
	
	@Test
	public void frenzyPantanoReduceVelocidadTest(){
		FrenzyHumanoide frenzy = new FrenzyHumanoide();
		Assert.assertFalse(frenzy.pantanoReduceVelocidad());
	}
	
	@Test
	public void frenzyReestableceLaVelocidad(){
		FrenzyHumanoide frenzy = new FrenzyHumanoide();
		Assert.assertEquals(2, frenzy.getVelocidad());
		
		frenzy.reducirVelocidad();
		Assert.assertEquals(1, frenzy.getVelocidad());
		frenzy.reducirVelocidad();
		Assert.assertEquals(0, frenzy.getVelocidad());
		
		frenzy.reestablecerVelocidad();
		Assert.assertEquals(2, frenzy.getVelocidad());
	}
	
	@Test
	public void frenzyReduceLaVelocidad(){
		FrenzyHumanoide frenzy = new FrenzyHumanoide();
		Assert.assertEquals(2, frenzy.getVelocidad());
		frenzy.reducirVelocidad();
		Assert.assertEquals(1, frenzy.getVelocidad());
		frenzy.reducirVelocidad();
		Assert.assertEquals(0, frenzy.getVelocidad());
	}
}
