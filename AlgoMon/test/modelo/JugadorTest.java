package modelo;

import modelo.algomones.*;
import modelo.ataques.*;
import modelo.elementos.Pocion;
import modelo.elementos.Restaurador;
import modelo.estados.EstadoNormal;
import modelo.excepciones.AlgoMonInexistenteException;
import modelo.excepciones.AtaqueInvalidoException;
import modelo.excepciones.AtaquesAgotadosException;
import modelo.excepciones.CantidadMaximaAlgoMonesException;
import org.junit.Test;

import static org.junit.Assert.*;

public class JugadorTest {

	@Test
	public void testCreacionJugador() {
		Jugador jugador = new Jugador(0,"Pedro");
		assertNotNull(jugador);
	}
	
	@Test
	public void testAgregarAlgomones() {
		Jugador jugador = new Jugador(0,"Pedro");
		AlgoMon jigg = new Jigglypuff();
		AlgoMon charm = new Charmander();
		jugador.agregarAlgomon(jigg);
		jugador.agregarAlgomon(charm);
		assertEquals(jugador.cantidadAlgomones(), 2);
		assertEquals(jugador.cantidadAlgomones() == 3, false);
	}
	
	@Test(expected = CantidadMaximaAlgoMonesException.class)
	public void testAgregaMasDe3AlgoMones() throws CantidadMaximaAlgoMonesException{
		Jugador jugador = new Jugador(0,"Pedro");
		AlgoMon jigg = new Jigglypuff();
		AlgoMon charm = new Charmander();
		AlgoMon rata = new Rattata();
		AlgoMon chan = new Chansey();
		jugador.agregarAlgomon(jigg);
		jugador.agregarAlgomon(charm);
		jugador.agregarAlgomon(rata);
		jugador.agregarAlgomon(chan);
	}
	
	@Test
	public void testCambiarAlgomonActivo() {
		Jugador jugador = new Jugador(0,"Pedro");
		AlgoMon jigg = new Jigglypuff();
		AlgoMon charm = new Charmander();
		jugador.agregarAlgomon(jigg);
		jugador.agregarAlgomon(charm);
		assertTrue(jugador.getAlgomonActivo().equals(new Jigglypuff()));
		jugador.cambiarDeAlgoMon(new Charmander());
		assertTrue(jugador.getAlgomonActivo().equals(new Charmander()));
	}
	
	@Test(expected = AlgoMonInexistenteException.class)
	public void testCambiarAlgomonInexistente() throws AlgoMonInexistenteException{
		Jugador jugador = new Jugador(0,"Pedro");
		AlgoMon jigg = new Jigglypuff();
		AlgoMon charm = new Charmander();
		jugador.agregarAlgomon(jigg);
		jugador.agregarAlgomon(charm);
		assertTrue(jugador.getAlgomonActivo().equals(new Jigglypuff()));
		jugador.cambiarDeAlgoMon(new Charmander());
		assertTrue(jugador.getAlgomonActivo().equals(new Charmander()));
		jugador.cambiarDeAlgoMon(new Squirtle());
	}
	
	@Test
	public void testTieneAlgomon() {
		Jugador jugador = new Jugador(0,"Pedro");
		AlgoMon jigg = new Jigglypuff();
		AlgoMon charm = new Charmander();
		jugador.agregarAlgomon(jigg);
		jugador.agregarAlgomon(charm);
		assertEquals(jugador.tieneAlgomon(new Jigglypuff()), true);
		assertEquals(jugador.tieneAlgomon(new Charmander()), true);
		assertEquals(jugador.tieneAlgomon(new Bulbasaur()), false);
		assertEquals(jugador.tieneAlgomon(new Squirtle()), false);
	}
	
	@Test
	public void testPrimeraEleccion() {
		Jugador jugador = new Jugador(0,"Pedro");
		AlgoMon jigg = new Jigglypuff();
		AlgoMon charm = new Charmander();
		jugador.agregarAlgomon(jigg);
		jugador.agregarAlgomon(charm);
		assertTrue(jugador.primeraEleccion().equals(new Jigglypuff()));
		assertFalse(jugador.primeraEleccion().equals(new Charmander()));
	}
	
	@Test
	public void testJugadorPerdio() throws AtaquesAgotadosException {
		Jugador jugador = new Jugador(0,"Pedro");
		AlgoMon jigglypuff = new Jigglypuff();
		AlgoMon charmander = new Charmander();
		AlgoMon squirtle = new Squirtle();
		jugador.agregarAlgomon(jigglypuff);
		jugador.agregarAlgomon(charmander);
		for(int i = 0; i <= 5; i++){
			squirtle.atacar(charmander, new CanonDeAgua());
		}
		for(int i = 0; i <= 13; i++){
			squirtle.atacar(jigglypuff, new Burbuja());
		}
		assertEquals(jugador.perdio(), true);
	}
	
