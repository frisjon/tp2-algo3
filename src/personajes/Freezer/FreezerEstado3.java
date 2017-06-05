package personajes.Freezer;

import personajes.ConstantesPersonajes;
import personajes.EstadoPersonaje;

public class FreezerEstado3 extends EstadoPersonaje {
   public FreezerEstado3() {
       this.poderDePelea = ConstantesPersonajes.FREEZER_ESTADO_3_PODER_DE_PELEA;
       this.distanciaAtaque = ConstantesPersonajes.FREEZER_ESTADO_3_DISTANCIA_DE_ATAQUE;
       this.velocidad = ConstantesPersonajes.FREEZER_ESTADO_3_VELOCIDAD;
       this.idEstado = ConstantesPersonajes.FREEZER_ESTADO_3_ID;
   }
}