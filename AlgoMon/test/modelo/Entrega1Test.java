package modelo;

import modelo.algomones.*;
import modelo.ataques.*;
import modelo.excepciones.AtaquesAgotadosException;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Entrega1Test {
	
	@Test
	public void test01SquirtleAtacaACharmander() throws AtaquesAgotadosException{
		AlgoMon squirtle = new Squirtle();
		AlgoMon charmander = new Charmander();
		
		squirtle.atacar(charmander, new Burbuja());
		assertEquals(150,charmander.getVida());
		squirtle.atacar(charmander, new CanonDeAgua());
		assertEquals(110,charmander.getVida());
	}
	
	@Test
	public void test02SquirtleAtacaABulbasaur() throws AtaquesAgotadosException{
		AlgoMon squirtle = new Squirtle();
		AlgoMon bulbasaur = new Bulbasaur();
		squirtle.atacar(bulbasaur, new Burbuja());
		assertEquals(135,bulbasaur.getVida());
		squirtle.atacar(bulbasaur, new CanonDeAgua());
		assertEquals(125,bulbasaur.getVida());
	}
	
	@Test
	public void test03SquirtleAtacaAlResto() throws AtaquesAgotadosException{
		AlgoMon squirtle = new Squirtle();
		AlgoMon jigglypuff = new Jigglypuff();
		AlgoMon chansey = new Chansey();
		AlgoMon rattata = new Rattata();
		Burbuja burbuja = new Burbuja();
		CanonDeAgua canon = new CanonDeAgua();
		
		squirtle.atacar(jigglypuff, burbuja);
		assertEquals(120,jigglypuff.getVida());
		squirtle.atacar(jigglypuff, canon);
		assertEquals(100,jigglypuff.getVida());
		squirtle.atacar(chansey, burbuja);
		assertEquals(120,chansey.getVida());
		squirtle.atacar(chansey, canon);
		assertEquals(100,chansey.getVida());
		squirtle.atacar(rattata, burbuja);
		assertEquals(160,rattata.getVida());
		squirtle.atacar(rattata, canon);
		assertEquals(140,rattata.getVida());
	}
	
	@Test
	public void test04BulbasaurYChanseyAtacanASquirtleConLatigoCepa() throws AtaquesAgotadosException{
		AlgoMon squirtle = new Squirtle();
		AlgoMon bulbasaur = new Bulbasaur();
		AlgoMon chansey = new Chansey();
		LatigoCepa latigo = new LatigoCepa();
		bulbasaur.atacar(squirtle, latigo);
		assertEquals(120,squirtle.getVida());
		chansey.atacar(squirtle, latigo);
		assertEquals(90,squirtle.getVida());
	}
	
	@Test
	public void test05BulbasaurYChanseyAtacanACharmanderConLatigoCepa() throws AtaquesAgotadosException{
		AlgoMon charmander = new Charmander();
		AlgoMon bulbasaur = new Bulbasaur();
		AlgoMon chansey = new Chansey();
		LatigoCepa latigo = new LatigoCepa();
		bulbasaur.atacar(charmander, latigo);
		assertEquals(163,charmander.getVida());
		chansey.atacar(charmander, latigo);
		assertEquals(156,charmander.getVida());
	}
	
	@Test
	public void test06BulbasaurYChanseyAtacanAlRestoConLatigoCepa() throws AtaquesAgotadosException{
		AlgoMon bulbasaur = new Bulbasaur();
		AlgoMon jigglypuff = new Jigglypuff();
		AlgoMon chansey = new Chansey();
		AlgoMon rattata = new Rattata();
		LatigoCepa latigo = new LatigoCepa();
		bulbasaur.atacar(jigglypuff, latigo);
		assertEquals(115,jigglypuff.getVida());
		chansey.atacar(jigglypuff, latigo);
		assertEquals(100,jigglypuff.getVida());
		bulbasaur.atacar(rattata, latigo);
		assertEquals(155,rattata.getVida());
		chansey.atacar(rattata, latigo);
		assertEquals(140,rattata.getVida());
	}
	
	@Test
	public void test07CharmanderAtacaABulbasaurConBrasas() throws AtaquesAgotadosException{
		AlgoMon charmander = new Charmander();
		AlgoMon bulbasaur = new Bulbasaur();
		charmander.atacar(bulbasaur, new Brasas());
		assertEquals(108,bulbasaur.getVida());
	}
	
	@Test
	public void test08CharmanderAtacaASquirtleConBrasas() throws AtaquesAgotadosException{
		AlgoMon charmander = new Charmander();
		AlgoMon squirtle = new Squirtle();
		charmander.atacar(squirtle, new Brasas());
		assertEquals(142,squirtle.getVida());
	}
	
	@Test
	public void test09CharmanderAtacaAlRestoConBrasas() throws AtaquesAgotadosException{
		AlgoMon charmander = new Charmander();
		AlgoMon jigglypuff = new Jigglypuff();
		AlgoMon chansey = new Chansey();
		AlgoMon rattata = new Rattata();
		Brasas brasas = new Brasas();
		charmander.atacar(jigglypuff, brasas);
		assertEquals(114,jigglypuff.getVida());
		charmander.atacar(chansey, brasas);
		assertEquals(114,chansey.getVida());
		charmander.atacar(rattata, brasas);
		assertEquals(154,rattata.getVida());
	}
	
	@Test
	public void test10AtaqueRapidoSinImportarTipo() throws AtaquesAgotadosException{
		AlgoMon bulbasaur = new Bulbasaur();
		AlgoMon jigglypuff = new Jigglypuff();
		AlgoMon chansey = new Chansey();
		AlgoMon rattata = new Rattata();
		AtaqueRapido ataqueRapido = new AtaqueRapido();
		bulbasaur.atacar(jigglypuff, ataqueRapido);
		assertEquals(120,jigglypuff.getVida());
		chansey.atacar(rattata, ataqueRapido);
		assertEquals(160,rattata.getVida());
		rattata.atacar(bulbasaur, ataqueRapido);
		assertEquals(130,bulbasaur.getVida());
		jigglypuff.atacar(chansey, ataqueRapido);
		assertEquals(120,chansey.getVida());
	}
	
	@Test(expected = AtaquesAgotadosException.class)
	public void test11AgotarCantidadDeAtaques() throws AtaquesAgotadosException{
		AlgoMon squirtle = new Squirtle();
		AlgoMon jigglypuff = new Jigglypuff();
		AlgoMon chansey = new Chansey();
		AlgoMon rattata = new Rattata();
		CanonDeAgua canon = new CanonDeAgua();
		for(int i=0; i<4;i++){
			squirtle.atacar(jigglypuff, canon);
			squirtle.atacar(chansey, canon);
		}
		squirtle.atacar(rattata, canon);
	}
}
