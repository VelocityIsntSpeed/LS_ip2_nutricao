package tempPackage;

public class Comida {
	private String nome;
	private InfoNutricional infoNutricional;
	
	public Comida(String nome, InfoNutricional infoNutricional) {
		super();
		this.nome = nome;
		this.infoNutricional = infoNutricional;
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

	@Override
	public String toString() {
		return String.format("{Comida: nome=\"%s\", %s}", nome, infoNutricional);
	}
}
