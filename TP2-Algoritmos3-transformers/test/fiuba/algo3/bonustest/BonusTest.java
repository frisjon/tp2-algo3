package fiuba.algo3.bonustest;

import org.junit.Assert;
import org.junit.Test;

import fiuba.algo3.modelo.bonus.*;
import fiuba.algo3.modelo.jugabilidad.Direccion;
import fiuba.algo3.modelo.jugabilidad.Jugador;
import fiuba.algo3.modelo.jugabilidad.Partida;
import fiuba.algo3.modelo.jugabilidad.TipoTransformer;
import fiuba.algo3.modelo.personajes.Personaje;
import fiuba.algo3.modelo.tablero.Posicion;

public class BonusTest {
	
	@Test
	public void test01AlgoformerCapturaCanionYAtacaDobleHumanoide(){		
		
		//Creo los jugadores, y la partida. Valido el test con el Personaje 1 de cada uno
		Jugador j1 = new Jugador("j1",TipoTransformer.AUTOBOT);
		Jugador j2 = new Jugador("j2",TipoTransformer.DECEPTICON);
		
		Partida p1 = new Partida(j1, j2);		
		
		Personaje optimus = j1.getPersonaje1();
		Personaje megatron =j2.getPersonaje1();
		Direccion direccion = new Direccion();		
		
		//Paso al turno del jugador 2
		p1.finalizarTurno();
		Assert.assertTrue(p1.obtenerJugadorDelTurno() == j2);
		
		//Megatron se transforma en su modo alterno
		p1.transformarAlgoformer(megatron);
		p1.finalizarTurno();
		p1.finalizarTurno();
		
		//Posiciono el bonus doble canion en la posicion (2,2)
		DobleCanion canion = new DobleCanion();
		Posicion posicionBonus = new Posicion(2,2);
		canion.setPosicion(posicionBonus);
		
		//Megatron se mueve en diagonal hacia la posicion (2,2)
		for (int i = 0 ; i < 6 ; i++){
			for(int j = 0; j < 8; j++){
				p1.moverAlgoformerA(megatron, direccion.getDiagonalIzqSuperior());
			}
			p1.finalizarTurno();
			p1.finalizarTurno();
		}
		
		Posicion posMegatron = new Posicion(2,2);
		Assert.assertTrue(megatron.getPosicion().equals(posMegatron));
		
		//Megatron se transforma en su modo humanoide
		p1.transformarAlgoformer(megatron);
		p1.finalizarTurno();
		p1.finalizarTurno();
		
		//Megatron en modo humanoide tiene 10 ptos de ataque
		Assert.assertEquals(megatron.getAtaque(),10);				
		
		//Optimus tiene 500 ptos de vida
		Assert.assertTrue(optimus.getPuntosDeVida() == 500);
		
		//Optimus es atacado por Megatron el cual le quita 10 ptos de vida
		p1.atacarConAlgoformerA(megatron, optimus);
		Assert.assertTrue(optimus.getPuntosDeVida() == 490);
		
		p1.finalizarTurno();
		p1.finalizarTurno();
		
		//Megatron toma el bonus en modo humanoide, ahora tiene 20 ptos de ataque
		megatron.agregarBonusPersonaje(canion);
		Assert.assertEquals(megatron.getAtaque(),20);
		
		//Optimus es atacado por Megatron con con bonus, el cual le quita 20 ptos de vida
		p1.atacarConAlgoformerA(megatron, optimus);
		Assert.assertTrue(optimus.getPuntosDeVida() == 470);
		p1.finalizarTurno();
		p1.finalizarTurno();
		
		//Al segundo turno propio el danio sigue siendo el doble
		Assert.assertEquals(megatron.getAtaque(),20);
		p1.atacarConAlgoformerA(megatron, optimus);
		Assert.assertTrue(optimus.getPuntosDeVida() == 450);
		p1.finalizarTurno();
		p1.finalizarTurno();
		
		//Al tercer turno propio el danio sigue siendo el doble
		Assert.assertEquals(megatron.getAtaque(),20);
		p1.atacarConAlgoformerA(megatron, optimus);
		Assert.assertTrue(optimus.getPuntosDeVida() == 430);
		p1.finalizarTurno();
		p1.finalizarTurno();
		
		//Al pasar los tres turnos el danio vuelve a la normalidad
		Assert.assertEquals(megatron.getAtaque(),10);
		p1.atacarConAlgoformerA(megatron, optimus);
		Assert.assertTrue(optimus.getPuntosDeVida() == 420);
		p1.finalizarTurno();
		p1.finalizarTurno();
				
	}
	
	
	@Test
	public void test02AlgoformerCapturaCanionYAtacaDobleAlterno(){		
		
		//Creo los jugadores, y la partida. Valido el test con el Personaje 1 de cada uno
		Jugador j1 = new Jugador("j1",TipoTransformer.AUTOBOT);
		Jugador j2 = new Jugador("j2",TipoTransformer.DECEPTICON);
		
		Partida p1 = new Partida(j1, j2);		
		
		Personaje optimus = j1.getPersonaje1();
		Personaje megatron =j2.getPersonaje1();
		Direccion direccion = new Direccion();		
		
		//Paso al turno del jugador 2
		p1.finalizarTurno();
		Assert.assertTrue(p1.obtenerJugadorDelTurno() == j2);
		
		//Megatron y optimus se transforman en su modo alterno
		p1.transformarAlgoformer(megatron);
		p1.finalizarTurno();
		p1.transformarAlgoformer(optimus);
		p1.finalizarTurno();
		
		//Posiciono el bonus doble canion en la posicion (2,2)
		DobleCanion canion = new DobleCanion();
		Posicion posicionBonus = new Posicion(2,2);
		canion.setPosicion(posicionBonus);
		
		//Megatron se mueve en diagonal hacia la posicion (2,2)
		for (int i = 0 ; i < 6 ; i++){
			for(int j = 0; j < 8; j++){
				p1.moverAlgoformerA(megatron, direccion.getDiagonalIzqSuperior());
			}
			p1.finalizarTurno();
			p1.finalizarTurno();
		}
		
		Posicion posMegatron = new Posicion(2,2);
		Assert.assertTrue(megatron.getPosicion().equals(posMegatron));
		
		//Megatron en modo alterno tiene 55 ptos de ataque
		Assert.assertEquals(megatron.getAtaque(),55);				
		
		//Optimus alterno tiene 500 ptos de vida
		Assert.assertTrue(optimus.getPuntosDeVida() == 500);
		
		//Optimus es atacado por Megatron el cual le quita 55 ptos de vida
		p1.atacarConAlgoformerA(megatron, optimus);
		Assert.assertTrue(optimus.getPuntosDeVida() == 445);
		
		p1.finalizarTurno();
		p1.finalizarTurno();
		
		//Megatron toma el bonus en modo humanoide, ahora tiene 20 ptos de ataque
		megatron.agregarBonusPersonaje(canion);
		Assert.assertEquals(megatron.getAtaque(),110);
		
		//Optimus es atacado por Megatron con con bonus, el cual le quita 20 ptos de vida
		p1.atacarConAlgoformerA(megatron, optimus);
		Assert.assertTrue(optimus.getPuntosDeVida() == 335);
		p1.finalizarTurno();
		p1.finalizarTurno();
		
		//Al segundo turno propio el danio sigue siendo el doble
		Assert.assertEquals(megatron.getAtaque(),110);
		p1.atacarConAlgoformerA(megatron, optimus);
		Assert.assertTrue(optimus.getPuntosDeVida() == 225);
		p1.finalizarTurno();
		p1.finalizarTurno();
		
		//Al tercer turno propio el danio sigue siendo el doble
		Assert.assertEquals(megatron.getAtaque(),110);
		p1.atacarConAlgoformerA(megatron, optimus);
		Assert.assertTrue(optimus.getPuntosDeVida() == 115);
		p1.finalizarTurno();
		p1.finalizarTurno();
		
		//Al pasar los tres turnos el danio vuelve a la normalidad
		Assert.assertEquals(megatron.getAtaque(),55);
		p1.atacarConAlgoformerA(megatron, optimus);
		Assert.assertTrue(optimus.getPuntosDeVida() == 60);
		p1.finalizarTurno();
		p1.finalizarTurno();
		
	}
		
