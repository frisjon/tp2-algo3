package fiuba.algo3.modelo.tablero;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import fiuba.algo3.modelo.bonus.Bonus;
import fiuba.algo3.modelo.personajes.Personaje;

public class CasilleroTest {
	
	@Mock
	private Personaje personaje;
	@Mock
	private ChispaSuprema chispaSuprema;
	@Mock
	private Bonus bonus;
	
	@Before
	public void setUpMocks(){
		MockitoAnnotations.initMocks(this);		
	}
	
	@After
	public void resetMocks(){
		Mockito.reset(this.personaje,this.chispaSuprema,this.bonus);
	}
	
	@Test
	public void agregarPosicionableTest(){
		Posicion posicion = new Posicion(0,0);
		Casillero casillero = new Casillero(posicion);
		//Bonus
		Assert.assertNull(casillero.getBonus());
		casillero.agregarPosicionable(this.bonus);
		Assert.assertEquals(this.bonus,casillero.getBonus());
		//Personaje
		Assert.assertNull(casillero.getPersonaje());
		casillero.agregarPosicionable(this.personaje);
		Assert.assertEquals(this.personaje,casillero.getPersonaje());		
		//Chispa Suprema
		Assert.assertNull(casillero.getChispaSuprema());
		casillero.agregarPosicionable(this.chispaSuprema);
		Assert.assertEquals(this.chispaSuprema,casillero.getChispaSuprema());
	}
	
	@Test
	public void retirarPersonajeTest(){
		Posicion posicion = new Posicion(0,0);
		Casillero casillero = new Casillero(posicion);
		//agregarPersonaje
		Assert.assertNull(casillero.getPersonaje());
		casillero.agregarPosicionable(this.personaje);
		Assert.assertEquals(this.personaje,casillero.getPersonaje());		
		//retirarPersonaje
		casillero.retirarPersonaje();
		Assert.assertNull(casillero.getPersonaje());
	}
	
	@Test
	public void estaOcupadoTest(){
		Posicion posicion = new Posicion(0,0);
		Casillero casillero = new Casillero(posicion);
		//agregarPersonaje
		Assert.assertFalse(casillero.estaOcupado());
		casillero.agregarPosicionable(this.personaje);
		Assert.assertTrue(casillero.estaOcupado());
		//retirarPersonaje
		casillero.retirarPersonaje();
		Assert.assertFalse(casillero.estaOcupado());
	}
}
