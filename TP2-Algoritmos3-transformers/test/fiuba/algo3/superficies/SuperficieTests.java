package fiuba.algo3.superficies;

import org.junit.Assert;
import org.junit.Test;

import fiuba.algo3.modelo.personajes.*;
import fiuba.algo3.modelo.superficies.*;

public class SuperficieTests {
	@Test
	public void test01AlgoformerHumanoideNoPuedeAtravesarPantano(){
		//Optimus y Megatron no pueden atravesar pantanos en modo humanoide
		Optimus optimus = new Optimus();
		Megatron megatron = new Megatron();
		
		SuperficieTerrestre pantano = new SuperficiePantano();
		
		Assert.assertFalse(pantano.puedeAtravesarlo(optimus));
		Assert.assertFalse(pantano.puedeAtravesarlo(megatron));
	}
	@Test
	public void test02AlgoformerAlternoPuedeAtravesarPantano(){
		//Optimus y Megatron pueden atravesar pantano en modo alterno
		Optimus optimus = new Optimus();
		Megatron megatron = new Megatron();
		
		SuperficieTerrestre pantano = new SuperficiePantano();
		
		optimus.transformar();
		megatron.transformar();
		
		Assert.assertTrue(pantano.puedeAtravesarlo(optimus));
		Assert.assertTrue(pantano.puedeAtravesarlo(megatron));
	}
	@Test
	public void test03AlgoformersHumanoidesYAlternosPuedeAtravesarRocosaYNube(){
		//Optimus y Megatron pueden atravesar roca y nube en cualquier modo
		Optimus optimus = new Optimus();
		Megatron megatron = new Megatron();
		
		SuperficieTerrestre rocosa = new SuperficieRocosa();
		SuperficieAerea nube = new SuperficieNube();
		
		Assert.assertTrue(rocosa.puedeAtravesarlo(optimus));
		Assert.assertTrue(rocosa.puedeAtravesarlo(megatron));
		Assert.assertTrue(nube.puedeAtravesarlo(optimus));
		Assert.assertTrue(nube.puedeAtravesarlo(megatron));
		
		optimus.transformar();
		megatron.transformar();
		
		Assert.assertTrue(rocosa.puedeAtravesarlo(optimus));
		Assert.assertTrue(rocosa.puedeAtravesarlo(megatron));
		Assert.assertTrue(nube.puedeAtravesarlo(optimus));
		Assert.assertTrue(nube.puedeAtravesarlo(megatron));
		
	}
	@Test
	public void test04EspinasNoLastimanAlgoformerAereo(){
		//Algoformers aereos no sufren quita de vida de espinas
		Ratchet ratchet = new Ratchet();
		Megatron megatron = new Megatron();
		
		SuperficieTerrestre espinas = new SuperficieEspinas();
		
		Assert.assertTrue(espinas.puedeAtravesarlo(ratchet));
		Assert.assertTrue(espinas.puedeAtravesarlo(megatron));
		
		ratchet.transformar();
		
		Assert.assertTrue(espinas.puedeAtravesarlo(ratchet));

		espinas.producirEfecto(ratchet);
		
		Assert.assertTrue(ratchet.getPuntosDeVida() == 150);
		
		megatron.transformar();
		Assert.assertTrue(espinas.puedeAtravesarlo(megatron));

		espinas.producirEfecto(megatron);

		Assert.assertTrue(megatron.getPuntosDeVida() == 550);
	}
	
