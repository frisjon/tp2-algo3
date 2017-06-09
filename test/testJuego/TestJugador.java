package testJuego;

import junit.framework.*;
import org.junit.Test;
import org.junit.Assert;
import equipos.Equipo;
import jugadores.Jugador;

public class TestJugador extends TestCase {
	
	@Test
	public void test01NombreCorrecto() {
		Equipo equipo = new Equipo("Guerreros Z");
		Jugador jugador = new Jugador("Ramiro", equipo);
		Assert.assertEquals(jugador.getNombre(), "Ramiro");
	}
	
	@Test
	public void test02EquipoCorrecto() {
		Equipo equipo = new Equipo("Guerreros Z");
		Jugador jugador = new Jugador("Ramiro", equipo);
		Assert.assertEquals(jugador.getEquipo(), equipo);
	}
}
