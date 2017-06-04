package personajes.Goku;

import personajes.ConstantesPersonajes;
import personajes.EstadoPersonaje;

public class GokuEstado2 extends EstadoPersonaje {
   public GokuEstado2() {
       this.poderDePelea = ConstantesPersonajes.GOKU_ESTADO_2_PODER_DE_PELEA;
       this.distanciaAtaque = ConstantesPersonajes.GOKU_ESTADO_2_DISTANCIA_DE_ATAQUE;
       this.velocidad = ConstantesPersonajes.GOKU_ESTADO_2_VELOCIDAD;
   }
}