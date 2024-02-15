package projectSoap;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.fxml.*;
public class MainWindow extends Application {

//Classe principale de l'interface utilisateur JavaFX.
//Charge l'interface utilisateur depuis le fichier FXML 
	
	
	    @Override
	    public void start(Stage stage) throws Exception {
	    	
	        FXMLLoader loader = new FXMLLoader(getClass().getResource("/MainWindowInterface.fxml"));
	        Parent root = loader.load();
	        
	        Scene scene = new Scene(root);
	        scene.setFill(Color.TRANSPARENT);
	        stage.setScene(scene);
	        stage.initStyle(StageStyle.TRANSPARENT);
	        scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
	        stage.setResizable(false);
	        stage.setTitle("Calculator");

	        // Obtenez le contrôleur après le chargement du FXML
	        MainWindowController controller = loader.getController();

	        // Initialisez le contrôleur avec le stage et le CalculatorService
	        controller.init(stage, new CalculatorService());

	        stage.show();
	    }

	    public void run() {
	        launch();
	    }
	}
