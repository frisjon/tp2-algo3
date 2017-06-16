package modelo.estados;

import modelo.algomones.AlgoMon;

public class Estados {
	
	private Estado estadoPersistente;
	private Estado estadoEfimero;
	
	public Estados(){
		setEstadoPersistente(new EstadoNormal());
		setEstadoEfimero(new EstadoNormal());
	}
	
	public void nuevoTurno(AlgoMon algomon){
		this.getEstadoPersistente().nuevoTurno(algomon);
		this.getEstadoEfimero().nuevoTurno(algomon);
	}
	
	public boolean puedeAtacar(){
		return (this.getEstadoPersistente().puedeAtacar()) && (this.getEstadoEfimero().puedeAtacar());
	}

	public Estado getEstadoPersistente() {
		return estadoPersistente;
	}

	public void setEstadoPersistente(Estado estadoPersistente) {
		this.estadoPersistente = estadoPersistente;
	}

	public Estado getEstadoEfimero() {
		return estadoEfimero;
	}

	public void setEstadoEfimero(Estado estadoEfimero) {
		this.estadoEfimero = estadoEfimero;
	}

	/*public List<Estado> getListaDeEstados() {
		List<Estado> lista = new ArrayList<Estado>();
		lista.add(estadoEfimero);
		lista.add(estadoPersistente);
		return lista;
	}*/
}
