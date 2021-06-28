package tempPackage;
import java.util.ArrayList;

public class RepositorioComidas {
	private ArrayList<Comida> comidas = new ArrayList<Comida>();
	
	// Adiciona uma comida. */
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
	
	/** Remove uma comida. */
	public boolean remover(Comida arg) {
		return comidas.remove(arg);
	}

	
	public String listarComidas() {
		//Será modificada futuramente de maneira a retornar algo mais útil para a GUI
		return this.toString();
	}
	
	@Override
	public String toString() {
		String strTemp = "";
		for(int i = 0; i < comidas.size(); i++) {
			strTemp = strTemp + comidas.get(i).toString() + "/n";
		}
		return "Comidas cadastradas: /n" + strTemp;
	}
	
	
	
}
