package lsss.appNutri.gui;

import java.io.IOException;
import java.time.LocalDateTime;

import javafx.application.Application;
import javafx.stage.Stage;
import lsss.appNutri.negocios.Comida;
import lsss.appNutri.negocios.InfoNutricional;
import lsss.appNutri.negocios.Refeicao;
import lsss.appNutri.negocios.RepositorioComidas;
import lsss.appNutri.negocios.RepositorioRefeicoes;

public class Main extends Application {
	
	public static void main(String[] args) {
		Application.launch(); // O JavaFX cria uma instancia de Main e chama o metodo start nela
	}
	
	// Atributos
	public final RepositorioComidas repoComidas = new RepositorioComidas();
	public final RepositorioRefeicoes repoRefeicoes = new RepositorioRefeicoes();

	@Override
	public void start(Stage primaryStage) throws IOException {
		
		// Inicialização de dados (só para testes)
		InfoNutricional infoNut1 = new InfoNutricional(100, 1, 20);
		InfoNutricional infoNut2 = new InfoNutricional(240, 8, 15);
		
		Comida arroz = new Comida("Arroz", infoNut2);
		Comida pastaDeAmendoim = new Comida("Pasta de Amendoim", infoNut1);
		Comida sucoDeLaranja = new Comida("Suco de Laranja", infoNut1);
		
		
		if (repoComidas.getObservableList().isEmpty()) {
			System.out.println("Não há comidas registradas, então foram adicionadas algumas para teste.\n");
			repoComidas.add(arroz);
			repoComidas.add(pastaDeAmendoim);
			repoComidas.add(sucoDeLaranja);
		}
		
		if (repoRefeicoes.getObservableList().isEmpty()) {
			System.out.println("Não há refeições registradas, então foram adicionadas algumas para teste.\n");
			
			repoRefeicoes.add(new Refeicao(new Comida[]{arroz},
                                           LocalDateTime.now().minusDays(10)));
			
			repoRefeicoes.add(new Refeicao(new Comida[]{arroz, pastaDeAmendoim},
	                                       LocalDateTime.now().minusHours(30)));
			
			repoRefeicoes.add(new Refeicao(new Comida[]{arroz, pastaDeAmendoim, sucoDeLaranja},
						                   LocalDateTime.now().minusHours(1)));
		}
		
		
		
		// Abre a janela principal
		new JanelaPrincipal(primaryStage, this);
	}
}
