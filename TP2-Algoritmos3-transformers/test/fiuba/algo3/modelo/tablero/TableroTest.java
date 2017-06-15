package fiuba.algo3.modelo.tablero;

import org.junit.Assert;
import org.junit.Test;

import fiuba.algo3.modelo.superficies.SuperficieDeCampo;
import fiuba.algo3.modelo.superficies.SuperficieNube;
import fiuba.algo3.modelo.superficies.SuperficieRocosa;

public class TableroTest {

	@Test
	public void crearTableroTest(){
		Tablero tablero = new Tablero();
		SuperficieDeCampo supDeCampoInicialBordes = new SuperficieDeCampo(new SuperficieNube(), new SuperficieRocosa());
		for (int x = 0; x < Tablero.alto ; x++ ){
			for (int y = 0 ; y <= Tablero.largo ; y++){
				Posicion posicion = new Posicion(x,y);
				Assert.assertEquals(tablero.obtenerCasillero(posicion).getSuperficies(),supDeCampoInicialBordes);
			}
		}
	}
	
	@Test
	public void crearTableroFijoTest(){
		Tablero tablero = new Tablero(false,Tablero.alto,Tablero.largo);
		SuperficieDeCampo supDeCampoInicialBordes = new SuperficieDeCampo(new SuperficieNube(), new SuperficieRocosa());
		for (int x = 0; x < Tablero.alto ; x++ ){
			for (int y = 0 ; y <= Tablero.largo ; y++){
				Posicion posicion = new Posicion(x,y);
				Assert.assertEquals(tablero.obtenerCasillero(posicion).getSuperficies(),supDeCampoInicialBordes);
			}
		}
	}
	
	
}
