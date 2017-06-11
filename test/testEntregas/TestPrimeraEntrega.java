package testEntregas;

import org.junit.Test;

import equipos.Equipo;
import juego.Juego;
import jugadores.Jugador;

import java.util.ArrayList;

import org.junit.Assert;
import junit.framework.*;
import personajes.Cell;
import personajes.ErrorNoPuedeCambiarEstado;
import personajes.Freezer;
import personajes.Gohan;
import personajes.Goku;
import personajes.MajinBoo;
import personajes.Piccolo;
import tablero.Casillero;
import tablero.ErrorCasilleroYaOcupado;
import tablero.ErrorMovimientoInvalido;
import tablero.ErrorNoHayObjeto;
import tablero.Tablero;


public class TestPrimeraEntrega extends TestCase {
	
	public void test01MoverPersonajeYVerificarNuevaPosicion() throws ErrorCasilleroYaOcupado, ErrorMovimientoInvalido, ErrorNoHayObjeto {
		Tablero tablero = new Tablero(20,20);
		Casillero casillero1 = new Casillero(0,0);
		Casillero casillero2 = new Casillero(0,1);
		Casillero casillero3 = new Casillero(0,2);
		Goku goku = new Goku();
		ArrayList<Casillero> camino = new ArrayList<Casillero>();
		
		camino.add(casillero2);
		camino.add(casillero3);
		casillero1.setObjeto(goku);
		goku.setCasillero(casillero1);
		Assert.assertEquals(casillero1.getObjeto(), goku);
		tablero.moverPersonaje(goku, camino);
		Assert.assertEquals(casillero3.getObjeto(), goku);
		Assert.assertEquals(casillero1.estaLibre(), true);
	}

	public void test02MoverPersonajeMasDeLoQuePuedeDebeLanzarExcepcion() throws ErrorCasilleroYaOcupado, ErrorMovimientoInvalido {
		Tablero tablero = new Tablero(20,20);
		Casillero casillero1 = new Casillero(0,0);
		Casillero casillero2 = new Casillero(0,1);
		Casillero casillero3 = new Casillero(0,2);
		Casillero casillero4 = new Casillero(0,3);
		Goku goku = new Goku();
		ArrayList<Casillero> camino = new ArrayList<Casillero>();
		
		camino.add(casillero2);
		camino.add(casillero3);
		camino.add(casillero4);
		casillero1.setObjeto(goku);
		goku.setCasillero(casillero1);
		try {
			tablero.moverPersonaje(goku, camino);
		} catch (ErrorMovimientoInvalido e){}
	}
	
	public void test03VerificarImposibilidadDosPersonajesEnCasilleroDebeLanzarExcepcion() {
		Casillero casillero = new Casillero(0,0);
		Goku goku = new Goku();
		Gohan gohan = new Gohan();
		casillero.setObjeto(goku);
		try {
			casillero.setObjeto(gohan);
		} catch (ErrorCasilleroYaOcupado e) {}
	 }
	
	public void test04VerificarImposibilidadPersonajePasarPorEncimaDeOtroDebeLanzarExcepcion() throws ErrorCasilleroYaOcupado {
		Tablero tablero = new Tablero(20,20);
		Casillero casillero1 = new Casillero(0,0);
		Casillero casillero2 = new Casillero(0,1);
		Casillero casillero3 = new Casillero(0,2);
		Goku goku = new Goku();
		Gohan gohan = new Gohan();
		ArrayList<Casillero> camino = new ArrayList<Casillero>();
		
		casillero1.setObjeto(goku);
		casillero2.setObjeto(gohan);
		goku.setCasillero(casillero1);
		gohan.setCasillero(casillero2);
		camino.add(casillero2);
		camino.add(casillero3);
		try {
			tablero.moverPersonaje(goku, camino);
		} catch (ErrorMovimientoInvalido e){}
	}
	
	public void test05VerificarTransformacionGokuEnEstadoDos() throws ErrorNoPuedeCambiarEstado {
		Casillero casillero = new Casillero(0,0);
		Goku goku = new Goku();
		
		casillero.setObjeto(goku);
		goku.setCasillero(casillero);
		goku.agregarKi(20);
		Assert.assertEquals(goku.getIdEstado(), 1);
		goku.cambiarAEstado2();
		Assert.assertEquals(goku.getIdEstado(), 2);
	}
	
