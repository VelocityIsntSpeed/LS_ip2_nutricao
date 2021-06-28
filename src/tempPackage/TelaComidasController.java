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
	
	// TODO Quire #23 #24
	@FXML private void btnAddComida(ActionEvent event) {
		
		InfoNutricional infoNut = new InfoNutricional(Double.parseDouble(txtFieldValEnergetico.getText()),
				                                      Double.parseDouble(txtFieldProteina.getText()),
				                                      Double.parseDouble(txtFieldCarboidratos.getText()));
		Comida comida = new Comida(txtFieldNome.getText(), infoNut);
		
		instanciaDoApp.repoComidas.add(comida);
		
		// Limpa os campos
		txtFieldNome.clear();
		txtFieldValEnergetico.clear();
		txtFieldProteina.clear();
		txtFieldCarboidratos.clear();
	}
}
