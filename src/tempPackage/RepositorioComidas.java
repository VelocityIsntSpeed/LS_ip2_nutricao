package tempPackage;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class RepositorioComidas {
	/** ObservableList pode ser usado como um ArrayList. A diferen�a � que � poss�vel
	 * setar observadores que s�o notificados quando h� alguma mudan�a na lista. */
	private ObservableList<Comida> comidas = FXCollections.observableArrayList();
	
	public ObservableList<Comida> getObservableList() {
		return comidas;
	}

	/** Adiciona uma comida. */
	public void add(Comida arg) {
		if (arg != null && !comidas.contains(arg)) {
			comidas.add(arg);
		}
	}
	
	/** Busca uma comida por nome. */
	public Comida buscar(String nome) {
		for (Comida comida : comidas) {
			if (comida.getNome().equals(nome)) {
				return comida;
			}
		}
		// Se n�o for encontrado
		return null;
	}
	
	/** Remove uma comida.
	 * @return true se a comida foi removida, false se n�o foi removida
	 * porque a comida n�o estava contida no reposit�rio. */
	public boolean remover(Comida arg) {
		return comidas.remove(arg);
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
}
