package tempPackage;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class TelaComidasController {
	
	/** Referência à instância de Application. */
	private Test instanciaDoApp;
	
	public void setInstanciaDoApp(Test instanciaDoApp) {
		this.instanciaDoApp = instanciaDoApp;
	}

	@FXML private TextField txtFieldNome;
	@FXML private TextField txtFieldValEnergetico;
	@FXML private TextField txtFieldProteina;
	@FXML private TextField txtFieldCarboidratos;
	
	@FXML private void btnAddComida(ActionEvent event) {
		System.out.println("Botão de adicionar comida foi clicado.");
	}
}
