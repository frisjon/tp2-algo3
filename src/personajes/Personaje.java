package personajes;

public abstract class Personaje implements ObjetoJuego {
    
    protected String nombre;
    protected double vida;
    protected double ki;
    protected EstadoPersonaje estado;
    protected String ataqueEspecial;
    protected Casillero casillero;

    /*
     * Devuelve el nombre del personaje
     */
    public String getNombre() {
        return this.nombre;
    }
    
    /*
     * Devuelve la cantidad de vida del personaje
     */
    public double getVida() {
        return this.vida;
    }
    
    /*
     * Devuelve la cantidad de Ki del personaje
     */
    public double getKi() {
        return this.ki;
    }
    
    /*
     * Permite modificar el valor de ki
     */
    public void agregarKi(double _ki)
    //throw ErrorValorNegativo
    {
        if (_ki < 0) return; //throw ErrorValorNegativo;
        this.ki += _ki;
    }
    
    /*
     * Permite modificar el valor de ki
     */
    public void quitarKi(double _ki)
    //throw ErrorValorNegativo
    {
        if (_ki < 0) return; //throw ErrorValorNegativo;
        this.ki += _ki;
    }
    
    /*
     * Permite modificar la cantidad de vida del personaje
     */
    public void agregarVida(double _vida)
    //throw ErrorValorNegativo
    {
        if (_vida < 0) return; //throw ErrorValorNegativo;
        this.ki += _vida;
    }
    
    /*
     * Permite modificar la cantidad de vida del personaje
     */
    public void quitarVida(double _vida)
    //throw ErrorValorNegativo
    {
        if (_vida < 0) return; //throw ErrorValorNegativo;
        this.ki += _vida;
    }
    
    /*
     * Determina si hay suficiente Ki
     * Devuelve true, si el Ki actual es mayor o igual al pedido
     * Devuelve false, en otro caso
     * 
     */
    public boolean kiSuficiente(double _ki) {
        if (_ki <= this.ki) return true;
        return false;
    }
    
<<<<<<< HEAD
    /*
     * Cambiar Estado
     * (es lo mismo que el personaje se transforme)
     */
    //public abstract void cambiarEstado(int idEstado);
    
    /*
     * Devuelve true, si se cumplen las condiciones necesarias para realizar el ataque especial.
     * (Depende del personaje, por eso es un metodo abstracto)
     */
    public abstract boolean puedeRealizarAtaqueEspecial();

     public void setCasillero(Casillero casillero){
    	this.casillero = casillero;
    }
    
    public Casillero getCasillero(){
    	return this.casillero;
    }
    
}
