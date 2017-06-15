package fiuba.algo3.modelo.personajes;

import org.junit.Assert;
import org.junit.Test;

public class FrenzyTest {

	private int FRENZY_VIDA = 400;
	private int FRENZY_HUMANOIDE_ATAQUE = 10;
	private int FRENZY_HUMANOIDE_DISTANCIA_DE_ATAQUE = 5;
	private int FRENZY_HUMANOIDE_VELOCIDAD = 2;
	private int FRENZY_ALTERNO_ATAQUE = 25 ;
	private int FRENZY_ALTERNO_DISTANCIA_DE_ATAQUE = 2;
	private int FRENZY_ALTERNO_VELOCIDAD = 6;

	
	@Test
	public void crearFrenzyHumanoideTest(){
		Personaje frenzy = new Frenzy();
		Assert.assertEquals(FRENZY_VIDA, frenzy.getPuntosDeVida());
		Assert.assertEquals(FRENZY_HUMANOIDE_ATAQUE, frenzy.getAtaque());
		Assert.assertEquals(FRENZY_HUMANOIDE_DISTANCIA_DE_ATAQUE, frenzy.getDistanciaDeAtaque());
		Assert.assertTrue(frenzy.esHumanoide());
		Assert.assertEquals(FRENZY_HUMANOIDE_VELOCIDAD, frenzy.getVelocidad());
	
	}
	
	@Test
	public void transformarFrenzyAModoHumanoideTest(){
		Personaje frenzy = new Frenzy();
		frenzy.transformar();
		frenzy.transformar();
		Assert.assertEquals(FRENZY_VIDA, frenzy.getPuntosDeVida());
		Assert.assertEquals(FRENZY_HUMANOIDE_ATAQUE, frenzy.getAtaque());
		Assert.assertEquals(FRENZY_HUMANOIDE_DISTANCIA_DE_ATAQUE, frenzy.getDistanciaDeAtaque());
		Assert.assertTrue(frenzy.esHumanoide());
		Assert.assertEquals(FRENZY_HUMANOIDE_VELOCIDAD, frenzy.getVelocidad());
	
	}
	
	@Test
	public void transformarFrenzyAModoAlternoTest(){
		Personaje frenzy = new Frenzy();
		frenzy.transformar();
		Assert.assertEquals(FRENZY_VIDA, frenzy.getPuntosDeVida());
		Assert.assertEquals(FRENZY_ALTERNO_ATAQUE, frenzy.getAtaque());
		Assert.assertEquals(FRENZY_ALTERNO_DISTANCIA_DE_ATAQUE, frenzy.getDistanciaDeAtaque());
		Assert.assertTrue(frenzy.esAlterno());
		Assert.assertEquals(FRENZY_ALTERNO_VELOCIDAD, frenzy.getVelocidad());
	
	}
}