	@Test
	public void test03AlgoformerCapturaBurbujaYEsInmuneHumanoide(){		
		
		//Creo los jugadores, y la partida. Valido el test con el Personaje 1 de cada uno
		Jugador j1 = new Jugador("j1",TipoTransformer.AUTOBOT);
		Jugador j2 = new Jugador("j2",TipoTransformer.DECEPTICON);
		
		Partida p1 = new Partida(j1, j2);		
		
		Personaje optimus = j1.getPersonaje1();
		Personaje megatron =j2.getPersonaje1();
		Direccion direccion = new Direccion();		
		
		//Paso al turno del jugador 2
		p1.finalizarTurno();
		Assert.assertTrue(p1.obtenerJugadorDelTurno() == j2);
		
		//Megatron se transforman en su modo alterno
		p1.transformarAlgoformer(megatron);
		p1.finalizarTurno();
		p1.finalizarTurno();
		
		//Posiciono el bonus burbuja inmaculada en la posicion (2,2)
		BurbujaInmaculada burbuja = new BurbujaInmaculada();
		Posicion posicionBonus = new Posicion(2,2);
		burbuja.setPosicion(posicionBonus);
		
		//Megatron se mueve en diagonal hacia la posicion (2,2)
		for (int i = 0 ; i < 6 ; i++){
			for(int j = 0; j < 8; j++){
				p1.moverAlgoformerA(megatron, direccion.getDiagonalIzqSuperior());
			}
			p1.finalizarTurno();
			p1.finalizarTurno();
		}
		
		Posicion posMegatron = new Posicion(2,2);
		Assert.assertTrue(megatron.getPosicion().equals(posMegatron));
		
		//Megatron se transforman en su modo humanoide
		p1.transformarAlgoformer(megatron);
		p1.finalizarTurno();
		
		//Megatron humanoide tiene 550 ptos de vida
		Assert.assertTrue(megatron.getPuntosDeVida() == 550);
		
		//Megatron es atacado por Optimus el cual le quita 50 ptos de vida
		p1.atacarConAlgoformerA(optimus, megatron);
		Assert.assertTrue(megatron.getPuntosDeVida() == 500);
		p1.finalizarTurno();
		p1.finalizarTurno();
		
		//Megatron toma el bonus de burbuja inmaculada en modo humanoide
		megatron.agregarBonusPersonaje(burbuja);
		
		//Megatron con el bonus burbuja es atacado por Optimus por lo que no recibe danio
		p1.atacarConAlgoformerA(optimus, megatron);
		Assert.assertTrue(megatron.getPuntosDeVida() == 500);
		p1.finalizarTurno();
		p1.finalizarTurno();
		
		//Al segundo turno sigue sin recibir danio
		p1.atacarConAlgoformerA(optimus, megatron);
		Assert.assertTrue(megatron.getPuntosDeVida() == 500);
		p1.finalizarTurno();
		p1.finalizarTurno();
		
		//Al pasar los dos turnos megatron vuelve a recibir danio
		p1.atacarConAlgoformerA(optimus, megatron);
		Assert.assertTrue(megatron.getPuntosDeVida() == 450);
		p1.finalizarTurno();
		p1.finalizarTurno();
	}

	
	@Test
	public void test04AlgoformerCapturaBurbujaYEsInmuneAlterno(){		
		
		//Creo los jugadores, y la partida. Valido el test con el Personaje 1 de cada uno
		Jugador j1 = new Jugador("j1",TipoTransformer.AUTOBOT);
		Jugador j2 = new Jugador("j2",TipoTransformer.DECEPTICON);
		
		Partida p1 = new Partida(j1, j2);		
		
		Personaje optimus = j1.getPersonaje1();
		Personaje megatron =j2.getPersonaje1();
		Direccion direccion = new Direccion();		
		
		//Paso al turno del jugador 2
		p1.finalizarTurno();
		Assert.assertTrue(p1.obtenerJugadorDelTurno() == j2);
		
		//Megatron se transforman en su modo alterno
		p1.transformarAlgoformer(megatron);
		p1.finalizarTurno();
		p1.transformarAlgoformer(optimus);
		p1.finalizarTurno();
		
		//Posiciono el bonus burbuja inmaculada en la posicion (2,2)
		BurbujaInmaculada burbuja = new BurbujaInmaculada();
		Posicion posicionBonus = new Posicion(2,2);
		burbuja.setPosicion(posicionBonus);
		
		//Megatron se mueve en diagonal hacia la posicion (2,2)
		for (int i = 0 ; i < 6 ; i++){
			for(int j = 0; j < 8; j++){
				p1.moverAlgoformerA(megatron, direccion.getDiagonalIzqSuperior());
			}
			p1.finalizarTurno();
			p1.finalizarTurno();
		}
		
		Posicion posMegatron = new Posicion(2,2);
		Assert.assertTrue(megatron.getPosicion().equals(posMegatron));
		
		//Megatron alterno tiene 550 ptos de vida
		Assert.assertTrue(megatron.getPuntosDeVida() == 550);
		
		//Megatron es atacado por Optimus el cual le quita 15 ptos de vida
		p1.atacarConAlgoformerA(optimus, megatron);
		Assert.assertTrue(megatron.getPuntosDeVida() == 535);
		p1.finalizarTurno();
		p1.finalizarTurno();
		
		//Megatron toma el bonus de burbuja inmaculada en modo alterno
		megatron.agregarBonusPersonaje(burbuja);
		
		//Megatron con el bonus burbuja es atacado por Optimus por lo que no recibe danio
		p1.atacarConAlgoformerA(optimus, megatron);
		Assert.assertTrue(megatron.getPuntosDeVida() == 535);
		p1.finalizarTurno();
		p1.finalizarTurno();
		
		//Al segundo turno sigue sin recibir danio
		p1.atacarConAlgoformerA(optimus, megatron);
		Assert.assertTrue(megatron.getPuntosDeVida() == 535);
		p1.finalizarTurno();
		p1.finalizarTurno();
		
		//Al pasar los dos turnos megatron vuelve a recibir danio
		p1.atacarConAlgoformerA(optimus, megatron);
		Assert.assertTrue(megatron.getPuntosDeVida() == 520);
		p1.finalizarTurno();
		p1.finalizarTurno();
	}
	
