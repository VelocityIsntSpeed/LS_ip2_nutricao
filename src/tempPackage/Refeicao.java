package tempPackage;
import java.time.LocalDateTime;

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
		String strTemp = "";
		for(int i = 0; i < comidas.length; i++) {
			strTemp = strTemp + comidas[i].toString() + "/n";
		}
		return "Comidas presentes na refei��o: /n" + strTemp;
	}
}
