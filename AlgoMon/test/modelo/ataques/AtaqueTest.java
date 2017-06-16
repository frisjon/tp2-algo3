package modelo.ataques;

import modelo.algomones.Bulbasaur;
import modelo.algomones.Charmander;
import modelo.algomones.Squirtle;
import modelo.excepciones.AtaquesAgotadosException;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class AtaqueTest {
	
	@Test
	public void testEquals(){
		Canto canto1 = new Canto();
		Canto canto2 = new Canto();
		LatigoCepa latigoCepa = new LatigoCepa();
		assertEquals(true, canto1.getClass().equals(canto2.getClass()));
		assertEquals(false, canto1.getClass().equals(latigoCepa.getClass()));
	}
	
	@Test
	public void testAtacar() {
		Squirtle squirtle = new Squirtle();
		Bulbasaur bulbasaur = new Bulbasaur();
		CanonDeAgua canon = new CanonDeAgua();

		try {
			squirtle.atacar(bulbasaur, canon);
		} catch (AtaquesAgotadosException e1) {
		}
		
		assertEquals(bulbasaur.getVida(), 130);
		
		Ataque ataque = buscarAtaque(squirtle.getAtaques(), canon);
		assertEquals(ataque.getCantidad(), 7);
	}
	
	@Test
	public void testDanoDeAtaqueEsUnEntero() {
		Bulbasaur bulbasaur = new Bulbasaur();
		Charmander charmander = new Charmander();
		LatigoCepa latigo = new LatigoCepa();
		
		try {
			bulbasaur.atacar(charmander, latigo);
		} catch (AtaquesAgotadosException e) {
		}
		assertEquals("El dano que hace un ataque es siempre un entero", charmander.getVida(), 163);
		try {
			bulbasaur.atacar(charmander, latigo);
			bulbasaur.atacar(charmander, latigo);
			bulbasaur.atacar(charmander, latigo);
			bulbasaur.atacar(charmander, latigo);
		} catch (AtaquesAgotadosException e) {
		}
		
		assertEquals(charmander.getVida(), 135);
		
		Ataque ataque = buscarAtaque(bulbasaur.getAtaques(), latigo);
		assertEquals(ataque.getCantidad(), 5);


	}
	
	public Ataque buscarAtaque(List<Ataque> ataques, Ataque unAtaque) {
		Ataque ataqueDevuelto = null;
		for (Ataque ataque: ataques) {
			if (ataque.getClass().equals(unAtaque.getClass())) {
				ataqueDevuelto = ataque;
			}
		}
		return ataqueDevuelto;
	}
}
