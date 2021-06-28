package tempPackage;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

public class Refeicao {
	private Comida[] comidas;
	/** Hora em que a refeicao foi consumida. */
	private LocalDateTime dateTime;
	
	
	public Refeicao(Comida[] comidas, LocalDateTime dateTime) {
		super();
		this.comidas = comidas;
		this.dateTime = dateTime;
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
}
