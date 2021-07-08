package lsss.appNutri.gui;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.LocalTime;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Dialog;
import lsss.appNutri.negocios.Comida;
import lsss.appNutri.negocios.Refeicao;

/**
 * Um Dialog pré-configurado, só precisa instanciar e chamar showAndWait. O
 * resultado é uma Refeicao válida.
 */
public class DialogAddEditRefeicao extends Dialog<Refeicao> {
	
	@FXML private DatePicker datePicker;
	
	// Construtor
	public DialogAddEditRefeicao() {
		// Carrega o FXML, cuja raiz é um DialogPane.
		// Obs.: O controller do FXML é a instância atual.
		try {
			var loader = new FXMLLoader(getClass().getResource("AddEditRefeicao.fxml"));
			loader.setController(this);
			this.setDialogPane(loader.load());
		}
		catch (IOException e) { e.printStackTrace(); }
		
		// Seta o resultConverter (é chamado pelo JavaFX quando o Dialog é fechado)
		this.setResultConverter(this::resultConverter);
	}
	
	private Refeicao resultConverter(ButtonType buttonType) {
		if (buttonType.getButtonData() != ButtonData.OK_DONE)
			return null;

		// O JavaFX não tem DateTimePicker, só DatePicker.
		// TODO: Então por enquanto a hora utilizada é a hora atual.
		return new Refeicao(new Comida[] {}, LocalDateTime.of(datePicker.getValue(),
				                                              LocalTime.now()));
	}
}
