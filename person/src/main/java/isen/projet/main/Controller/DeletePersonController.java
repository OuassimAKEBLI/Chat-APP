package isen.projet.main.Controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import isen.projet.main.model.CheckID;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import projet.isen.java2.db.daos.PersonDao;

public class DeletePersonController implements Initializable{
	
	// declaration of fields present in our view ( one Text Field and Three Buttons )
	@FXML
	Button Delete;
	@FXML
	Button Quit;
	@FXML
	Button Back;
	
	@FXML
	private TextField GetID;
	
	
	/*
	 * this function is controlling the delete button in the DeletePersonScreen view
	 * @param: none
	 * @return : void
	 * @author : Ouassim AKEBLI
	 * */
	@FXML
	public void deleteperson() {
		String id = GetID.getText();
		CheckID check = new CheckID();
		if(check.chek_id(id)) {
			int id_checked = Integer.parseInt(id);
			PersonDao perDao = new PersonDao();
			perDao.deletePerson(id_checked);
			
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Person Deleted");
			alert.setHeaderText(null);
			alert.setContentText("The Person Was Deleted Successfully");
			alert.showAndWait();
		}else {
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("Invalid ID");
			alert.setHeaderText(null);
			alert.setContentText("Please select a valid ID");
			alert.showAndWait();
		}
	}
	
	/*
	 * this function controls the button quit in DeletePersonScreen view , when you press the button it goes out of the software
	 * @param : none
	 * @return : void
	 * @author : Ouassim AKEBLI
	 * */
	@FXML
	public void Quit() {
		System.exit(0);
	}
	
	/*
	 * this function controls the button back , when you press the button it goes back to the main screen
	 * @param : location as URL, resources as ResourceBundle
	 * @return : void
	 * @author : Ouassim AKEBLI
	 * */
	@FXML
	public void BackMainScreen(ActionEvent event) throws IOException {
		Parent homeScreen_par = FXMLLoader.load(getClass().getResource("../view/HomeScreen.fxml"));
		Scene homeScreen = new Scene(homeScreen_par);
		Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		app_stage.hide();
		app_stage.setTitle("Contact Application");
		app_stage.setScene(homeScreen);
		app_stage.show();
	}

	/*
	 * this function is an implementation of the function initialize from the interface "Initializable", basically initializing the view before showing it 
	 * @param : location as URL, resources as ResourceBundle
	 * @return : void
	 * @author : Ouassim AKEBLI
	 * */
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
	}

}
