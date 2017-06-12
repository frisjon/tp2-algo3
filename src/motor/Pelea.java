package motor;

import personajes.*;
import consumibles.*;
import motor.ErrorNoHayKi;
import motor.ErrorNoSePuedeRealizarAtaqueEspecial;

/**
 * Clase que se encargara de desarollar una pelea entre dos personajes.
 * @author Thomas
 *
 */
public final class Pelea {
    /**
     * Funcion que actualiza los personajes luego de una pelea.
     * Esta funcion modificara los atributos de los personajes y de los consumibles si fueron
     * utilizados.
     * @author Thomas
     * @param pj1
     * @param pj2
     * @param hpSanado
     * @param dmgRealizado
     * @param kiUtilizado
     * @return True si el personaje debe morir y False en caso contrario.
     */
    private static boolean actualizarPersonajes(Personaje pj1, Personaje pj2, double hpSanado, double dmgRealizado, double kiUtilizado){
        pj1.agregarVida(hpSanado);
        pj1.quitarKi(kiUtilizado);
        pj2.quitarVida(dmgRealizado);
        
        if (pj2.getVida() == 0.0){
            return true;
        }
        
        return false;
    }
    
    /**
     * Funcion que desarolla un ataque basico de pj1 a pj2.
     * Esta funcion puede modificar los atributos de los objetos involucrados.
     * La reduccion del 20% del daño si pj2 es mas poderoso que pj1 se aplica luego de aplicar
     * los estados de los consumibles.
     * @author Thomas
     * @param pj1
     * @param pj2
     * @throws ErrorConsumibleInstantaneo 
     */
    public static boolean ataqueBasico(Personaje pj1, Personaje pj2) throws ErrorConsumibleInstantaneo{
        double poderPeleaPj1 = pj1.getPoderPelea();
        double poderPeleaPj2 = pj2.getPoderPelea();
        /**
         * Daño realizado al pj2.
         */
        double dmg;
        /**
         * Posible aumento realizado por el consumible.
         * En el caso de que no haya sera 0.
         */
        double aumentoConsumible = 0;
        /**
         * Si el personaje tiene aumento de ataque en la pasiva se tendra en cuenta.
         * Ej: Goku.
         */
        double aumentoPasiva = poderPeleaPj1 * pj1.getAumentoPasiva();
        /**
         * Posible descuento realizado por la diferencia de poder.
         * En el caso de que no haya sera 0.
         */
        double descuentoDifPoder = 0;
        
        if (pj1.tieneConsumible()){
            Consumible consumiblePj1 = pj1.getConsumible();
            
            switch (consumiblePj1.getAtributo()){
                case "Ataque": aumentoConsumible = (poderPeleaPj1 + aumentoPasiva) * (consumiblePj1.getCantidadAtributo());
            }
            
            try{
                consumiblePj1.decrementarUso();
            }
            catch (ErrorNoHayUsosRestantes e1){
                pj1.eliminarConsumible();
            }
            catch (ErrorConsumibleInstantaneo e2){
                throw new ErrorConsumibleInstantaneo("El personaje posee un consumible instaneo.");
            }
        }
        
        //Caso en el cual se aplica un descuento al daño.
        if (poderPeleaPj2 > poderPeleaPj1){
            descuentoDifPoder = ((poderPeleaPj1 + aumentoConsumible + aumentoPasiva) * 20.0) / 100.0;
        }
        
        dmg = poderPeleaPj1 + aumentoConsumible + aumentoPasiva - descuentoDifPoder;
        
        return actualizarPersonajes(pj1, pj2, 0, dmg, 0);
    }
    
    /**
     * Funcion que desarolla un ataque basico de pj1 a pj2.
     * Esta funcion puede modificar los atributos de los objetos involucrados.
     * La reduccion del 20% del daño si pj2 es mas poderoso que pj1 se aplica luego de aplicar
     * los estados de los consumibles.
     * @author Thomas
     * @param pj1
     * @param pj2
     * @throws ErrorNoHayKi
     * @throws ErrorNoSePuedeRealizarAtaqueEspecial
     * @throws ErrorConsumibleInstantaneo 
     */
    public static boolean ataqueEspecial(Personaje pj1, Personaje pj2) throws ErrorNoHayKi, ErrorNoSePuedeRealizarAtaqueEspecial, ErrorConsumibleInstantaneo{
        double kiAtaqueEspecial = pj1.getKiNecesario();
        double poderPeleaPj1 = pj1.getPoderPelea();
        double poderPeleaPj2 = pj2.getPoderPelea();
        /**
         * Daño realizado al pj2.
         */
        double dmg;
        /**
         * Posible aumento realizado por el consumible.
         * En el caso de que no haya sera 0.
         */
        double aumentoConsumible = 0;
        /**
         * Si el personaje tiene aumento de ataque en la pasiva se tendra en cuenta.
         * Ej: Goku.
         */
        double aumentoPasiva = poderPeleaPj1 * pj1.getAumentoPasiva();
        double aumentoAtaqueEspecial = poderPeleaPj1 * pj1.getAumentoAtaqueEspecial();
        /**
         * Posible descuento realizado por la diferencia de poder.
         * En el caso de que no haya sera 0.
         */
        double descuentoDifPoder = 0;
        
        if (pj1.kiSuficiente(kiAtaqueEspecial) == false){
            throw new ErrorNoHayKi("No hay Ki sufieciente.");
        }
        
        if (pj1.puedeRealizarAtaqueEspecial() == false){
            throw new ErrorNoSePuedeRealizarAtaqueEspecial("El personaje no cumple con los requisitos necesarios.");
        }
        
        if (pj1.tieneConsumible()){
            Consumible consumiblePj1 = pj1.getConsumible();
            
            switch (consumiblePj1.getAtributo()){
                case "Ataque": aumentoConsumible = (poderPeleaPj1 + aumentoPasiva + aumentoAtaqueEspecial) * (consumiblePj1.getCantidadAtributo());
            }
            
            try{
                consumiblePj1.decrementarUso();
            }
            catch (ErrorNoHayUsosRestantes e1){
                pj1.eliminarConsumible();
            }
            catch (ErrorConsumibleInstantaneo e2){
                throw new ErrorConsumibleInstantaneo("El personaje posee un consumible instaneo.");
            }
        }
        
        //Caso en el cual se aplica un descuento al daño.
        if (poderPeleaPj2 > poderPeleaPj1){
            descuentoDifPoder = ((poderPeleaPj1 + aumentoConsumible + aumentoPasiva + aumentoAtaqueEspecial) * 20.0) / 100.0;
        }
        
        dmg = poderPeleaPj1 + aumentoConsumible + aumentoPasiva + aumentoAtaqueEspecial - descuentoDifPoder;
        
        pj1.consecuenciasAtaqueEspecial();
        
        return actualizarPersonajes(pj1, pj2, 0, dmg, kiAtaqueEspecial);
    }
}
