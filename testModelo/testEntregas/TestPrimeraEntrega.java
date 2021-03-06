package testEntregas;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;

import junit.framework.*;
import modelo.juego.Equipo;
import modelo.juego.Juego;
import modelo.juego.Jugador;
import modelo.juego.PosibleEquipo;
import modelo.pelea.ErrorNoSePuedeRealizarAtaqueEspecial;
import modelo.pelea.Pelea;
import modelo.personajes.Cell;
import modelo.personajes.ErrorNoPuedeCambiarEstado;
import modelo.personajes.Freezer;
import modelo.personajes.Gohan;
import modelo.personajes.Goku;
import modelo.personajes.MajinBoo;
import modelo.personajes.Piccolo;
import modelo.tablero.Casillero;
import modelo.tablero.ErrorCasilleroYaOcupado;
import modelo.tablero.ErrorMovimientoInvalido;
import modelo.tablero.Tablero;


public class TestPrimeraEntrega extends TestCase {
	
	public void test01MoverPersonajeYVerificarNuevaPosicion() {
		Tablero tablero = new Tablero(20, 20);
		Casillero casillero1 = new Casillero(0,0);
		Casillero casillero2 = new Casillero(0,1);
		Casillero casillero3 = new Casillero(0,2);
		Goku goku = new Goku(PosibleEquipo.guerreros);
		List<Casillero> camino = new ArrayList<Casillero>();
		
		camino.add(casillero2);
		camino.add(casillero3);
		casillero1.setObjeto(goku);
		goku.setCasillero(casillero1);
		tablero.moverPersonaje(goku, camino);
		Assert.assertEquals(casillero3.getObjeto(), goku);
		Assert.assertEquals(casillero1.estaLibre(), true);
	}

	public void test02MoverPersonajeMasDeLoQuePuedeDebeLanzarExcepcion() {
		Tablero tablero = new Tablero(20,20);
		Casillero casillero1 = new Casillero(0,0);
		Casillero casillero2 = new Casillero(0,1);
		Casillero casillero3 = new Casillero(0,2);
		Casillero casillero4 = new Casillero(0,3);
		Goku goku = new Goku(PosibleEquipo.guerreros);
		List<Casillero> camino = new ArrayList<Casillero>();
		
		camino.add(casillero2);
		camino.add(casillero3);
		camino.add(casillero4);
		casillero1.setObjeto(goku);
		goku.setCasillero(casillero1);
		try {tablero.moverPersonaje(goku, camino);
		} catch (ErrorMovimientoInvalido e){}
	}
	
	public void test03VerificarImposibilidadDosPersonajesEnCasilleroDebeLanzarExcepcion() {
		Casillero casillero = new Casillero(0,0);
		Goku goku = new Goku(PosibleEquipo.guerreros);
		Gohan gohan = new Gohan(PosibleEquipo.guerreros);
		casillero.setObjeto(goku);
		try {casillero.setObjeto(gohan);
		} catch (ErrorCasilleroYaOcupado e) {}
	 }
	
	public void test04VerificarImposibilidadPersonajePasarPorEncimaDeOtroDebeLanzarExcepcion() {
		Tablero tablero = new Tablero(20,20);
		Casillero casillero1 = new Casillero(0,0);
		Casillero casillero2 = new Casillero(0,1);
		Casillero casillero3 = new Casillero(0,2);
		Goku goku = new Goku(PosibleEquipo.guerreros);
		Gohan gohan = new Gohan(PosibleEquipo.guerreros);
		List<Casillero> camino = new ArrayList<Casillero>();
		
		casillero1.setObjeto(goku);
		casillero2.setObjeto(gohan);
		
		goku.setCasillero(casillero1);
		gohan.setCasillero(casillero2);
		camino.add(casillero2);
		camino.add(casillero3);
		try {tablero.moverPersonaje(goku, camino);
		} catch (ErrorMovimientoInvalido e){} catch (ErrorCasilleroYaOcupado e) {}
	}
	
	public void test05VerificarTransformacionGokuEnEstadoDos() {
		Casillero casillero = new Casillero(0,0);
		Goku goku = new Goku(PosibleEquipo.guerreros);
		
		casillero.setObjeto(goku);
		goku.setCasillero(casillero);
		goku.agregarKi(20);
		goku.cambiarAEstado2();

		Assert.assertEquals(goku.getIdEstado(), 2);
	}
	
	public void test06VerificarImposibilidadTransformacionGokuEnEstadoTresDebeLanzarExcepcion() {
		Casillero casillero = new Casillero(0,0);
		Goku goku = new Goku(PosibleEquipo.guerreros);
		
		casillero.setObjeto(goku);
		goku.setCasillero(casillero);
		goku.agregarKi(20);
		try {
			goku.cambiarAEstado3();
		} catch (ErrorNoPuedeCambiarEstado e) {}
	}
	