	@Test
	public void test05AlgoformerCapturaFlashYEsVelozHumanoide(){		
		
		//Creo los jugadores, y la partida. Valido el test con el Personaje 1 de cada uno
		Jugador j1 = new Jugador("j1",TipoTransformer.AUTOBOT);
		Jugador j2 = new Jugador("j2",TipoTransformer.DECEPTICON);
		
		Partida p1 = new Partida(j1, j2);		
		
		Personaje optimus = j1.getPersonaje1();
		Direccion direccion = new Direccion();
		
		//Posiciono el bonus flash en la posicion (2,2)
		Flash flash = new Flash();
		Posicion posicionBonus = new Posicion(2,2);
		flash.setPosicion(posicionBonus);
		
		//Optimus humanoide tiene 2 de velocidad
		Assert.assertTrue(optimus.getVelocidad() == 2);
		for (int i = 0 ; i < 2 ; i++){
			p1.moverAlgoformerA(optimus, direccion.getDiagonalDerInferior());
		}
		//Optimus se mueve hacia la posicion (2,2)
		Posicion posOptimus = new Posicion(2,2);
		Assert.assertTrue(optimus.getPosicion().equals(posOptimus));
		p1.finalizarTurno();
		p1.finalizarTurno();
		
		//Optimus toma el bonus flash en modo humanoide
		optimus.agregarBonusPersonaje(flash);
		
		//Optimus humanoide ahora tiene 6 de velocidad
		Assert.assertTrue(optimus.getVelocidad() == 6);
		for (int i = 0 ; i < 6 ; i++){
			p1.moverAlgoformerA(optimus, direccion.getDiagonalDerInferior());
		}
		//Optimus ahora esta en la posicion (8,8)
		posOptimus = new Posicion(8,8);
		Assert.assertTrue(optimus.getPosicion().equals(posOptimus));

		p1.finalizarTurno();
		p1.finalizarTurno();
		     
		//Durante el segundo turno sigue con 6 de velocidad
		Assert.assertTrue(optimus.getVelocidad() == 6);
		for (int i = 0 ; i < 6 ; i++){
			p1.moverAlgoformerA(optimus, direccion.getDiagonalDerInferior());
		}		
		
		//Optimus ahora esta en la posicion (14,14)
		posOptimus = new Posicion(14,14);
		Assert.assertTrue(optimus.getPosicion().equals(posOptimus));
		p1.finalizarTurno();
		p1.finalizarTurno();
		
		//Durante el tercer turno sigue con 6 de velocidad
		Assert.assertTrue(optimus.getVelocidad() == 6);
		for (int i = 0 ; i < 6 ; i++){
			p1.moverAlgoformerA(optimus, direccion.getDiagonalDerInferior());
		}		
		
		//Optimus ahora esta en la posicion (20,20)
		posOptimus = new Posicion(20,20);
		Assert.assertTrue(optimus.getPosicion().equals(posOptimus));
		p1.finalizarTurno();
		p1.finalizarTurno();
		
		//Al pasar los tres turnos la velocidad vuelve a la normalidad
		Assert.assertTrue(optimus.getVelocidad() == 2);
		
	}

