package testJuego;

import junit.framework.*;
import modelo.juego.Equipo;
import modelo.juego.Jugador;
import modelo.juego.PosibleEquipo;

import org.junit.Test;
import org.junit.Assert;

public class TestJugador extends TestCase {
	
	@Test
	public void test01NombreCorrecto() {
		Equipo equipo = new Equipo(PosibleEquipo.guerreros);
		Jugador jugador = new Jugador("Ramiro", equipo);
		Assert.assertEquals(jugador.getNombre(), "Ramiro");
	}
	
	@Test
	public void test02EquipoCorrecto() {
		Equipo equipo = new Equipo(PosibleEquipo.guerreros);
		Jugador jugador = new Jugador("Ramiro", equipo);
		Assert.assertEquals(jugador.getEquipo(), equipo);
	}
}