	@Test
	public void test05EspinasLastimanAlgoformerNoAereo(){
		Ratchet ratchet = new Ratchet();
		Optimus optimus = new Optimus();
		Megatron megatron = new Megatron();
		Superion superion = new Superion(1000);
		
		SuperficieTerrestre espinas = new SuperficieEspinas();
		
		//Pueden atravesar la superficie espinas
		Assert.assertTrue(espinas.puedeAtravesarlo(ratchet));
		Assert.assertTrue(espinas.puedeAtravesarlo(optimus));
		Assert.assertTrue(espinas.puedeAtravesarlo(megatron));
		Assert.assertTrue(espinas.puedeAtravesarlo(superion));
		
		//Espinas sacan 5% vida ratchet en modo humanoide
		espinas.producirEfecto(ratchet);
		
		Assert.assertTrue(ratchet.getPuntosDeVida() == 143);
		
		//Espinas sacan 5% vida optimus en cualquiera de sus modos y todas las veces que pase por ellas
		espinas.producirEfecto(optimus);

		Assert.assertTrue(optimus.getPuntosDeVida() == 475);
		
		espinas.producirEfecto(optimus);
		
		Assert.assertTrue(optimus.getPuntosDeVida() == 452);
		
		optimus.transformar();
		Assert.assertTrue(espinas.puedeAtravesarlo(optimus));

		espinas.producirEfecto(optimus);
		
		Assert.assertTrue(optimus.getPuntosDeVida() == 430);
		
		//Espinas sacan 5% vida Megatron en modo humanoide
		espinas.producirEfecto(megatron);
		
		Assert.assertTrue(megatron.getPuntosDeVida() == 523);
		
		//Espinas sacan 5% vida Superion en modo unico
		espinas.producirEfecto(superion);
		
		Assert.assertTrue(superion.getPuntosDeVida() == 950);
	}
	@Test
	public void test06TormentaPsionicaAfectaAtaqueAlgoformerAereo(){
		Ratchet ratchet = new Ratchet();
		Megatron megatron = new Megatron();
		
		SuperficieAerea tormenta = new SuperficieTormentaPsionica();
		
		Assert.assertTrue(tormenta.puedeAtravesarlo(ratchet));
		Assert.assertTrue(tormenta.puedeAtravesarlo(megatron));
		
		ratchet.transformar();
		megatron.transformar();
		
		Assert.assertTrue(tormenta.puedeAtravesarlo(ratchet));
		Assert.assertTrue(tormenta.puedeAtravesarlo(megatron));
		
		//Tormenta disminuye en un 40% ataque de algoformers aereos
		tormenta.producirEfecto(ratchet);
		tormenta.producirEfecto(megatron);
		
		Assert.assertTrue(ratchet.getAtaque() == 21);
		Assert.assertTrue(megatron.getAtaque() == 33);
		
		//Al pasar por segunda vez no afecta
		tormenta.producirEfecto(ratchet);
		tormenta.producirEfecto(megatron);
		
		Assert.assertTrue(ratchet.getAtaque() == 21);
		Assert.assertTrue(megatron.getAtaque() == 33);
		
		//Ataque del modo humanoide no se vio afectado
		ratchet.transformar();
		megatron.transformar();
		
		tormenta.producirEfecto(ratchet);
		tormenta.producirEfecto(megatron);
		
		Assert.assertTrue(ratchet.getAtaque() == 5);
		Assert.assertTrue(megatron.getAtaque() == 10);
		
		//Al volver a transformarse a unidad aerea el ataque sigue disminuido y no se volver a disminuir
		ratchet.transformar();
		megatron.transformar();
		
		Assert.assertTrue(ratchet.getAtaque() == 21);
		Assert.assertTrue(megatron.getAtaque() == 33);
		
		tormenta.producirEfecto(ratchet);
		tormenta.producirEfecto(megatron);
		
		Assert.assertTrue(ratchet.getAtaque() == 21);
		Assert.assertTrue(megatron.getAtaque() == 33);
	}
	
