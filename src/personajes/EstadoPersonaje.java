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
        this.setPoderDePelea(ConstantesPersonajes.GOKU_ESTADO_1_PODER_DE_PELEA);
        this.setDistanciaAtaque(ConstantesPersonajes.GOKU_ESTADO_1_DISTANCIA_DE_ATAQUE);
        this.setVelocidad(ConstantesPersonajes.GOKU_ESTADO_1_VELOCIDAD);
        this.setIdEstado(ConstantesPersonajes.GOKU_ESTADO_1_ID);
    }

    public void cambiarAGokuEstado2() {
        this.setPoderDePelea(ConstantesPersonajes.GOKU_ESTADO_2_PODER_DE_PELEA);
        this.setDistanciaAtaque(ConstantesPersonajes.GOKU_ESTADO_2_DISTANCIA_DE_ATAQUE);
        this.setVelocidad(ConstantesPersonajes.GOKU_ESTADO_2_VELOCIDAD);
        this.setIdEstado(ConstantesPersonajes.GOKU_ESTADO_2_ID);
    }

    public void cambiarAGokuEstado3() {
        this.setPoderDePelea(ConstantesPersonajes.GOKU_ESTADO_3_PODER_DE_PELEA);
        this.setDistanciaAtaque(ConstantesPersonajes.GOKU_ESTADO_3_DISTANCIA_DE_ATAQUE);
        this.setVelocidad(ConstantesPersonajes.GOKU_ESTADO_3_VELOCIDAD);
        this.setIdEstado(ConstantesPersonajes.GOKU_ESTADO_3_ID);
    }


    public void cambiarAGohanEstado1() {
        this.setPoderDePelea(ConstantesPersonajes.GOHAN_ESTADO_1_PODER_DE_PELEA);
        this.setDistanciaAtaque(ConstantesPersonajes.GOHAN_ESTADO_1_DISTANCIA_DE_ATAQUE);
        this.setVelocidad(ConstantesPersonajes.GOHAN_ESTADO_1_VELOCIDAD);
        this.setIdEstado(ConstantesPersonajes.GOHAN_ESTADO_1_ID);
    }

    public void cambiarAGohanEstado2() {
        this.setPoderDePelea(ConstantesPersonajes.GOHAN_ESTADO_2_PODER_DE_PELEA);
        this.setDistanciaAtaque(ConstantesPersonajes.GOHAN_ESTADO_2_DISTANCIA_DE_ATAQUE);
        this.setVelocidad(ConstantesPersonajes.GOHAN_ESTADO_2_VELOCIDAD);
        this.setIdEstado(ConstantesPersonajes.GOHAN_ESTADO_2_ID);
    }

    public void cambiarAGohanEstado3() {
        this.setPoderDePelea(ConstantesPersonajes.GOHAN_ESTADO_3_PODER_DE_PELEA);
        this.setDistanciaAtaque(ConstantesPersonajes.GOHAN_ESTADO_3_DISTANCIA_DE_ATAQUE);
        this.setVelocidad(ConstantesPersonajes.GOHAN_ESTADO_3_VELOCIDAD);
        this.setIdEstado(ConstantesPersonajes.GOHAN_ESTADO_3_ID);
    }


    public void cambiarAPiccoloEstado1() {
        this.setPoderDePelea(ConstantesPersonajes.PICCOLO_ESTADO_1_PODER_DE_PELEA);
        this.setDistanciaAtaque(ConstantesPersonajes.PICCOLO_ESTADO_1_DISTANCIA_DE_ATAQUE);
        this.setVelocidad(ConstantesPersonajes.PICCOLO_ESTADO_1_VELOCIDAD);
        this.setIdEstado(ConstantesPersonajes.PICCOLO_ESTADO_1_ID);
    }

    public void cambiarAPiccoloEstado2() {
        this.setPoderDePelea(ConstantesPersonajes.PICCOLO_ESTADO_2_PODER_DE_PELEA);
        this.setDistanciaAtaque(ConstantesPersonajes.PICCOLO_ESTADO_2_DISTANCIA_DE_ATAQUE);
        this.setVelocidad(ConstantesPersonajes.PICCOLO_ESTADO_2_VELOCIDAD);
        this.setIdEstado(ConstantesPersonajes.PICCOLO_ESTADO_2_ID);
    }

    public void cambiarAPiccoloEstado3() {
        this.setPoderDePelea(ConstantesPersonajes.PICCOLO_ESTADO_3_PODER_DE_PELEA);
        this.setDistanciaAtaque(ConstantesPersonajes.PICCOLO_ESTADO_3_DISTANCIA_DE_ATAQUE);
        this.setVelocidad(ConstantesPersonajes.PICCOLO_ESTADO_3_VELOCIDAD);
        this.setIdEstado(ConstantesPersonajes.PICCOLO_ESTADO_3_ID);
    }


    public void cambiarACellEstado1() {
        this.setPoderDePelea(ConstantesPersonajes.CELL_ESTADO_1_PODER_DE_PELEA);
        this.setDistanciaAtaque(ConstantesPersonajes.CELL_ESTADO_1_DISTANCIA_DE_ATAQUE);
        this.setVelocidad(ConstantesPersonajes.CELL_ESTADO_1_VELOCIDAD);
        this.setIdEstado(ConstantesPersonajes.CELL_ESTADO_1_ID);
    }

    public void cambiarACellEstado2() {
        this.setPoderDePelea(ConstantesPersonajes.CELL_ESTADO_2_PODER_DE_PELEA);
        this.setDistanciaAtaque(ConstantesPersonajes.CELL_ESTADO_2_DISTANCIA_DE_ATAQUE);
        this.setVelocidad(ConstantesPersonajes.CELL_ESTADO_2_VELOCIDAD);
        this.setIdEstado(ConstantesPersonajes.CELL_ESTADO_2_ID);
    }

    public void cambiarACellEstado3() {
        this.setPoderDePelea(ConstantesPersonajes.CELL_ESTADO_3_PODER_DE_PELEA);
        this.setDistanciaAtaque(ConstantesPersonajes.CELL_ESTADO_3_DISTANCIA_DE_ATAQUE);
        this.setVelocidad(ConstantesPersonajes.CELL_ESTADO_3_VELOCIDAD);
        this.setIdEstado(ConstantesPersonajes.CELL_ESTADO_3_ID);
    }


    public void cambiarAFreezerEstado1() {
        this.setPoderDePelea(ConstantesPersonajes.FREEZER_ESTADO_1_PODER_DE_PELEA);
        this.setDistanciaAtaque(ConstantesPersonajes.FREEZER_ESTADO_1_DISTANCIA_DE_ATAQUE);
        this.setVelocidad(ConstantesPersonajes.FREEZER_ESTADO_1_VELOCIDAD);
        this.setIdEstado(ConstantesPersonajes.FREEZER_ESTADO_1_ID);
    }

    public void cambiarAFreezerEstado2() {
        this.setPoderDePelea(ConstantesPersonajes.FREEZER_ESTADO_2_PODER_DE_PELEA);
        this.setDistanciaAtaque(ConstantesPersonajes.FREEZER_ESTADO_2_DISTANCIA_DE_ATAQUE);
        this.setVelocidad(ConstantesPersonajes.FREEZER_ESTADO_2_VELOCIDAD);
        this.setIdEstado(ConstantesPersonajes.FREEZER_ESTADO_2_ID);
    }

    public void cambiarAFreezerEstado3() {
        this.setPoderDePelea(ConstantesPersonajes.FREEZER_ESTADO_3_PODER_DE_PELEA);
        this.setDistanciaAtaque(ConstantesPersonajes.FREEZER_ESTADO_3_DISTANCIA_DE_ATAQUE);
        this.setVelocidad(ConstantesPersonajes.FREEZER_ESTADO_3_VELOCIDAD);
        this.setIdEstado(ConstantesPersonajes.FREEZER_ESTADO_3_ID);
    }


    public void cambiarAMajinBooEstado1() {
        this.setPoderDePelea(ConstantesPersonajes.MAJINBOO_ESTADO_1_PODER_DE_PELEA);
        this.setDistanciaAtaque(ConstantesPersonajes.MAJINBOO_ESTADO_1_DISTANCIA_DE_ATAQUE);
        this.setVelocidad(ConstantesPersonajes.MAJINBOO_ESTADO_1_VELOCIDAD);
        this.setIdEstado(ConstantesPersonajes.MAJINBOO_ESTADO_1_ID);
    }

    public void cambiarAMajinBooEstado2() {
        this.setPoderDePelea(ConstantesPersonajes.MAJINBOO_ESTADO_2_PODER_DE_PELEA);
        this.setDistanciaAtaque(ConstantesPersonajes.MAJINBOO_ESTADO_2_DISTANCIA_DE_ATAQUE);
        this.setVelocidad(ConstantesPersonajes.MAJINBOO_ESTADO_2_VELOCIDAD);
        this.setIdEstado(ConstantesPersonajes.MAJINBOO_ESTADO_2_ID);
    }

    public void cambiarAMajinBooEstado3() {
        this.setPoderDePelea(ConstantesPersonajes.MAJINBOO_ESTADO_3_PODER_DE_PELEA);
        this.setDistanciaAtaque(ConstantesPersonajes.MAJINBOO_ESTADO_3_DISTANCIA_DE_ATAQUE);
        this.setVelocidad(ConstantesPersonajes.MAJINBOO_ESTADO_3_VELOCIDAD);
        this.setIdEstado(ConstantesPersonajes.MAJINBOO_ESTADO_3_ID);
    }

    public double getAumentoPasiva() {
        return 9001;
    }



}
