package fiuba.algo3.jugabilidad;

import org.junit.Assert;
import org.junit.Test;

import fiuba.algo3.modelo.jugabilidad.Jugador;
import fiuba.algo3.modelo.jugabilidad.TipoTransformer;

public class UnitTestsJugador {

	@Test
	public void test01CreoJugadorValidoNombreYPersonajes() {
		Jugador j1 = new Jugador("Juan", TipoTransformer.AUTOBOT);
		Assert.assertEquals(j1.getNombre(),"Juan");
	}

}