	@Test
	public void test07TormentaPsionicaNoAfectaAlgoformersNoAereos(){
		Ratchet ratchet = new Ratchet();
		Megatron megatron = new Megatron();
		Optimus optimus = new Optimus();
		Superion superion = new Superion(1000);
		
		SuperficieAerea tormenta = new SuperficieTormentaPsionica();
		
		Assert.assertTrue(tormenta.puedeAtravesarlo(ratchet));
		Assert.assertTrue(tormenta.puedeAtravesarlo(megatron));
		Assert.assertTrue(tormenta.puedeAtravesarlo(optimus));
		Assert.assertTrue(tormenta.puedeAtravesarlo(superion));

		//Tormenta no disminuye ataque de algoformers en modo humanoide
		tormenta.producirEfecto(ratchet);
		tormenta.producirEfecto(megatron);
		tormenta.producirEfecto(optimus);

		Assert.assertTrue(ratchet.getAtaque() == 5);
		Assert.assertTrue(megatron.getAtaque() == 10);
		Assert.assertTrue(optimus.getAtaque() == 50);
		
		//Tormenta no afecta ataque de algoformers en modo unico
		tormenta.producirEfecto(superion);
		
		Assert.assertTrue(superion.getAtaque() == 100);
		
		//Tormenta no afecta ataque de algoformers terrestres
		optimus.transformar();

		tormenta.producirEfecto(optimus);

		Assert.assertTrue(optimus.getAtaque() == 15);
		
	}
	
	
	@Test
	public void test08PruebasDeAtravesarSuperficieDeCampo(){
		Personaje optimus = new Optimus();
		Personaje megatron = new Megatron();
		
		SuperficieAerea tormenta = new SuperficieTormentaPsionica();
		SuperficieTerrestre pantano = new SuperficiePantano();
		
		SuperficieDeCampo supDeCampo = new SuperficieDeCampo(tormenta,pantano);
		
		//En modo humanoide no pueden atravesar el pantano
		Assert.assertFalse(supDeCampo.puedeAtravesarlo(megatron));
		Assert.assertFalse(supDeCampo.puedeAtravesarlo(optimus));
		
		megatron.transformar();
		optimus.transformar();
		
		//En modo alterno, tanto siendo terrestres como aereos pueden atravesar el pantano y la tormenta
		Assert.assertTrue(supDeCampo.puedeAtravesarlo(megatron));
		Assert.assertTrue(supDeCampo.puedeAtravesarlo(optimus));
	}
		
		@Test
		public void test09PruebasDeAplicarEfectosEnSuperficieDeCampo(){
			Personaje optimus = new Optimus();
			Personaje megatron = new Megatron();
			
			SuperficieAerea tormenta = new SuperficieTormentaPsionica();
			SuperficieTerrestre espinas = new SuperficieEspinas();
			
			SuperficieDeCampo supDeCampo = new SuperficieDeCampo(tormenta,espinas);
			
			supDeCampo.aplicarEfecto(megatron);
			supDeCampo.aplicarEfecto(optimus);
			
			//A los dos algoformers se les aplica el efecto de las espinas por ser unidades terrestres
			Assert.assertTrue(megatron.getPuntosDeVida() == 523);
			Assert.assertTrue(optimus.getPuntosDeVida() == 475);
			
			megatron.transformar();
			optimus.transformar();
			
			supDeCampo.aplicarEfecto(megatron);
			supDeCampo.aplicarEfecto(optimus);
			//A megatron se le aplica el efecto aereo y a optimus se le aplica el efecto terrestre
			Assert.assertTrue(megatron.getPuntosDeVida() == 523);
			Assert.assertTrue(megatron.getAtaque() == 33);
			Assert.assertTrue(optimus.getPuntosDeVida() == 452);
			Assert.assertTrue(optimus.getAtaque() == 15);
			
	}
		@Test
		public void test10SuperficieDeCampoConPantanoReduceVelocidadExtraAlternoTerrestre(){

			Personaje optimus = new Optimus();
			Assert.assertFalse(optimus.getModoAlgoformer().esAlterno());
			optimus.transformar();
			Assert.assertTrue(optimus.getModoAlgoformer().esAlterno());
			Assert.assertEquals(5,optimus.getVelocidad());
	
			SuperficieAerea nube = new SuperficieNube();
			SuperficieTerrestre pantano = new SuperficiePantano();
			SuperficieDeCampo supDeCampo = new SuperficieDeCampo(nube,pantano);

			Assert.assertTrue(supDeCampo.puedeAtravesarlo(optimus));
			
			optimus.reducirVelocidad();
			supDeCampo.aplicarEfecto(optimus);
			
			Assert.assertEquals(optimus.getVelocidad(),3);
			
		}
		
