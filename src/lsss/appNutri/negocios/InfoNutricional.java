package lsss.appNutri.negocios;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;

/** Representa uma lista de nutrientes. */
public final class InfoNutricional {
	
	private final float valEnergetico;
	private final float proteina;
	private final float carboidratos;
	// TODO: O resto dos nutrientes
	
	public InfoNutricional(float valEnergetico, float proteina, float carboidratos) {
		
		if (valEnergetico < 0 || proteina < 0 || carboidratos < 0) {
			throw new IllegalArgumentException("O nutriente não pode ser negativo.");
		}
		
		this.valEnergetico = valEnergetico;
		this.proteina = proteina;
		this.carboidratos = carboidratos;
	}
	
	
	
	public InfoNutricional() {
		this.valEnergetico = 0;
		this.proteina = 0;
		this.carboidratos = 0;
	}
	
	/** @return Um novo InfoNutricional que é a soma desse com o do argumento. */
	public InfoNutricional mais(InfoNutricional outro) {
		if (outro == null) throw new IllegalArgumentException("O argumento não pode ser nulo.");
		
		return new InfoNutricional(this.valEnergetico + (float)outro.getValEnergetico(),
				                   this.proteina + (float)outro.getProteina(),
				                   this.carboidratos + (float)outro.getCarboidratos());
	}
	
	public static InfoNutricional soma(Collection<InfoNutricional> infos) {
		float tempValEnergetico = 0;
		float tempProteina = 0;
		float tempCarboidratos = 0;
		ArrayList<InfoNutricional> infosList = new ArrayList<>(infos);
		for(int i = 0; i < infosList.size(); i++) {
			tempValEnergetico += infosList.get(i).getValEnergetico();
			tempProteina += infosList.get(i).getProteina();
			tempCarboidratos += infosList.get(i).getCarboidratos();
		}
		InfoNutricional temp = new InfoNutricional(tempValEnergetico, tempProteina, tempCarboidratos);
		return temp;
	}

	@Override
	public String toString() {
		return String.format("{InfoNutricional: %s, %s, %s}", valEnergetico, proteina, carboidratos);
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

	@Override
	public int hashCode() {
		return Objects.hash(carboidratos, proteina, valEnergetico);
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
}
