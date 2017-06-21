package modelo.consumibles;


/**
 * Clase que contiene constantes para los diversos objetos del juego.
 * Esta clase no debe ser instanciada. Debe ser utilizada de la forma Constantes.MAX_HEALTH.
 * 
 * @author Thomas
 *
 */
public final class Constantes {
    /**
     * Constantes de la clase Semilla.
     */
    public static final String SEMILLA_NOMBRE = "Semilla del ermitaño";
    //public static final String SEMILLA_ATRIBUTO = "HP";
    /**
     * En este caso el atributo es un incremento neto, es decir, se suma.
     */
    public static final double SEMILLA_CANTIDAD_ATRIBUTO = 100.0;
    public static final Boolean SEMILLA_INSTANTANEO = true;
    public static final int SEMILLA_CANTIDAD_TURNOS_RESTANTES = 0;
    
    
    /**
     * Constantes de la clase Esfera.
     */
    public static final String ESFERA_NOMBRE = "Esfera del dragon";
   // public static final String ESFERA_ATRIBUTO = "Ataque";
    /**
     * En este caso el atributo es un incremento es porcentual.
     */
    public static final double ESFERA_CANTIDAD_ATRIBUTO = 0.25;
    public static final Boolean ESFERA_INSTANTANEO = false;
    public static final int ESFERA_CANTIDAD_USOS_RESTANTES = 2;
   
    
    
    /**
     * Constantes de la clase Nube.
     */
    public static final String NUBE_NOMBRE = "Nube voladora";
    //public static final String NUBE_ATRIBUTO = "Velocidad";
    /**
     * En este caso el atributo es un incremento por un cociente.
     */
    public static final double NUBE_CANTIDAD_ATRIBUTO = 2.0;
    public static final Boolean NUBE_INSTANTANEO = false;
    public static final int NUBE_CANTIDAD_TURNOS_RESTANTES = 2;
    
}