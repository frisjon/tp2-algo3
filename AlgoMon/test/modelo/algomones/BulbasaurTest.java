package modelo.algomones;

import modelo.Tipo;
import modelo.ataques.*;
import modelo.excepciones.AtaquesAgotadosException;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class BulbasaurTest {

	@Test
	public void testCrearNoDevuelveNull() {
		Bulbasaur bulbasaur = new Bulbasaur();
		assertNotNull(bulbasaur);
	}

	@Test
	public void testObtenerVidaOriginal() {
		Bulbasaur bulbasaur = new Bulbasaur();
		assertEquals(bulbasaur.getVidaOriginal(),140);
	}
	
	@Test
	public void testCrearBalbasaur() {

		Bulbasaur bulbasaur = new Bulbasaur();
		LatigoCepa latigo = new LatigoCepa();
		AtaqueRapido ataqueRapido = new AtaqueRapido();
		Chupavidas chupavidas = new Chupavidas();
		Canto canto = new Canto();

		Assert.assertEquals(bulbasaur.getTipo(), Tipo.PLANTA);
		assertEquals(bulbasaur.getVida(), 140);
		assertEquals(bulbasaur.tieneAtaque(latigo), true);
		assertEquals(bulbasaur.tieneAtaque(ataqueRapido), true);
		assertEquals(bulbasaur.tieneAtaque(chupavidas), true);
		assertEquals(bulbasaur.tieneAtaque(canto), false);
	}
	
	@Test
	public void testAlgoMonDormido() {
		
		Bulbasaur bulbasaur = new Bulbasaur();
		Jigglypuff jigglypuff = new Jigglypuff();
		Canto canto = new Canto();

		try {
			jigglypuff.atacar(bulbasaur, canto);
		} catch (AtaquesAgotadosException e) { }
		assertEquals(false, bulbasaur.puedeAtacar());
	}
	
	@Test
	public void testAlgoMonQuemado() {
		
		Bulbasaur bulbasaur = new Bulbasaur();
		Charmander charmander = new Charmander();
		Fogonazo fogonazo = new Fogonazo();
		AtaqueRapido ataqueRapido = new AtaqueRapido();

		try {
			charmander.atacar(bulbasaur, fogonazo);
			bulbasaur.nuevoTurno();
			bulbasaur.atacar(charmander, ataqueRapido);
		} catch (AtaquesAgotadosException e) { }
		assertEquals(122, bulbasaur.getVida());
	}
	
	@Test
	public void testAlgoMonMuerto() {
		Bulbasaur bulbasaur = new Bulbasaur();
		Charmander charmander = new Charmander();
		Brasas brasas = new Brasas();
		try {
			charmander.atacar(bulbasaur, brasas);
			charmander.atacar(bulbasaur, brasas);
		} catch (AtaquesAgotadosException e) { }
		assertEquals(false, bulbasaur.estaMuerto());

		try {
			charmander.atacar(bulbasaur, brasas);
			charmander.atacar(bulbasaur, brasas);
			charmander.atacar(bulbasaur, brasas);
		} catch (AtaquesAgotadosException e) { }
		assertEquals(true, bulbasaur.estaMuerto());
	}

}
