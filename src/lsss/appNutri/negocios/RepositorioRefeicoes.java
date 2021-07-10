package lsss.appNutri.negocios;

import javafx.collections.ObservableList;
import lsss.appNutri.persistencia.ListaDAO;

public class RepositorioRefeicoes {
	/** ObservableList pode ser usado como um ArrayList. A diferença é que é possível
	 * setar observadores que são notificados quando há alguma mudança na lista. */
	private final ObservableList<Refeicao> refeicoes;
	private final ListaDAO dao = new ListaDAO("Refeicoes.txt");

	// Construtor
	@SuppressWarnings("unchecked")
	public RepositorioRefeicoes() {
		refeicoes = dao.carregar();
	}
	
	
	public ObservableList<Refeicao> getObservableList() {
		return refeicoes;
	}

	/** Registra uma refeição. */
	public void add(Refeicao arg) {
		if (arg != null && !refeicoes.contains(arg)) {
			refeicoes.add(arg);
		}
		
		dao.salvar(refeicoes);
	}
	
	/** Remove uma refeição.
	 * @return true se a refeição foi removida, false se não foi removida
	 * porque a refeição não estava contida no repositório. */
	public boolean remover(Refeicao arg) {
		boolean foiRemovida = refeicoes.remove(arg);
		
		dao.salvar(refeicoes);
		
		return foiRemovida;
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
