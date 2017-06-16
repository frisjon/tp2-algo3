package modelo.algomones;

import modelo.Tipo;
import modelo.ataques.*;
import modelo.excepciones.AtaquesAgotadosException;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class CharmanderTest {
	@Test
	public void testCrearNoDevuelveNull() {
		Charmander charmander = new Charmander();
		assertNotNull(charmander);
	}


	@Test
	public void testObtenerVidaOriginal() {
		Charmander charmander = new Charmander();
		assertEquals(charmander.getVidaOriginal(),170);
	}
	
	@Test
	public void testCrearCharmander() {
		
		Charmander charmander = new Charmander();
		Brasas brasas = new Brasas();
		AtaqueRapido ataqueRapido = new AtaqueRapido();
		Fogonazo fogonazo = new Fogonazo();
		LatigoCepa latigo = new LatigoCepa();

		Assert.assertEquals(charmander.getTipo(), Tipo.FUEGO);
		assertEquals(charmander.getVida(), 170);
		assertEquals(charmander.tieneAtaque(brasas), true);
		assertEquals(charmander.tieneAtaque(ataqueRapido), true);
		assertEquals(charmander.tieneAtaque(fogonazo), true);
		assertEquals(charmander.tieneAtaque(latigo), false);
	}
	
	@Test
	public void testAlgoMonDormido() {
		
		Charmander charmander = new Charmander();
		Jigglypuff jigglypuff = new Jigglypuff();
		Canto canto = new Canto();
		try {
			jigglypuff.atacar(charmander, canto);
		} catch (AtaquesAgotadosException e) { }
		assertEquals(false, charmander.puedeAtacar());
	}
	
	@Test
	public void testAlgoMonQuemado() {
		
		Charmander charmander = new Charmander();
		Rattata rattata = new Rattata();
		Fogonazo fogonazo = new Fogonazo();
		AtaqueRapido ataqueRapido = new AtaqueRapido();
		try {
			rattata.atacar(charmander, fogonazo);
			charmander.nuevoTurno();
			charmander.atacar(rattata, ataqueRapido);
		} catch (AtaquesAgotadosException e) { }
		assertEquals(152, charmander.getVida());
	}
	
	@Test
	public void testAlgoMonMuerto() {
		Charmander charmander = new Charmander();
		Squirtle squirtle = new Squirtle();
		CanonDeAgua canon = new CanonDeAgua();
		try {
			squirtle.atacar(charmander, canon);
			squirtle.atacar(charmander, canon);
		} catch (AtaquesAgotadosException e) { }
		assertEquals(false, charmander.estaMuerto());
		
		try {
			for(int i=0; i<3;i++){
				squirtle.atacar(charmander, canon);
			}
		} catch (AtaquesAgotadosException e) { }
		assertEquals(true, charmander.estaMuerto());
	}
}