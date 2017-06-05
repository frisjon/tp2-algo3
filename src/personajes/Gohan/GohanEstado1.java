package personajes.Gohan;

import personajes.ConstantesPersonajes;
import personajes.EstadoPersonaje;

public class GohanEstado1 extends EstadoPersonaje {
   public GohanEstado1() {
       this.poderDePelea = ConstantesPersonajes.GOHAN_ESTADO_1_PODER_DE_PELEA;
       this.distanciaAtaque = ConstantesPersonajes.GOHAN_ESTADO_1_DISTANCIA_DE_ATAQUE;
       this.velocidad = ConstantesPersonajes.GOHAN_ESTADO_1_VELOCIDAD;
       this.idEstado = ConstantesPersonajes.GOHAN_ESTADO_1_ID;
   }
}