		@Test
		public void test11PantanoReduceVelocidadExtraAlternoTerrestre(){

			Personaje optimus = new Optimus();
			SuperficieTerrestre pantano = new SuperficiePantano();
		
			Assert.assertFalse(optimus.getModoAlgoformer().esAlterno());
			Assert.assertFalse(pantano.seReduceLaVelocidad(optimus));

			optimus.transformar();
			Assert.assertTrue(optimus.getModoAlgoformer().esAlterno());
			Assert.assertTrue(pantano.seReduceLaVelocidad(optimus));
			
		}
		
		@Test
		public void test12SuperficieDeCampoConNebulosaInmovilizaTresTurnos(){

			Personaje ratchet = new Ratchet();
			Assert.assertEquals(ratchet.getTurnosInmovilizado(),0);
			Assert.assertFalse(ratchet.getModoAlgoformer().esUnidadAerea());
			Assert.assertFalse(ratchet.getModoAlgoformer().esAlterno());
			ratchet.transformar();
			Assert.assertTrue(ratchet.getModoAlgoformer().esAlterno());
			Assert.assertTrue(ratchet.getModoAlgoformer().esUnidadAerea());
			Assert.assertEquals(ratchet.getTurnosInmovilizado(),0);
	
			SuperficieAerea nebulosaDeAndromeda = new SuperficieNebulosaDeAndromeda();
			SuperficieTerrestre rocosa = new SuperficieRocosa();
			SuperficieDeCampo supDeCampo = new SuperficieDeCampo(nebulosaDeAndromeda,rocosa);

			Assert.assertTrue(supDeCampo.puedeAtravesarlo(ratchet));
			
			supDeCampo.aplicarEfecto(ratchet);
			
			Assert.assertEquals(ratchet.getTurnosInmovilizado(),3);
			
			ratchet.reestablecerEfectos(); //CAMBIO DE TURNO

			Assert.assertEquals(ratchet.getTurnosInmovilizado(),2);

			ratchet.reestablecerEfectos(); //CAMBIO DE TURNO

			Assert.assertEquals(ratchet.getTurnosInmovilizado(),1);

			ratchet.reestablecerEfectos(); //CAMBIO DE TURNO
			
			Assert.assertEquals(ratchet.getTurnosInmovilizado(),0);
			
		}
		
		@Test
		public void test13NebulosaInmovilizaTresTurnos(){

			Personaje ratchet = new Ratchet();
			Assert.assertEquals(ratchet.getTurnosInmovilizado(),0);
			Assert.assertFalse(ratchet.getModoAlgoformer().esUnidadAerea());
			Assert.assertFalse(ratchet.getModoAlgoformer().esAlterno());
			ratchet.transformar();
			Assert.assertTrue(ratchet.getModoAlgoformer().esAlterno());
			Assert.assertTrue(ratchet.getModoAlgoformer().esUnidadAerea());
			Assert.assertEquals(ratchet.getTurnosInmovilizado(),0);
	
			SuperficieAerea nebulosaDeAndromeda = new SuperficieNebulosaDeAndromeda();
			
			nebulosaDeAndromeda.producirEfecto(ratchet);
			
			Assert.assertEquals(ratchet.getTurnosInmovilizado(),3);
			
			ratchet.reestablecerEfectos(); //CAMBIO DE TURNO

			Assert.assertEquals(ratchet.getTurnosInmovilizado(),2);

			ratchet.reestablecerEfectos(); //CAMBIO DE TURNO

			Assert.assertEquals(ratchet.getTurnosInmovilizado(),1);

			ratchet.reestablecerEfectos(); //CAMBIO DE TURNO
			
			Assert.assertEquals(ratchet.getTurnosInmovilizado(),0);
			
		}
}
