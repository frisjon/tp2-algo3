package modelo;

import modelo.algomones.AlgoMon;
import modelo.ataques.Ataque;
import modelo.elementos.Elemento;
import modelo.excepciones.AtaquesAgotadosException;

import java.util.concurrent.ThreadLocalRandom;

public class Partida {
	
	private Jugador jugador1;
	private Jugador jugador2;
	private int turnos;
	private int turnoActual;
	
	public Partida(Jugador jugador1 , Jugador jugador2){
		this.jugador1 = jugador1;
		this.jugador2 = jugador2;
		this.setTurnos();
		this.setOrdenJugadores();
	}

	public void setTurnos() {
		this.turnos = 0;
	}
	
	public int getTurnos() {
		return turnos;
	}
	
	public void setOrdenJugadores() {
		int random = ThreadLocalRandom.current().nextInt(1, 3); // Genera num aleatorio entre 1 y 2.
		this.turnoActual = random % 2;
	}
	
	public String nombreGanador(){
		if(jugador1.perdio()) return jugador2.getNombre();
		return jugador1.getNombre();
	}
	
	public Jugador jugadorActual(){
		if(this.turnoActual == this.jugador1.getIndiceTurno()) return jugador1;
		return jugador2;
	}
	
	public Jugador jugadorOponente(){
		if(this.turnoActual != this.jugador1.getIndiceTurno()) return jugador1;
		return jugador2;
	}
	
	public void jugarTurnoActual(Ataque ataque) throws AtaquesAgotadosException{
		Jugador jugadorActual = jugadorActual();
		jugadorActual.atacar(this.jugadorOponente().getAlgomonActivo(), ataque);
		this.nuevoTurno();
		turnos++;
	}
	
	public void jugarTurnoActual(AlgoMon algomon){
		Jugador jugadorActual = jugadorActual();
		jugadorActual.cambiarDeAlgoMon(algomon);
		this.nuevoTurno();
		turnos++;
	}
	
	public void jugarTurnoActual(Elemento elemento){
		Jugador jugadorActual = jugadorActual();
		jugadorActual.aplicarElemento(elemento);
		this.nuevoTurno();
		turnos++;
	}
	
	public boolean juegoTerminado(){

		return this.jugador1.perdio() || this.jugador2.perdio();
	}
	
	public void nuevoTurno(){
		turnoActual = (turnoActual + 1) % 2;
	}
	
	public void agregarAlgomon(AlgoMon algomon){ //creo que esto ya no sirve mas
		Jugador jugadorActual = jugadorActual();
		jugadorActual.agregarAlgomon(algomon);
	}
}
