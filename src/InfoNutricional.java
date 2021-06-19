import java.util.Objects;

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

	@Override
	public int hashCode() {
		return Objects.hash(carboidratos, proteina, valEnergetico);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		// Gerado automaticamente pelo Eclipse. Não sei porque o doubleToLongBits, tem a ver com -0.0 ou NaN.
		InfoNutricional other = (InfoNutricional) obj;
		return Double.doubleToLongBits(carboidratos) == Double.doubleToLongBits(other.carboidratos)
				&& Double.doubleToLongBits(proteina) == Double.doubleToLongBits(other.proteina)
				&& Double.doubleToLongBits(valEnergetico) == Double.doubleToLongBits(other.valEnergetico);
	}
}
