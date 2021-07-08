package lsss.appNutri.gui;

import java.time.LocalDateTime;
import java.time.LocalTime;

import javafx.fxml.FXML;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DatePicker;
import lsss.appNutri.negocios.Comida;
import lsss.appNutri.negocios.Refeicao;

public class AddEditRefeicaoController {
	@FXML private DatePicker datePicker;
	
	
	/**
	 * É Chamado pelo JavaFX quando um Dialog é fechado.
	 * 
	 * @param buttonType
	 * @return Um novo objeto Refeicao, ou nulo se a janela foi fechada sem ser pelo botão de OK.
	 */
	public Refeicao resultConverter(ButtonType buttonType) {
		if (buttonType.getButtonData() != ButtonData.OK_DONE)
			return null;

		// O JavaFX não tem DateTimePicker, só DatePicker. Então por enquanto a hora
		// utilizada é a hora atual.
		return new Refeicao(new Comida[] {},
				            LocalDateTime.of(datePicker.getValue(), LocalTime.now()));
	}
}
