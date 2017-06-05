package personajes.Cell;

import personajes.ConstantesPersonajes;
import personajes.EstadoPersonaje;

public class CellEstado2 extends EstadoPersonaje {
   public CellEstado2() {
       this.poderDePelea = ConstantesPersonajes.CELL_ESTADO_2_PODER_DE_PELEA;
       this.distanciaAtaque = ConstantesPersonajes.CELL_ESTADO_2_DISTANCIA_DE_ATAQUE;
       this.velocidad = ConstantesPersonajes.CELL_ESTADO_2_VELOCIDAD;
       this.idEstado = ConstantesPersonajes.CELL_ESTADO_2_ID;
   }
}