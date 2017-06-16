package modelo;

import modelo.algomones.*;
import modelo.ataques.*;
import modelo.excepciones.AtaquesAgotadosException;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Entrega2Test {
	
	@Test
	public void test01JigglypuffAtacaConCanto() throws AtaquesAgotadosException {
		
		AlgoMon jigglypuff = new Jigglypuff();
		AlgoMon squirtle = new Squirtle();
		Canto canto = new Canto();
		AtaqueRapido ataqueRapido = new AtaqueRapido();
		Burbuja burbuja = new Burbuja();

		jigglypuff.atacar(squirtle, canto);
		squirtle.atacar(jigglypuff, ataqueRapido);
		squirtle.nuevoTurno();
		jigglypuff.atacar(squirtle, burbuja);
		squirtle.atacar(jigglypuff, ataqueRapido);
		squirtle.nuevoTurno();
		jigglypuff.atacar(squirtle, burbuja);
		squirtle.atacar(jigglypuff, ataqueRapido);
		squirtle.nuevoTurno();
		
		assertEquals(jigglypuff.getVida(), jigglypuff.getVidaOriginal());

	}
	
	@Test
	public void test02ChanseyAtacaConCanto() throws AtaquesAgotadosException {
		
		AlgoMon squirtle = new Squirtle();
		AlgoMon chansey = new Chansey();
		Canto canto = new Canto();
		Burbuja burbuja = new Burbuja();
		AtaqueRapido ataqueRapido = new AtaqueRapido();

		
		chansey.atacar(squirtle, canto);
		squirtle.atacar(chansey, burbuja);
		squirtle.nuevoTurno();
		chansey.atacar(squirtle, ataqueRapido);
		squirtle.atacar(chansey, burbuja);
		squirtle.nuevoTurno();
		chansey.atacar(squirtle, ataqueRapido);
		squirtle.atacar(chansey, burbuja);
		squirtle.nuevoTurno();
		chansey.atacar(squirtle, ataqueRapido);
		squirtle.atacar(chansey, burbuja);	// En este si le hace dano
		squirtle.nuevoTurno();
		
		assertEquals(chansey.getVida(), 120); // 130 - 10 (pot. burbuja)
		
	}
	
	@Test
	public void test03BulbasaurAtacaConChupavidasACharmander() throws AtaquesAgotadosException {
		AlgoMon bulbasaur = new Bulbasaur();
		AlgoMon charmander = new Charmander();
		LatigoCepa latigo = new LatigoCepa();
		AtaqueRapido ataqueRapido = new AtaqueRapido();
		Chupavidas chupavidas = new Chupavidas();
		
		bulbasaur.atacar(charmander, latigo);
		charmander.atacar(bulbasaur, ataqueRapido);
		
		bulbasaur.atacar(charmander, chupavidas);
		charmander.atacar(bulbasaur, ataqueRapido);
		
		bulbasaur.atacar(charmander, ataqueRapido);
		charmander.atacar(bulbasaur, ataqueRapido);
		
		assertEquals(bulbasaur.getVida(), 112); // 140 - 30 = 110 + 2 (Ganancia Chupavidas)

	}
	
	@Test
	public void test04BulbasaurAtacaConChupavidasASquirtle() throws AtaquesAgotadosException {
		AlgoMon bulbasaur2 = new Bulbasaur();
		AlgoMon squirtle = new Squirtle();
		LatigoCepa latigo = new LatigoCepa();
		AtaqueRapido ataqueRapido = new AtaqueRapido();
		Chupavidas chupavidas = new Chupavidas();
		
		bulbasaur2.atacar(squirtle, latigo);
		squirtle.atacar(bulbasaur2, ataqueRapido);
		
		bulbasaur2.atacar(squirtle, chupavidas);
		squirtle.atacar(bulbasaur2, ataqueRapido);
		
		bulbasaur2.atacar(squirtle, ataqueRapido);
		squirtle.atacar(bulbasaur2, ataqueRapido);
		
		assertEquals(bulbasaur2.getVida(), 119); // 140 - 30 = 110 + 9 (Ganancia Chupavidas)
		
	}
	
	@Test
	public void test05BulbasaurAtacaConChupavidasAOtrosAlgomones() throws AtaquesAgotadosException {
		AlgoMon bulbasaur = new Bulbasaur();
		AlgoMon rattata = new Rattata();
		AlgoMon chansey = new Chansey();
		AlgoMon jiggly = new Jigglypuff();
		AtaqueRapido ataqueRapido = new AtaqueRapido();
		Chupavidas chupavidas = new Chupavidas();
		Burbuja burbuja = new Burbuja();

		
		chansey.atacar(bulbasaur, ataqueRapido);
		bulbasaur.atacar(rattata, chupavidas);
		
		rattata.atacar(bulbasaur, burbuja);
		bulbasaur.atacar(chansey, chupavidas);
		
		jiggly.atacar(bulbasaur, ataqueRapido);
		bulbasaur.atacar(jiggly, chupavidas);
		
		assertEquals(bulbasaur.getVida(), 127); // 140 - 25 = 115 + 4 + 4 + 4 (Ganancia Chupavidas)
	}
	
	@Test
	public void test06CharmanderAtacaConFogonazo() throws AtaquesAgotadosException {
		AlgoMon charmander = new Charmander();
		AlgoMon rattata = new Rattata();
		AlgoMon squirtle = new Squirtle();
		Fogonazo fogonazo = new Fogonazo();
		AtaqueRapido ataqueRapido = new AtaqueRapido();
		Burbuja burbuja = new Burbuja();
		
		charmander.atacar(rattata, fogonazo);
		rattata.atacar(charmander, ataqueRapido);
		rattata.nuevoTurno();
		
		charmander.atacar(rattata, ataqueRapido);
		rattata.atacar(charmander, ataqueRapido);
		rattata.nuevoTurno();
		
		charmander.atacar(squirtle, fogonazo);
		squirtle.atacar(charmander, burbuja);
		squirtle.nuevoTurno();
		
		charmander.atacar(squirtle, ataqueRapido);
		squirtle.atacar(charmander, burbuja);
		squirtle.nuevoTurno();
		
		assertEquals(rattata.getVida(), 124); // 170 - 2 - 10 = 158 - 17 - 17 (Dos quemados)
		assertEquals(squirtle.getVida(), 109); // 150 - 1 - 10 = 139 - 15 - 15 (Dos quemados)
	}
	
	@Test
	public void test07RattataAtacaConFogonazo() throws AtaquesAgotadosException {
		AlgoMon rattata = new Rattata();
		AlgoMon chansey = new Chansey();
		AlgoMon bulba = new Bulbasaur();
		Fogonazo fogonazo = new Fogonazo();
		LatigoCepa latigo = new LatigoCepa();
		AtaqueRapido ataqueRapido = new AtaqueRapido();
		Chupavidas chupavidas = new Chupavidas();
		
		rattata.atacar(chansey, fogonazo);
		chansey.atacar(rattata, latigo);
		chansey.nuevoTurno();
		
		rattata.atacar(chansey, ataqueRapido);
		chansey.atacar(rattata, ataqueRapido);
		chansey.nuevoTurno();
		
		rattata.atacar(bulba, fogonazo);
		bulba.atacar(rattata, latigo);
		bulba.nuevoTurno();
		
		rattata.atacar(bulba, ataqueRapido);
		bulba.atacar(rattata, chupavidas);
		bulba.nuevoTurno();
		
		assertEquals(chansey.getVida(), 92); // 130 - 2 - 10 = 118 - 13 - 13 (Dos quemados)
		assertEquals(bulba.getVida(), 102); // 140 - 4 - 10 = 126 - 14 - 14 + 4 (Dos quemados + Chupavidas)
	}
}