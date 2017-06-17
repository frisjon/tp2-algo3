package vista;

import controlador.handlers.BotonHandler;
import javafx.scene.control.MenuButton;

public class BotonMenu extends MenuButton {
    
    public BotonMenu(BotonHandler handler) {
        super();
        
        this.setOnAction(handler);
        this.setMaxWidth(175);
    }

}
