package isen.projet.main.Controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import isen.projet.main.model.CheckTextFields;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import projet.isen.java2.db.entity.Person;
import projet.isen.java2.db.daos.PersonDao;

public class AddPersonController implements Initializable{
	
	// declaration of fields present in our view ( Seven Text Fields and Four Buttons )
	@FXML
	private TextField GetLastName;
	@FXML
	private TextField GetFirstName;
	@FXML
	private TextField GetNickName;
	@FXML
	private TextField GetPhoneNumber;
	@FXML
	private TextField GetAddress;
	@FXML
	private TextField GetEmailAddress;
	@FXML
	private TextField GetBirthDay;
	
	/*
	 * this function is controlling the submit button in the AddPersonScreen view
	 * @param: none
	 * @return : void
	 * @author : Ouassim AKEBLI
	 * */
	@FXML
	private void SubmitForm() {
		String lastname = GetLastName.getText();		
		String firstname = GetFirstName.getText();
		String nickname = GetNickName.getText();
		String phonenumber = GetPhoneNumber.getText();
		String address = GetAddress.getText();
		String emailaddress = GetEmailAddress.getText();
		String birthday = GetBirthDay.getText();
		
		CheckTextFields check = new CheckTextFields();
		Person per = check.CheckValidation(lastname, firstname, nickname, phonenumber, address, emailaddress, birthday);
		if(per != null) {
			PersonDao perDao = new PersonDao();
			perDao.addPerson(per);
			
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Person Add");
			alert.setHeaderText(null);
			alert.setContentText("The person has been added successfully ");
			alert.showAndWait();
			EmptyTextField();
		}else {
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("Person Add");
			alert.setHeaderText(null);
			alert.setContentText("The person Failed to add");
			alert.showAndWait();
		}
		
	}
	
	/*
	 * this function controls the button empty fields by making all the text fields in AddPersonScreen view form empty
	 * @param :  none
	 * @return void
	 * @author : Ouassim AKEBLI
	 * */
	@FXML
	private void EmptyTextField() {
		if(GetLastName.getText() != null || !GetLastName.getText().trim().isEmpty()) {
			GetLastName.clear();
		}
		if(GetFirstName.getText() != null || !GetFirstName.getText().trim().isEmpty()) {
			GetFirstName.clear();
		}
		if(GetNickName.getText() != null || !GetNickName.getText().trim().isEmpty()) {
			GetNickName.clear();
		}
		if(GetPhoneNumber.getText() != null || !GetPhoneNumber.getText().trim().isEmpty()) {
			GetPhoneNumber.clear();
		}
		if(GetAddress.getText() != null || !GetAddress.getText().trim().isEmpty()) {
			GetAddress.clear();
		}
		if(GetEmailAddress.getText() != null || !GetEmailAddress.getText().trim().isEmpty()) {
			GetEmailAddress.clear();
		}
		if(GetBirthDay.getText() != null || !GetBirthDay.getText().trim().isEmpty()) {
			GetBirthDay.clear();
		}
	}
	
	/*
	 * this function controls the button quit in AddPersonScreen view , when you press the button it goes out of the software
	 * @param : none
	 * @return : void
	 * @author : Ouassim AKEBLI
	 * */
	@FXML
	private void Quit() {
		System.exit(0);
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
	
	/*
	 * this function controls the button back , when you press the button it goes back to the main screen
	 * @param : location as URL, resources as ResourceBundle
	 * @return : void
	 * @author : Ouassim AKEBLI
	 * */
	@FXML
	private void GetBackToMainScreen(ActionEvent event) throws IOException {
		Parent homeScreen_par = FXMLLoader.load(getClass().getResource("../view/HomeScreen.fxml"));
		Scene homeScreen = new Scene(homeScreen_par);
		Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		app_stage.hide();
		app_stage.setTitle("Contact Application");
		app_stage.setScene(homeScreen);
		app_stage.show();
	}

}
