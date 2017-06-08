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
        try {
            cell.agregarKi(20);
            cell.cambiarAEstado2();
        } catch (ErrorCambiarEstadoCondicionesNoCumplidas e1) {
            fail("Error Inesperado");
        }
        assertEquals(2, cell.getIdEstado());
    }

    @Test (expected=ErrorCambiarEstadoCondicionesNoCumplidas.class)
    public void test05CambiarCellAEstado2KiInsuficienteLanzaExcepcion() throws ErrorCambiarEstadoCondicionesNoCumplidas{
        try {
            cell.cambiarAEstado2();
        } catch (ErrorCambiarEstadoCondicionesNoCumplidas e1) {
            throw e1;
        }
        fail("Error Inesperado");
    }

    @Test
    public void test06CambiarCellAEstado3() throws ErrorCambiarEstadoCondicionesNoCumplidas {
        try {
            cell.agregarKi(50);
            cell.cambiarAEstado3();
        } catch (ErrorCambiarEstadoCondicionesNoCumplidas e1) {
            fail("Error Inesperado");
        }
        assertEquals(3, cell.getIdEstado());
    }

    @Test (expected=ErrorCambiarEstadoCondicionesNoCumplidas.class)
    public void test07CambiarCellAEstado3KiInsuficienteLanzaExcepcion() throws ErrorCambiarEstadoCondicionesNoCumplidas {
        try {
            cell.cambiarAEstado3();
        } catch (ErrorCambiarEstadoCondicionesNoCumplidas e1) {
            throw e1;
        }
        fail("Error Inesperado");
    }

    @Test
    public void test08() {

    }
}

