import java.util.ArrayList;

public class Comida {
	private InfoNutricional infoNutricional;
	private String nome;
	private ArrayList<Comida> ingredientes;
	
	
	public Comida(InfoNutricional infoNutricional, String nome, ArrayList<Comida> ingredientes) {
		super();
		this.infoNutricional = infoNutricional;
		this.nome = nome;
		this.ingredientes = ingredientes;
	}
	
	
	public InfoNutricional getInfoNutricional() {
		return infoNutricional;
	}
	public void setInfoNutricional(InfoNutricional infoNutricional) {
		this.infoNutricional = infoNutricional;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
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
		return "N�o";
	}


	@Override
	public String toString() {
		return "Comida: " + nome + "/nPossui Ingredientes: " 
				+ this.possuiIngredientes() + "/nInforma��o Nutricional: " + infoNutricional;
	}
	
	
	
}
