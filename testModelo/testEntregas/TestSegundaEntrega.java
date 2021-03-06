package testEntregas;
import org.junit.Assert;

import junit.framework.*;
import modelo.juego.Equipo;
import modelo.juego.Juego;
import modelo.juego.Jugador;
import modelo.juego.PosibleEquipo;
import modelo.pelea.Pelea;
import modelo.personajes.Cell;
import modelo.personajes.ErrorNoPuedeCambiarEstado;
import modelo.personajes.Gohan;
import modelo.personajes.Goku;
import modelo.personajes.MajinBoo;
import modelo.personajes.Piccolo;
import modelo.tablero.Casillero;
import modelo.tablero.ErrorCasilleroYaOcupado;

public class TestSegundaEntrega extends TestCase {
	public void test01VerificarGohanNoLlegaASegundaTransformacionDebeLanzarExcepcion() {
		Juego juego = new Juego();
		Goku goku = new Goku(PosibleEquipo.guerreros);
		Gohan gohan = new Gohan(PosibleEquipo.guerreros);
		Piccolo piccolo = new Piccolo(PosibleEquipo.guerreros);
		
		Equipo equipo = new Equipo(PosibleEquipo.guerreros);
		equipo.agregarPersonaje(goku);
		equipo.agregarPersonaje(gohan);
		equipo.agregarPersonaje(piccolo);
		
		Jugador jugador = new Jugador("Juan", equipo);
		juego.agregarJugador(jugador);
		
		juego.distribuirPersonajesEquipos();
		
		gohan.agregarKi(10);
		gohan.cambiarAEstado2();
		try {gohan.cambiarAEstado3();
		} catch (ErrorNoPuedeCambiarEstado e) {}
	}
	
	public void test02VerificarGohanLlegaASegundaTransformacion() {
		Juego juego = new Juego();
		Goku goku = new Goku(PosibleEquipo.guerreros);
		Gohan gohan = new Gohan(PosibleEquipo.guerreros);
		Piccolo piccolo = new Piccolo(PosibleEquipo.guerreros);
		
		Equipo equipo = new Equipo(PosibleEquipo.guerreros);
		equipo.agregarPersonaje(goku);
		equipo.agregarPersonaje(gohan);
		equipo.agregarPersonaje(piccolo);
		
		Jugador jugador = new Jugador("Juan", equipo);
		juego.agregarJugador(jugador);
		
		juego.distribuirPersonajesEquipos();
		
		gohan.agregarKi(30);
		gohan.setAliado1(goku);
		gohan.setAliado2(piccolo);
		goku.quitarVida(375); //queda en 125 de vida (menos del 30%)
		piccolo.quitarVida(375); //idem goku
		gohan.cambiarAEstado3();
		Assert.assertEquals(gohan.getIdEstado(), 3);
		
	}
	
	public void test03VerificarPiccoloNoLegaASegundaTransformacionDebeLanzarExcepcion() {
		Gohan gohan = new Gohan(PosibleEquipo.guerreros);
		Piccolo piccolo = new Piccolo(PosibleEquipo.guerreros);
		Casillero casillero1 = new Casillero(0,1);
		Casillero casillero2 = new Casillero(0,2);
		
		try{
			casillero1.setObjeto(gohan);
			casillero2.setObjeto(piccolo);
		}catch (ErrorCasilleroYaOcupado e) {}
		gohan.setCasillero(casillero1);
		piccolo.setCasillero(casillero2);
		
		piccolo.setProtegido(gohan);
		piccolo.agregarKi(20);
		piccolo.cambiarAEstado2();
	
		gohan.quitarVida(240); //para verificar que sacandole el 20% de vida a gohan, piccolo no se pude transformar
		try {piccolo.cambiarAEstado3();
		} catch (ErrorNoPuedeCambiarEstado e) {}
	}

	public void test04VerificarPiccoloLlegaASegundaTransformacion() {
		Gohan gohan = new Gohan(PosibleEquipo.guerreros);
		Piccolo piccolo = new Piccolo(PosibleEquipo.guerreros);
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

	public void test05VerificarQueCellNoLlegaAPrimeraTransformacionDebeLanzarExcepcion() {
		Cell cell = new Cell(PosibleEquipo.enemigos);
		Casillero casillero = new Casillero(0,1);
		casillero.setObjeto(cell);
		cell.setCasillero(casillero);
		
		try {cell.cambiarAEstado2();
		} catch (ErrorNoPuedeCambiarEstado e) {}
	}
	
	public void test06VerificarQueCellNoLlegaASegundaTransformacionDebeLanzarExcepcion() {
		Cell cell = new Cell(PosibleEquipo.enemigos);
		Casillero casillero = new Casillero(0,1);
		casillero.setObjeto(cell);
		cell.setCasillero(casillero);
		
		try {cell.cambiarAEstado3();
		} catch (ErrorNoPuedeCambiarEstado e) {}
	}
	
	public void test07VerificarCorrectoFuncionamientoAbsorverVidaDeCell() {
		Cell cell = new Cell(PosibleEquipo.enemigos);
		Casillero casilleroconenemigo = new Casillero(0,1);
		casilleroconenemigo.setObjeto(cell);
		cell.setCasillero(casilleroconenemigo);
		Gohan gohan = new Gohan(PosibleEquipo.guerreros);
		Casillero casilleroconguerrero = new Casillero(0,3);
		casilleroconguerrero.setObjeto(gohan);
		gohan.setCasillero(casilleroconguerrero);
		
		cell.agregarKi(100);
		for (int i = 0; i < 4; i++) {
			Pelea.ataqueEspecial(cell, gohan);
		}
		
		cell.cambiarAEstado2();
		Assert.assertEquals(cell.getIdEstado(), 2);
		//tener en cuenta que ahora cell esta en transformacion 2 y por cada ataque especial saca y absorbe 40
		for (int i = 0; i < 4; i++) {
			Pelea.ataqueEspecial(cell, gohan);
		}
		cell.cambiarAEstado3();
		Assert.assertEquals(cell.getIdEstado(), 3);
	}
	
	
	public void test08VerificarCorrectoFuncionamientoConvierteteEnChocolateDeMajinboo() {
		MajinBoo majinboo = new MajinBoo(PosibleEquipo.enemigos);
		Casillero casilleroconenemigo = new Casillero(0,1);
		casilleroconenemigo.setObjeto(majinboo);
		majinboo.setCasillero(casilleroconenemigo);
		Gohan gohan = new Gohan(PosibleEquipo.guerreros);
		Casillero casilleroconguerrero = new Casillero(0,3);
		casilleroconguerrero.setObjeto(gohan);
		gohan.setCasillero(casilleroconguerrero);
		
		majinboo.agregarKi(30);
		Pelea.ataqueEspecial(majinboo, gohan);
		Assert.assertEquals(gohan.getTurnosInutilizados(), 3);
	}
	
	public void test09VerificarCorrectoFuncionamientoDanioGokuEstandoCasiMuerto() {
		Goku goku = new Goku(PosibleEquipo.guerreros);
		Casillero casilleroconguerrero = new Casillero(0,1);
		casilleroconguerrero.setObjeto(goku);
		goku.setCasillero(casilleroconguerrero);
		Cell cell = new Cell(PosibleEquipo.enemigos);
		Casillero casilleroconenemigo = new Casillero(0,3);
		casilleroconenemigo.setObjeto(cell);
		cell.setCasillero(casilleroconenemigo);
		
		goku.quitarVida(410); //le saco a goku mas del 80% de la vida
		Pelea.ataqueBasico(goku, cell);
		Assert.assertEquals(cell.getVida(), 476,0);
	}
}
