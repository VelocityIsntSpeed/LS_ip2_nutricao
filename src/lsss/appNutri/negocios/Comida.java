package lsss.appNutri.negocios;

import java.io.Serializable;
import java.util.Objects;

public class Comida implements Serializable {
	private String nome;
	private InfoNutricional infoNutricional;
	
	public Comida(String nome, InfoNutricional infoNutricional) {
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
	public int hashCode() {
		return Objects.hash(infoNutricional, nome);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Comida other = (Comida) obj;
		return Objects.equals(infoNutricional, other.infoNutricional) && Objects.equals(nome, other.nome);
	}

	@Override
	public String toString() {
		return String.format("{Comida: nome=\"%s\", %s}", nome, infoNutricional);
	}
}
