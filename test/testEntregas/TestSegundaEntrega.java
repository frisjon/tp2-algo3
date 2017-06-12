package testEntregas;

import equipos.Equipo;
import juego.Juego;
import jugadores.Jugador;

import org.junit.Assert;

import consumibles.ErrorConsumibleInstantaneo;
import junit.framework.*;
import motor.ErrorNoHayKi;
import motor.ErrorNoSePuedeRealizarAtaqueEspecial;
import motor.Pelea;
import personajes.Cell;
import personajes.ErrorNoPuedeCambiarEstado;
import personajes.Gohan;
import personajes.Goku;
import personajes.Piccolo;
import tablero.Casillero;
import tablero.ErrorCasilleroYaOcupado;
import tablero.ErrorNoHayMasExtremos;

public class TestSegundaEntrega extends TestCase {
	public void test01VerificarGohanNoLlegaASegundaTransformacionDebeLanzarExcepcion() throws ErrorNoPuedeCambiarEstado {
		Juego juego = new Juego();
		Goku goku = new Goku();
		Gohan gohan = new Gohan();
		Piccolo piccolo = new Piccolo();
		
		Equipo equipo = new Equipo("Guerreros Z");
		equipo.agregarPersonaje(goku);
		equipo.agregarPersonaje(gohan);
		equipo.agregarPersonaje(piccolo);
		
		Jugador jugador = new Jugador("Juan", equipo);
		juego.agregarJugador(jugador);
		
		try {
			juego.distribuirPersonajesEquipos();
		} catch (ErrorNoHayMasExtremos e) {
			// se que no me quedo sin extremos ya que son pocos personajes
		}
		
		gohan.agregarKi(10);
		gohan.cambiarAEstado2();
		//verifico cambio de estado
		Assert.assertEquals(gohan.getIdEstado(), 2);
		try {
			gohan.cambiarAEstado3();
		} catch (ErrorNoPuedeCambiarEstado e) {}
	}
	
	public void test02VerificarGohanLlegaASegundaTransformacion() throws ErrorNoPuedeCambiarEstado {
		Juego juego = new Juego();
		Goku goku = new Goku();
		Gohan gohan = new Gohan();
		Piccolo piccolo = new Piccolo();
		
		Equipo equipo = new Equipo("Guerreros Z");
		equipo.agregarPersonaje(goku);
		equipo.agregarPersonaje(gohan);
		equipo.agregarPersonaje(piccolo);
		
		Jugador jugador = new Jugador("Juan", equipo);
		juego.agregarJugador(jugador);
		
		try {
			juego.distribuirPersonajesEquipos();
		} catch (ErrorNoHayMasExtremos e) {
			// se que no me quedo sin extremos ya que son pocos personajes
		}
		
		gohan.agregarKi(30);
		gohan.setAliado1(goku);
		gohan.setAliado2(piccolo);
		goku.quitarVida(375); //queda en 125 de vida (menos del 30%)
		piccolo.quitarVida(375); //idem goku
		gohan.cambiarAEstado3();
		Assert.assertEquals(gohan.getIdEstado(), 3);
		
	}
	
	public void test03VerificarPiccoloNoLegaASegundaTransformacionDebeLanzarExcepcion() throws ErrorNoPuedeCambiarEstado, ErrorCasilleroYaOcupado {
		Gohan gohan = new Gohan();
		Piccolo piccolo = new Piccolo();
		Casillero casillero1 = new Casillero(0,1);
		Casillero casillero2 = new Casillero(0,2);
		
		casillero1.setObjeto(gohan);
		casillero2.setObjeto(piccolo);
		gohan.setCasillero(casillero1);
		piccolo.setCasillero(casillero2);
		
		piccolo.setProtegido(gohan);
		piccolo.agregarKi(20);
		piccolo.cambiarAEstado2();
		gohan.quitarVida(240); //para verificar que sacandole el 20% de vida a gohan piccolo no se pude trasnformar
		Assert.assertEquals(piccolo.getIdEstado(), 2);
		try {
			piccolo.cambiarAEstado3();
		} catch (ErrorNoPuedeCambiarEstado e) {}
	}

