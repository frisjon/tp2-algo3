package testEntregas;
//CREAR TESTS UNITARIOS PARA CELL Y GOKU Y ASI LES SACO ASSERTS DEMAS
import org.junit.Assert;

import junit.framework.*;
import modelo.consumibles.ErrorConsumibleInstantaneo;
import modelo.equipo.Equipo;
import modelo.juego.Juego;
import modelo.jugador.Jugador;
import modelo.pelea.ErrorNoHayKi;
import modelo.pelea.ErrorNoSePuedeRealizarAtaqueEspecial;
import modelo.pelea.Pelea;
import modelo.personajes.Cell;
import modelo.personajes.ErrorNoPuedeCambiarEstado;
import modelo.personajes.Gohan;
import modelo.personajes.Goku;
import modelo.personajes.MajinBoo;
import modelo.personajes.Piccolo;
import modelo.tablero.Casillero;
import modelo.tablero.ErrorCasilleroYaOcupado;
import modelo.tablero.ErrorNoHayMasExtremos;

public class TestSegundaEntrega extends TestCase {
	public void test01VerificarGohanNoLlegaASegundaTransformacionDebeLanzarExcepcion() {
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
		try {gohan.cambiarAEstado2();
		} catch (ErrorNoPuedeCambiarEstado e) {}
		try {gohan.cambiarAEstado3();
		} catch (ErrorNoPuedeCambiarEstado e) {}
	}
	
	public void test02VerificarGohanLlegaASegundaTransformacion()  {
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
		try {gohan.cambiarAEstado3();
		} catch (ErrorNoPuedeCambiarEstado e) {}
		Assert.assertEquals(gohan.getIdEstado(), 3);
		
	}
	
	public void test03VerificarPiccoloNoLegaASegundaTransformacionDebeLanzarExcepcion() {
		Gohan gohan = new Gohan();
		Piccolo piccolo = new Piccolo();
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
		try {piccolo.cambiarAEstado2();
		} catch (ErrorNoPuedeCambiarEstado e) {}
		gohan.quitarVida(240); //para verificar que sacandole el 20% de vida a gohan, piccolo no se pude transformar
		try {
			piccolo.cambiarAEstado3();
		} catch (ErrorNoPuedeCambiarEstado e) {}
	}

	public void test04VerificarPiccoloLlegaASegundaTransformacion() {
		Gohan gohan = new Gohan();
		Piccolo piccolo = new Piccolo();
		Casillero casillero1 = new Casillero(0,1);
		Casillero casillero2 = new Casillero(0,2);
		
		try{
			casillero1.setObjeto(gohan);
			casillero2.setObjeto(piccolo);
		}catch (ErrorCasilleroYaOcupado e) {}
		gohan.setCasillero(casillero1);
		piccolo.setCasillero(casillero2);
		
		piccolo.setProtegido(gohan);
		gohan.quitarVida(250);
		try {piccolo.cambiarAEstado3();
		} catch (ErrorNoPuedeCambiarEstado e) {}
		Assert.assertEquals(piccolo.getIdEstado(), 3);
	}

	public void test05VerificarQueCellNoLlegaAPrimeraTransformacionDebeLanzarExcepcion() {
		Cell cell = new Cell();
		Casillero casillero = new Casillero(0,1);
		try{casillero.setObjeto(cell);
		}catch (ErrorCasilleroYaOcupado e) {}
		cell.setCasillero(casillero);
		
		try {cell.cambiarAEstado2();
		} catch (ErrorNoPuedeCambiarEstado e) {}
	}
	
	public void test06VerificarQueCellNoLlegaASegundaTransformacionDebeLanzarExcepcion() {
		Cell cell = new Cell();
		Casillero casillero = new Casillero(0,1);
		try{casillero.setObjeto(cell);
		}catch (ErrorCasilleroYaOcupado e) {}
		cell.setCasillero(casillero);
		
		try {cell.cambiarAEstado3();
		} catch (ErrorNoPuedeCambiarEstado e) {}
	}
	
