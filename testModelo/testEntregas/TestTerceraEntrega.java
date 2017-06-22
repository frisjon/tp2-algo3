package testEntregas;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import junit.framework.TestCase;
import modelo.consumibles.Esfera;
import modelo.consumibles.Nube;
import modelo.consumibles.Semilla;
import modelo.equipo.Equipo;
import modelo.equipo.PosibleEquipo;
import modelo.pelea.Pelea;
import modelo.personajes.Cell;
import modelo.personajes.Gohan;
import modelo.tablero.Casillero;
import modelo.tablero.Tablero;

public class TestTerceraEntrega extends TestCase {
	private Gohan gohan;
	private Tablero tablero;
	private Casillero casillero1;
	private Casillero casillero2;
	
	public void setUp() {
		tablero = new Tablero(20, 20);
		gohan = new Gohan(PosibleEquipo.guerreros);
		casillero1 = new Casillero(0,1);
		gohan.setCasillero(casillero1);
		casillero1.setObjeto(gohan);
		casillero2 = new Casillero(0,2);
    }
	
	public void test01VerificarDesaparicionConsumibleAlPosicionarPersonajeSobreEl() {
		Esfera esfera = new Esfera();
		Casillero casillero3 = new Casillero(0,3);
		esfera.setCasillero(casillero3);
		casillero3.setObjeto(esfera);
		
		List<Casillero> camino = new ArrayList<Casillero>();
		camino.add(casillero2);
		camino.add(casillero3);
		tablero.moverPersonaje(gohan, camino, new Equipo(PosibleEquipo.guerreros));
		
		Assert.assertEquals(gohan.tieneObjeto(), true);
		//Assert.assertEquals(esfera.getCasillero(), null);
		Assert.assertEquals(casillero3.getObjeto(), gohan); // no esta mas la esfera
		
	}
	
	//tomar supuesto o que al aumetnar el da�o se toma que el poder pelea es mayor (para comparar con contrincante) o se toma supuesto que no aumenta poder pelea(tomo este caso)
	//en este caso si tomo 2do supuesto se le reduciria el ataque en un 20% y luego se aumentaria en un 25% por el efecto de la esfera, qeudando un ataque de 15,75
	public void test02VerificarCorrectaAplicacionDeConsumibleEsfera() {
		Esfera esfera = new Esfera();
		Casillero casillero3 = new Casillero(0,3);
		esfera.setCasillero(casillero3);
		casillero3.setObjeto(esfera);
		
		Cell cell = new Cell(PosibleEquipo.enemigos);
		Casillero casillero4 = new Casillero(0,4);
		cell.setCasillero(casillero4);
		casillero4.setObjeto(cell);
		
		
		List<Casillero> camino = new ArrayList<Casillero>();
		camino.add(casillero2);
		camino.add(casillero3);
		tablero.moverPersonaje(gohan, camino, new Equipo(PosibleEquipo.guerreros));
		
		Pelea.ataqueBasico(gohan,cell);
		Assert.assertEquals(cell.getVida(), 484,25);
	}
	
	public void test03VerificarCorrectaAplicacionDeConsumibleNube() {
		Nube nube = new Nube();
		Casillero casillero3 = new Casillero(0,3);
		nube.setCasillero(casillero3);
		casillero3.setObjeto(nube);
		Casillero casillero4 = new Casillero(0,4);
		Casillero casillero5 = new Casillero(0,5);
		Casillero casillero6 = new Casillero(0,6);
		Casillero casillero7 = new Casillero(0,7);
	
		
		List<Casillero> camino = new ArrayList<Casillero>();
		camino.add(casillero2);
		camino.add(casillero3);
		tablero.moverPersonaje(gohan, camino, new Equipo(PosibleEquipo.guerreros));
		
		camino = new ArrayList<Casillero>();
		camino.add(casillero4);
		camino.add(casillero5);
		camino.add(casillero6);
		camino.add(casillero7);
		
		tablero.moverPersonaje(gohan, camino, new Equipo(PosibleEquipo.guerreros));
		
		Assert.assertEquals(casillero7.getObjeto(), gohan);
		Assert.assertEquals(casillero3.estaLibre(), true);
		
	}
	
	//tomo supuesto que no se usa cuando uno quiere sino que cuando se agarra se activa
	public void test04VerificarCorrectaAplicacionDeConsumibleSemilla() {
		Semilla semilla = new Semilla();
		Casillero casillero3 = new Casillero(0,3);
		semilla.setCasillero(casillero3);
		casillero3.setObjeto(semilla);
		gohan.quitarVida(100);
		
		List<Casillero> camino = new ArrayList<Casillero>();
		camino.add(casillero2);
		camino.add(casillero3);
		tablero.moverPersonaje(gohan, camino, new Equipo(PosibleEquipo.guerreros));
		
		Assert.assertEquals(gohan.getVida(), 300,0);
	}
}
