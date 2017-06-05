package personajes.Piccolo;

import personajes.ConstantesPersonajes;
import personajes.EstadoPersonaje;

public class PiccoloEstado3 extends EstadoPersonaje {
   public PiccoloEstado3() {
       this.poderDePelea = ConstantesPersonajes.PICCOLO_ESTADO_3_PODER_DE_PELEA;
       this.distanciaAtaque = ConstantesPersonajes.PICCOLO_ESTADO_3_DISTANCIA_DE_ATAQUE;
       this.velocidad = ConstantesPersonajes.PICCOLO_ESTADO_3_VELOCIDAD;
       this.idEstado = ConstantesPersonajes.PICCOLO_ESTADO_3_ID;
   }
}