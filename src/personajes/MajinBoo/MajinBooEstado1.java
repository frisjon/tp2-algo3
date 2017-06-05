package personajes.MajinBoo;

import personajes.ConstantesPersonajes;
import personajes.EstadoPersonaje;

public class MajinBooEstado1 extends EstadoPersonaje {
   public MajinBooEstado1() {
       this.poderDePelea = ConstantesPersonajes.MAJINBOO_ESTADO_1_PODER_DE_PELEA;
       this.distanciaAtaque = ConstantesPersonajes.MAJINBOO_ESTADO_1_DISTANCIA_DE_ATAQUE;
       this.velocidad = ConstantesPersonajes.MAJINBOO_ESTADO_1_VELOCIDAD;
       this.idEstado = ConstantesPersonajes.MAJINBOO_ESTADO_1_ID;
   }
}