package fiuba.algo3.modelo.personajes;

import org.junit.Assert;
import org.junit.Test;

import fiuba.algo3.modelo.tablero.Posicion;

public class PersonajeTest {

	@Test
	public void ubicarEnPosicionTest(){
		Personaje personaje = new Optimus();
		Posicion posicionInicial = new Posicion(0,0);
		personaje.setPosicion(posicionInicial);
		Assert.assertEquals(posicionInicial, personaje.getPosicion());
		Posicion posicionDentroDelMapa = new Posicion(10,10);
		personaje.setPosicion(posicionDentroDelMapa);
		Assert.assertEquals(posicionDentroDelMapa, personaje.getPosicion());
	}
	
	@Test
	public void recibirAtaqueTest(){
		Autobot autobot = new Optimus();
		Decepticon decepticon = new Megatron();
		Assert.assertEquals(500, autobot.getPuntosDeVida());
		autobot.recibirAtaqueDe(decepticon);
		Assert.assertEquals(490, autobot.getPuntosDeVida());

	}
}
