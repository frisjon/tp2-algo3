package testTablero;

import org.junit.Test;
import org.junit.Assert;
import junit.framework.*;
import modelo.consumibles.Esfera;
import modelo.personajes.Gohan;
import modelo.personajes.Personaje;
import modelo.tablero.Casillero;
import modelo.tablero.ErrorCasilleroYaOcupado;
import modelo.tablero.ErrorNoHayObjeto;

public class TestCasillero extends TestCase {
	
	@Test
	public void test01VerificarCasilleroVacioAlInicializarse() {
		Casillero casillero = new Casillero(20, 20);
		Assert.assertEquals(casillero.estaLibre(), true);
	}
	
	@Test
	public void test02VerificarQueEsExtremoIzquierdo() {
		Casillero casillero = new Casillero(0, 0);
		Assert.assertEquals(casillero.esExtremo("izq",20,20), true);
	}

	@Test
	public void test04PonerObjetoYVerificarQueEsta() throws ErrorCasilleroYaOcupado, ErrorNoHayObjeto {
		Casillero casillero = new Casillero(20, 20);
		Esfera esfera = new Esfera();
		casillero.setObjeto(esfera);
		Assert.assertEquals(casillero.getObjeto(), esfera);
	}
	
	@Test
	public void test05AlPedirObjetoEnCasilleroVacioDebeLanzarExcepcion() throws ErrorNoHayObjeto {
		Casillero casillero = new Casillero(20, 20);
		try {
			casillero.getObjeto();
		}catch (ErrorNoHayObjeto e) {
		}
	}
	
	@Test
	public void test06AlPonerUnObjetoEnCasilleroOcupadoDebeLanzarExcepcion() throws ErrorCasilleroYaOcupado {
		Casillero casillero = new Casillero(20, 20);
		Personaje gohan = new Gohan();
		Esfera esfera = new Esfera();
		casillero.setObjeto(gohan);
		try {
			casillero.setObjeto(esfera);
		}catch (ErrorCasilleroYaOcupado e) {
		}
	}
}
