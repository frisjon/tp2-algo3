package fiuba.algo3.modelo.personajes;

import org.junit.Assert;
import org.junit.Test;

import fiuba.algo3.modelo.tablero.Posicion;

public class DecepticonTest {

	private int PUNTOS_DE_VIDA_AUTOBOT_OPTIMUS = 500;
	private int PUNTOS_DE_VIDA_AUTOBOT_OPTIMUS_DESPUES_ATAQUE_MEGATRON = 490;
	private int PUNTOS_DE_VIDA_DECEPTICON_FRENZY = 400;

	@Test
	public void atacarAutobotTest(){
		Personaje decepticon = new Megatron();
		Posicion posicion = new Posicion(1,1);
		decepticon.setPosicion(posicion);
		
		Personaje autobot = new Optimus();
		posicion = new Posicion(3,4);
		autobot.setPosicion(posicion);
		
		Assert.assertEquals(PUNTOS_DE_VIDA_AUTOBOT_OPTIMUS , autobot.getPuntosDeVida());
		decepticon.atacar(autobot);
		Assert.assertEquals(PUNTOS_DE_VIDA_AUTOBOT_OPTIMUS_DESPUES_ATAQUE_MEGATRON ,autobot.getPuntosDeVida());
	}
	
	@Test
	public void noAtacarDecepticonTest(){
		Personaje decepticonMegatron = new Megatron();
		Posicion posicion = new Posicion(1,1);
		decepticonMegatron.setPosicion(posicion);
		Personaje decepticonFrenzy = new Frenzy();
		posicion = new Posicion(2,2);
		decepticonFrenzy.setPosicion(posicion);
		
		Assert.assertEquals(PUNTOS_DE_VIDA_DECEPTICON_FRENZY , decepticonFrenzy.getPuntosDeVida());
		decepticonMegatron.atacar(decepticonFrenzy);
		Assert.assertEquals(PUNTOS_DE_VIDA_DECEPTICON_FRENZY ,decepticonFrenzy.getPuntosDeVida());
	}
}
