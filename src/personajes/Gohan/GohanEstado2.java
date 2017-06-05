package personajes.Gohan;

import personajes.ConstantesPersonajes;
import personajes.EstadoPersonaje;

public class GohanEstado2 extends EstadoPersonaje {
   public GohanEstado2() {
       this.poderDePelea = ConstantesPersonajes.GOHAN_ESTADO_2_PODER_DE_PELEA;
       this.distanciaAtaque = ConstantesPersonajes.GOHAN_ESTADO_2_DISTANCIA_DE_ATAQUE;
       this.velocidad = ConstantesPersonajes.GOHAN_ESTADO_2_VELOCIDAD;
       this.idEstado = ConstantesPersonajes.GOHAN_ESTADO_2_ID;
   }
}