	@Test
	public void test06AlgoformerCapturaFlashYEsVelozAlterno(){		
		
		//Creo los jugadores, y la partida. Valido el test con el Personaje 1 de cada uno
		Jugador j1 = new Jugador("j1",TipoTransformer.AUTOBOT);
		Jugador j2 = new Jugador("j2",TipoTransformer.DECEPTICON);
		
		Partida p1 = new Partida(j1, j2);		
		
		Personaje optimus = j1.getPersonaje1();
		Direccion direccion = new Direccion();
		
		//Transformo optimus humanoide a modo alterno
		p1.transformarAlgoformer(optimus);
		p1.finalizarTurno();
		p1.finalizarTurno();
		
		//Posiciono el bonus flash en la posicion (5,5)
		Flash flash = new Flash();
		Posicion posicionBonus = new Posicion(5,5);
		flash.setPosicion(posicionBonus);
		
		//Optimus alterno tiene 5 de velocidad
		Assert.assertTrue(optimus.getVelocidad() == 5);
		for (int i = 0 ; i < 5 ; i++){
			p1.moverAlgoformerA(optimus, direccion.getDiagonalDerInferior());
		}
		//Optimus se mueve hacia la posicion (5,5)
		Posicion posOptimus = new Posicion(5,5);
		Assert.assertTrue(optimus.getPosicion().equals(posOptimus));
		p1.finalizarTurno();
		p1.finalizarTurno();
		
		//Optimus toma el bonus flash en modo humanoide
		optimus.agregarBonusPersonaje(flash);
		
		//Optimus humanoide ahora tiene 6 de velocidad
		Assert.assertTrue(optimus.getVelocidad() == 15);
		for (int i = 0 ; i < 15 ; i++){
			p1.moverAlgoformerA(optimus, direccion.getDiagonalDerInferior());
		}
		//Optimus ahora esta en la posicion (20,20)
		posOptimus = new Posicion(20,20);
		Assert.assertTrue(optimus.getPosicion().equals(posOptimus));

		p1.finalizarTurno();
		p1.finalizarTurno();
		
      
		//Durante el segundo turno sigue con 15 de velocidad
		Assert.assertTrue(optimus.getVelocidad() == 15);
		for (int i = 0 ; i < 15 ; i++){
			p1.moverAlgoformerA(optimus, direccion.getDiagonalDerInferior());
		}		
		
		//Optimus ahora esta en la posicion (35,35)
		posOptimus = new Posicion(35,35);
		Assert.assertTrue(optimus.getPosicion().equals(posOptimus));
		p1.finalizarTurno();
		p1.finalizarTurno();
	
		//Durante el tercer turno sigue con 15 de velocidad
		Assert.assertTrue(optimus.getVelocidad() == 15);
		for (int i = 0 ; i < 15 ; i++){
			p1.moverAlgoformerA(optimus, direccion.getDiagonalIzqSuperior());
		}		
		
		//Optimus ahora esta en la posicion (20,20)
		posOptimus = new Posicion(20,20);
		Assert.assertTrue(optimus.getPosicion().equals(posOptimus));
		p1.finalizarTurno();
		p1.finalizarTurno();
		
		//Al pasar los tres turnos la velocidad vuelve a la normalidad
		Assert.assertTrue(optimus.getVelocidad() == 5);
	
	}
	
