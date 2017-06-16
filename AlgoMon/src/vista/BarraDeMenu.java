package vista;

import controlador.handlers.BotonModoPantallaCompletaHandler;
import controlador.handlers.BotonReglasEventHandler;
import controlador.handlers.BotonSalirEventHandler;
import javafx.beans.binding.When;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;

public class BarraDeMenu extends MenuBar {

	public BarraDeMenu(Stage primaryStage) {
		
		super();
		Menu menuArchivo = new Menu("Archivo");
		Menu menuEdicion = new Menu("Ver");
		Menu menuAyuda = new Menu("Ayuda");

		//opciones de "Archivo"
		MenuItem opcionSalir = new MenuItem("Salir");
		BotonSalirEventHandler opcionSalirHandler = new BotonSalirEventHandler();
		opcionSalir.setOnAction(opcionSalirHandler);
		menuArchivo.getItems().addAll(opcionSalir);

		//opciones de "Ver"
		MenuItem modoPantallaCompleta = new MenuItem();
		modoPantallaCompleta.textProperty().bind(
				new When(primaryStage.fullScreenProperty())
						.then("Salir de pantalla completa")
						.otherwise("Pantalla completa"));

		BotonModoPantallaCompletaHandler modoPantallaCompletaHandler= new
				BotonModoPantallaCompletaHandler(primaryStage);
		modoPantallaCompleta.setOnAction(modoPantallaCompletaHandler);

//		ésta es una idea a futuro
//		MenuItem musicaDeFondo = new MenuItem("Musica de fondo");
//		BotonMusicaDeFondoEventHandler musicaDeFondoHandler = new BotonMusicaDeFondoEventHandler(audioclip);
//		musicaDeFondo.setOnAction(musicaDeFondoHandler);
		
		menuEdicion.getItems().addAll(modoPantallaCompleta);
		
		//opciones de "Ayuda"
		MenuItem reglasDelJuego = new MenuItem("Reglas del juego");
		BotonReglasEventHandler reglasDelJuegoHandler = new BotonReglasEventHandler();
		reglasDelJuego.setOnAction(reglasDelJuegoHandler);
		
		MenuItem acercaDe = new MenuItem("Acerca de...");
		menuAyuda.getItems().addAll(reglasDelJuego, acercaDe);
		
		this.getMenus().addAll(menuArchivo, menuEdicion, menuAyuda);
        this.prefWidthProperty().bind(primaryStage.minWidthProperty());
	}
	
}
