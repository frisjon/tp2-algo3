package testPersonajes;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import modelo.consumibles.ErrorConsumibleInstantaneo;
import modelo.juego.PosibleEquipo;
import modelo.pelea.ErrorNoHayKi;
import modelo.pelea.ErrorNoSePuedeRealizarAtaqueEspecial;
import modelo.pelea.Pelea;
import modelo.personajes.Cell;
import modelo.personajes.ErrorNoPuedeCambiarEstado;
import modelo.personajes.Gohan;

public class TestCell{
    
    private Cell cell;

    @Before
    public void setUp() {
        cell = new Cell(PosibleEquipo.enemigos);
    }

    @Test
    public void test01CrearCell() {
        assertEquals("Cell", cell.getNombre());
    }

    @Test
    public void test02CellEmpiezaEnEstado1() {
        assertEquals(1, cell.getIdEstado());
    }

    @Test
    public void test03CambiarCellAEstado1() {
        cell.cambiarAEstado1();
        assertEquals(1, cell.getIdEstado());
    }

    @Test
    public void test04CambiarCellAEstado2() throws ErrorNoPuedeCambiarEstado {
    	cell.agregarKi(20);
        for (int i=0;i<4;i++)
        	//cell.aumentarCantidadAbsorciones();
        	// aca realizar ataque especial, que es lo mismo que aumentarCantidadAbsorciones pero mas
        	// prolijo y aparte aumentando vida y restando ki que es lo que se espera
        try {
            cell.cambiarAEstado2();
        } catch (ErrorNoPuedeCambiarEstado e1) {
            fail("Error Inesperado");
        }
        assertEquals(1, cell.getIdEstado());
        assertEquals(0, (int)cell.getKi());
    }

    @Test (expected=ErrorNoPuedeCambiarEstado.class)
    public void test05CambiarCellAEstado2KiInsuficienteLanzaExcepcion() throws ErrorNoPuedeCambiarEstado{
    	cell.cambiarAEstado2();
    }

    @Test
    public void test06CambiarCellAEstado3() throws ErrorNoPuedeCambiarEstado {
    	cell.agregarKi(40);
        for (int i=0;i<8;i++)
        	// cell.aumentarCantidadAbsorciones();
        	// aca realizar ataque especial, que es lo mismo que aumentarCantidadAbsorciones pero mas
        	// prolijo y aparte aumentando vida y restando ki que es lo que se espera
        try {
            cell.cambiarAEstado3();
        } catch (ErrorNoPuedeCambiarEstado e1) {
            fail("Error Inesperado");
        }
        assertEquals(2, cell.getIdEstado());
        assertEquals(0, (int)cell.getKi());
    }

    @Test (expected=ErrorNoPuedeCambiarEstado.class)
    public void test07CambiarCellAEstado3KiInsuficienteLanzaExcepcion() throws ErrorNoPuedeCambiarEstado {
    	cell.cambiarAEstado3();
    }

    @Test
    public void test08CellHaceDanioAlAtacarConAtaqueEspecial() {
    	Gohan gohan = new Gohan(PosibleEquipo.guerreros);
    	int vida_gohan;
    	cell.agregarKi(100);
    	Pelea.ataqueEspecial(cell, gohan);
		vida_gohan = (int) gohan.getVida();
		Assert.assertEquals(vida_gohan, 280);

    }
    
    @Test
    public void test09CellRecuperaVidaConAtaqueEspecial() {
    	Gohan gohan = new Gohan(PosibleEquipo.guerreros);
    	int vida_cell;
    	cell.agregarKi(100);
    	cell.quitarVida(60); //lo deja en 440 de vida
		Pelea.ataqueEspecial(cell, gohan);

    	
    	vida_cell = (int) cell.getVida();
    	Assert.assertEquals(vida_cell, 460);
    }
}

