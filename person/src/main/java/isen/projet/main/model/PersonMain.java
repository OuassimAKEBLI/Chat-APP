package isen.projet.main.model;

import java.net.URL;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

/**
 * Hello world!
 *
 */
public class PersonMain extends Application
{
	
	/*
	 * the main function for our project
	 */
	public static void main(String[] args) {
        launch(args);
        
    }
	
	
	/*
	 * the function start inherited from Application load our view and show it to the user 
	 * @param : primaryStage of type Stage
	 * @return : void
	 * */
    
    @Override
    public void start(Stage primaryStage) throws Exception {
    	FXMLLoader loader = new FXMLLoader();
    	URL xmlUrl = getClass().getResource("../view/HomeScreen.fxml");
    	loader.setLocation(xmlUrl);
    	Parent root = loader.load();
    	primaryStage.setScene(new Scene(root));
    	primaryStage.setTitle("Contact Application");
    	primaryStage.getIcons().add(new Image(getClass().getResourceAsStream("../view/personIcon.png")));
    	primaryStage.setResizable(false);
    	primaryStage.show();
    }
}
