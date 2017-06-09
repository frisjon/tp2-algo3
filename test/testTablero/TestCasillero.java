package testTablero;

import org.junit.Test;

import consumibles.Esfera;

import org.junit.Assert;
import junit.framework.*;
import Gohan;
import tablero.Casillero;
import tablero.ErrorCasilleroYaOcupado;
import tablero.ErrorNoHayObjeto;

public class TestCasillero extends TestCase {
	
	@Test
	public void test01VerificarCasilleroVacioAlInicializarse() {
		Casillero casillero = new Casillero(20, 20);
		Assert.assertEquals(casillero.estaLibre(), true);
	}
	
	@Test
	public void test02VerificarQueEsExtremoIzquierdo() {
		Casillero casillero = new Casillero(0, 0);
		Assert.assertEquals(casillero.esExtremo(20,20), true);
	}
	
	@Test
	public void test03VerificarQueEsExtremoDerecho() {
		Casillero casillero = new Casillero(19, 19);
		Assert.assertEquals(casillero.esExtremo(20,20), true);
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
		Gohan gohan = new Gohan();
		Esfera esfera = new Esfera();
		casillero.setObjeto(gohan);
		try {
			casillero.setObjeto(esfera);
		}catch (ErrorCasilleroYaOcupado e) {
		}
	}
}
