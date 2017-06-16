package modelo.algomones;

import modelo.Tipo;
import modelo.ataques.*;
import modelo.excepciones.AtaquesAgotadosException;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class SquirtleTest {
    @Test
	public void testCrearNoDevuelveNull() {
		Squirtle squirtle = new Squirtle();
		assertNotNull(squirtle);
	}

	@Test
	public void testObtenerVidaOriginal() {
		Squirtle squirtle = new Squirtle();
		assertEquals(squirtle.getVidaOriginal(),150);
	}
	@Test
	public void testCrearSquirtle() {
		
		Squirtle squirtle = new Squirtle();
		Burbuja burbuja = new Burbuja();
		AtaqueRapido ataqueRapido = new AtaqueRapido();
		CanonDeAgua canon = new CanonDeAgua();
		LatigoCepa latigo = new LatigoCepa();
		
		Assert.assertEquals(squirtle.getTipo(), Tipo.AGUA);
		assertEquals(squirtle.getVida(), 150);
		assertEquals(squirtle.tieneAtaque(burbuja), true);
		assertEquals(squirtle.tieneAtaque(ataqueRapido), true);
		assertEquals(squirtle.tieneAtaque(canon), true);
		assertEquals(squirtle.tieneAtaque(latigo), false);		
	}
	
	@Test
	public void testAlgoMonDormido() {
		
		Squirtle squirtle = new Squirtle();
		Jigglypuff jigglypuff = new Jigglypuff();
		Canto canto = new Canto();
		try {
			jigglypuff.atacar(squirtle, canto);
		} catch (AtaquesAgotadosException e) { }
		assertEquals(false, squirtle.puedeAtacar());
	}
	
	@Test
	public void testAlgoMonQuemado() {
		
		Squirtle squirtle = new Squirtle();
		Charmander charmander = new Charmander();
		Fogonazo fogonazo = new Fogonazo();
		AtaqueRapido ataqueRapido = new AtaqueRapido();
		try {
			charmander.atacar(squirtle, fogonazo);
			squirtle.nuevoTurno();
			squirtle.atacar(charmander, ataqueRapido);
		} catch (AtaquesAgotadosException e) { }
		assertEquals(134, squirtle.getVida());
	}
	
	@Test
	public void testAlgoMonMuerto() {
		
		Squirtle squirtle = new Squirtle();
		Bulbasaur bulbasaur = new Bulbasaur();
		Chupavidas chupavidas = new Chupavidas();
		try {
			bulbasaur.atacar(squirtle, chupavidas);
		} catch (AtaquesAgotadosException e) { }
		assertEquals(false, squirtle.estaMuerto());

		try {
			for(int i=0; i<4;i++){
				bulbasaur.atacar(squirtle, chupavidas);
			}
		} catch (AtaquesAgotadosException e) { }
		assertEquals(true, squirtle.estaMuerto());
	}
}