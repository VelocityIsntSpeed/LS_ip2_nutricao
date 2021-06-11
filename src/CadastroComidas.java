import java.util.ArrayList;

public class CadastroComidas {
	private ArrayList<Comida> comidas;
	
	// Adiciona uma comida. */
	public void add(Comida arg) {
		if (!comidas.contains(arg)) {
			comidas.add(arg);
		}
		// TODO: Não deixar adicionar nulos
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
	
}
