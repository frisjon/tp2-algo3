package personajes.MajinBoo;

import personajes.ConstantesPersonajes;
import personajes.EstadoPersonaje;

public class MajinBooEstado2 extends EstadoPersonaje {
   public MajinBooEstado2() {
       this.poderDePelea = ConstantesPersonajes.MAJINBOO_ESTADO_2_PODER_DE_PELEA;
       this.distanciaAtaque = ConstantesPersonajes.MAJINBOO_ESTADO_2_DISTANCIA_DE_ATAQUE;
       this.velocidad = ConstantesPersonajes.MAJINBOO_ESTADO_2_VELOCIDAD;
   }
}