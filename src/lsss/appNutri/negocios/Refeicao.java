package lsss.appNutri.negocios;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.ArrayList;

public class Refeicao {
	
	/** Lista de comidas que fazem parte dessa refei��o. Pode estar vazia. */
	private Comida[] comidas;
	/** Hora em que a refeicao foi consumida. */
	private LocalDateTime dateTime;
	
	
	public Refeicao(Comida[] comidas, LocalDateTime dateTime) {
		this.comidas = comidas;
		this.dateTime = dateTime;
	}
	
	public Refeicao(Comida[] comidas) {
		super();
		this.comidas = comidas;
		this.dateTime = LocalDateTime.now();
	}

	/**
	 * @return A informa��o nutricional da refei��o (somando de todas as comidas).
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
	
	// TODO equals e hashCode

	
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
