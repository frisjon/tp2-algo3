package modelo.tablero;

public interface ObjetoJuego {
	// Objeto que se encuentra activo dentro del tablero del juego
	
	public boolean sePuedePasar();
	public boolean sePuedeObtener();
	public void setCasillero(Casillero casillero);
	public Casillero getCasillero();
	public String getAtributo();
	public void decrementarUso();
	public int getCantidadUsosRestantes();
	public double getCantidadAtributo();

}
