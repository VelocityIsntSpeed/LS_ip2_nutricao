package lsss.appNutri.negocios;

import javafx.collections.ObservableList;
import lsss.appNutri.persistencia.ListaDAO;

public class RepositorioComidas {
	/** ObservableList pode ser usado como um ArrayList. A diferença é que é possível
	 * setar observadores que são notificados quando há alguma mudança na lista. */
	private final ObservableList<Comida> comidas;
	private final ListaDAO dao = new ListaDAO("Comidas.txt");
	
	// Construtor
	public RepositorioComidas() {
		comidas = dao.carregar();
	}

	/** Adiciona uma comida. */
	public void add(Comida arg) {
		if (arg != null && !comidas.contains(arg)) {
			comidas.add(arg);
		}
		
		dao.salvar(comidas); // Salva mudanças 
	}
	
	/** Remove uma comida.
	 * @return true se a comida foi removida, false se não foi removida
	 * porque a comida não estava contida no repositório. */
	public boolean remover(Comida arg) {
	    boolean foiRemovida = comidas.remove(arg);
		
		dao.salvar(comidas); // Salva mudanças
		
		return foiRemovida;
	}
	
	@Override
	public String toString() {
		String strTemp = "RepositorioComidas:";
		
		if (comidas.size() == 0) {
			return strTemp + "(vazio)";
		}
		else {
			strTemp += "\n";
			for (Comida comida : comidas) {
				strTemp += "- " + comida.toString() + "\n";
			}
			return strTemp;
		}
	}
	
	public ObservableList<Comida> getObservableList() {
		return comidas;
	}
}
