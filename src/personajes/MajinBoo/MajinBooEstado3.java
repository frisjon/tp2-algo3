package personajes.MajinBoo;

import personajes.ConstantesPersonajes;
import personajes.EstadoPersonaje;

public class MajinBooEstado3 extends EstadoPersonaje {
   public MajinBooEstado3() {
       this.poderDePelea = ConstantesPersonajes.MAJINBOO_ESTADO_3_PODER_DE_PELEA;
       this.distanciaAtaque = ConstantesPersonajes.MAJINBOO_ESTADO_3_DISTANCIA_DE_ATAQUE;
       this.velocidad = ConstantesPersonajes.MAJINBOO_ESTADO_3_VELOCIDAD;
   }
}