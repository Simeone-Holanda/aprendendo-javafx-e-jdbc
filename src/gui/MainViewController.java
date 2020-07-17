package gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import application.Main;
import gui.util.Alerts;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;

public class MainViewController implements Initializable { 
	
	// logo abaixo foi criado os atributos dos itens do menu
	@FXML
	private MenuItem menuItemSeller;
	
	@FXML
	private MenuItem menuItemDepartment;
	
	@FXML
	private MenuItem menuItemAbout;
	
	// logo abaixo temos as funções q irão manipular os elementos da tela
	@FXML
	public void onMenuItemSellerAction() {
		System.out.println("onMenuItemSellerAction");
	}
	@FXML
	public void onMenuItemDepartmentAction() {
		System.out.println("onMenuItemDepartmentAction");
	}
	@FXML
	public void onMenuItemAboutAction() {
		loadView("/gui/About.fxml");
	}
	
	private synchronized void loadView(String absoluteName) { // esse synchron ... garante q a aplicação rode sem ser interrompida por problemas (dica boa)
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource(absoluteName)); // minha nova tela
			VBox newVbox = loader.load(); //carradando nossa view 
			
			//chamando uma nova tela, entenda q eu tenho um Vbox principal e um auxiliar onde fica o About cada Vbox é 
			//composto por filhos e eu tenho basicamente q substituir esses elementos filhos do meu Vbox principal pelo VBox 
			//do About
			Scene mainScene = Main.getMainScene(); // pegando nossa cena principal
			VBox mainVBox = (VBox) ((ScrollPane) mainScene.getRoot()).getContent(); // guardando a cena principal 
			// Esse metodo getRoot ele pega o primeiro elemento da minha cena no caso o meu ScrollPane(fiz um casting para q o 
			//elemento ficasse com seu tipo padrao),com o get.content conseguimos pegar tds os filhos do SP em outras palavras o conteudo,
			// o Casting q foi feito para VBox é pq o content tem como conteudo um outro VBox
			
			Node mainMenu = mainVBox.getChildren().get(0); // aq estou guardando o o primeiro elemento do Vbox da minha tela principal 
			mainVBox.getChildren().clear(); // excluindo td o conteudo do VBox principal
			mainVBox.getChildren().add(mainMenu); // adicionando a cena 
			mainVBox.getChildren().addAll(newVbox.getChildren());// aq estou add uma cena nova ao conteudo da minha cena principal
		}
		catch(IOException e) {
			Alerts.showAlert("IO Exeception", "Error loading view", e.getMessage(), AlertType.ERROR);
		}
	}
	@Override
	public void initialize(URL uri, ResourceBundle rb) {
	}

}
