package personajes;

import personajes.ConstantesGoku;
import personajes.ConstantesGohan;
import personajes.ConstantesPiccolo;
import personajes.ConstantesCel;
import personajes.ConstantesFreezer;
import personajes.ConstantesMajinBoo;


public class EstadoPersonaje {

    private double poderDePelea;
    private double distanciaAtaque;
    private double velocidad;
    private int idEstado;
    
    
    public double getPoderDePelea() {
        return this.poderDePelea;
    }
    
    public double getDistanciaAtaque() {
        return this.distanciaAtaque;
    }
    
    public double getVelocidad() {
        return this.velocidad;
    }
    
    public int getIdEstado() {
        return this.idEstado;
    }
    
    private void setPoderDePelea(double _poderDePelea) {
        this.poderDePelea = _poderDePelea;
    }
    
    private void setDistanciaAtaque(double _distanciaAtaque) {
        this.distanciaAtaque = _distanciaAtaque;
    }
    
    private void setVelocidad(double _velocidad) {
        this.velocidad = _velocidad;
    }
    
    private void setIdEstado(int _idEstado) {
        this.idEstado = _idEstado;
    }

    public void cambiarAGokuEstado1() {
        this.setPoderDePelea(ConstantesGoku.GOKU_ESTADO_1_PODER_DE_PELEA);
        this.setDistanciaAtaque(ConstantesGoku.GOKU_ESTADO_1_DISTANCIA_DE_ATAQUE);
        this.setVelocidad(ConstantesGoku.GOKU_ESTADO_1_VELOCIDAD);
        this.setIdEstado(ConstantesGoku.GOKU_ESTADO_1_ID);
    }

    public void cambiarAGokuEstado2() {
        this.setPoderDePelea(ConstantesGoku.GOKU_ESTADO_2_PODER_DE_PELEA);
        this.setDistanciaAtaque(ConstantesGoku.GOKU_ESTADO_2_DISTANCIA_DE_ATAQUE);
        this.setVelocidad(ConstantesGoku.GOKU_ESTADO_2_VELOCIDAD);
        this.setIdEstado(ConstantesGoku.GOKU_ESTADO_2_ID);
    }

    public void cambiarAGokuEstado3() {
        this.setPoderDePelea(ConstantesGoku.GOKU_ESTADO_3_PODER_DE_PELEA);
        this.setDistanciaAtaque(ConstantesGoku.GOKU_ESTADO_3_DISTANCIA_DE_ATAQUE);
        this.setVelocidad(ConstantesGoku.GOKU_ESTADO_3_VELOCIDAD);
        this.setIdEstado(ConstantesGoku.GOKU_ESTADO_3_ID);
    }


    public void cambiarAGohanEstado1() {
        this.setPoderDePelea(ConstantesGohan.GOHAN_ESTADO_1_PODER_DE_PELEA);
        this.setDistanciaAtaque(ConstantesGohan.GOHAN_ESTADO_1_DISTANCIA_DE_ATAQUE);
        this.setVelocidad(ConstantesGohan.GOHAN_ESTADO_1_VELOCIDAD);
        this.setIdEstado(ConstantesGohan.GOHAN_ESTADO_1_ID);
    }

    public void cambiarAGohanEstado2() {
        this.setPoderDePelea(ConstantesGohan.GOHAN_ESTADO_2_PODER_DE_PELEA);
        this.setDistanciaAtaque(ConstantesGohan.GOHAN_ESTADO_2_DISTANCIA_DE_ATAQUE);
        this.setVelocidad(ConstantesGohan.GOHAN_ESTADO_2_VELOCIDAD);
        this.setIdEstado(ConstantesGohan.GOHAN_ESTADO_2_ID);
    }

    public void cambiarAGohanEstado3() {
        this.setPoderDePelea(ConstantesGohan.GOHAN_ESTADO_3_PODER_DE_PELEA);
        this.setDistanciaAtaque(ConstantesGohan.GOHAN_ESTADO_3_DISTANCIA_DE_ATAQUE);
        this.setVelocidad(ConstantesGohan.GOHAN_ESTADO_3_VELOCIDAD);
        this.setIdEstado(ConstantesGohan.GOHAN_ESTADO_3_ID);
    }


    public void cambiarAPiccoloEstado1() {
        this.setPoderDePelea(ConstantesPiccolo.PICCOLO_ESTADO_1_PODER_DE_PELEA);
        this.setDistanciaAtaque(ConstantesPiccolo.PICCOLO_ESTADO_1_DISTANCIA_DE_ATAQUE);
        this.setVelocidad(ConstantesPiccolo.PICCOLO_ESTADO_1_VELOCIDAD);
        this.setIdEstado(ConstantesPiccolo.PICCOLO_ESTADO_1_ID);
    }

    public void cambiarAPiccoloEstado2() {
        this.setPoderDePelea(ConstantesPiccolo.PICCOLO_ESTADO_2_PODER_DE_PELEA);
        this.setDistanciaAtaque(ConstantesPiccolo.PICCOLO_ESTADO_2_DISTANCIA_DE_ATAQUE);
        this.setVelocidad(ConstantesPiccolo.PICCOLO_ESTADO_2_VELOCIDAD);
        this.setIdEstado(ConstantesPiccolo.PICCOLO_ESTADO_2_ID);
    }

