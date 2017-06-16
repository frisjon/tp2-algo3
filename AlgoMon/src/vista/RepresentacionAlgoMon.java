package vista;

import javafx.scene.image.Image;
import javafx.scene.media.AudioClip;
import modelo.algomones.AlgoMon;
import modelo.ataques.Ataque;
import modelo.estados.Estado;
import modelo.estados.EstadoNormal;
import modelo.estados.Quemado;

public class RepresentacionAlgoMon {
	private AudioClip sonido;
	private Image imagen;
	private Image tabla;
	private AlgoMon algomon;
	private String nombre;
	
	public RepresentacionAlgoMon(Image imagen, Image tabla, AlgoMon algomon, String nombre, AudioClip sonido){
		setImagen(imagen);
		setAlgomon(algomon);
		setTabla(tabla);
		setNombre(nombre);
		this.sonido = sonido;
	}

	public String getEstadoPersistente(){
		Estado estado = algomon.getEstadoPersistente();
		return getNombreDeEstado(estado);
	}

	public String getEstadoEfimero(){
		Estado estado = algomon.getEstadoEfimero();
		return getNombreDeEstado(estado);
	}

	private String getNombreDeEstado(Estado estado){
		if(estado.getClass().equals((Quemado.class))) return "Quemado";
		if(estado.getClass().equals(EstadoNormal.class)) return "Normal";
		return "Dormido";

	}
	
	public String getNombreDeAtaque(Ataque ataque){
		return ataque.getClass().getSimpleName();
	}
	
	public Image getImagen() {
		return imagen;
	}

	private void setImagen(Image imagen) {
		this.imagen = imagen;
	}

	public AlgoMon getAlgomon() {
		return algomon;
	}

	public void setAlgomon(AlgoMon algomon) {
		this.algomon = algomon;
	}

	public Image getTabla() {
		return tabla;
	}

	private void setTabla(Image tabla) {
		this.tabla = tabla;
	}

	public String getNombre() {
		return nombre;
	}

	private void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public AudioClip getSonido(){
		return sonido;
	}
}
