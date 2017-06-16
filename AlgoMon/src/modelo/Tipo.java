package modelo;

public enum Tipo {
	AGUA(0.5,0.5,2,1) {
		@Override
		public double obtenerMultiplicador(Tipo otroTipo) {
			return otroTipo.getVsAgua();
		}
	},
	FUEGO(2,0.5,0.5,1) {
		@Override
		public double obtenerMultiplicador(Tipo otroTipo) {
			return otroTipo.getVsFuego();
		}
	},
	PLANTA(0.5,2,0.5,1) {
		@Override
		public double obtenerMultiplicador(Tipo otroTipo) {
			return otroTipo.getVsPlanta();
		}
	},
	NORMAL(1,1,1,1) {
		@Override
		public double obtenerMultiplicador(Tipo otroTipo) {
			return otroTipo.getVsNormal();
		}
	};
	
	private double vsAgua;
	private double vsFuego;
	private double vsPlanta;
	private double vsNormal;
	
	Tipo(double vsAgua, double vsFuego, double vsPlanta, double vsNormal){
		this.vsAgua = vsAgua;
		this.vsFuego = vsFuego;
		this.vsPlanta = vsPlanta;
		this.vsNormal = vsNormal;
	}
	
	protected double getVsAgua() {
		return vsAgua;
	}
	
	protected double getVsFuego() {
		return vsFuego;
	}
	
	protected double getVsPlanta() {
		return vsPlanta;
	}
	
	protected double getVsNormal() {
		return vsNormal;
	}

	public abstract double obtenerMultiplicador(Tipo otroTipo);
}
