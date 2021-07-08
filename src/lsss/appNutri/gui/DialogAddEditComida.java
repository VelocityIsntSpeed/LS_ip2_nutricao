package lsss.appNutri.gui;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.TextField;
import lsss.appNutri.negocios.Comida;
import lsss.appNutri.negocios.InfoNutricional;

public class DialogAddEditComida extends Dialog<Comida> {
	
	@FXML private TextField txtFieldNome;
	@FXML private TextField txtFieldValEnergetico;
	@FXML private TextField txtFieldProteina;
	@FXML private TextField txtFieldCarboidratos;

	// Construtor
	public DialogAddEditComida() {
		// Carrega o FXML, cuja raiz é um DialogPane.
		// Obs.: O controller do FXML é a instância atual.
		try {
			var loader = new FXMLLoader(getClass().getResource("AddEditComida.fxml"));
			loader.setController(this);
			this.setDialogPane(loader.load());
		}
		catch (IOException e) { e.printStackTrace(); }
		
		// Seta o resultConverter (é chamado pelo JavaFX quando o Dialog é fechado)
		this.setResultConverter(this::resultConverter);
	}
	

	private Comida resultConverter(ButtonType buttonType) {
		if (buttonType.getButtonData() != ButtonData.OK_DONE)
			return null;
		
		var infoNut = new InfoNutricional(
			Double.parseDouble(txtFieldValEnergetico.getText()),
			Double.parseDouble(txtFieldProteina.getText()),
			Double.parseDouble(txtFieldCarboidratos.getText())
		);

		return new Comida(txtFieldNome.getText(), infoNut);
	}
}
