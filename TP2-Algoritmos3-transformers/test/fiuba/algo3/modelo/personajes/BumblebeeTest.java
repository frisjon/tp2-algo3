package fiuba.algo3.modelo.personajes;

import org.junit.Assert;
import org.junit.Test;

public class BumblebeeTest {

	private int BUMBLEBEE_VIDA = 350;
	private int BUMBLEBEE_HUMANOIDE_ATAQUE = 40;
	private int BUMBLEBEE_HUMANOIDE_DISTANCIA_DE_ATAQUE = 1;
	private int BUMBLEBEE_HUMANOIDE_VELOCIDAD = 2;
	private int BUMBLEBEE_ALTERNO_ATAQUE = 20 ;
	private int BUMBLEBEE_ALTERNO_DISTANCIA_DE_ATAQUE = 3;
	private int BUMBLEBEE_ALTERNO_VELOCIDAD = 5;

	
	@Test
	public void crearBumblebeeHumanoideTest(){
		Personaje bumblebee = new Bumblebee();
		Assert.assertEquals(BUMBLEBEE_VIDA, bumblebee.getPuntosDeVida());
		Assert.assertEquals(BUMBLEBEE_HUMANOIDE_ATAQUE, bumblebee.getAtaque());
		Assert.assertEquals(BUMBLEBEE_HUMANOIDE_DISTANCIA_DE_ATAQUE, bumblebee.getDistanciaDeAtaque());
		Assert.assertTrue(bumblebee.esHumanoide());
		Assert.assertEquals(BUMBLEBEE_HUMANOIDE_VELOCIDAD, bumblebee.getVelocidad());
	
	}
	
	@Test
	public void transformarBumblebeeAModoHumanoideTest(){
		Personaje bumblebee = new Bumblebee();
		bumblebee.transformar();
		bumblebee.transformar();
		Assert.assertEquals(BUMBLEBEE_VIDA, bumblebee.getPuntosDeVida());
		Assert.assertEquals(BUMBLEBEE_HUMANOIDE_ATAQUE, bumblebee.getAtaque());
		Assert.assertEquals(BUMBLEBEE_HUMANOIDE_DISTANCIA_DE_ATAQUE, bumblebee.getDistanciaDeAtaque());
		Assert.assertTrue(bumblebee.esHumanoide());
		Assert.assertEquals(BUMBLEBEE_HUMANOIDE_VELOCIDAD, bumblebee.getVelocidad());
	
	}
	
	@Test
	public void transformarBumblebeeAModoAlternoTest(){
		Personaje bumblebee = new Bumblebee();
		bumblebee.transformar();
		Assert.assertEquals(BUMBLEBEE_VIDA, bumblebee.getPuntosDeVida());
		Assert.assertEquals(BUMBLEBEE_ALTERNO_ATAQUE, bumblebee.getAtaque());
		Assert.assertEquals(BUMBLEBEE_ALTERNO_DISTANCIA_DE_ATAQUE, bumblebee.getDistanciaDeAtaque());
		Assert.assertTrue(bumblebee.esAlterno());
		Assert.assertEquals(BUMBLEBEE_ALTERNO_VELOCIDAD, bumblebee.getVelocidad());
	
	}
}
