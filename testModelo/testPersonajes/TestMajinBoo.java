package testPersonajes;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import modelo.juego.PosibleEquipo;
import modelo.personajes.ErrorNoPuedeCambiarEstado;
import modelo.personajes.MajinBoo;


public class TestMajinBoo{
    
    private MajinBoo majinboo;

    @Before
    public void setUp() {
        majinboo = new MajinBoo(PosibleEquipo.enemigos);
    }

    @Test
    public void test01CrearMajinBoo() {
        assertEquals("MajinBoo", majinboo.getNombre());
    }

    @Test
    public void test02MajinBooEmpiezaEnEstado1() {
        assertEquals(1, majinboo.getIdEstado());
    }

    @Test
    public void test03CambiarMajinBooAEstado1() {
        majinboo.cambiarAEstado1();
        assertEquals(1, majinboo.getIdEstado());
    }

    @Test
    public void test04CambiarMajinBooAEstado2() {
    	majinboo.agregarKi(20);
    	majinboo.cambiarAEstado2();
        assertEquals(2, majinboo.getIdEstado());
    }

    @Test (expected=ErrorNoPuedeCambiarEstado.class)
    public void test05CambiarMajinBooAEstado2KiInsuficienteLanzaExcepcion() throws ErrorNoPuedeCambiarEstado {
        majinboo.cambiarAEstado2();
    }

    @Test
    public void test06CambiarMajinBooAEstado3() {
    	majinboo.agregarKi(50);
    	majinboo.cambiarAEstado3();

        assertEquals(3, majinboo.getIdEstado());
    }

    @Test (expected=ErrorNoPuedeCambiarEstado.class)
    public void test07CambiarMajinBooAEstado3KiInsuficienteLanzaExcepcion() throws ErrorNoPuedeCambiarEstado {
        majinboo.cambiarAEstado3();
    }

    @Test
    public void test08() {

    }
}

