package personajes.Cell;

import personajes.ConstantesPersonajes;
import personajes.EstadoPersonaje;

public class CellEstado3 extends EstadoPersonaje {
   public CellEstado3() {
       this.poderDePelea = ConstantesPersonajes.CELL_ESTADO_3_PODER_DE_PELEA;
       this.distanciaAtaque = ConstantesPersonajes.CELL_ESTADO_3_DISTANCIA_DE_ATAQUE;
       this.velocidad = ConstantesPersonajes.CELL_ESTADO_3_VELOCIDAD;
       this.idEstado = ConstantesPersonajes.CELL_ESTADO_3_ID;
   }
}