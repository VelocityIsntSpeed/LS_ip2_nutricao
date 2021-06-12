import java.time.LocalDateTime;

public class Refeicao {
	private Comida comida;
	/** Hora em que a refeicao foi consumida. */
	private LocalDateTime dateTime;
	
	
	public Refeicao(Comida comidas, LocalDateTime dateTime) {
		super();
		this.comida = comidas;
		this.dateTime = dateTime;
	}
	
	public Comida getComidas() {
		return comida;
	}
	public void setComidas(Comida comidas) {
		this.comida = comidas;
	}
	public LocalDateTime getDateTime() {
		return dateTime;
	}
	public void setDateTime(LocalDateTime dateTime) {
		this.dateTime = dateTime;
	}
	
	
}
