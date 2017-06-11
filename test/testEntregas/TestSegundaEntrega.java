package testEntregas;

import equipos.Equipo;
import juego.Juego;
import jugadores.Jugador;

import org.junit.Assert;
import junit.framework.*;
import personajes.ErrorNoPuedeCambiarEstado;
import personajes.Gohan;
import personajes.Goku;
import personajes.Piccolo;
import tablero.Casillero;

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
		
		juego.distribuirPersonajesEquipos();
		
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
		
		juego.distribuirPersonajesEquipos();
		
		gohan.agregarKi(30);
		gohan.setAliado1(goku);
		gohan.setAliado2(piccolo);
		goku.quitarVida(375); //queda en 125 de vida (menos del 30%)
		piccolo.quitarVida(375); //idem goku
		gohan.cambiarAEstado3();
		Assert.assertEquals(gohan.getIdEstado(), 3);
		
	}
	
	public void test03VerificarPiccoloNoLegaASegundaTransformacionDebeLanzarExcepcion() throws ErrorNoPuedeCambiarEstado {
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
		Assert.assertEquals(piccolo.getIdEstado(), 2);
		try {
			piccolo.cambiarAEstado3();
		} catch (ErrorNoPuedeCambiarEstado e) {}
	}

}
