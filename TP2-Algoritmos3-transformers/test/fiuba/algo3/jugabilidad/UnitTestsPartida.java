package fiuba.algo3.jugabilidad;


import org.junit.Assert;
import org.junit.Test;

import fiuba.algo3.modelo.excepciones.NoEsValidaLaTransformacionAModoUnico;
import fiuba.algo3.modelo.jugabilidad.Direccion;
import fiuba.algo3.modelo.jugabilidad.Jugador;
import fiuba.algo3.modelo.jugabilidad.Partida;
import fiuba.algo3.modelo.jugabilidad.TipoTransformer;
import fiuba.algo3.modelo.tablero.Posicion;

public class UnitTestsPartida {

	private Jugador jugador1;
	private Jugador jugador2;

		
	@Test 
	public void moverAlgoformerTest(){
		this.jugador1 = new Jugador("Pepe", TipoTransformer.AUTOBOT);
		this.jugador2 = new Jugador("Beto", TipoTransformer.DECEPTICON);
		Partida partida = new Partida(this.jugador1, this.jugador2);
		Posicion posicionInicial = new Posicion(0,1);
		Assert.assertEquals(this.jugador1.getPersonaje2().getPosicion(),posicionInicial);
		Assert.assertEquals(partida.getTurno().getJugadorActual(),this.jugador1);
		
		//Algoformer se mueve hacia la Derecha
		Direccion direccion = new Direccion();
		partida.moverAlgoformerA(this.jugador1.getPersonaje2(), direccion.getDerecha());
		Posicion posicionEsperada = new Posicion(0,2);
		Assert.assertEquals(this.jugador1.getPersonaje2().getPosicion(),posicionEsperada);
		
		//El algoformer se mueve en diagonal
		partida.moverAlgoformerA(this.jugador1.getPersonaje2(), direccion.getDiagonalDerInferior());
		posicionEsperada = new Posicion(1,3);
		Assert.assertEquals(this.jugador1.getPersonaje2().getPosicion(),posicionEsperada);

	}
	
	@Test
	public void simulacionJugadaDeAtaque(){
		Direccion movimiento = new Direccion();
		this.jugador1 = new Jugador("Pepe", TipoTransformer.AUTOBOT);
		this.jugador2 = new Jugador("Beto", TipoTransformer.DECEPTICON);
		Partida partida = new Partida(this.jugador1, this.jugador2);

		//Muevo a optimus 5 veces
		partida.transformarAlgoformer(partida.obtenerJugadorDelTurno().getPersonaje1());						
		for (int i = 1 ; i <= 5 ; i++){
			partida.moverAlgoformerA(partida.obtenerJugadorDelTurno().getPersonaje1(), movimiento.getDiagonalDerInferior());						
		}
		partida.finalizarTurno();
		
		//Muevo a megatron 8 veces
		partida.transformarAlgoformer(partida.obtenerJugadorDelTurno().getPersonaje1());						
		for (int i = 1 ; i <= 8 ; i++){
			partida.moverAlgoformerA(partida.obtenerJugadorDelTurno().getPersonaje1(), movimiento.getDiagonalIzqSuperior());						
		}
		partida.finalizarTurno();
		
		//Muevo a optimus 5 veces
		for (int i = 1 ; i <= 5 ; i++){
			partida.moverAlgoformerA(partida.obtenerJugadorDelTurno().getPersonaje1(), movimiento.getDiagonalDerInferior());						
		}
		partida.finalizarTurno();
		
		//Muevo a megatron 8 veces
		for (int i = 1 ; i <= 8 ; i++){
			partida.moverAlgoformerA(partida.obtenerJugadorDelTurno().getPersonaje1(), movimiento.getDiagonalIzqSuperior());						
		}
		partida.finalizarTurno();
		
		//Muevo a optimus 5 veces
		for (int i = 1 ; i < 5 ; i++){
			partida.moverAlgoformerA(partida.obtenerJugadorDelTurno().getPersonaje1(), movimiento.getDiagonalDerInferior());						
		}
		partida.finalizarTurno();
		
		//Muevo a megatron 8 veces
		for (int i = 0 ; i < 8 ; i++){
			partida.moverAlgoformerA(partida.obtenerJugadorDelTurno().getPersonaje1(), movimiento.getDiagonalIzqSuperior());						
		}
		partida.finalizarTurno();
		
		//Muevo a optimus 5 veces
		for (int i = 1 ; i <= 5 ; i++){
			partida.moverAlgoformerA(partida.obtenerJugadorDelTurno().getPersonaje1(), movimiento.getDiagonalDerInferior());						
		}
		partida.finalizarTurno();
		
		//Muevo a megatron 6 veces
		for (int i = 1 ; i <= 6 ; i++){
			partida.moverAlgoformerA(partida.obtenerJugadorDelTurno().getPersonaje1(), movimiento.getDiagonalIzqSuperior());						
		}
		partida.finalizarTurno();
		
		Assert.assertEquals(500,this.jugador1.getPersonaje1().getPuntosDeVida());
		Assert.assertEquals(550,this.jugador2.getPersonaje1().getPuntosDeVida());
		
		partida.atacarConAlgoformerA(this.jugador1.getPersonaje1(), this.jugador2.getPersonaje1());
		
		Assert.assertEquals(500,this.jugador1.getPersonaje1().getPuntosDeVida());
		Assert.assertEquals(535,this.jugador2.getPersonaje1().getPuntosDeVida());
		
	}
	
	@Test
	public void simulacionDeTransformacionModoUnico(){
		this.jugador1 = new Jugador("Pepe", TipoTransformer.AUTOBOT);
		this.jugador2 = new Jugador("Beto", TipoTransformer.DECEPTICON);
		Partida partida = new Partida(this.jugador1, this.jugador2);
		
		Assert.assertNull(this.jugador1.getPersonajeModoUnico());
		partida.transformarAlgoformerAModoUnico(this.jugador1);
		Assert.assertNotNull(this.jugador1.getPersonajeModoUnico());
		Assert.assertEquals(1000,this.jugador1.getPersonajeModoUnico().getPuntosDeVida());
	
	}
	
	@Test(expected = NoEsValidaLaTransformacionAModoUnico.class)
	public void simulacionDeTransformacionModoUnicoNoValidaPorPosiciones(){
		Direccion direccion = new Direccion();
		this.jugador1 = new Jugador("Pepe", TipoTransformer.AUTOBOT);
		this.jugador2 = new Jugador("Beto", TipoTransformer.DECEPTICON);
		Partida partida = new Partida(this.jugador1, this.jugador2);
		partida.moverAlgoformerA(this.jugador1.getPersonaje2(), direccion.getDiagonalDerInferior());
		partida.moverAlgoformerA(this.jugador1.getPersonaje2(), direccion.getDiagonalDerInferior());
		
		Assert.assertNull(this.jugador1.getPersonajeModoUnico());
		partida.transformarAlgoformerAModoUnico(this.jugador1);
	
	}
	
}
