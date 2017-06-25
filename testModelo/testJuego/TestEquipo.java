package testJuego;


import org.junit.Test;
import org.junit.Assert;
import junit.framework.*;
import modelo.juego.Equipo;
import modelo.juego.PosibleEquipo;
import modelo.personajes.Gohan;
import modelo.personajes.Goku;
import modelo.personajes.Personaje;
import modelo.personajes.Piccolo;

import java.util.ArrayList;

public class TestEquipo extends TestCase {
	
	 @Test
	 public void test01NombreCorrecto() {
		 Equipo equipo = new Equipo(PosibleEquipo.guerreros);
		 Assert.assertEquals(equipo.getNombre(), PosibleEquipo.guerreros);
	 }
	 
	 @Test
	 public void test02VerificarQueNoTienePersonajes() {
		 Equipo equipo = new Equipo(PosibleEquipo.guerreros);
		 Personaje gohan = new Gohan(PosibleEquipo.guerreros);
		 Personaje goku = new Goku(PosibleEquipo.guerreros);
		 Personaje piccolo = new Piccolo(PosibleEquipo.guerreros);
		 Assert.assertFalse(equipo.tienePersonaje(gohan));
		 Assert.assertFalse(equipo.tienePersonaje(goku));
		 Assert.assertFalse(equipo.tienePersonaje(piccolo));
	 }
	 
	 @Test
	 public void test03VerificarQueTieneSoloAGoku() {
		 Equipo equipo = new Equipo(PosibleEquipo.guerreros); 
		 Personaje goku = new Goku(PosibleEquipo.guerreros);
		 Personaje gohan = new Gohan(PosibleEquipo.guerreros);
		 equipo.agregarPersonaje(goku);
		 Assert.assertEquals(equipo.tienePersonaje(goku), true);
		 Assert.assertFalse(equipo.tienePersonaje(gohan));
	 }
	 
	 @Test
	 public void test04AgregarPersonajeYPedirlo() {
		 Equipo equipo = new Equipo(PosibleEquipo.guerreros); 
		 Personaje goku = new Goku(PosibleEquipo.guerreros);
		 equipo.agregarPersonaje(goku);
		 if(equipo.tienePersonaje(goku)) Assert.assertEquals(equipo.devolverPersonaje(goku.getNombre()), goku);
	 }
	 
	 @Test
	 public void test05VerificarListaDePersonajesEnEquipo() {
		 Equipo equipo = new Equipo(PosibleEquipo.guerreros);
		 Personaje gohan = new Gohan(PosibleEquipo.guerreros);
		 Personaje goku = new Goku(PosibleEquipo.guerreros);
		 Personaje piccolo = new Piccolo(PosibleEquipo.guerreros);
		 equipo.agregarPersonaje(goku);
		 equipo.agregarPersonaje(gohan);
		 equipo.agregarPersonaje(piccolo);
		 ArrayList<Personaje> listapersonajes = (ArrayList<Personaje>) equipo.pedirListaPersonajes();
		 Assert.assertEquals(listapersonajes.contains(goku), true);
		 Assert.assertEquals(listapersonajes.contains(gohan), true);
		 Assert.assertEquals(listapersonajes.contains(piccolo), true);
	 }
	 
	 @Test
	 public void test06VerificarListaDePersonajesNoTieneAGoku() {
		 Equipo equipo = new Equipo(PosibleEquipo.guerreros);
		 Personaje gohan = new Gohan(PosibleEquipo.guerreros);
		 Personaje goku = new Goku(PosibleEquipo.guerreros);
		 equipo.agregarPersonaje(gohan);
		 ArrayList<Personaje> listapersonajes = (ArrayList<Personaje>) equipo.pedirListaPersonajes();
		 Assert.assertFalse(listapersonajes.contains(goku));
		 Assert.assertEquals(listapersonajes.contains(gohan), true);
		 
	 }
}
