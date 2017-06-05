package juego;

import java.util.ArrayList;
import java.util.Scanner;

import equipos.Equipo;
import equipos.EquipoEnemigos;
import equipos.EquipoGuerreros;
import jugadores.*;

/**
 * Clase que representa el Juego con sus respectivos jugadores y organizador del juego.
 * @author Ramiro
 *
 */

public class Juego {
	private ArrayList<Jugador> listajugadores;
	private OrganizadorJuego organizador;
	final String EQUIPO1 = "Guerreros Z", EQUIPO2 = "Enemigos de la Tierra";
	
	public Juego() {
		this.listajugadores = new ArrayList<Jugador>();
		this.organizador = new OrganizadorJuego();
	}
	
	public void agregarJugador(String numero_jugador) {
		Scanner input = new Scanner(System.in);
		System.out.println("Jugador "+ numero_jugador + " ingrese su nombre: ");
		String nombre_jugador = input.next();
		Jugador jugador = new Jugador(nombre_jugador);
		this.listajugadores.add(jugador);
	}
	
	/**
	 * Segun que equipo elija el jugador 1 el restante se le asigna automaticamente al jugador 2.
	 *
	 */
	public void agregarEquipos() {
		Jugador jugador1 = this.listajugadores.get(0);
		Jugador jugador2 = this.listajugadores.get(1);
		Equipo equipo_guerreros = new EquipoGuerreros();
		Equipo equipo_enemigos = new EquipoEnemigos();
		System.out.println(jugador1.getNombre() + " elegí tu equipo (1 o 2): ");
		Scanner input = new Scanner(System.in);
		System.out.println("1." + EQUIPO1 + ".");
		System.out.println("2. " + EQUIPO2 + ".");
		String numero_equipo = input.next();
		while( numero_equipo != "1" || numero_equipo != "2" ) {
			System.out.println("Eleccion incorrecta");
			numero_equipo = input.next();
		}
		if( numero_equipo == "1") {
			this.organizador.otorgarEquipo(jugador1, equipo_guerreros);
			this.organizador.otorgarEquipo(jugador2, equipo_enemigos);
		}else {
			this.organizador.otorgarEquipo(jugador1, equipo_enemigos);
			this.organizador.otorgarEquipo(jugador2, equipo_guerreros);
		}
		
		
	}
	
	public Jugador pedirJugador(int numero_jugador) {
		return this.listajugadores.get(numero_jugador - 1);
	}
	
	public void distribuirPersonajesEquipos() {
		this.organizador.colocarPersonajesEnTablero(this.listajugadores.get(0), this.listajugadores.get(1));
		
	}
	
	public void main() {
		Juego juego = new Juego();
		juego.agregarJugador("1");
		juego.agregarJugador("2");
		juego.agregarEquipos();
		juego.distribuirPersonajes();
		
	}
}
