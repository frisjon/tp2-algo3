package modelo.elementos;

import modelo.algomones.*;
import modelo.ataques.*;
import modelo.estados.Dormido;
import modelo.estados.EstadoNormal;
import modelo.estados.Quemado;
import modelo.excepciones.AtaquesAgotadosException;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ElementosTest {

	@Test
	public void testAplicarPocion() throws AtaquesAgotadosException {
		
		AlgoMon squirtle = new Squirtle();
		AlgoMon bulbasaur = new Bulbasaur();
		Pocion pocion = new Pocion();
		Burbuja burbuja = new Burbuja();
		LatigoCepa latigo = new LatigoCepa();
		AtaqueRapido ataqueRapido = new AtaqueRapido();
		
		squirtle.atacar(bulbasaur, burbuja);
		bulbasaur.atacar(squirtle, latigo);
		
		squirtle.atacar(bulbasaur, ataqueRapido);
		bulbasaur.atacar(squirtle, ataqueRapido);
		
		pocion.aplicar(squirtle);
		pocion.aplicar(bulbasaur);
		
		assertEquals(140,bulbasaur.getVida());	// 140 - 5 - 10 + 20 = 145 >> 140
		assertEquals(130,squirtle.getVida());	// 150 - 30 - 10 + 20 = 130
	}
	
	@Test
	public void testAplicarSuperPocion() throws AtaquesAgotadosException {
		
		AlgoMon squirtle = new Squirtle();
		AlgoMon bulbasaur = new Bulbasaur();
		SuperPocion superpocion = new SuperPocion();
		Burbuja burbuja = new Burbuja();
		LatigoCepa latigo = new LatigoCepa();
		AtaqueRapido ataqueRapido = new AtaqueRapido();
		CanonDeAgua canon = new CanonDeAgua();
		
		squirtle.atacar(bulbasaur, burbuja);
		bulbasaur.atacar(squirtle, latigo);
		
		squirtle.atacar(bulbasaur, ataqueRapido);
		bulbasaur.atacar(squirtle, ataqueRapido);
		
		squirtle.atacar(bulbasaur, canon);
		bulbasaur.atacar(squirtle, latigo);
		
		superpocion.aplicar(squirtle);
		superpocion.aplicar(bulbasaur);
		
		assertEquals(140,bulbasaur.getVida());	// 140 - 5 - 10 - 10 + 40 = 155 >> 140
		assertEquals(120,squirtle.getVida());	// 150 - 30 - 10 - 30 + 40 = 120
	}
	
	@Test
	public void testAplicarRestauradorConEstadoQuemado() throws AtaquesAgotadosException {
		
		AlgoMon charmander = new Charmander();
		AlgoMon bulbasaur = new Bulbasaur();
		Restaurador restaurador = new Restaurador();
		Fogonazo fogonazo = new Fogonazo();
		LatigoCepa latigo = new LatigoCepa();
		AtaqueRapido ataqueRapido = new AtaqueRapido();
		Brasas brasas = new Brasas();
		
		charmander.atacar(bulbasaur,fogonazo);
		bulbasaur.atacar(charmander,latigo);
		bulbasaur.nuevoTurno();
		
		charmander.atacar(bulbasaur, ataqueRapido);
		bulbasaur.atacar(charmander, ataqueRapido);
		bulbasaur.nuevoTurno();
		
		restaurador.aplicar(bulbasaur);
		
		charmander.atacar(bulbasaur, brasas);
		bulbasaur.atacar(charmander, latigo);
		
		assertEquals(66,bulbasaur.getVida());	// 140 - 4 - 10 - 14 (Quemado) - 14 (Quemado) - 32 = 66
		assertEquals(bulbasaur.getEstadoPersistente() instanceof Quemado, false);
		assertEquals(bulbasaur.getEstadoPersistente() instanceof EstadoNormal, true);
	}
	
	@Test
	public void testAplicarRestauradorConEstadoDormido() throws AtaquesAgotadosException {
		
		AlgoMon jigglypuff = new Jigglypuff();
		AlgoMon bulbasaur = new Bulbasaur();
		Restaurador restaurador = new Restaurador();
		Canto canto = new Canto();
		LatigoCepa latigo = new LatigoCepa();
		Burbuja burbuja = new Burbuja();
		AtaqueRapido ataqueRapido = new AtaqueRapido();

		
		jigglypuff.atacar(bulbasaur, canto);
		bulbasaur.atacar(jigglypuff, latigo);
		bulbasaur.nuevoTurno();
		
		jigglypuff.atacar(bulbasaur, burbuja);
		bulbasaur.atacar(jigglypuff, ataqueRapido);
		bulbasaur.nuevoTurno();
		
		restaurador.aplicar(bulbasaur);
		jigglypuff.atacar(bulbasaur, ataqueRapido);
		bulbasaur.atacar(jigglypuff, latigo);
		
		assertEquals(115,jigglypuff.getVida());	// 130 - 15 = 115
		assertEquals(bulbasaur.getEstadoPersistente() instanceof Dormido, false);
		assertEquals(bulbasaur.getEstadoPersistente() instanceof EstadoNormal, true);
	}
	
	@Test
	public void testAplicarVitaminaNoExcedeCantidadInicial() throws AtaquesAgotadosException {
		
		AlgoMon squirtle = new Squirtle();
		AlgoMon bulbasaur = new Bulbasaur();
		Vitamina vitamina = new Vitamina();
		CanonDeAgua canon = new CanonDeAgua();
		LatigoCepa latigo = new LatigoCepa();
		
		squirtle.atacar(bulbasaur, canon);
		bulbasaur.atacar(squirtle, latigo);
		
		vitamina.aplicar(squirtle);
		vitamina.aplicar(bulbasaur);
		
		for(Ataque ataque: squirtle.getAtaques()){
			assertEquals(ataque.getCantidad() <= ataque.cantidadInicial(),true);
		}
		for(Ataque ataque: bulbasaur.getAtaques()){
			assertEquals(ataque.getCantidad() <= ataque.cantidadInicial(),true);
		}
		
	}
	
	@Test
	public void testAplicarVitaminaConAtaquesEnBajasCantidades() throws AtaquesAgotadosException {
		
		AlgoMon squirtle = new Squirtle();
		AlgoMon bulbasaur = new Bulbasaur();
		Vitamina vitamina = new Vitamina();
		CanonDeAgua canon = new CanonDeAgua();
		Burbuja burbuja = new Burbuja();
		AtaqueRapido ataqueRapido = new AtaqueRapido();
		
		for(int x=0; x<8; x++){
			squirtle.atacar(bulbasaur, canon);
		}
		
		for(int x=0; x<15; x++){
			squirtle.atacar(bulbasaur, burbuja);
		}
		
		for(int x=0; x<16; x++){
			squirtle.atacar(bulbasaur, ataqueRapido);
		}
		
		vitamina.aplicar(squirtle);
		
		for(Ataque ataque: squirtle.getAtaques()){
			assertEquals(ataque.getCantidad() == 2, true);
		}
		assertEquals(bulbasaur.estaMuerto(), true);
	}
}
