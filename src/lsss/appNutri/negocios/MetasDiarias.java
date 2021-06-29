package lsss.appNutri.negocios;

public class MetasDiarias {
	private InfoNutricional nutrientes;
	
	public MetasDiarias(InfoNutricional nutrientes) {
		super();
		this.nutrientes = nutrientes;
	}

	public InfoNutricional getNutrientes() {
		return nutrientes;
	}

	public void setNutrientes(InfoNutricional nutrientes) {
		this.nutrientes = nutrientes;
	}
	
	
}
