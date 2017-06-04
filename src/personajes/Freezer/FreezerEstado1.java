package personajes.Freezer;

import personajes.ConstantesPersonajes;
import personajes.EstadoPersonaje;

public class FreezerEstado1 extends EstadoPersonaje {
   public FreezerEstado1() {
       this.poderDePelea = ConstantesPersonajes.FREEZER_ESTADO_1_PODER_DE_PELEA;
       this.distanciaAtaque = ConstantesPersonajes.FREEZER_ESTADO_1_DISTANCIA_DE_ATAQUE;
       this.velocidad = ConstantesPersonajes.FREEZER_ESTADO_1_VELOCIDAD;
   }
}