	public void test04VerificarPiccoloLlegaASegundaTransformacion() throws ErrorCasilleroYaOcupado, ErrorNoPuedeCambiarEstado {
		Gohan gohan = new Gohan();
		Piccolo piccolo = new Piccolo();
		Casillero casillero1 = new Casillero(0,1);
		Casillero casillero2 = new Casillero(0,2);
		
		casillero1.setObjeto(gohan);
		casillero2.setObjeto(piccolo);
		gohan.setCasillero(casillero1);
		piccolo.setCasillero(casillero2);
		
		piccolo.setProtegido(gohan);
		gohan.quitarVida(250);
		piccolo.cambiarAEstado3();
		Assert.assertEquals(piccolo.getIdEstado(), 3);
	}

	public void test05VerificarQueCellNoLlegaAPrimeraTransformacionDebeLanzarExcepcion() throws ErrorCasilleroYaOcupado, ErrorNoPuedeCambiarEstado {
		Cell cell = new Cell();
		Casillero casillero = new Casillero(0,1);
		casillero.setObjeto(cell);
		cell.setCasillero(casillero);
		
		try {
			cell.cambiarAEstado2();
		} catch (ErrorNoPuedeCambiarEstado e) {}
	}
	
	public void test06VerificarQueCellNoLlegaASegundaTransformacionDebeLanzarExcepcion() throws ErrorCasilleroYaOcupado, ErrorNoPuedeCambiarEstado {
		Cell cell = new Cell();
		Casillero casillero = new Casillero(0,1);
		casillero.setObjeto(cell);
		cell.setCasillero(casillero);
		
		try {
			cell.cambiarAEstado3();
		} catch (ErrorNoPuedeCambiarEstado e) {}
	}
	
	public void test07VerificarCorrectoFuncionamientoAbsorverVidaDeCell() throws ErrorCasilleroYaOcupado, ErrorNoHayKi, ErrorNoSePuedeRealizarAtaqueEspecial, ErrorConsumibleInstantaneo, ErrorNoPuedeCambiarEstado {
		Cell cell = new Cell();
		Casillero casilleroconenemigo = new Casillero(0,1);
		casilleroconenemigo.setObjeto(cell);
		cell.setCasillero(casilleroconenemigo);
		Gohan gohan = new Gohan();
		Casillero casilleroconguerrero = new Casillero(0,3);
		casilleroconguerrero.setObjeto(gohan);
		gohan.setCasillero(casilleroconguerrero);
		int vida_cell;
		int vida_gohan;
		
		cell.agregarKi(100);
		Pelea.ataqueEspecial(cell, gohan);
		vida_gohan = (int) gohan.getVida();
		vida_cell = (int) cell.getVida();
		Assert.assertEquals(vida_cell, 500);
		Assert.assertEquals(vida_gohan, 280);
		
		cell.quitarVida(80); //lo deja en 420 de vida
		Pelea.ataqueEspecial(cell, gohan);
		Pelea.ataqueEspecial(cell, gohan);
		Pelea.ataqueEspecial(cell, gohan);
		vida_gohan = (int) gohan.getVida();
		vida_cell = (int) cell.getVida();
		cell.cambiarAEstado2();
		Assert.assertEquals(cell.getIdEstado(), 2);
		Assert.assertEquals(vida_gohan, 220);
		
		cell.cambiarAEstado2();
		Assert.assertEquals(cell.getIdEstado(), 2);
		
		cell.quitarVida(140);
		//tener en cuenta que ahora cell esta en transformacion 2 y por cada ataque especial saca y absorve 40
		for (int i = 0; i < 4; i++) {
			Pelea.ataqueEspecial(cell, gohan);
		}
		
		Assert.assertEquals(vida_cell, 500);
		Assert.assertEquals(vida_gohan, 60);
		
		cell.cambiarAEstado3();
		Assert.assertEquals(cell.getIdEstado(), 3);
	}
	
	public void test08VerificarCorrectoFuncionamientoConvierteteEnChocolateDeMajinboo() {
		
	}
}
