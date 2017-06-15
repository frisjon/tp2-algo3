package fiuba.algo3.modelo.personajes;

import org.junit.Assert;
import org.junit.Test;

public class OptimusTest {
	
	private int OPTIMUS_VIDA = 500;
	private int OPTIMUS_HUMANOIDE_ATAQUE = 50;
	private int OPTIMUS_HUMANOIDE_DISTANCIA_DE_ATAQUE = 2;
	private int OPTIMUS_HUMANOIDE_VELOCIDAD = 2;
	private int OPTIMUS_ALTERNO_ATAQUE = 15 ;
	private int OPTIMUS_ALTERNO_DISTANCIA_DE_ATAQUE = 4;
	private int OPTIMUS_ALTERNO_VELOCIDAD = 5;

	
	@Test
	public void crearOptimusHumanoideTest(){
		Personaje optimus = new Optimus();
		Assert.assertEquals(OPTIMUS_VIDA, optimus.getPuntosDeVida());
		Assert.assertEquals(OPTIMUS_HUMANOIDE_ATAQUE, optimus.getAtaque());
		Assert.assertEquals(OPTIMUS_HUMANOIDE_DISTANCIA_DE_ATAQUE, optimus.getDistanciaDeAtaque());
		Assert.assertTrue(optimus.esHumanoide());
		Assert.assertEquals(OPTIMUS_HUMANOIDE_VELOCIDAD, optimus.getVelocidad());
	
	}
	
	@Test
	public void transformarOptimusAModoHumanoideTest(){
		Personaje optimus = new Optimus();
		optimus.transformar();
		optimus.transformar();
		Assert.assertEquals(OPTIMUS_VIDA, optimus.getPuntosDeVida());
		Assert.assertEquals(OPTIMUS_HUMANOIDE_ATAQUE, optimus.getAtaque());
		Assert.assertEquals(OPTIMUS_HUMANOIDE_DISTANCIA_DE_ATAQUE, optimus.getDistanciaDeAtaque());
		Assert.assertTrue(optimus.esHumanoide());
		Assert.assertEquals(OPTIMUS_HUMANOIDE_VELOCIDAD, optimus.getVelocidad());
	
	}
	
	@Test
	public void transformarOptimusAModoAlternoTest(){
		Personaje optimus = new Optimus();
		optimus.transformar();
		Assert.assertEquals(OPTIMUS_VIDA, optimus.getPuntosDeVida());
		Assert.assertEquals(OPTIMUS_ALTERNO_ATAQUE, optimus.getAtaque());
		Assert.assertEquals(OPTIMUS_ALTERNO_DISTANCIA_DE_ATAQUE, optimus.getDistanciaDeAtaque());
		Assert.assertTrue(optimus.esAlterno());
		Assert.assertEquals(OPTIMUS_ALTERNO_VELOCIDAD, optimus.getVelocidad());
	
	}
}
