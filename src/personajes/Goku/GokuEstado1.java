package personajes.Goku;

import personajes.ConstantesPersonajes;
import personajes.EstadoPersonaje;

public class GokuEstado1 extends EstadoPersonaje {
   public GokuEstado1() {
       this.poderDePelea = ConstantesPersonajes.GOKU_ESTADO_1_PODER_DE_PELEA;
       this.distanciaAtaque = ConstantesPersonajes.GOKU_ESTADO_1_DISTANCIA_DE_ATAQUE;
       this.velocidad = ConstantesPersonajes.GOKU_ESTADO_1_VELOCIDAD;
       this.idEstado = ConstantesPersonajes.GOKU_ESTADO_1_ID;
   }
}