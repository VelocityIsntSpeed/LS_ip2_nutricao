
public class InfoNutricional {
	private double valEnergetico;
	private double proteina;
	private double carboidratos;
	
	
	
	public InfoNutricional(double valEnergetico, double proteina, double carboidratos) {
		super();
		this.valEnergetico = valEnergetico;
		this.proteina = proteina;
		this.carboidratos = carboidratos;
	}
	
	public double getValEnergetico() {
		return valEnergetico;
	}
	public void setValEnergetico(double valEnergetico) {
		this.valEnergetico = valEnergetico;
	}
	public double getProteina() {
		return proteina;
	}
	public void setProteina(double proteina) {
		this.proteina = proteina;
	}
	public double getCarboidratos() {
		return carboidratos;
	}
	public void setCarboidratos(double carboidratos) {
		this.carboidratos = carboidratos;
	}
	
	
}
