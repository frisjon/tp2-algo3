package fiuba.algo3.modelo.personajes;

import org.junit.Assert;
import org.junit.Test;

public class BonecrusherTest {

	private int BONECRUSHER_VIDA = 200;
	private int BONECRUSHER_HUMANOIDE_ATAQUE = 30;
	private int BONECRUSHER_HUMANOIDE_DISTANCIA_DE_ATAQUE = 3;
	private int BONECRUSHER_HUMANOIDE_VELOCIDAD = 1;
	private int BONECRUSHER_ALTERNO_ATAQUE = 30 ;
	private int BONECRUSHER_ALTERNO_DISTANCIA_DE_ATAQUE = 3;
	private int BONECRUSHER_ALTERNO_VELOCIDAD = 8;

	
	@Test
	public void crearBonecrusherHumanoideTest(){
		Personaje bonecrusher = new Bonecrusher();
		Assert.assertEquals(BONECRUSHER_VIDA, bonecrusher.getPuntosDeVida());
		Assert.assertEquals(BONECRUSHER_HUMANOIDE_ATAQUE, bonecrusher.getAtaque());
		Assert.assertEquals(BONECRUSHER_HUMANOIDE_DISTANCIA_DE_ATAQUE, bonecrusher.getDistanciaDeAtaque());
		Assert.assertTrue(bonecrusher.esHumanoide());
		Assert.assertEquals(BONECRUSHER_HUMANOIDE_VELOCIDAD, bonecrusher.getVelocidad());
	
	}
	
	@Test
	public void transformarBonecrusherAModoHumanoideTest(){
		Personaje bonecrusher = new Bonecrusher();
		bonecrusher.transformar();
		bonecrusher.transformar();
		Assert.assertEquals(BONECRUSHER_VIDA, bonecrusher.getPuntosDeVida());
		Assert.assertEquals(BONECRUSHER_HUMANOIDE_ATAQUE, bonecrusher.getAtaque());
		Assert.assertEquals(BONECRUSHER_HUMANOIDE_DISTANCIA_DE_ATAQUE, bonecrusher.getDistanciaDeAtaque());
		Assert.assertTrue(bonecrusher.esHumanoide());
		Assert.assertEquals(BONECRUSHER_HUMANOIDE_VELOCIDAD, bonecrusher.getVelocidad());
	
	}
	
	@Test
	public void transformarBonecrusherAModoAlternoTest(){
		Personaje bonecrusher = new Bonecrusher();
		bonecrusher.transformar();
		Assert.assertEquals(BONECRUSHER_VIDA, bonecrusher.getPuntosDeVida());
		Assert.assertEquals(BONECRUSHER_ALTERNO_ATAQUE, bonecrusher.getAtaque());
		Assert.assertEquals(BONECRUSHER_ALTERNO_DISTANCIA_DE_ATAQUE, bonecrusher.getDistanciaDeAtaque());
		Assert.assertTrue(bonecrusher.esAlterno());
		Assert.assertEquals(BONECRUSHER_ALTERNO_VELOCIDAD, bonecrusher.getVelocidad());
	
	}
}