	public void testJugadorNoPerdio() throws AtaquesAgotadosException {
		Jugador jugador = new Jugador(0,"Pedro");
		AlgoMon jigglypuff = new Jigglypuff();
		AlgoMon charmander = new Charmander();
		AlgoMon squirtle = new Squirtle();
		jugador.agregarAlgomon(jigglypuff);
		jugador.agregarAlgomon(charmander);
		for(int i = 0; i <= 5; i++){
			squirtle.atacar(charmander, new CanonDeAgua());
		}
		assertEquals(jugador.perdio(), false);
	}
	
	public void testAtacarAlgomonActivo() throws AtaquesAgotadosException {
		Jugador jugador1 = new Jugador(0,"Pedro");
		Jugador jugador2 = new Jugador(1,"Pablo");
		AlgoMon jigglypuff = new Jigglypuff();
		AlgoMon charmander = new Charmander();
		AlgoMon squirtle = new Squirtle();
		jugador1.agregarAlgomon(jigglypuff);
		jugador1.agregarAlgomon(charmander);
		jugador2.agregarAlgomon(squirtle);
		jugador1.atacar(jugador2.getAlgomonActivo(),new AtaqueRapido());
		assertEquals(jugador2.getAlgomonActivo().getVida(), 140);
		assertEquals(jugador2.getAlgomonActivo().estaMuerto(), false);
	}
	
	@Test(expected = AtaqueInvalidoException.class)
	public void testAtacarAlgomonAtaqueInexistente() throws AtaquesAgotadosException {
		Jugador jugador1 = new Jugador(0,"Pedro");
		Jugador jugador2 = new Jugador(1,"Pablo");
		AlgoMon jigglypuff = new Jigglypuff();
		AlgoMon charmander = new Charmander();
		AlgoMon squirtle = new Squirtle();
		jugador1.agregarAlgomon(jigglypuff);
		jugador1.agregarAlgomon(charmander);
		jugador2.agregarAlgomon(squirtle);
		jugador1.atacar(jugador2.getAlgomonActivo(),new Chupavidas());
	}
	
	@Test
	public void testJugadorAplicaElementoPocion() throws AtaquesAgotadosException {
		Jugador jugador1 = new Jugador(0,"Pedro");
		Jugador jugador2 = new Jugador(1,"Pablo");
		
		AlgoMon jigglypuff = new Jigglypuff();
		AlgoMon charmander = new Charmander();
		
		jugador1.agregarAlgomon(charmander);
		jugador2.agregarAlgomon(jigglypuff);
		
		jugador1.atacar(jugador2.getAlgomonActivo(),new AtaqueRapido());
		jugador2.atacar(jugador1.getAlgomonActivo(),new AtaqueRapido());
		
		jugador1.atacar(jugador2.getAlgomonActivo(),new Brasas());
		jugador2.atacar(jugador1.getAlgomonActivo(),new AtaqueRapido());
		
		jugador1.atacar(jugador2.getAlgomonActivo(),new Brasas());
		jugador2.aplicarElemento(new Pocion());
		
		assertEquals(jugador2.vidaAlgomonActivo(), 108); // 130 - 10 - 16 - 16 + 20 = 108
	}
	
	@Test
	public void testJugadorAplicaElementoRestaurador() throws AtaquesAgotadosException {
		Jugador jugador1 = new Jugador(0,"Pedro");
		Jugador jugador2 = new Jugador(1,"Pablo");
		
		AlgoMon jigglypuff = new Jigglypuff();
		AlgoMon charmander = new Charmander();
		
		jugador1.agregarAlgomon(charmander);
		jugador2.agregarAlgomon(jigglypuff);
		
		jugador1.atacar(jugador2.getAlgomonActivo(),new Fogonazo());	// Lo quema
		jugador2.atacar(jugador1.getAlgomonActivo(),new AtaqueRapido());
		
		jugador1.atacar(jugador2.getAlgomonActivo(),new Brasas());
		jugador2.aplicarElemento(new Restaurador());
		
		jugador1.atacar(jugador2.getAlgomonActivo(),new Brasas());
		jugador2.atacar(jugador1.getAlgomonActivo(),new AtaqueRapido());
		
		assertEquals(jugador2.vidaAlgomonActivo(), 83); // 130 - 2 - 16 - 13 (Quemado) - 16 = 83
		assertEquals(jugador2.getAlgomonActivo().getEstadoPersistente() instanceof EstadoNormal, true);
	}
}
