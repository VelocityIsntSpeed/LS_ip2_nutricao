package tempPackage;
import java.util.ArrayList;

public class RepositorioComidas {
	private ArrayList<Comida> comidas = new ArrayList<Comida>();
	
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
		// Se não for encontrado
		return null;
	}
	
	/** Remove uma comida.
	 * @return true se a comida foi removida, false se não foi removida
	 * porque a comida não estava contida no repositório. */
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
