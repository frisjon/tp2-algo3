package testPersonajes;

import personajes.Cell;
import personajes.ErrorCambiarEstadoCondicionesNoCumplidas;

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

public class TestCell{
    private Cell cell;

    @Before
    public void setUp() {
        cell = new Cell();
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
    public void test04CambiarCellAEstado2() throws ErrorCambiarEstadoCondicionesNoCumplidas {
    	cell.agregarKi(20);
        for (int i=0;i<3;i++)
        	cell.aumentarCantidadAbsorciones();
        try {
            cell.cambiarAEstado2();
        } catch (ErrorCambiarEstadoCondicionesNoCumplidas e1) {
            fail("Error Inesperado");
        }
        assertEquals(2, cell.getIdEstado());
    }

    @Test (expected=ErrorCambiarEstadoCondicionesNoCumplidas.class)
    public void test05CambiarCellAEstado2KiInsuficienteLanzaExcepcion() throws ErrorCambiarEstadoCondicionesNoCumplidas{
    	cell.cambiarAEstado2();
    }

    @Test
    public void test06CambiarCellAEstado3() throws ErrorCambiarEstadoCondicionesNoCumplidas {
    	cell.agregarKi(20);
        for (int i=0;i<3;i++)
        	cell.aumentarCantidadAbsorciones();
        try {
            cell.cambiarAEstado3();
        } catch (ErrorCambiarEstadoCondicionesNoCumplidas e1) {
            fail("Error Inesperado");
        }
        assertEquals(3, cell.getIdEstado());
    }

    @Test (expected=ErrorCambiarEstadoCondicionesNoCumplidas.class)
    public void test07CambiarCellAEstado3KiInsuficienteLanzaExcepcion() throws ErrorCambiarEstadoCondicionesNoCumplidas {
    	cell.cambiarAEstado3();
    }

    @Test
    public void test08() {

    }
}

