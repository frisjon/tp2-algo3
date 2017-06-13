package personajes;

public class EstadoPersonaje {

    protected double poderPelea;
    protected double distanciaAtaque;
    protected double velocidad;
    protected int idEstado;
    
    
    public double getPoderPelea() {
        return this.poderPelea;
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
    
    public void setPoderDePelea(double _poderDePelea) {
        this.poderPelea = _poderDePelea;
    }
    
    public void setDistanciaAtaque(double _distanciaAtaque) {
        this.distanciaAtaque = _distanciaAtaque;
    }
    
    public void setVelocidad(double _velocidad) {
        this.velocidad = _velocidad;
    }
    
    public void setIdEstado(int _idEstado) {
        this.idEstado = _idEstado;
    }
    
    public void cambiarAGokuEstado1() {
        this.setPoderDePelea(Goku.GOKU_ESTADO_1_PODER_DE_PELEA);
        this.setDistanciaAtaque(Goku.GOKU_ESTADO_1_DISTANCIA_DE_ATAQUE);
        this.setVelocidad(Goku.GOKU_ESTADO_1_VELOCIDAD);
        this.setIdEstado(Goku.GOKU_ESTADO_1_ID);
    }

    public void cambiarAGokuEstado2() {
        this.setPoderDePelea(Goku.GOKU_ESTADO_2_PODER_DE_PELEA);
        this.setDistanciaAtaque(Goku.GOKU_ESTADO_2_DISTANCIA_DE_ATAQUE);
        this.setVelocidad(Goku.GOKU_ESTADO_2_VELOCIDAD);
        this.setIdEstado(Goku.GOKU_ESTADO_2_ID);
    }

    public void cambiarAGokuEstado3() {
        this.setPoderDePelea(Goku.GOKU_ESTADO_3_PODER_DE_PELEA);
        this.setDistanciaAtaque(Goku.GOKU_ESTADO_3_DISTANCIA_DE_ATAQUE);
        this.setVelocidad(Goku.GOKU_ESTADO_3_VELOCIDAD);
        this.setIdEstado(Goku.GOKU_ESTADO_3_ID);
    }


    public void cambiarAGohanEstado1() {
        this.setPoderDePelea(Gohan.GOHAN_ESTADO_1_PODER_DE_PELEA);
        this.setDistanciaAtaque(Gohan.GOHAN_ESTADO_1_DISTANCIA_DE_ATAQUE);
        this.setVelocidad(Gohan.GOHAN_ESTADO_1_VELOCIDAD);
        this.setIdEstado(Gohan.GOHAN_ESTADO_1_ID);
    }

    public void cambiarAGohanEstado2() {
        this.setPoderDePelea(Gohan.GOHAN_ESTADO_2_PODER_DE_PELEA);
        this.setDistanciaAtaque(Gohan.GOHAN_ESTADO_2_DISTANCIA_DE_ATAQUE);
        this.setVelocidad(Gohan.GOHAN_ESTADO_2_VELOCIDAD);
        this.setIdEstado(Gohan.GOHAN_ESTADO_2_ID);
    }

    public void cambiarAGohanEstado3() {
        this.setPoderDePelea(Gohan.GOHAN_ESTADO_3_PODER_DE_PELEA);
        this.setDistanciaAtaque(Gohan.GOHAN_ESTADO_3_DISTANCIA_DE_ATAQUE);
        this.setVelocidad(Gohan.GOHAN_ESTADO_3_VELOCIDAD);
        this.setIdEstado(Gohan.GOHAN_ESTADO_3_ID);
    }


    public void cambiarAPiccoloEstado1() {
        this.setPoderDePelea(Piccolo.PICCOLO_ESTADO_1_PODER_DE_PELEA);
        this.setDistanciaAtaque(Piccolo.PICCOLO_ESTADO_1_DISTANCIA_DE_ATAQUE);
        this.setVelocidad(Piccolo.PICCOLO_ESTADO_1_VELOCIDAD);
        this.setIdEstado(Piccolo.PICCOLO_ESTADO_1_ID);
    }

    public void cambiarAPiccoloEstado2() {
        this.setPoderDePelea(Piccolo.PICCOLO_ESTADO_2_PODER_DE_PELEA);
        this.setDistanciaAtaque(Piccolo.PICCOLO_ESTADO_2_DISTANCIA_DE_ATAQUE);
        this.setVelocidad(Piccolo.PICCOLO_ESTADO_2_VELOCIDAD);
        this.setIdEstado(Piccolo.PICCOLO_ESTADO_2_ID);
    }

    public void cambiarAPiccoloEstado3() {
        this.setPoderDePelea(Piccolo.PICCOLO_ESTADO_3_PODER_DE_PELEA);
        this.setDistanciaAtaque(Piccolo.PICCOLO_ESTADO_3_DISTANCIA_DE_ATAQUE);
        this.setVelocidad(Piccolo.PICCOLO_ESTADO_3_VELOCIDAD);
        this.setIdEstado(Piccolo.PICCOLO_ESTADO_3_ID);
    }


    public void cambiarACellEstado1() {
        this.setPoderDePelea(Cell.CELL_ESTADO_1_PODER_DE_PELEA);
        this.setDistanciaAtaque(Cell.CELL_ESTADO_1_DISTANCIA_DE_ATAQUE);
        this.setVelocidad(Cell.CELL_ESTADO_1_VELOCIDAD);
        this.setIdEstado(Cell.CELL_ESTADO_1_ID);
    }

    public void cambiarACellEstado2() {
        this.setPoderDePelea(Cell.CELL_ESTADO_2_PODER_DE_PELEA);
        this.setDistanciaAtaque(Cell.CELL_ESTADO_2_DISTANCIA_DE_ATAQUE);
        this.setVelocidad(Cell.CELL_ESTADO_2_VELOCIDAD);
        this.setIdEstado(Cell.CELL_ESTADO_2_ID);
    }

    public void cambiarACellEstado3() {
        this.setPoderDePelea(Cell.CELL_ESTADO_3_PODER_DE_PELEA);
        this.setDistanciaAtaque(Cell.CELL_ESTADO_3_DISTANCIA_DE_ATAQUE);
        this.setVelocidad(Cell.CELL_ESTADO_3_VELOCIDAD);
        this.setIdEstado(Cell.CELL_ESTADO_3_ID);
    }


    public void cambiarAFreezerEstado1() {
        this.setPoderDePelea(Freezer.FREEZER_ESTADO_1_PODER_DE_PELEA);
        this.setDistanciaAtaque(Freezer.FREEZER_ESTADO_1_DISTANCIA_DE_ATAQUE);
        this.setVelocidad(Freezer.FREEZER_ESTADO_1_VELOCIDAD);
        this.setIdEstado(Freezer.FREEZER_ESTADO_1_ID);
    }

    public void cambiarAFreezerEstado2() {
        this.setPoderDePelea(Freezer.FREEZER_ESTADO_2_PODER_DE_PELEA);
        this.setDistanciaAtaque(Freezer.FREEZER_ESTADO_2_DISTANCIA_DE_ATAQUE);
        this.setVelocidad(Freezer.FREEZER_ESTADO_2_VELOCIDAD);
        this.setIdEstado(Freezer.FREEZER_ESTADO_2_ID);
    }

    public void cambiarAFreezerEstado3() {
        this.setPoderDePelea(Freezer.FREEZER_ESTADO_3_PODER_DE_PELEA);
        this.setDistanciaAtaque(Freezer.FREEZER_ESTADO_3_DISTANCIA_DE_ATAQUE);
        this.setVelocidad(Freezer.FREEZER_ESTADO_3_VELOCIDAD);
        this.setIdEstado(Freezer.FREEZER_ESTADO_3_ID);
    }


    public void cambiarAMajinBooEstado1() {
        this.setPoderDePelea(MajinBoo.MAJINBOO_ESTADO_1_PODER_DE_PELEA);
        this.setDistanciaAtaque(MajinBoo.MAJINBOO_ESTADO_1_DISTANCIA_DE_ATAQUE);
        this.setVelocidad(MajinBoo.MAJINBOO_ESTADO_1_VELOCIDAD);
        this.setIdEstado(MajinBoo.MAJINBOO_ESTADO_1_ID);
    }

    public void cambiarAMajinBooEstado2() {
        this.setPoderDePelea(MajinBoo.MAJINBOO_ESTADO_2_PODER_DE_PELEA);
        this.setDistanciaAtaque(MajinBoo.MAJINBOO_ESTADO_2_DISTANCIA_DE_ATAQUE);
        this.setVelocidad(MajinBoo.MAJINBOO_ESTADO_2_VELOCIDAD);
        this.setIdEstado(MajinBoo.MAJINBOO_ESTADO_2_ID);
    }

    public void cambiarAMajinBooEstado3() {
        this.setPoderDePelea(MajinBoo.MAJINBOO_ESTADO_3_PODER_DE_PELEA);
        this.setDistanciaAtaque(MajinBoo.MAJINBOO_ESTADO_3_DISTANCIA_DE_ATAQUE);
        this.setVelocidad(MajinBoo.MAJINBOO_ESTADO_3_VELOCIDAD);
        this.setIdEstado(MajinBoo.MAJINBOO_ESTADO_3_ID);
    }

    public double getAumentoPasiva() {
        return 9001;
    }



}
