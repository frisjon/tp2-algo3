package tablero;

import java.util.ArrayList;
import java.util.List;

import consumibles.Consumible;
import personajes.Personaje;

public class Tablero {
	
	private int ancho;
	private int alto;
	private List<Casillero> casilleros;
	private List<Personaje> personajes;
	private List<Consumible> consumibles;
	// private DesarrolladorAtaque desarrolladorAtaque;
	// private ValidadorMovimiento validadorMovimiento;
	
	public void crearCasilleros(){
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

	public Casillero buscarExtremo(int tipoDeExtremo) {
		for (int i = 0; i < this.casilleros.size(); i++){
			Casillero casillero = this.casilleros.get(i); 
			if (casillero.estaLibre() && casillero.esExtremo(tipoDeExtremo, this.ancho, this.alto))
				return casillero;
		}
		
		// throw new ErrorNoHayMasExtremos("No hay extremo disponible");
		return null; // momentaneo asi no me molesta con los try - catch
	}
	
	public void colocarPersonajes(ArrayList<ArrayList<Personaje>> equipos){
		int tipoDeExtremo = -1;
		
		for (int j = 0; j < equipos.size(); j++){
			// recorro equipo por equipo
			
			tipoDeExtremo++;
			List<Personaje> personajes = equipos.get(j);
			for (int i = 0; i < personajes.size(); i++){
				// recorro todos los personajes del equipo
				
				Personaje personaje = personajes.get(i);
				Casillero casillero = this.buscarExtremo(tipoDeExtremo);
				personaje.setCasillero(casillero);
				try {
					casillero.setObjeto(personaje);
				} catch (ErrorCasilleroYaOcupado e) {
					continue; // nunca va a entrar porque se chequea en buscarExtremo
				}
				this.personajes.add(personaje);
			}		
		}		
	}
	
	public boolean movimientoValido(Personaje personaje, Casillero nuevoCasillero){
		Casillero casillero = personaje.getCasillero();
		// falta implementar
		return true;
	}
	
	public void moverPersonaje(Personaje personaje, Casillero nuevoCasillero) throws ErrorCasilleroYaOcupado, ErrorMovimientoInvalido{
		if (!nuevoCasillero.estaLibre())
			throw new ErrorCasilleroYaOcupado("Casillero ocupado");
		
		if (!this.movimientoValido(personaje, nuevoCasillero))
			throw new ErrorMovimientoInvalido("Movimiento invalido");
			
		nuevoCasillero.setObjeto(personaje);
		Casillero casilleroViejo = personaje.getCasillero();
		personaje.setCasillero(nuevoCasillero);
		casilleroViejo.setObjeto(null);		
	}
	
	public void mostrarPosicionesPersonajes(){
		for (int j = 0; j < this.personajes.size(); j++){
			Personaje personaje = this.personajes.get(j);
			Coordenada coordenada = personaje.getCasillero().getCoordenada();
			System.out.println(personaje.getNombre());
			System.out.println(coordenada.getX() + "," + coordenada.getY());			
		}
	}
	
	
}