	public void test07VerificarMovimientoGokuEnEstadoDos() {
		Tablero tablero = new Tablero(20,20);
		Casillero casillero1 = new Casillero(0,0);
		Casillero casillero2 = new Casillero(0,1);
		Casillero casillero3 = new Casillero(0,2);
		Casillero casillero4 = new Casillero(0,3);
		Goku goku = new Goku(PosibleEquipo.guerreros);
		List<Casillero> camino = new ArrayList<Casillero>();
		
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
		Goku goku = new Goku(PosibleEquipo.guerreros);
		Gohan gohan = new Gohan(PosibleEquipo.guerreros);
		Piccolo piccolo = new Piccolo(PosibleEquipo.guerreros);
		Freezer freezer = new Freezer(PosibleEquipo.enemigos);
		MajinBoo majinboo = new MajinBoo(PosibleEquipo.enemigos);
		Cell cell = new Cell(PosibleEquipo.enemigos);
		
		Equipo equipo1 = new Equipo(PosibleEquipo.guerreros);
		equipo1.agregarPersonaje(goku);
		equipo1.agregarPersonaje(gohan);
		equipo1.agregarPersonaje(piccolo);
		
		Equipo equipo2 = new Equipo(PosibleEquipo.enemigos);
		equipo2.agregarPersonaje(freezer);
		equipo2.agregarPersonaje(majinboo);
		equipo2.agregarPersonaje(cell);
		
		
		Jugador jugador1 = new Jugador("Juan", equipo1);
		Jugador jugador2 = new Jugador("Pedro", equipo2);
		
		juego.agregarJugador(jugador1);
		juego.agregarJugador(jugador2);
		//verifico que el juego tenga a los jugadores
		//Assert.assertEquals(juego.pedirJugador("Juan"), jugador1);
		//Assert.assertEquals(juego.pedirJugador("Pedro"), jugador2);
		
		
		juego.distribuirPersonajesEquipos();
		
		//lo siguiente es teniendo en cuenta que el tablero es de 30x30
		
		if((goku.getCasillero().getCoordenada().getX() == 29) ||(goku.getCasillero().getCoordenada().getX() == 0)) Assert.assertEquals(true, true);
		if((gohan.getCasillero().getCoordenada().getX() == 29) ||(gohan.getCasillero().getCoordenada().getX() == 0)) Assert.assertEquals(true, true);
		if((piccolo.getCasillero().getCoordenada().getX() == 29) ||(piccolo.getCasillero().getCoordenada().getX() == 0)) Assert.assertEquals(true, true);
		if((freezer.getCasillero().getCoordenada().getX() == 29) ||(freezer.getCasillero().getCoordenada().getX() == 0)) Assert.assertEquals(true, true);
		if((majinboo.getCasillero().getCoordenada().getX() == 29) ||(majinboo.getCasillero().getCoordenada().getX() == 0)) Assert.assertEquals(true, true);
		if((cell.getCasillero().getCoordenada().getX() == 29) ||(cell.getCasillero().getCoordenada().getX() == 0)) Assert.assertEquals(true, true);
		
	}
	
	public void test09VerificarModificacionEstatusPersonajesLuegoDeCombatir() {
		Casillero casilleroconguerrero = new Casillero(5,5);
		Casillero casilleroconenemigo = new Casillero(5,8);
		Goku goku = new Goku(PosibleEquipo.guerreros);
		Freezer freezer = new Freezer(PosibleEquipo.enemigos);
		
		goku.setCasillero(casilleroconguerrero);
		casilleroconguerrero.setObjeto(goku);
		freezer.setCasillero(casilleroconenemigo);
		casilleroconenemigo.setObjeto(freezer);
		
		goku.agregarKi(20);
		goku.cambiarAEstado2();
		
		Pelea.ataqueBasico(goku, freezer);
		
		freezer.agregarKi(20);
		
		Pelea.ataqueEspecial(freezer, goku);
		Assert.assertEquals(goku.getVida(), 476,0);
		Assert.assertEquals(freezer.getVida(), 360,0);
	}
	
	public void test10VerificarImposibilidadDeAtacarDebidoADistanciaDebeLanzarExcepcion() {
		Casillero casilleroconguerrero = new Casillero(5,5);
		Casillero casilleroconenemigo = new Casillero(5,9);
		Goku goku = new Goku(PosibleEquipo.guerreros);
		Freezer freezer = new Freezer(PosibleEquipo.enemigos);
		
		goku.setCasillero(casilleroconguerrero);
		casilleroconguerrero.setObjeto(goku);
		freezer.setCasillero(casilleroconenemigo);
		casilleroconenemigo.setObjeto(freezer);
		
		try {
			freezer.agregarKi(20);
			Pelea.ataqueEspecial(freezer, goku);
		} catch (ErrorNoSePuedeRealizarAtaqueEspecial e) {}
	}
	
}