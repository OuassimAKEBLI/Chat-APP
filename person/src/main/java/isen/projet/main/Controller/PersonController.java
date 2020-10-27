package isen.projet.main.Controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.scene.Node;

public class PersonController implements Initializable{
	
	// declaration of fields present in our view ( Five Buttons )
	@FXML
	private Button ListPersons;
	@FXML
	private Button AddPerson;
	@FXML
	private Button DeletePerson;
	@FXML
	private Button Quit;
	@FXML
	private Button UpdatePerson;
	
	
	/*
	 * this function controls the button quit in HomeScreen view , when you press the button it goes out of the software
	 * @param : none
	 * @return : void
	 * @author : Ouassim AKEBLI
	 * */
	@FXML
	public void QuitSoftWare() {
		System.exit(0);
	}
	
	/*
	 * this function goes to the next scene where you can list all the persons in the database
	 * @param : none
	 * @return : void
	 * @author : Ouassim AKEBLI
	 * */
	@FXML
	private void ShowPersonsButton(ActionEvent event) throws IOException {		
		Parent homeScreen_par = FXMLLoader.load(getClass().getResource("../view/ListPersonsScreen.fxml"));
		Scene homeScreen = new Scene(homeScreen_par);
		Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		app_stage.hide();
		app_stage.setScene(homeScreen);
		app_stage.setTitle("List Of Persons");
		app_stage.show();
	}
	
	/*
	 * this function goes to the next scene where you can add a person to the database
	 * @param : none
	 * @return : void
	 * @author : Ouassim AKEBLI
	 * */
	@FXML
	private void AddPeronButton(ActionEvent event) throws IOException {
		Parent homeScreen_par = FXMLLoader.load(getClass().getResource("../view/AddPersonScreen.fxml"));
		Scene homeScreen = new Scene(homeScreen_par);
		Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		app_stage.hide();
		app_stage.setScene(homeScreen);
		app_stage.setTitle("Add Person");
		app_stage.show();
	}
	
	/*
	 * this function goes to the next scene where you can delete a person from the database
	 * @param : none
	 * @return : void
	 * @author : Ouassim AKEBLI
	 * */
	@FXML
	private void DeletePersonButton(ActionEvent event) throws IOException {
		Parent homeScreen_par = FXMLLoader.load(getClass().getResource("../view/DeletePersonScreen.fxml"));
		Scene homeScreen = new Scene(homeScreen_par);
		Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		app_stage.hide();
		app_stage.setScene(homeScreen);
		app_stage.setTitle("Delete Person");
		app_stage.show();
	}
	
	/*
	 * this function goes to the next scene where you can update a person information using its ID
	 * @param : none
	 * @return : void
	 * @author : Ouassim AKEBLI
	 * */
	@FXML
	private void UpdatePersonButton(ActionEvent event) throws IOException {
		Parent homeScreen_par = FXMLLoader.load(getClass().getResource("../view/UpdatePersonScreen.fxml"));
		Scene homeScreen = new Scene(homeScreen_par);
		Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		app_stage.hide();
		app_stage.setScene(homeScreen);
		app_stage.setTitle("Update Person");
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
