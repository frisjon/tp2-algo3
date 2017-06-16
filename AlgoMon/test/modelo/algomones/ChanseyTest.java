package modelo.algomones;

import modelo.Tipo;
import modelo.ataques.*;
import modelo.excepciones.AtaquesAgotadosException;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;


public class ChanseyTest {
	@Test
	public void testCrearNoDevuelveNull() {
		Chansey chansey = new Chansey();
		assertNotNull(chansey);
	}

	@Test
	public void testObtenerVidaOriginal() {
		Chansey chansey = new Chansey();
		assertEquals(chansey.getVidaOriginal(),130);
	}

	@Test
	public void testCrearChansey() {
		
		Chansey chansey = new Chansey();
		Canto canto = new Canto();
		AtaqueRapido ataqueRapido = new AtaqueRapido();
		LatigoCepa latigo = new LatigoCepa();
		Chupavidas chupavidas = new Chupavidas();

		Assert.assertEquals(chansey.getTipo(), Tipo.NORMAL);
		assertEquals(chansey.getVida(), 130);
		assertEquals(chansey.tieneAtaque(canto), true);
		assertEquals(chansey.tieneAtaque(ataqueRapido), true);
		assertEquals(chansey.tieneAtaque(latigo), true);
		assertEquals(chansey.tieneAtaque(chupavidas), false);
	}
	
	@Test
	public void testAlgoMonDormido() {
		
		Chansey chansey = new Chansey();
		Jigglypuff jigglypuff = new Jigglypuff();
		Canto canto = new Canto();
		try {
			jigglypuff.atacar(chansey, canto);
		} catch (AtaquesAgotadosException e) { }
		assertEquals(false, chansey.puedeAtacar());
	}
	
	@Test
	public void testAlgoMonQuemado() {
		
		Chansey chansey = new Chansey();
		Charmander charmander = new Charmander();
		Fogonazo fogonazo = new Fogonazo();
		AtaqueRapido ataqueRapido = new AtaqueRapido();

		try {
			charmander.atacar(chansey, fogonazo);
			chansey.nuevoTurno();
			chansey.atacar(charmander, ataqueRapido);
		} catch (AtaquesAgotadosException e) { }
		assertEquals(115, chansey.getVida());
	}

	@Test
	public void testAlgoMonMuerto() {
		Chansey chansey = new Chansey();
		Charmander charmander = new Charmander();
		Brasas brasas = new Brasas();
		try {
			charmander.atacar(chansey, brasas);
			charmander.atacar(chansey, brasas);
		} catch (AtaquesAgotadosException e) { }
		assertEquals(false, chansey.estaMuerto());

		try {
			for(int i=0; i<7;i++){
				charmander.atacar(chansey, brasas);
			}
		} catch (AtaquesAgotadosException e) { }
		assertEquals(true, chansey.estaMuerto());
	}
}