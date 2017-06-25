package testFinalJuego;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import junit.framework.TestCase;
import modelo.consumibles.Esfera;
import modelo.juego.Equipo;
import modelo.juego.Juego;
import modelo.juego.Jugador;
import modelo.juego.OrganizadorJuego;
import modelo.juego.PosibleEquipo;
import modelo.personajes.Cell;
import modelo.personajes.Freezer;
import modelo.personajes.Gohan;
import modelo.personajes.Goku;
import modelo.personajes.MajinBoo;
import modelo.personajes.Piccolo;
import modelo.tablero.Casillero;

public class TestFinalizacionJuego extends TestCase {
	private Juego juego;
	private OrganizadorJuego organizador;
	private Goku goku;
	private Gohan gohan;
	private Piccolo piccolo;
	private Freezer freezer;
	private MajinBoo majinboo;
	private Cell cell;
	private Equipo equipo1;
	private Equipo equipo2;
	private Jugador jugador1;
	private Jugador jugador2;
	
	public void setUp() {
		juego = new Juego();
		organizador = juego.getOrganizadorJuego();
		goku = new Goku(PosibleEquipo.guerreros);
		gohan = new Gohan(PosibleEquipo.guerreros);
		piccolo = new Piccolo(PosibleEquipo.guerreros);
		freezer = new Freezer(PosibleEquipo.enemigos);
		majinboo = new MajinBoo(PosibleEquipo.enemigos);
		cell = new Cell(PosibleEquipo.enemigos);
		
		equipo1 = new Equipo(PosibleEquipo.guerreros);
		equipo1.agregarPersonaje(goku);
		equipo1.agregarPersonaje(gohan);
		equipo1.agregarPersonaje(piccolo);
		
		equipo2 = new Equipo(PosibleEquipo.enemigos);
		equipo2.agregarPersonaje(freezer);
		equipo2.agregarPersonaje(majinboo);
		equipo2.agregarPersonaje(cell);
		
		jugador1 = new Jugador("Juan", equipo1);
		jugador2 = new Jugador("Pedro", equipo2);
		
		juego.agregarJugador(jugador1);
		juego.agregarJugador(jugador2);
		
		juego.distribuirPersonajesEquipos();
		juego.inicializarJuegoAdjudicandoPrimerTurno();
		
	}
	
	public void test01VerificarJuegoTerminaAlEliminarPersonajesContrincante() {
		freezer.quitarVida(500);
		equipo2.matarPersonaje();
		majinboo.quitarVida(500);
		equipo2.matarPersonaje();
		cell.quitarVida(500);
		equipo2.matarPersonaje();
		
		Assert.assertEquals(organizador.finalizarTurno(), true);
	}
	
	public void test02VerificarJuegoTerminaAlRecolectarSieteEsferas() {
		
		equipo1.sumarEsferasObtenidas(7);

		Assert.assertEquals(organizador.finalizarTurno(), true);
	}
}
