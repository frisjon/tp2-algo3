package testJuego;

import junit.framework.*;
import org.junit.Test;

import equipos.Equipo;
import juego.Juego;
import jugadores.Jugador;
import org.junit.Assert;

public class TestJuego extends TestCase{
	
	@Test
	public void test01VerificarJugadorAgregado() {
		Juego juego = new Juego();
		Equipo equipo = new Equipo("Guerreros Z");
		Jugador jugador = new Jugador("Ramiro", equipo);
		juego.agregarJugador(jugador);
		Assert.assertEquals(juego.pedirJugador("Ramiro"), jugador);
	}
}
