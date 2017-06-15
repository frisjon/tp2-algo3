package fiuba.algo3.modelo.tablero;

import org.junit.Assert;
import org.junit.Test;

public class ChispaSupremaTest {

	@Test
	public void crearChispaSupremaTest(){
		ChispaSuprema chispaSuprema = new ChispaSuprema();
		Assert.assertEquals(new Posicion(24,25), chispaSuprema.getPosicion());
		Assert.assertFalse(chispaSuprema.chispaCapturada());

	}

	@Test
	public void capturarChispaSupremaTest(){
		ChispaSuprema chispaSuprema = new ChispaSuprema();
		Assert.assertFalse(chispaSuprema.chispaCapturada());
		chispaSuprema.capturar();
		Assert.assertTrue(chispaSuprema.chispaCapturada());


	}
}
