package modelo.algomones;

import modelo.Tipo;
import modelo.ataques.*;
import modelo.excepciones.AtaquesAgotadosException;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class JigglypuffTest {
	@Test
	public void testCrearNoDevuelveNull() {
		Jigglypuff jigglypuff = new Jigglypuff();
		assertNotNull(jigglypuff);
	}

	@Test
	public void testObtenerVidaOriginal() {
		Jigglypuff jigglypuff = new Jigglypuff();
		assertEquals(jigglypuff.getVidaOriginal(),130);
	}
	
	@Test
	public void testCrearJigglypuff() {
		
		Jigglypuff jigglypuff = new Jigglypuff();
		Canto canto = new Canto();
		AtaqueRapido ataqueRapido = new AtaqueRapido();
		Burbuja burbuja = new Burbuja();
		Brasas brasas = new Brasas();
		
		Assert.assertEquals(jigglypuff.getTipo(), Tipo.NORMAL);
		assertEquals(jigglypuff.getVida(), 130);
		assertEquals(jigglypuff.tieneAtaque(canto), true);
		assertEquals(jigglypuff.tieneAtaque(ataqueRapido), true);
		assertEquals(jigglypuff.tieneAtaque(burbuja), true);
		assertEquals(jigglypuff.tieneAtaque(brasas), false);
	}
	
	@Test
	public void testAlgoMonDormido() {
		
		Jigglypuff jigglypuff = new Jigglypuff();
		Chansey chansey = new Chansey();
		Canto canto = new Canto();
		try {
			chansey.atacar(jigglypuff, canto);
		} catch (AtaquesAgotadosException e) { }
		assertEquals(false, jigglypuff.puedeAtacar());
	}
	
	@Test
	public void testAlgoMonQuemado() {
		
		Jigglypuff jigglypuff = new Jigglypuff();
		Charmander charmander = new Charmander();
		Fogonazo fogonazo = new Fogonazo();
		AtaqueRapido ataqueRapido = new AtaqueRapido();
		try {
			charmander.atacar(jigglypuff, fogonazo);
			jigglypuff.nuevoTurno();
			jigglypuff.atacar(charmander, ataqueRapido);
		} catch (AtaquesAgotadosException e) { }
		assertEquals(115, jigglypuff.getVida());
	}
	
	@Test
	public void testAlgoMonMuerto() {
		Jigglypuff jigglypuff = new Jigglypuff();
		Squirtle squirtle = new Squirtle();
		AtaqueRapido ataqueRapido = new AtaqueRapido();
		Burbuja burbuja = new Burbuja();

		try {
			squirtle.atacar(jigglypuff, ataqueRapido);
		} catch (AtaquesAgotadosException e) { }
		assertEquals(false, jigglypuff.estaMuerto());
		
		try {
			for(int i=0; i<6;i++){
				squirtle.atacar(jigglypuff, ataqueRapido);
				squirtle.atacar(jigglypuff, burbuja);
			}
		} catch (AtaquesAgotadosException e) { }
		assertEquals(true, jigglypuff.estaMuerto());
	}
}