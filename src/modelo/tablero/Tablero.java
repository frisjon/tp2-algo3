package modelo.tablero;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import modelo.consumibles.Consumible;
import modelo.consumibles.Esfera;
import modelo.consumibles.Nube;
import modelo.consumibles.Semilla;
import modelo.equipo.Equipo;
import modelo.pelea.ErrorNoHayKi;
import modelo.pelea.ErrorNoSePuedeRealizarAtaqueEspecial;
import modelo.pelea.Pelea;
import modelo.personajes.Personaje;

public class Tablero {
	
	private int ancho;
	private int alto;
	private List<Casillero> casilleros;
	//private List<Personaje> personajes;
	//private List<Consumible> consumibles;
	private List<ObjetoJuego> objetos; // personaje = consumible = polimorfismo nivel 99
			
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
		//this.personajes = new ArrayList<Personaje>();
		//this.consumibles = new ArrayList<Consumible>();
		this.objetos = new ArrayList<ObjetoJuego>();
				
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
				this.objetos.add(personaje);
			}
			tipoDeExtremo = Extremo.obtenerSiguienteExtremo(tipoDeExtremo);
		}		
	}
	
	public void moverPersonaje(Personaje personaje, List<Casillero> camino) throws ErrorCasilleroYaOcupado, ErrorMovimientoInvalido{
		// camino tiene que tener la lista de casilleros del movimiento deseado, salvo el casillero actual
		// del personaje
		Casillero ultimoCasillero = camino.get(camino.size()-1);
		
		if (!ultimoCasillero.sePuedePasar())
			throw new ErrorCasilleroYaOcupado("Casillero ocupado");
		
		if (!ValidadorMovimientoyAtaque.movimientoValido(personaje, camino))
			throw new ErrorMovimientoInvalido("Movimiento invalido");
		
		//camino valido, entonces el personaje puede recojer los consumibles / objetos
		for (int i = 0; i < camino.size(); i++){
			if (!camino.get(i).estaLibre()){
				ObjetoJuego objeto = camino.get(i).getObjeto();
				if (objeto.sePuedeObtener())
					personaje.obtenerObjeto(objeto);					
			}				
		}
		
		ultimoCasillero.setObjeto(personaje);
		Casillero casilleroViejo = personaje.getCasillero();
		personaje.setCasillero(ultimoCasillero);
		casilleroViejo.setObjeto(null);		
	}	
	
	public void ataqueBasico(Personaje p1, Personaje p2) throws ErrorAtaqueInvalido{
		if (!ValidadorMovimientoyAtaque.ataqueValido(p1, p2))
			throw new ErrorAtaqueInvalido("Ataque invalido");
		 
		this._ataqueBasico(p1, p2);
		this.eliminarConsumiblesVacios(p1);
	}	
	
	private void _ataqueBasico(Personaje p1, Personaje p2){
		if (Pelea.ataqueBasico(p1, p2)){
			// murio el p2, lo saco del tablero
			Casillero casilleroP2 = p2.getCasillero();
			casilleroP2.setObjeto(null);
			this.objetos.remove(p2);
			// si quieren tambien se puede remover p2 del equipo en donde pertenece, no lo veo necesario
		}
		// si es necesario esta funcion puede devolver true si es que murio el p2 para avisarle
		// a OrganizadorJuego. Eso hay que verlo cuando se haga la vista.
	}
	
	public void ataqueEspecial(Personaje p1, Personaje p2) throws ErrorAtaqueInvalido, ErrorNoHayKi, ErrorNoSePuedeRealizarAtaqueEspecial{
		if (!ValidadorMovimientoyAtaque.ataqueValido(p1, p2))
			throw new ErrorAtaqueInvalido("Ataque invalido");
		 
		this._ataqueEspecial(p1, p2);
		this.eliminarConsumiblesVacios(p1);
	}
	
	private void _ataqueEspecial(Personaje p1, Personaje p2) throws ErrorNoHayKi, ErrorNoSePuedeRealizarAtaqueEspecial{
		if (Pelea.ataqueEspecial(p1, p2)){
			// murio el p2, lo saco del tablero
			Casillero casilleroP2 = p2.getCasillero();
			casilleroP2.setObjeto(null);
			this.objetos.remove(p2);	
			// si quieren tambien se puede remover p2 del equipo en donde pertenece, no lo veo necesario
		} 
		// si es necesario esta funcion puede devolver true si es que murio el p2 para avisarle
		// a OrganizadorJuego. Eso hay que verlo cuando se haga la vista.
	}
	
	private Consumible crearConsumibleAleatorio(int random){
		if (random >= 0 && random <= 33){
			Esfera esfera = new Esfera();
			return esfera;
		}else if (random >= 34 && random <= 67){
			Nube nube = new Nube();
			return nube;
		}
		
		Semilla semilla = new Semilla();
		return semilla;		
	}
	
	private Casillero buscarCasilleroLibreAleatorio(){
		Random rand = new Random();
		int x,y;
		Casillero casillero = null;
		
		while(true){
			// hasta encontrar casillero disponible para el consumible
			y = rand.nextInt(this.alto - 1);
			x = rand.nextInt(this.ancho - 1);
						
			for (int i = 0; i < this.casilleros.size(); i++){
				casillero = this.casilleros.get(i); 
				if (casillero.getCoordenada().getX() == x && casillero.getCoordenada().getY() == y)
					break;
					// encontre el casillero elegido aleatoriamente
			}
			
			if (casillero.estaLibre())
				// si esta libre me sirve, sino debo repetir el proceso
				break;
		}
		
		return casillero;
	}
	
	public void crearConsumible(){
		Random rand = new Random();
		int n = rand.nextInt(100);
		//entre 0 y 100
		Consumible consumible = this.crearConsumibleAleatorio(n);
		this.objetos.add(consumible);
		Casillero casillero = this.buscarCasilleroLibreAleatorio();
		consumible.setCasillero(casillero);	
		casillero.setObjeto(consumible);
	}
	
	private void eliminarConsumiblesVacios(Personaje p1){
		List<ObjetoJuego> objetosAEliminar = new ArrayList<ObjetoJuego>();
			
		for (int i = 0; i < p1.getObjetos().size(); i++){
			ObjetoJuego objeto = p1.getObjetos().get(i);
			
			if (objeto.getCantidadUsosRestantes() == 0)
				objetosAEliminar.add(objeto);
        		// no puedo eliminar un objeto si está donde estoy iterando, por eso uso esta
        		// lista auxiliar   			
		}
		
		for (int i = 0; i < objetosAEliminar.size(); i++){
        	ObjetoJuego objeto = objetosAEliminar.get(i);
        	Casillero casillero = objeto.getCasillero();
           	p1.eliminarObjeto(objeto);           	
           	this.objetos.remove(objeto);
           	casillero.setObjeto(null);
        }  
		
	}

    public int getAlto() {
        return this.alto;
    }
    
    public int getAncho() {
        return this.ancho;
    }
	
}