    public void cambiarAPiccoloEstado3() {
        this.setPoderDePelea(ConstantesPiccolo.PICCOLO_ESTADO_3_PODER_DE_PELEA);
        this.setDistanciaAtaque(ConstantesPiccolo.PICCOLO_ESTADO_3_DISTANCIA_DE_ATAQUE);
        this.setVelocidad(ConstantesPiccolo.PICCOLO_ESTADO_3_VELOCIDAD);
        this.setIdEstado(ConstantesPiccolo.PICCOLO_ESTADO_3_ID);
    }


    public void cambiarACelEstado1() {
        this.setPoderDePelea(ConstantesCel.CEL_ESTADO_1_PODER_DE_PELEA);
        this.setDistanciaAtaque(ConstantesCel.CEL_ESTADO_1_DISTANCIA_DE_ATAQUE);
        this.setVelocidad(ConstantesCel.CEL_ESTADO_1_VELOCIDAD);
        this.setIdEstado(ConstantesCel.CEL_ESTADO_1_ID);
    }

    public void cambiarACelEstado2() {
        this.setPoderDePelea(ConstantesCel.CEL_ESTADO_2_PODER_DE_PELEA);
        this.setDistanciaAtaque(ConstantesCel.CEL_ESTADO_2_DISTANCIA_DE_ATAQUE);
        this.setVelocidad(ConstantesCel.CEL_ESTADO_2_VELOCIDAD);
        this.setIdEstado(ConstantesCel.CEL_ESTADO_2_ID);
    }

    public void cambiarACelEstado3() {
        this.setPoderDePelea(ConstantesCel.CEL_ESTADO_3_PODER_DE_PELEA);
        this.setDistanciaAtaque(ConstantesCel.CEL_ESTADO_3_DISTANCIA_DE_ATAQUE);
        this.setVelocidad(ConstantesCel.CEL_ESTADO_3_VELOCIDAD);
        this.setIdEstado(ConstantesCel.CEL_ESTADO_3_ID);
    }


    public void cambiarAFreezerEstado1() {
        this.setPoderDePelea(ConstantesFreezer.FREEZER_ESTADO_1_PODER_DE_PELEA);
        this.setDistanciaAtaque(ConstantesFreezer.FREEZER_ESTADO_1_DISTANCIA_DE_ATAQUE);
        this.setVelocidad(ConstantesFreezer.FREEZER_ESTADO_1_VELOCIDAD);
        this.setIdEstado(ConstantesFreezer.FREEZER_ESTADO_1_ID);
    }

    public void cambiarAFreezerEstado2() {
        this.setPoderDePelea(ConstantesFreezer.FREEZER_ESTADO_2_PODER_DE_PELEA);
        this.setDistanciaAtaque(ConstantesFreezer.FREEZER_ESTADO_2_DISTANCIA_DE_ATAQUE);
        this.setVelocidad(ConstantesFreezer.FREEZER_ESTADO_2_VELOCIDAD);
        this.setIdEstado(ConstantesFreezer.FREEZER_ESTADO_2_ID);
    }

    public void cambiarAFreezerEstado3() {
        this.setPoderDePelea(ConstantesFreezer.FREEZER_ESTADO_3_PODER_DE_PELEA);
        this.setDistanciaAtaque(ConstantesFreezer.FREEZER_ESTADO_3_DISTANCIA_DE_ATAQUE);
        this.setVelocidad(ConstantesFreezer.FREEZER_ESTADO_3_VELOCIDAD);
        this.setIdEstado(ConstantesFreezer.FREEZER_ESTADO_3_ID);
    }


    public void cambiarAMajinBooEstado1() {
        this.setPoderDePelea(ConstantesMajinBoo.MAJINBOO_ESTADO_1_PODER_DE_PELEA);
        this.setDistanciaAtaque(ConstantesMajinBoo.MAJINBOO_ESTADO_1_DISTANCIA_DE_ATAQUE);
        this.setVelocidad(ConstantesMajinBoo.MAJINBOO_ESTADO_1_VELOCIDAD);
        this.setIdEstado(ConstantesMajinBoo.MAJINBOO_ESTADO_1_ID);
    }

    public void cambiarAMajinBooEstado2() {
        this.setPoderDePelea(ConstantesMajinBoo.MAJINBOO_ESTADO_2_PODER_DE_PELEA);
        this.setDistanciaAtaque(ConstantesMajinBoo.MAJINBOO_ESTADO_2_DISTANCIA_DE_ATAQUE);
        this.setVelocidad(ConstantesMajinBoo.MAJINBOO_ESTADO_2_VELOCIDAD);
        this.setIdEstado(ConstantesMajinBoo.MAJINBOO_ESTADO_2_ID);
    }

    public void cambiarAMajinBooEstado3() {
        this.setPoderDePelea(ConstantesMajinBoo.MAJINBOO_ESTADO_3_PODER_DE_PELEA);
        this.setDistanciaAtaque(ConstantesMajinBoo.MAJINBOO_ESTADO_3_DISTANCIA_DE_ATAQUE);
        this.setVelocidad(ConstantesMajinBoo.MAJINBOO_ESTADO_3_VELOCIDAD);
        this.setIdEstado(ConstantesMajinBoo.MAJINBOO_ESTADO_3_ID);
    }



}
