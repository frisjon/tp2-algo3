package testJuego;


import equipos.Equipo;
import org.junit.Test;
import org.junit.Assert;
import junit.framework.*;
import java.util.ArrayList;

import personajes.Gohan;
import personajes.Goku;
import personajes.Personaje;
import personajes.Piccolo;

public class TestEquipo extends TestCase {
	
	 @Test
	 public void test01NombreCorrecto() {
		 Equipo equipo = new Equipo("Guerreros Z");
		 Assert.assertEquals(equipo.getNombre(), "Guerreros Z");
	 }
	 
	 @Test
	 public void test02VerificarQueNoTienePersonajes() {
		 Equipo equipo = new Equipo("Guerreros Z");
		 Personaje gohan = new Gohan();
		 Personaje goku = new Goku();
		 Personaje piccolo = new Piccolo();
		 Assert.assertFalse(equipo.tienePersonaje(gohan));
		 Assert.assertFalse(equipo.tienePersonaje(goku));
		 Assert.assertFalse(equipo.tienePersonaje(piccolo));
	 }
	 
	 @Test
	 public void test03VerificarQueTieneSoloAGoku() {
		 Equipo equipo = new Equipo("Guerreros Z"); 
		 Personaje goku = new Goku();
		 Personaje gohan = new Gohan();
		 equipo.agregarPersonaje(goku);
		 Assert.assertEquals(equipo.tienePersonaje(goku), true);
		 Assert.assertFalse(equipo.tienePersonaje(gohan));
	 }
	 
	 @Test
	 public void test04AgregarPersonajeYPedirlo() {
		 Equipo equipo = new Equipo("Guerreros Z"); 
		 Personaje goku = new Goku();
		 equipo.agregarPersonaje(goku);
		 if(equipo.tienePersonaje(goku)) Assert.assertEquals(equipo.devolverPersonaje(goku.getNombre()), goku);
	 }
	 
	 @Test
	 public void test05VerificarListaDePersonajesEnEquipo() {
		 Equipo equipo = new Equipo("Guerreros Z");
		 Personaje gohan = new Gohan();
		 Personaje goku = new Goku();
		 Personaje piccolo = new Piccolo();
		 equipo.agregarPersonaje(goku);
		 equipo.agregarPersonaje(gohan);
		 equipo.agregarPersonaje(piccolo);
		 ArrayList<Personaje> listapersonajes = equipo.pedirListaPersonajes();
		 Assert.assertEquals(listapersonajes.contains(goku), true);
		 Assert.assertEquals(listapersonajes.contains(gohan), true);
		 Assert.assertEquals(listapersonajes.contains(piccolo), true);
	 }
	 
	 @Test
	 public void test06VerificarListaDePersonajesNoTieneAGoku() {
		 Equipo equipo = new Equipo("Guerreros Z");
		 Personaje gohan = new Gohan();
		 Personaje goku = new Goku();
		 equipo.agregarPersonaje(gohan);
		 ArrayList<Personaje> listapersonajes = equipo.pedirListaPersonajes();
		 Assert.assertFalse(listapersonajes.contains(goku));
		 Assert.assertEquals(listapersonajes.contains(gohan), true);
		 
	 }
}