	public void test07VerificarCorrectoFuncionamientoAbsorverVidaDeCell() {
		Cell cell = new Cell();
		Casillero casilleroconenemigo = new Casillero(0,1);
		try{casilleroconenemigo.setObjeto(cell);
		}catch (ErrorCasilleroYaOcupado e) {}
		cell.setCasillero(casilleroconenemigo);
		Gohan gohan = new Gohan();
		Casillero casilleroconguerrero = new Casillero(0,3);
		try{ casilleroconguerrero.setObjeto(gohan);
		}catch (ErrorCasilleroYaOcupado e) {}
		gohan.setCasillero(casilleroconguerrero);
		int vida_cell;
		int vida_gohan;
		
		cell.agregarKi(100);
		try {
			Pelea.ataqueEspecial(cell, gohan);
		} catch (ErrorNoHayKi | ErrorNoSePuedeRealizarAtaqueEspecial | ErrorConsumibleInstantaneo e) {}
		vida_gohan = (int) gohan.getVida();
		vida_cell = (int) cell.getVida();
		Assert.assertEquals(vida_cell, 500);
		Assert.assertEquals(vida_gohan, 280);
		
		cell.quitarVida(60); //lo deja en 420 de vida
		try {
			Pelea.ataqueEspecial(cell, gohan);
			Pelea.ataqueEspecial(cell, gohan);
			Pelea.ataqueEspecial(cell, gohan);
		} catch (ErrorNoHayKi | ErrorNoSePuedeRealizarAtaqueEspecial | ErrorConsumibleInstantaneo e) {}
		vida_gohan = (int) gohan.getVida();
		vida_cell = (int) cell.getVida();
		try {cell.cambiarAEstado2();
		} catch (ErrorNoPuedeCambiarEstado e) {}
		Assert.assertEquals(cell.getIdEstado(), 2);
		Assert.assertEquals(vida_gohan, 220);
		Assert.assertEquals(vida_cell, 500);
		
		try {cell.cambiarAEstado2();
		} catch (ErrorNoPuedeCambiarEstado e) {}
		Assert.assertEquals(cell.getIdEstado(), 2);
		
		cell.quitarVida(160); //lo deja en 360 de vida a cell
		//tener en cuenta que ahora cell esta en transformacion 2 y por cada ataque especial saca y absorbe 40
		for (int i = 0; i < 4; i++) {
			try {
				Pelea.ataqueEspecial(cell, gohan);
			} catch (ErrorNoHayKi | ErrorNoSePuedeRealizarAtaqueEspecial | ErrorConsumibleInstantaneo e) {}
		}
		
		vida_cell = (int) cell.getVida();
		Assert.assertEquals(vida_cell, 500);
		
		try {cell.cambiarAEstado3();
		} catch (ErrorNoPuedeCambiarEstado e) {}
		Assert.assertEquals(cell.getIdEstado(), 3);
	}
	
	
	public void test08VerificarCorrectoFuncionamientoConvierteteEnChocolateDeMajinboo() {
		MajinBoo majinboo = new MajinBoo();
		Casillero casilleroconenemigo = new Casillero(0,1);
		try { casilleroconenemigo.setObjeto(majinboo);
		} catch (ErrorCasilleroYaOcupado e) {}
		majinboo.setCasillero(casilleroconenemigo);
		Gohan gohan = new Gohan();
		Casillero casilleroconguerrero = new Casillero(0,3);
		try { casilleroconguerrero.setObjeto(gohan);
		} catch (ErrorCasilleroYaOcupado e) {}
		gohan.setCasillero(casilleroconguerrero);
		
		majinboo.agregarKi(30);
		try {
			Pelea.ataqueEspecial(majinboo, gohan);
		} catch (ErrorNoHayKi | ErrorNoSePuedeRealizarAtaqueEspecial | ErrorConsumibleInstantaneo e) {}
		Assert.assertEquals(gohan.getTurnosInutilizados(), 3);
	}
	
	public void test09VerificarCorrectoFuncionamientoDanioGokuEstandoCasiMuerto() {
		Goku goku = new Goku();
		Casillero casilleroconguerrero = new Casillero(0,1);
		try { casilleroconguerrero.setObjeto(goku);
		} catch (ErrorCasilleroYaOcupado e) {}
		goku.setCasillero(casilleroconguerrero);
		Cell cell = new Cell();
		Casillero casilleroconenemigo = new Casillero(0,3);
		try { casilleroconenemigo.setObjeto(cell);
		} catch (ErrorCasilleroYaOcupado e) {}
		cell.setCasillero(casilleroconenemigo);
		int vida_cell;
		
		try { Pelea.ataqueBasico(goku, cell);
		} catch (ErrorConsumibleInstantaneo e) {}
		vida_cell = (int) cell.getVida();
		Assert.assertEquals(vida_cell, 480);
		
		cell.agregarVida(20); //le recargo la vida a cell
		goku.quitarVida(410); //le saco a goku mas del 80% de la vida
		try { Pelea.ataqueBasico(goku, cell);
		} catch (ErrorConsumibleInstantaneo e) {}
		vida_cell = (int) cell.getVida();
		Assert.assertEquals(vida_cell, 476);
	}
}
