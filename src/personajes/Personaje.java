package personajes;

public abstract class Personaje {
    
    protected String nombre;
    protected double vida;
    protected double ki;
    protected EstadoPersonaje estado;
    protected String ataqueEspecial;

    
    public String getNombre() {
        return this.nombre;
    }
    
    public double getVida() {
        return this.vida;
    }
    
    public void agregarKi(double _ki)
    //throw ErrorValorNegativo
    {
        if (_ki < 0) return; //throw ErrorValorNegativo;
        this.ki += _ki;
    }
    
    public void quitarKi(double _ki)
    //throw ErrorValorNegativo
    {
        if (_ki < 0) return; //throw ErrorValorNegativo;
        this.ki += _ki;
    }
    
    public void agregarVida(double _vida)
    //throw ErrorValorNegativo
    {
        if (_vida < 0) return; //throw ErrorValorNegativo;
        this.ki += _vida;
    }
    
    public void quitarVida(double _vida)
    //throw ErrorValorNegativo
    {
        if (_vida < 0) return; //throw ErrorValorNegativo;
        this.ki += _vida;
    }
    
    public abstract double calcularDanoAtaqueEspecial();
    
    public double danioAtaqueNormal() {
        return this.estado.getPoderDePelea();
    }
    
}
