package lsss.appNutri.gui;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.LocalTime;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Dialog;
import lsss.appNutri.negocios.Comida;
import lsss.appNutri.negocios.Refeicao;

/**
 * Um Dialog pr�-configurado, s� precisa instanciar e chamar showAndWait. O
 * resultado � do tipo Refeicao.
 */
public class AddEditRefeicaoDialog extends Dialog<Refeicao> {
	
	@FXML private DatePicker datePicker;
	
	// Construtor
	public AddEditRefeicaoDialog() {
		// Carrega o FXML, cuja raiz � um DialogPane.
		// Obs.: O controller do FXML � a classe atual.
		try {
			var loader = new FXMLLoader(getClass().getResource("AddEditRefeicao.fxml"));
			loader.setController(this);
			this.setDialogPane(loader.load());
		}
		catch (IOException e) { e.printStackTrace(); }
		
		// Seta o resultConverter (� chamado pelo JavaFX quando o Dialog � fechado)
		this.setResultConverter(buttonType -> {
			if (buttonType.getButtonData() != ButtonData.OK_DONE)
				return null;

			// O JavaFX n�o tem DateTimePicker, s� DatePicker.
			// Ent�o por enquanto a hora utilizada � a hora atual.
			return new Refeicao(
					new Comida[] {},
					LocalDateTime.of(datePicker.getValue(), LocalTime.now()));
		});
	}
}
