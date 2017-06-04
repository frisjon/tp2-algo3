package personajes.Freezer;

import personajes.ConstantesPersonajes;
import personajes.EstadoPersonaje;

public class FreezerEstado2 extends EstadoPersonaje {
   public FreezerEstado2() {
       this.poderDePelea = ConstantesPersonajes.FREEZER_ESTADO_2_PODER_DE_PELEA;
       this.distanciaAtaque = ConstantesPersonajes.FREEZER_ESTADO_2_DISTANCIA_DE_ATAQUE;
       this.velocidad = ConstantesPersonajes.FREEZER_ESTADO_2_VELOCIDAD;
   }
}