	@Test
	public void test07AlgoformerCapturaFlashYEsVelozHumanoideAlternoHumanoide(){
		
		//Creo los jugadores, y la partida. Valido el test con el Personaje 1 de cada uno
		Jugador j1 = new Jugador("j1",TipoTransformer.AUTOBOT);
		Jugador j2 = new Jugador("j2",TipoTransformer.DECEPTICON);
		
		Partida p1 = new Partida(j1, j2);		
		
		Personaje optimus = j1.getPersonaje1();
		Direccion direccion = new Direccion();
		
		//Posiciono el bonus flash en la posicion (2,2)
		Flash flash = new Flash();
		Posicion posicionBonus = new Posicion(2,2);
		flash.setPosicion(posicionBonus);
		
		//Optimus humanoide tiene 2 de velocidad
		Assert.assertTrue(optimus.getVelocidad() == 2);
		for (int i = 0 ; i < 2 ; i++){
			p1.moverAlgoformerA(optimus, direccion.getDiagonalDerInferior());
		}
		//Optimus se mueve hacia la posicion (2,2)
		Posicion posOptimus = new Posicion(2,2);
		Assert.assertTrue(optimus.getPosicion().equals(posOptimus));
		p1.finalizarTurno();
		p1.finalizarTurno();
		
		//Optimus toma el bonus flash en modo humanoide
		optimus.agregarBonusPersonaje(flash);
		
		//Optimus humanoide ahora tiene 6 de velocidad
		Assert.assertTrue(optimus.getVelocidad() == 6);
		for (int i = 0 ; i < 6 ; i++){
			p1.moverAlgoformerA(optimus, direccion.getDiagonalDerInferior());
		}
		//Optimus ahora esta en la posicion (8,8)
		posOptimus = new Posicion(8,8);
		Assert.assertTrue(optimus.getPosicion().equals(posOptimus));

		p1.finalizarTurno();
		p1.finalizarTurno();
		    
		//Durante el segundo turno transformo a Optimus a modo Alterno
		p1.transformarAlgoformer(optimus);
		p1.finalizarTurno();
		p1.finalizarTurno();
		
		//Durante el tercer turno optimus alterno tiene 15 de velocidad
		Assert.assertTrue(optimus.getVelocidad() == 15);
		for (int i = 0 ; i < 15 ; i++){
			p1.moverAlgoformerA(optimus, direccion.getDiagonalDerInferior());
		}		
		
		//Optimus ahora esta en la posicion (23,23)
		posOptimus = new Posicion(23,23);
		Assert.assertTrue(optimus.getPosicion().equals(posOptimus));
		p1.finalizarTurno();
		p1.finalizarTurno();
		
		//Al pasar los tres turnos la velocidad vuelve a la normalidad en ambos modos
		Assert.assertTrue(optimus.getVelocidad() == 5);
		p1.transformarAlgoformer(optimus);
		p1.finalizarTurno();
		p1.finalizarTurno();
		Assert.assertTrue(optimus.getVelocidad() == 2);
		
	}
	
