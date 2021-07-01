package lsss.appNutri.negocios;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class RepositorioRefeicoes {
	/** ObservableList pode ser usado como um ArrayList. A diferen�a � que � poss�vel
	 * setar observadores que s�o notificados quando h� alguma mudan�a na lista. */
	private final ObservableList<Refeicao> refeicoes = FXCollections.observableArrayList();
	
	public ObservableList<Refeicao> getObservableList() {
		return refeicoes;
	}

	/** Registra uma refei��o. */
	public void add(Refeicao arg) {
		if (arg != null && !refeicoes.contains(arg)) {
			refeicoes.add(arg);
		}
	}
	
	/** Remove uma refei��o.
	 * @return true se a refei��o foi removida, false se n�o foi removida
	 * porque a refei��o n�o estava contida no reposit�rio. */
	public boolean remover(Refeicao arg) {
		return refeicoes.remove(arg);
	}
	
	@Override
	public String toString() {
		String strTemp = "RepositorioRefeicoes:";
		
		if (refeicoes.size() == 0) {
			return strTemp + "(vazio)";
		}
		else {
			strTemp += "\n";
			for (Refeicao refeicao : refeicoes) {
				strTemp += refeicao.toString();
			}
			return strTemp;
		}
	}
}
