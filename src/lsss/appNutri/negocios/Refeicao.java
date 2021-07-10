package lsss.appNutri.negocios;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

public class Refeicao implements Serializable {
	
	/** Lista de comidas que fazem parte dessa refeição. Pode estar vazia. */
	private Comida[] comidas;
	/** Hora em que a refeicao foi consumida. */
	private LocalDateTime dateTime;
	
	
	public Refeicao(Comida[] comidas, LocalDateTime dateTime) {
		this.comidas = comidas;
		this.dateTime = dateTime;
	}
	
	public Refeicao(Comida[] comidas) {
		this(comidas, LocalDateTime.now());
	}

	/**
	 * @return A informação nutricional da refeição (somando de todas as comidas).
	 */
	public InfoNutricional getInfoNutricional() {
		var infoNutList = new ArrayList<InfoNutricional>();
		// Gera lista de InfoNutricional
		for (Comida comida : comidas) {
			infoNutList.add(comida.getInfoNutricional());
		}
		
		return InfoNutricional.soma(infoNutList);
	}
		
	public String toString() {
		String strTemp = String.format("Refeicao (%s):",
				dateTime.format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM)));
		
		if (comidas.length == 0) {
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

	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(comidas);
		result = prime * result + Objects.hash(dateTime);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Refeicao other = (Refeicao) obj;
		return Arrays.equals(comidas, other.comidas) && Objects.equals(dateTime, other.dateTime);
	}

	public int getQuantidadeComida() {
		return comidas.length;
	}
	
	public Comida[] getComidas() {
		return comidas;
	}
	public void setComidas(Comida[] comidas) {
		this.comidas = comidas;
	}
	public LocalDateTime getDateTime() {
		return dateTime;
	}
	public void setDateTime(LocalDateTime dateTime) {
		this.dateTime = dateTime;
	}
}
