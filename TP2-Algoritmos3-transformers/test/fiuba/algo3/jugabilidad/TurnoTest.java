package fiuba.algo3.jugabilidad;


import org.junit.Assert;
import org.junit.Test;

import fiuba.algo3.modelo.jugabilidad.Jugador;
import fiuba.algo3.modelo.jugabilidad.TipoTransformer;
import fiuba.algo3.modelo.jugabilidad.Turno;

public class TurnoTest {

	private Jugador jugador1;
	private Jugador jugador2;
	@Test
	public void comienzaElTurnoElPrimerJugadorTest(){
		this.jugador1 = new Jugador("Pepe", TipoTransformer.AUTOBOT);
		this.jugador2 = new Jugador("Beto", TipoTransformer.DECEPTICON);
		
		Turno turno = new Turno(jugador1,jugador2);
		Assert.assertEquals(jugador1, turno.getJugadorActual());
	}
	
	@Test
	public void cambioDeTurnoAlSegundoJugadorTest(){
		this.jugador1 = new Jugador("Pepe", TipoTransformer.AUTOBOT);
		this.jugador2 = new Jugador("Beto", TipoTransformer.DECEPTICON);
		
		Turno turno = new Turno(jugador1,jugador2);
		Assert.assertEquals(jugador1, turno.getJugadorActual());
		turno.cambioDeTurno();
		Assert.assertEquals(jugador2, turno.getJugadorActual());

	}
	
	@Test
	public void cambioDeTurnosSucesivosTest(){
		this.jugador1 = new Jugador("Pepe", TipoTransformer.AUTOBOT);
		this.jugador2 = new Jugador("Beto", TipoTransformer.DECEPTICON);
		
		Turno turno = new Turno(jugador1,jugador2);
		Assert.assertEquals(jugador1, turno.getJugadorActual());
		turno.cambioDeTurno();
		Assert.assertEquals(jugador2, turno.getJugadorActual());
		turno.cambioDeTurno();
		Assert.assertEquals(jugador1, turno.getJugadorActual());
		turno.cambioDeTurno();
		Assert.assertEquals(jugador2, turno.getJugadorActual());
		turno.cambioDeTurno();
		Assert.assertEquals(jugador1, turno.getJugadorActual());

	}
}
