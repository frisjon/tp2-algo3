package testPersonajes;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import modelo.juego.PosibleEquipo;
import modelo.personajes.ErrorNoPuedeCambiarEstado;
import modelo.personajes.Gohan;
import modelo.personajes.Piccolo;

public class TestPiccolo{
    
    private Piccolo piccolo;
    private Gohan gohan;

    @Before
    public void setUp() {
        piccolo = new Piccolo(PosibleEquipo.guerreros);
        gohan = new Gohan(PosibleEquipo.guerreros);
        
        piccolo.setProtegido(gohan);
    }

    @Test
    public void test01CrearPiccolo() {
        assertEquals("Piccolo", piccolo.getNombre());
    }

    @Test
    public void test02PiccoloEmpiezaEnEstado1() {
        assertEquals(1, piccolo.getIdEstado());
    }

    @Test
    public void test03CambiarPiccoloAEstado1() {
        piccolo.cambiarAEstado1();
        assertEquals(1, piccolo.getIdEstado());
    }

    @Test
    public void test04CambiarPiccoloAEstado2() {
    	piccolo.agregarKi(20);
    	piccolo.cambiarAEstado2();
    
        assertEquals(2, piccolo.getIdEstado());
    }

    @Test (expected=ErrorNoPuedeCambiarEstado.class)
    public void test05CambiarPiccoloAEstado2KiInsuficienteLanzaExcepcion() {
        piccolo.agregarKi(19);
        piccolo.cambiarAEstado2();
    }

    @Test
    public void test06CambiarPiccoloAEstado3() {
    	gohan.quitarVida(241);
        piccolo.cambiarAEstado3();
        assertEquals(3, piccolo.getIdEstado());
    }

    @Test (expected=ErrorNoPuedeCambiarEstado.class)
    public void test07CambiarPiccoloAEstado3KiInsuficienteLanzaExcepcion() throws ErrorNoPuedeCambiarEstado {
        piccolo.cambiarAEstado3();
    }
   
}

