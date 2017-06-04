package juego;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Clase que representa el Juego con sus respectivos jugadores y organizador del juego.
 * @author Ramiro
 *
 */

public class Juego {
	private ArrayList<Jugador> listajugadores;
	private OrganizadorJuego organizador;
	
	public Juego() {
		this.listajugadores = new ArrayList<Jugador>();
		this.organizador = new OrganizadorJuego();
	}
	
	public void agregarJugadores(String numero_jugador) {
		Scanner input = new Scanner(System.in);
		System.out.println("Jugador "+ numero_jugador + " ingrese su nombre: ");
		String nombre_jugador = input.next();
		Jugador jugador = new Jugador(nombre_jugador);
		this.listajugadores.add(jugador);
	}
}