	public void test06VerificarImposibilidadTransformacionGokuEnEstadoTresDebeLanzarExcepcion() {
		Casillero casillero = new Casillero(0,0);
		Goku goku = new Goku();
		
		casillero.setObjeto(goku);
		goku.setCasillero(casillero);
		goku.agregarKi(20);
		try {
			goku.cambiarAEstado3();
		} catch (ErrorNoPuedeCambiarEstado e) {}
	}
	
	public void test07VerificarMovimientoGokuEnEstadoDos() throws ErrorNoPuedeCambiarEstado, ErrorCasilleroYaOcupado, ErrorMovimientoInvalido, ErrorNoHayObjeto {
		Tablero tablero = new Tablero(20,20);
		Casillero casillero1 = new Casillero(0,0);
		Casillero casillero2 = new Casillero(0,1);
		Casillero casillero3 = new Casillero(0,2);
		Casillero casillero4 = new Casillero(0,3);
		Goku goku = new Goku();
		ArrayList<Casillero> camino = new ArrayList<Casillero>();
		
		casillero1.setObjeto(goku);
		goku.setCasillero(casillero1);
		goku.agregarKi(20);
		goku.cambiarAEstado2();
		camino.add(casillero2);
		camino.add(casillero3);
		camino.add(casillero4);
		tablero.moverPersonaje(goku, camino);
		Assert.assertEquals(casillero4.getObjeto(), goku);
		Assert.assertEquals(casillero1.estaLibre(), true);
	}
	
	public void test08CrearJuegoConJugadoresYPersonajesRepartidosEnTablero() {
		Juego juego = new Juego();
		Goku goku = new Goku();
		Gohan gohan = new Gohan();
		Piccolo piccolo = new Piccolo();
		Freezer freezer = new Freezer();
		MajinBoo majinboo = new MajinBoo();
		Cell cell = new Cell();
		
		Equipo equipo1 = new Equipo("Guerreros Z");
		equipo1.agregarPersonaje(goku);
		equipo1.agregarPersonaje(gohan);
		equipo1.agregarPersonaje(piccolo);
		
		Equipo equipo2 = new Equipo("Enemigos de la Tierra");
		equipo2.agregarPersonaje(freezer);
		equipo2.agregarPersonaje(majinboo);
		equipo2.agregarPersonaje(cell);
		
		
		Jugador jugador1 = new Jugador("Juan", equipo1);
		Jugador jugador2 = new Jugador("Pedro", equipo2);
		
		juego.agregarJugador(jugador1);
		juego.agregarJugador(jugador2);
		//verifico que el juego tenga a los jugadores
		Assert.assertEquals(juego.pedirJugador("Juan"), jugador1);
		Assert.assertEquals(juego.pedirJugador("Pedro"), jugador2);
		
		juego.distribuirPersonajesEquipos();
		
		Assert.assertEquals(goku.getCasillero().getCoordenada().getX(), 0);
		Assert.assertEquals(goku.getCasillero().getCoordenada().getY(), 0);
		Assert.assertEquals(gohan.getCasillero().getCoordenada().getX(), 0);
		Assert.assertEquals(gohan.getCasillero().getCoordenada().getY(), 1);
		Assert.assertEquals(piccolo.getCasillero().getCoordenada().getX(), 0);
		Assert.assertEquals(piccolo.getCasillero().getCoordenada().getY(), 2);
		
		//lo siguiente es teniendo en cuenta que el tablero es de 30x30
		Assert.assertEquals(freezer.getCasillero().getCoordenada().getX(), 29);
		Assert.assertEquals(freezer.getCasillero().getCoordenada().getY(), 29);
		Assert.assertEquals(majinboo.getCasillero().getCoordenada().getX(), 29);
		Assert.assertEquals(majinboo.getCasillero().getCoordenada().getY(), 28);
		Assert.assertEquals(cell.getCasillero().getCoordenada().getX(), 29);
		Assert.assertEquals(cell.getCasillero().getCoordenada().getY(), 27);
		
	}
	
}
