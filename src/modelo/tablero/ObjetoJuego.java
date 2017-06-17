package modelo.tablero;

import java.util.List;

public interface ObjetoJuego {
	// Objeto que se encuentra activo dentro del tablero del juego
	
	public boolean sePuedePasar();
	public boolean sePuedeObtener();
	public void setCasillero(Casillero casillero);
	public Casillero getCasillero();
	public String getAtributo();
	public void decrementarUso();
	public void decrementarTurno();
	public int getCantidadUsosRestantes();
	public int getCantidadTurnosRestantes();
	public double getCantidadAtributo();
	public boolean tieneObjeto();
	public List<ObjetoJuego> getObjetos();
	public void eliminarObjeto(ObjetoJuego objeto);
 }
