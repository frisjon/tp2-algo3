package fiuba.algo3.modelo.personajes;

import org.junit.Assert;
import org.junit.Test;

public class RatchetTest {

	private int RATCHET_VIDA = 150;
	private int RATCHET_HUMANOIDE_ATAQUE = 5;
	private int RATCHET_HUMANOIDE_DISTANCIA_DE_ATAQUE = 5;
	private int RATCHET_HUMANOIDE_VELOCIDAD = 1;
	private int RATCHET_ALTERNO_ATAQUE = 35;
	private int RATCHET_ALTERNO_DISTANCIA_DE_ATAQUE = 2;
	private int RATCHET_ALTERNO_VELOCIDAD = 8;

	
	@Test
	public void crearRatchetHumanoideTest(){
		Personaje ratchet = new Ratchet();
		Assert.assertEquals(RATCHET_VIDA, ratchet.getPuntosDeVida());
		Assert.assertEquals(RATCHET_HUMANOIDE_ATAQUE, ratchet.getAtaque());
		Assert.assertEquals(RATCHET_HUMANOIDE_DISTANCIA_DE_ATAQUE, ratchet.getDistanciaDeAtaque());
		Assert.assertTrue(ratchet.esHumanoide());
		Assert.assertEquals(RATCHET_HUMANOIDE_VELOCIDAD, ratchet.getVelocidad());
	
	}
	
	@Test
	public void transformarRatchetAModoHumanoideTest(){
		Personaje ratchet = new Ratchet();
		ratchet.transformar();
		ratchet.transformar();
		Assert.assertEquals(RATCHET_VIDA, ratchet.getPuntosDeVida());
		Assert.assertEquals(RATCHET_HUMANOIDE_ATAQUE, ratchet.getAtaque());
		Assert.assertEquals(RATCHET_HUMANOIDE_DISTANCIA_DE_ATAQUE, ratchet.getDistanciaDeAtaque());
		Assert.assertTrue(ratchet.esHumanoide());
		Assert.assertEquals(RATCHET_HUMANOIDE_VELOCIDAD, ratchet.getVelocidad());
	
	}
	
	@Test
	public void transformarRatchetAModoAlternoTest(){
		Personaje ratchet = new Ratchet();
		ratchet.transformar();
		Assert.assertEquals(RATCHET_VIDA, ratchet.getPuntosDeVida());
		Assert.assertEquals(RATCHET_ALTERNO_ATAQUE, ratchet.getAtaque());
		Assert.assertEquals(RATCHET_ALTERNO_DISTANCIA_DE_ATAQUE, ratchet.getDistanciaDeAtaque());
		Assert.assertTrue(ratchet.esAlterno());
		Assert.assertEquals(RATCHET_ALTERNO_VELOCIDAD, ratchet.getVelocidad());
	
	}
}
