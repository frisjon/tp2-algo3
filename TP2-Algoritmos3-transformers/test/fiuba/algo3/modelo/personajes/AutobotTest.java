package fiuba.algo3.modelo.personajes;

import org.junit.Assert;
import org.junit.Test;

import fiuba.algo3.modelo.tablero.Posicion;

public class AutobotTest {

	private int PUNTOS_DE_VIDA_DECEPTICON_MEGATRON = 550;
	private int PUNTOS_DE_VIDA_DECEPTICON_MEGATRON_DESPUES_ATAQUE_OPTIMUS = 500;
	private int PUNTOS_DE_VIDA_AUTOBOT_RATCHET = 150;

	@Test
	public void atacarDecepticonTest(){
		Personaje autobot = new Optimus();
		Posicion posicion = new Posicion(1,1);
		autobot.setPosicion(posicion);
		Personaje decepticon = new Megatron();
		posicion = new Posicion(2,2);
		decepticon.setPosicion(posicion);
		
		Assert.assertEquals(PUNTOS_DE_VIDA_DECEPTICON_MEGATRON , decepticon.getPuntosDeVida());
		autobot.atacar(decepticon);
		Assert.assertEquals(PUNTOS_DE_VIDA_DECEPTICON_MEGATRON_DESPUES_ATAQUE_OPTIMUS ,decepticon.getPuntosDeVida());
	}
	
	@Test
	public void noAtacarAutobotTest(){
		Personaje autobotOptimus = new Optimus();
		Posicion posicion = new Posicion(1,1);
		autobotOptimus.setPosicion(posicion);
		Personaje autobotRatchet = new Ratchet();
		posicion = new Posicion(2,2);
		autobotRatchet.setPosicion(posicion);
		
		Assert.assertEquals(PUNTOS_DE_VIDA_AUTOBOT_RATCHET , autobotRatchet.getPuntosDeVida());
		autobotOptimus.atacar(autobotRatchet);
		Assert.assertEquals(PUNTOS_DE_VIDA_AUTOBOT_RATCHET ,autobotRatchet.getPuntosDeVida());
	}
}
