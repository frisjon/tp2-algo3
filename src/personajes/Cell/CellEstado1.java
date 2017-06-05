package personajes.Cell;

import personajes.ConstantesPersonajes;
import personajes.EstadoPersonaje;

public class CellEstado1 extends EstadoPersonaje {
   public CellEstado1() {
       this.poderDePelea = ConstantesPersonajes.CELL_ESTADO_1_PODER_DE_PELEA;
       this.distanciaAtaque = ConstantesPersonajes.CELL_ESTADO_1_DISTANCIA_DE_ATAQUE;
       this.velocidad = ConstantesPersonajes.CELL_ESTADO_1_VELOCIDAD;
       this.idEstado = ConstantesPersonajes.CELL_ESTADO_1_ID;
   }
}