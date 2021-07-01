package lsss.appNutri.negocios;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class RepositorioRefeicoes {
	/** ObservableList pode ser usado como um ArrayList. A diferença é que é possível
	 * setar observadores que são notificados quando há alguma mudança na lista. */
	private final ObservableList<Refeicao> refeicoes = FXCollections.observableArrayList();
	
	public ObservableList<Refeicao> getObservableList() {
		return refeicoes;
	}

	/** Registra uma refeição. */
	public void add(Refeicao arg) {
		if (arg != null && !refeicoes.contains(arg)) {
			refeicoes.add(arg);
		}
	}
	
	/** Remove uma refeição.
	 * @return true se a refeição foi removida, false se não foi removida
	 * porque a refeição não estava contida no repositório. */
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
