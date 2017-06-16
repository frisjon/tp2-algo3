package vista;


import javafx.scene.control.Slider;

public class BarraDeVolumen extends Slider{

    public BarraDeVolumen() {
        this.setValue(1);
        this.setMin(0);
        this.setMax(1);
        this.setMaxWidth(225);
        this.setStyle("-fx-base: #394867");
    }


}
