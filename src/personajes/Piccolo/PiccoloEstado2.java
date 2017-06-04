package personajes.Piccolo;

import personajes.ConstantesPersonajes;
import personajes.EstadoPersonaje;

public class PiccoloEstado2 extends EstadoPersonaje {
   public PiccoloEstado2() {
       this.poderDePelea = ConstantesPersonajes.PICCOLO_ESTADO_2_PODER_DE_PELEA;
       this.distanciaAtaque = ConstantesPersonajes.PICCOLO_ESTADO_2_DISTANCIA_DE_ATAQUE;
       this.velocidad = ConstantesPersonajes.PICCOLO_ESTADO_2_VELOCIDAD;
   }
}