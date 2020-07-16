package application;
	
import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/gui/MainView.fxml")); // instanciado um objeto para rodar nossa tela
			Parent parent = loader.load(); // carregandando a tela
			Scene mainScene = new Scene(parent); // passando para meu objeto cena 
			primaryStage.setScene(mainScene); // e passando a cena para o palco 
			primaryStage.setTitle("Sample JavaFX application"); // add um titulo a ela
			primaryStage.show(); // mostrando td
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
