package personajes.Gohan;

import personajes.ConstantesPersonajes;
import personajes.EstadoPersonaje;

public class GohanEstado3 extends EstadoPersonaje {
   public GohanEstado3() {
       this.poderDePelea = ConstantesPersonajes.GOHAN_ESTADO_3_PODER_DE_PELEA;
       this.distanciaAtaque = ConstantesPersonajes.GOHAN_ESTADO_3_DISTANCIA_DE_ATAQUE;
       this.velocidad = ConstantesPersonajes.GOHAN_ESTADO_3_VELOCIDAD;
   }
}