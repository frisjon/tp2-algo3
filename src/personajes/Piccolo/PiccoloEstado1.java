package personajes.Piccolo;

import personajes.ConstantesPersonajes;
import personajes.EstadoPersonaje;

public class PiccoloEstado1 extends EstadoPersonaje {
   public PiccoloEstado1() {
       this.poderDePelea = ConstantesPersonajes.PICCOLO_ESTADO_1_PODER_DE_PELEA;
       this.distanciaAtaque = ConstantesPersonajes.PICCOLO_ESTADO_1_DISTANCIA_DE_ATAQUE;
       this.velocidad = ConstantesPersonajes.PICCOLO_ESTADO_1_VELOCIDAD;
       this.idEstado = ConstantesPersonajes.PICCOLO_ESTADO_1_ID;
   }
}