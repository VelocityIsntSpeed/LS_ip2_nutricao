import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class Test extends Application {
	
	public static void main(String[] args) {
		InfoNutricional infoNut = new InfoNutricional(0, 0, 0);
		System.out.println(infoNut);
		
		System.out.println(new Comida("Arroz", infoNut));
		
		
		Application.launch();
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("LSSS App nutrição");
		Label label = new Label("Hello World!");
		Scene scene = new Scene(label, 300, 100);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
}
