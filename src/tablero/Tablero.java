package tablero;

import java.util.ArrayList;
import java.util.List;

import consumibles.Consumible;
import consumibles.ErrorConsumibleInstantaneo;
import equipos.Equipo;
import motor.ErrorNoHayKi;
import motor.ErrorNoSePuedeRealizarAtaqueEspecial;
import motor.Pelea;
import personajes.Personaje;

public class Tablero {
	
	private int ancho;
	private int alto;
	private List<Casillero> casilleros;
	private List<Personaje> personajes;
	private List<Consumible> consumibles;
			
	private void crearCasilleros(){
		for (int i = 0; i < this.ancho; i++){
			for (int j = 0; j < this.alto; j++){
				Casillero casillero = new Casillero(i, j);
				this.casilleros.add(casillero);
			}			
		}		
	}
	
	public Tablero (int ancho, int alto) {
		this.alto = alto;
		this.ancho = ancho;
		this.casilleros = new ArrayList<Casillero>();
		this.personajes = new ArrayList<Personaje>();
		this.consumibles = new ArrayList<Consumible>();
				
		this.crearCasilleros();
	}

	private Casillero buscarExtremo(String tipoDeExtremo) throws ErrorNoHayMasExtremos {
		for (int i = 0; i < this.casilleros.size(); i++){
			Casillero casillero = this.casilleros.get(i); 
			if (casillero.estaLibre() && casillero.esExtremo(tipoDeExtremo, this.ancho, this.alto))
				return casillero;
		}
		
		throw new ErrorNoHayMasExtremos("No hay extremo disponible");
	}
	
	public void colocarPersonajes(List<Equipo> equipos) throws ErrorNoHayMasExtremos, ErrorCasilleroYaOcupado{
		String tipoDeExtremo = Extremo.izquierda;
		
		for (int j = 0; j < equipos.size(); j++){
			// recorro equipo por equipo
					
			List<Personaje> personajes = equipos.get(j).pedirListaPersonajes();
			for (int i = 0; i < personajes.size(); i++){
				// recorro todos los personajes del equipo
				
				Personaje personaje = personajes.get(i);
				Casillero casillero = this.buscarExtremo(tipoDeExtremo);
				personaje.setCasillero(casillero);
				casillero.setObjeto(personaje);
				this.personajes.add(personaje);
			}
			tipoDeExtremo = Extremo.obtenerSiguienteExtremo(tipoDeExtremo);
		}		
	}
	
	public void moverPersonaje(Personaje personaje, List<Casillero> camino) throws ErrorCasilleroYaOcupado, ErrorMovimientoInvalido{
		// camino tiene que tener la lista de casilleros del movimiento deseado, salvo el casillero actual
		// del personaje
		Casillero ultimoCasillero = camino.get(camino.size()-1);
		
		if (!ultimoCasillero.estaLibre()) //a modificar (tener en cuenta que si hay un consumible el pj se puede posicionar)
			throw new ErrorCasilleroYaOcupado("Casillero ocupado");
		
		if (!ValidadorMovimientoyAtaque.movimientoValido(personaje, camino))
			throw new ErrorMovimientoInvalido("Movimiento invalido");
			
		ultimoCasillero.setObjeto(personaje);
		Casillero casilleroViejo = personaje.getCasillero();
		personaje.setCasillero(ultimoCasillero);
		casilleroViejo.setObjeto(null);		
	}	
	
	//FALTA VALIDAR QUE DOS DEL MISMO EQUIPO NO SE PUEDEN ATACAR ENTRE ELLOS
	public void ataqueBasico(Personaje p1, Personaje p2) throws ErrorAtaqueInvalido{
		if (!ValidadorMovimientoyAtaque.ataqueValido(p1, p2))
			throw new ErrorAtaqueInvalido("Ataque invalido");
		 
		this._ataqueBasico(p1, p2);
	}	
	
	private void _ataqueBasico(Personaje p1, Personaje p2){
		try {
			if (Pelea.ataqueBasico(p1, p2)){
				// murio el p2, lo saco del tablero
				Casillero casilleroP2 = p2.getCasillero();
				try {
					casilleroP2.setObjeto(null);
				} catch (ErrorCasilleroYaOcupado e) {
					
				}
				this.personajes.remove(p2);
				// si quieren tambien se puede remover p2 del equipo en donde pertenece, no lo veo necesario
			}
		} catch (ErrorConsumibleInstantaneo e) {
			
		}
		// si es necesario esta funcion puede devolver true si es que murio el p2 para avisarle
		// a OrganizadorJuego. Eso hay que verlo cuando se haga la vista.
	}
	
	public void ataqueEspecial(Personaje p1, Personaje p2) throws ErrorAtaqueInvalido, ErrorNoHayKi, ErrorNoSePuedeRealizarAtaqueEspecial{
		if (!ValidadorMovimientoyAtaque.ataqueValido(p1, p2))
			throw new ErrorAtaqueInvalido("Ataque invalido");
		 
		this._ataqueEspecial(p1, p2);
	}
	
	//FALTA VALIDAR QUE DOS DEL MISMO EQUIPO NO SE PUEDEN ATACAR ENTRE ELLOS
	private void _ataqueEspecial(Personaje p1, Personaje p2) throws ErrorNoHayKi, ErrorNoSePuedeRealizarAtaqueEspecial{
		try {
			if (Pelea.ataqueEspecial(p1, p2)){
					// murio el p2, lo saco del tablero
					Casillero casilleroP2 = p2.getCasillero();
					try {
						casilleroP2.setObjeto(null);
					} catch (ErrorCasilleroYaOcupado e) {
						
					}
					this.personajes.remove(p2);	
					// si quieren tambien se puede remover p2 del equipo en donde pertenece, no lo veo necesario
				}
		} catch (ErrorConsumibleInstantaneo e) {
			
		}
		// si es necesario esta funcion puede devolver true si es que murio el p2 para avisarle
		// a OrganizadorJuego. Eso hay que verlo cuando se haga la vista.
	}
	
}
