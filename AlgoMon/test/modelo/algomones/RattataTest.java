package modelo.algomones;

import modelo.Tipo;
import modelo.ataques.*;
import modelo.excepciones.AtaquesAgotadosException;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class RattataTest {
	@Test
	public void testCrearNoDevuelveNull() {
		Rattata rattata = new Rattata();
		assertNotNull(rattata);
	}


	@Test
	public void testObtenerVidaOriginal() {
		Rattata rattata = new Rattata();
		assertEquals(rattata.getVidaOriginal(),170);
	}
	@Test
	public void testCrearRattata() {
		
		Rattata rattata = new Rattata();
		Fogonazo fogonazo = new Fogonazo();
		AtaqueRapido ataqueRapido = new AtaqueRapido();
		Burbuja burbuja = new Burbuja();
		CanonDeAgua canon = new CanonDeAgua();

		Assert.assertEquals(rattata.getTipo(), Tipo.NORMAL);
		assertEquals(rattata.getVida(), 170);
		assertEquals(rattata.tieneAtaque(fogonazo), true);
		assertEquals(rattata.tieneAtaque(ataqueRapido), true);
		assertEquals(rattata.tieneAtaque(burbuja), true);
		assertEquals(rattata.tieneAtaque(canon), false);
	}
	
	@Test
	public void testAlgoMonDormido() {
		
		Rattata rattata = new Rattata();
		Jigglypuff jigglypuff = new Jigglypuff();
		Canto canto = new Canto();
		try {
			jigglypuff.atacar(rattata, canto);
		} catch (AtaquesAgotadosException e) { }
		assertEquals(false, rattata.puedeAtacar());
	}

	@Test
	public void testAlgoMonQuemado() {
		
		Rattata rattata = new Rattata();
		Charmander charmander = new Charmander();
		Fogonazo fogonazo = new Fogonazo();
		AtaqueRapido ataqueRapido = new AtaqueRapido();
		try {
			charmander.atacar(rattata, fogonazo);
			rattata.nuevoTurno();
			rattata.atacar(charmander, ataqueRapido);
		} catch (AtaquesAgotadosException e) { }
		assertEquals(151, rattata.getVida());
	}

	@Test
	public void testAlgoMonMuerto() {
		
		Rattata rattata = new Rattata();
		Squirtle squirtle = new Squirtle();
		CanonDeAgua canon = new CanonDeAgua();
		Burbuja burbuja = new Burbuja();
		try {
			squirtle.atacar(rattata, canon);
			squirtle.atacar(rattata, canon);
		} catch (AtaquesAgotadosException e) { }
		assertEquals(false, rattata.estaMuerto());
		
		try {
			for(int i=0; i<5;i++){
				squirtle.atacar(rattata, canon);
				squirtle.atacar(rattata, burbuja);
			}
		} catch (AtaquesAgotadosException e) { }
		assertEquals(true, rattata.estaMuerto());
	}
}