package lsss.appNutri.negocios;

import javafx.collections.ObservableList;
import lsss.appNutri.persistencia.ListaDAO;

public class RepositorioRefeicoes {
	/** ObservableList pode ser usado como um ArrayList. A diferen�a � que � poss�vel
	 * setar observadores que s�o notificados quando h� alguma mudan�a na lista. */
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

	/** Registra uma refei��o. */
	public void add(Refeicao arg) {
		if (arg != null && !refeicoes.contains(arg)) {
			refeicoes.add(arg);
		}
		
		dao.salvar(refeicoes);
	}
	
	/** Remove uma refei��o.
	 * @return true se a refei��o foi removida, false se n�o foi removida
	 * porque a refei��o n�o estava contida no reposit�rio. */
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
