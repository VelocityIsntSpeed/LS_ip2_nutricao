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
	 * � Chamado pelo JavaFX quando um Dialog � fechado.
	 * 
	 * @param buttonType
	 * @return Um novo objeto Refeicao, ou nulo se a janela foi fechada sem ser pelo bot�o de OK.
	 */
	public Refeicao resultConverter(ButtonType buttonType) {
		if (buttonType.getButtonData() != ButtonData.OK_DONE)
			return null;

		// O JavaFX n�o tem DateTimePicker, s� DatePicker. Ent�o por enquanto a hora
		// utilizada � a hora atual.
		return new Refeicao(new Comida[] {},
				            LocalDateTime.of(datePicker.getValue(), LocalTime.now()));
	}
}
