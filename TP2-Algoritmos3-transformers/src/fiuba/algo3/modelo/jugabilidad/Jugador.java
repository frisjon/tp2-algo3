package fiuba.algo3.modelo.jugabilidad;

import fiuba.algo3.modelo.personajes.*;

public class Jugador {
	
	private String Nombre;
	boolean ganador;
	private Personaje personaje1;
	private Personaje personaje2;
	private Personaje personaje3;
	private Personaje personajeModoUnico = null;
	private TipoTransformer tipo;
	
	public void finalizarTurno(){
		if (this.personajeModoUnico != null){
			
			this.personajeModoUnico.reestablecerEfectos();
			this.personajeModoUnico.actualizarBonus();
			
		}else{
			
		this.personaje1.reestablecerEfectos();
		this.personaje1.actualizarBonus();
		
		this.personaje2.reestablecerEfectos();
		this.personaje2.actualizarBonus();
		
		this.personaje3.reestablecerEfectos();
		this.personaje3.actualizarBonus();
		}
	}
	
	public Jugador(String nombre,TipoTransformer tipo){
		this.Nombre= nombre;
		this.ganador=false;
		this.tipo = tipo;
		
		if(tipo.equals(TipoTransformer.AUTOBOT)){
			personaje1 = new Optimus();
			personaje2 = new Bumblebee();
			personaje3 = new Ratchet();			
		}
		else{
			personaje1 = new Megatron();
			personaje2 = new Bonecrusher();
			personaje3 = new Frenzy();
		}
	}	

	public String getNombre() {
		return this.Nombre;
	}
	public Personaje getPersonaje1() {
		return this.personaje1;
	}	
	public Personaje getPersonaje2() {
		return this.personaje2;
		
	}public Personaje getPersonaje3() {
		return this.personaje3;
	}
	
	public boolean getGanador(){
		return this.ganador;
	}

	public Personaje getPersonajeModoUnico() {
		return personajeModoUnico;
	}

	public void setPersonajeModoUnico(Personaje personajeModoUnico) {
		this.personajeModoUnico = personajeModoUnico;
	}

	public TipoTransformer getTipo() {
		return tipo;
	}
	

}
