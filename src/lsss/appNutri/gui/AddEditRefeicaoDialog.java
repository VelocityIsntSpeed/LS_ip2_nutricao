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

public class AddEditRefeicaoDialog extends Dialog<Refeicao> {
	
	// Controller do FXML do DialogPane
	public final class Controller {
		@FXML private DatePicker datePicker;

		public DatePicker getDatePicker() {
			return datePicker;
		}
	}
	
	// Refer�ncia ao controller
	private Controller controller = new Controller();
	
	// Construtor
	public AddEditRefeicaoDialog() {
		// Carrega o DialogPane que est� no FXML
		try {
			var loader = new FXMLLoader(getClass().getResource("AddEditRefeicao.fxml"));
			loader.setController(controller);
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
					LocalDateTime.of(controller.datePicker.getValue(), LocalTime.now()));
		});
	}
}
