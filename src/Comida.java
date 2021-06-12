import java.util.Arrays;

public class Comida {
	private InfoNutricional infoNutricional;
	private String nome;
	private Comida[] ingredientes;
	
	
	public Comida(InfoNutricional infoNutricional, String nome, Comida[] ingredientes) {
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
	
	public Comida[] getIngredientes() {
		return ingredientes;
	}
	public void setIngredientes(Comida[] ingredientes) {
		this.ingredientes = ingredientes;
	}
	
	public String possuiIngredientes() {
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
