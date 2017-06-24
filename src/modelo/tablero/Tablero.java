package modelo.tablero;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import modelo.consumibles.Consumible;
import modelo.consumibles.ErrorNoHayTurnosDeDuracion;
import modelo.consumibles.ErrorNoTieneCantidadUsos;
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
	private List<ObjetoJuego> objetos; // personaje = consumible = polimorfismo
			
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
	
	public List<ObjetoJuego> moverPersonaje(Personaje personaje, List<Casillero> camino) throws ErrorCasilleroYaOcupado, ErrorMovimientoInvalido{
		// camino tiene que tener la lista de casilleros del movimiento deseado, salvo el casillero actual
		// del personaje
		// devuelve los objetos que fueron recodigos por el personaje que realizó el movimiento
		
		List<ObjetoJuego> objetosRecogidos = new ArrayList<ObjetoJuego>();
		Casillero ultimoCasillero = camino.get(camino.size()-1);
				
		if (!ultimoCasillero.sePuedePasar())
			throw new ErrorCasilleroYaOcupado("Casillero ocupado");
		
		if (!ValidadorMovimientoyAtaque.movimientoValido(personaje, camino))
			throw new ErrorMovimientoInvalido("Movimiento invalido");
		
		//camino valido, entonces el personaje puede recojer los consumibles / objetos
		for (int i = 0; i < camino.size(); i++){
			if (!camino.get(i).estaLibre()){
				ObjetoJuego objeto = camino.get(i).getObjeto();
				if (objeto.sePuedeObtener()){
					personaje.obtenerObjeto(objeto);
					objetosRecogidos.add(objeto);
					// if (objeto.getAtributo().equals("HP")) 
					personaje.agregarVida(objeto.getCantidadAtributoHP());
					this.objetos.remove(objeto);
					Casillero casillero = objeto.getCasillero();
					casillero.setObjeto(null);
					objeto.setCasillero(null);					
				}
			}				
		}
		
		ultimoCasillero.setObjeto(personaje);
		Casillero casilleroViejo = personaje.getCasillero();
		personaje.setCasillero(ultimoCasillero);
		casilleroViejo.setObjeto(null);	
		return objetosRecogidos;
	}	
	
	public boolean ataqueBasico(Personaje p1, Personaje p2) throws ErrorAtaqueInvalido{
		if (!ValidadorMovimientoyAtaque.ataqueValido(p1, p2))
			throw new ErrorAtaqueInvalido("Ataque invalido");
		boolean resultadoPelea = this._ataqueBasico(p1, p2);
		this.eliminarConsumiblesSinUsos(p1);
		return resultadoPelea;
	}	
	
	private boolean _ataqueBasico(Personaje p1, Personaje p2){
		boolean resultadoPelea = Pelea.ataqueBasico(p1, p2);
		
		if (resultadoPelea){
			// murio el p2, lo saco del tablero
			Casillero casilleroP2 = p2.getCasillero();
			casilleroP2.setObjeto(null);
			p2.setCasillero(null); // no creo que se necesario pero lo pongo por las dudas
			// el recolector de basura deberia sacarlo ya que no hay más referencias a p2,
			// pero capaz en la vista / controlador si siga habiendo alguna (no deberia, no es necesario)
			this.objetos.remove(p2);			
		}
		
		return resultadoPelea;
	}
	
	public boolean ataqueEspecial(Personaje p1, Personaje p2) throws ErrorAtaqueInvalido, ErrorNoHayKi, ErrorNoSePuedeRealizarAtaqueEspecial{
		if (!ValidadorMovimientoyAtaque.ataqueValido(p1, p2))
			throw new ErrorAtaqueInvalido("Ataque invalido");
		
		boolean resultadoPelea = this._ataqueEspecial(p1, p2);
		this.eliminarConsumiblesSinUsos(p1);
		return resultadoPelea;
	}
	
	private boolean _ataqueEspecial(Personaje p1, Personaje p2) throws ErrorNoHayKi, ErrorNoSePuedeRealizarAtaqueEspecial{
		boolean resultadoPelea = Pelea.ataqueEspecial(p1, p2); 
		
		if (resultadoPelea){
			// murio el p2, lo saco del tablero
			Casillero casilleroP2 = p2.getCasillero();
			casilleroP2.setObjeto(null);
			p2.setCasillero(null); // no creo que se necesario pero lo pongo por las dudas
			// el recolector de basura deberia sacarlo ya que no hay más referencias a p2,
			// pero capaz en la vista / controlador si siga habiendo alguna (no deberia, no es necesario)
			this.objetos.remove(p2);		
		} 
		
		return resultadoPelea;
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
	
	private boolean hayLugarDisponible(){
		for (Casillero casillero: this.casilleros) {
			if (casillero.estaLibre() && !casillero.esExtremo(Extremo.derecha, ancho, alto)
					&& !casillero.esExtremo(Extremo.abajo, ancho, alto))
				return true;
		}
		return false;
	}
	
	public Consumible crearConsumible(){
		Random rand = new Random();
		int n = rand.nextInt(100);
		//entre 0 y 100
		
		Consumible consumible = null;
		if (this.hayLugarDisponible()){		
			consumible = this.crearConsumibleAleatorio(n);
			this.objetos.add(consumible);
			Casillero casillero = this.buscarCasilleroLibreAleatorio();
			consumible.setCasillero(casillero);	
			casillero.setObjeto(consumible);
		}
		
		return consumible;
	}
	
	private void eliminarConsumiblesSinUsos(Personaje p1){
		List<ObjetoJuego> objetosAEliminar = new ArrayList<ObjetoJuego>();
			
		for (int i = 0; i < p1.getObjetos().size(); i++){
			ObjetoJuego objeto = p1.getObjetos().get(i);
			
			try {		
				if (objeto.getCantidadUsosRestantes() == 0){
					objetosAEliminar.add(objeto);
        			// no puedo eliminar un objeto si está donde estoy iterando, por eso uso esta
        			// lista auxiliar
				}
			} catch(ErrorNoTieneCantidadUsos e){
				continue;
			}
		}
		
		for (int i = 0; i < objetosAEliminar.size(); i++){
        	ObjetoJuego objeto = objetosAEliminar.get(i);
        	p1.eliminarObjeto(objeto);          	
        }  		
	}
	
	public void restarTurnoRestanteConsumibles(){
		for (int i = 0; i < this.objetos.size(); i++){
			ObjetoJuego objeto = this.objetos.get(i);
			if (objeto.tieneObjeto()){
				for (int j = 0; j < objeto.getObjetos().size(); j++){
					ObjetoJuego obj = objeto.getObjetos().get(j);
					try {
						obj.decrementarTurno();
					} catch (ErrorNoHayTurnosDeDuracion e) {
						continue;
					}
				}				
			}
		}  	
	}
	
	public void eliminarConsumiblesSinTurnosRestantes(){
		ArrayList<ArrayList<ObjetoJuego>> objetosAEliminar = new ArrayList<ArrayList<ObjetoJuego>>();
					
		for (int i = 0; i < this.objetos.size(); i++){
			ObjetoJuego objeto = this.objetos.get(i);
			if (objeto.tieneObjeto()){
				for (int j = 0; j < objeto.getObjetos().size(); j++){
					ObjetoJuego obj = objeto.getObjetos().get(j);
					try {
						if (obj.getCantidadTurnosRestantes() == 0){
							ArrayList<ObjetoJuego> personajeYconsumible = new ArrayList<ObjetoJuego>();
							personajeYconsumible.add(objeto); // el personaje dueño del consumible
							personajeYconsumible.add(obj);
							objetosAEliminar.add(personajeYconsumible);
							// no puedo eliminar un objeto si está donde estoy iterando, por eso uso esta
							// lista auxiliar
						}
					} catch (ErrorNoHayTurnosDeDuracion e){
						continue;
					}
				}
			}			
		}
		
		for (int i = 0; i < objetosAEliminar.size(); i++){
			ArrayList<ObjetoJuego> personajeYconsumible = objetosAEliminar.get(i); 
						
        	ObjetoJuego objeto = personajeYconsumible.get(0);
        	objeto.eliminarObjeto(personajeYconsumible.get(1));        	
        }
		
		
	}
	
    public int getAlto() {
        return this.alto;
    }
    
    public int getAncho() {
        return this.ancho;
    }
	
    public List<ObjetoJuego> getObjetosQueSePuedenObtener() { // es lo mismo que poner consumibles
    														  // pero así queda más genérico
        List<ObjetoJuego> objetosQueSePuedenObtener = new ArrayList<ObjetoJuego>();
        
        for (int i = 0; i < this.objetos.size(); i++){
        	ObjetoJuego objeto = this.objetos.get(i); 
        	if (objeto.sePuedeObtener())
        		objetosQueSePuedenObtener.add(objeto);        	
        }
        
        return objetosQueSePuedenObtener;
    } // no creo que se utilice esto, no es necesario

    public Casillero getCasilleroEn(int x, int y) {
        for (Casillero casillero: this.casilleros) {
            if (casillero.getCoordenada().getX() == x && casillero.getCoordenada().getY() == y)
                return casillero;
        }
        
        return null;
    }
    
}
