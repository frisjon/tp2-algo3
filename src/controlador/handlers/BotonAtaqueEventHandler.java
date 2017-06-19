package controlador.handlers;

import javafx.event.ActionEvent;
import modelo.pelea.Pelea;
import modelo.personajes.Personaje;

public class BotonAtaqueEventHandler extends BotonHandler {
	private Personaje atacante;
	private Personaje defensor;
	String tipoDeAtaque;

	public BotonAtaqueEventHandler(Personaje pj_atacante, Personaje pj_defensor, String ataque) {
		// TODO Auto-generated constructor stub
		this.atacante = pj_atacante;
		this.defensor = pj_defensor;
		this.tipoDeAtaque = ataque;
	}
	//ver lo de las excepciones
	@Override
    public void handle(ActionEvent event) {
		super.handle(event);
		if(this.tipoDeAtaque == "Ataque Basico") Pelea.ataqueBasico(this.atacante, this.defensor);
		else Pelea.ataqueEspecial(this.atacante, this.defensor);
	}
	
	
}