	@Test
	public void test08AlgoformerNoCapturaDosBonusIguales(){		
		
		//Creo los jugadores, y la partida. Valido el test con el Personaje 1 de cada uno
		Jugador j1 = new Jugador("j1",TipoTransformer.AUTOBOT);
		Jugador j2 = new Jugador("j2",TipoTransformer.DECEPTICON);
		
		@SuppressWarnings("unused")
		Partida p1 = new Partida(j1, j2);		
		
		Personaje optimus = j1.getPersonaje1();
		
		Posicion posicionOptimus = new Posicion(14,14);		
		optimus.setPosicion(posicionOptimus);
		
		//Velocidad de Optimus es 2 en modo humanoide
		Assert.assertEquals(optimus.getVelocidad(),2);		
		
		Flash flash = new Flash();
		Posicion posicionBonus = new Posicion(14,14);
		flash.setPosicion(posicionBonus);		
				
		optimus.agregarBonusPersonaje(flash);		
		
		//Optimus Humanoide tiene velocidad 6. Flash triplica
		Assert.assertEquals(optimus.getVelocidad(),6);
		
		
		//Intento agregar otro flash
		Flash flash2 = new Flash();		
		flash2.setPosicion(posicionBonus);		
		optimus.agregarBonusPersonaje(flash2);		
		
		//Optimus Humanoide tiene velocidad 6, si ya cuenta con un Flash
		Assert.assertEquals(optimus.getVelocidad(),6);
				
	}
	
		
}
