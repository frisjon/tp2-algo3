package personajes;

public abstract class EstadoPersonaje {
    
    protected double poderDePelea;
    protected double distanciaAtaque;
    protected double velocidad;
    
    public double getPoderDePelea() {
        return this.poderDePelea;
    }
    
    public double getDistanciaAtaque() {
        return this.distanciaAtaque;
    }
    
    public double getVelocidad() {
        return this.velocidad;
    }

}
