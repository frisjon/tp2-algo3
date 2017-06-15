package fiuba.algo3.modelo.excepciones;

import fiuba.algo3.modelo.jugabilidad.Jugador;

public class JugadorGanoException extends RuntimeException {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private Jugador jugadorGanador = null;

	public JugadorGanoException(Jugador jugadorGanador){
		super();
		this.jugadorGanador = jugadorGanador;
	}

	public JugadorGanoException(){
		super();
	}

	public Jugador getJugadorGanador() {
		return jugadorGanador;
	}

}
