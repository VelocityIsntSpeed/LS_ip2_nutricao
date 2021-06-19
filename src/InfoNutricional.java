
/** Representa uma lista de nutrientes. */
public final class InfoNutricional {
	private final double valEnergetico;
	private final double proteina;
	private final double carboidratos;
	// TODO: O resto dos nutrientes
	
	public InfoNutricional(double valEnergetico, double proteina, double carboidratos) {
		super();
		
		if (valEnergetico < 0 || proteina < 0 || carboidratos < 0) {
			throw new IllegalArgumentException("O nutriente não pode ser negativo.");
		}
		
		this.valEnergetico = valEnergetico;
		this.proteina = proteina;
		this.carboidratos = carboidratos;
	}
	
	public double getValEnergetico() {
		return valEnergetico;
	}
	public double getProteina() {
		return proteina;
	}
	public double getCarboidratos() {
		return carboidratos;
	}

	@Override
	public String toString() {
		return "Valor Energetico:" + valEnergetico + ", proteína=" + proteina + ", carboidratos:"
				+ carboidratos;
	}
}
