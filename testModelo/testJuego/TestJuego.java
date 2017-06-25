package testJuego;

import junit.framework.*;
import modelo.equipo.Equipo;
import modelo.equipo.PosibleEquipo;
import modelo.juego.Juego;
import modelo.jugador.Jugador;

import org.junit.Test;
import org.junit.Assert;

public class TestJuego extends TestCase{
	
	@Test
	public void test01VerificarJugadorAgregado() {
		Juego juego = new Juego();
		Equipo equipo = new Equipo(PosibleEquipo.guerreros);
		Jugador jugador = new Jugador("Ramiro", equipo);
		juego.agregarJugador(jugador);
		//Assert.assertEquals(juego.pedirJugador("Ramiro"), jugador);
	}
}
