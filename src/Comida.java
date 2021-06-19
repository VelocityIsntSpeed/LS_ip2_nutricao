import java.util.ArrayList;

public class Comida {
	private String nome;
	private InfoNutricional infoNutricional;
	private ArrayList<Comida> ingredientes;
	
	public Comida(String nome, InfoNutricional infoNutricional, ArrayList<Comida> ingredientes) {
		super();
		this.nome = nome;
		this.infoNutricional = infoNutricional;
		this.ingredientes = ingredientes;
	}

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public InfoNutricional getInfoNutricional() {
		return infoNutricional;
	}
	public void setInfoNutricional(InfoNutricional infoNutricional) {
		this.infoNutricional = infoNutricional;
	}
	
	public ArrayList<Comida> getIngredientes() {
		return ingredientes;
	}
	public void setIngredientes(ArrayList<Comida> ingredientes) {
		this.ingredientes = ingredientes;
	}
	
	private String possuiIngredientes() {
		if (this.ingredientes != null) {
			return "Sim";
		}
		return "Não";
	}
	
	@Override
	public String toString() {
		return "Comida: " + nome + "/nPossui Ingredientes: " 
				+ this.possuiIngredientes() + "/nInformação Nutricional: " + infoNutricional;
	}
}
