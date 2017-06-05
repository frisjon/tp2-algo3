package personajes.Goku;

import personajes.ConstantesPersonajes;
import personajes.EstadoPersonaje;

public class GokuEstado3 extends EstadoPersonaje {
   public GokuEstado3() {
       this.poderDePelea = ConstantesPersonajes.GOKU_ESTADO_3_PODER_DE_PELEA;
       this.distanciaAtaque = ConstantesPersonajes.GOKU_ESTADO_3_DISTANCIA_DE_ATAQUE;
       this.velocidad = ConstantesPersonajes.GOKU_ESTADO_3_VELOCIDAD;
       this.idEstado = ConstantesPersonajes.GOKU_ESTADO_3_ID;
   }
}