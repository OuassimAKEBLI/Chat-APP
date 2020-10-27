package isen.projet.main.Controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.time.LocalDate;
import java.util.List;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import projet.isen.java2.db.daos.PersonDao;
import projet.isen.java2.db.entity.Person;

public class ShowPersonsController implements Initializable{

	// declaration of fields present in our view ( Three Buttons , table view and eight columns)
	@FXML
	private Button Back450;
	@FXML
	private Button Quit450;
	@FXML
	private Button Export450;
	
	@FXML
	private TableView<Person> my_table = new TableView<Person>();
	@FXML
	private TableColumn<Person, Integer> id_person = new TableColumn<Person, Integer>("id");
	@FXML
	private TableColumn<Person, String> lastname = new TableColumn<Person, String>("last_name");
	@FXML
	private TableColumn<Person, String> firstname = new TableColumn<Person, String>("first_name");
	@FXML
	private TableColumn<Person, String> nickname = new TableColumn<Person, String>("nickname");
	@FXML
	private TableColumn<Person, String> phonenumber = new TableColumn<Person, String>("phone_number");
	@FXML
	private TableColumn<Person, String> address = new TableColumn<Person, String>("address");
	@FXML
	private TableColumn<Person, String> emailaddress = new TableColumn<Person, String>("email_address");
	@FXML
	private TableColumn<Person, LocalDate> birthday = new TableColumn<Person, LocalDate>("birthday");
	
	ObservableList<Person> item = FXCollections.observableArrayList();
	PersonDao per = new PersonDao();
	List<Person> allPersons = per.listPersons();
	
	/*
	 * this function is extracting data from database before it showing it 
	 * @param : none
	 * @return : void
	 * @author : Ouassim AKEBLI
	 * */
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		my_table.setEditable(true);
		
		for(Person my_person : allPersons) {
			item.add(my_person);
		}
		
		id_person.setCellValueFactory(new PropertyValueFactory<Person, Integer>("id"));
		lastname.setCellValueFactory(new PropertyValueFactory<Person, String>("last_name"));
		firstname.setCellValueFactory(new PropertyValueFactory<Person, String>("first_name"));
		nickname.setCellValueFactory(new PropertyValueFactory<Person, String>("nickname"));
		phonenumber.setCellValueFactory(new PropertyValueFactory<Person, String>("phone_number"));
		address.setCellValueFactory(new PropertyValueFactory<Person, String>("address"));
		emailaddress.setCellValueFactory(new PropertyValueFactory<Person, String>("email_address"));
		birthday.setCellValueFactory(new PropertyValueFactory<Person, LocalDate>("birth_date"));
		my_table.setItems(item);
		
	}
	
	/*
	 * this function quit the software
	 * @param : none
	 * @return : void
	 * @author : Ouassim AKEBLI
	 * */
	@FXML
	private void quitPersonsList() {
		System.exit(0);
	}
	
	/*
	 * this function goes back to the home screen
	 * @param : none
	 * @return : void
	 * @author : Ouassim AKEBLI
	 * */
	@FXML
	private void GoBackMainScreen(ActionEvent event) throws IOException {
		Parent homeScreen_par = FXMLLoader.load(getClass().getResource("../view/HomeScreen.fxml"));
		Scene homeScreen = new Scene(homeScreen_par);
		Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		app_stage.hide();
		app_stage.setTitle("Contact Application");
		app_stage.setScene(homeScreen);
		app_stage.show();
	}
	
	/*
	 * this function writing backup to a CSV file
	 * @param : none
	 * @return : void
	 * @author : Ouassim AKEBLI
	 * */
	@FXML
	private void ExportDataToCSV(ActionEvent event) throws IOException {
		String path = System.getProperty("user.dir");
		File tmpDir= new File(path+"\\src\\main\\resources\\vcard\\VCard.csv");
		PrintWriter pw;
		if(!tmpDir.exists()) {
			pw = new PrintWriter(tmpDir);
			StringBuilder sb = new StringBuilder();
			sb.append("idperson");
			sb.append(";");
			sb.append("lastname");
			sb.append(";");
			sb.append("firstname");
			sb.append(";");
			sb.append("nickname");
			sb.append(";");
			sb.append("phone_number");
			sb.append(";");
			sb.append("address");
			sb.append(";");
			sb.append("email_address");
			sb.append(";");
			sb.append("birthday");
			
			for(Person perso : allPersons) {
				sb.append("\n");
				sb.append(Integer.toString(perso.getId()));
				sb.append(";");
				sb.append(perso.getLast_name());
				sb.append(";");
				sb.append(perso.getFirst_name());
				sb.append(";");
				sb.append(perso.getNickname());
				sb.append(";");
				sb.append(perso.getPhone_number());
				sb.append(";");
				sb.append(perso.getAddress());
				sb.append(";");
				sb.append(perso.getEmail_address());
				sb.append(";");
				sb.append(perso.getBirth_date().toString());
			}

			pw.write(sb.toString());
			pw.close();
		}else {
			pw = new PrintWriter(tmpDir);
			StringBuilder sb = new StringBuilder();
			sb.append("idperson");
			sb.append(";");
			sb.append("lastname");
			sb.append(";");
			sb.append("firstname");
			sb.append(";");
			sb.append("nickname");
			sb.append(";");
			sb.append("phone_number");
			sb.append(";");
			sb.append("address");
			sb.append(";");
			sb.append("email_address");
			sb.append(";");
			sb.append("birthday");
			
			for(Person perso : allPersons) {
				sb.append("\n");
				sb.append(Integer.toString(perso.getId()));
				sb.append(";");
				sb.append(perso.getLast_name());
				sb.append(";");
				sb.append(perso.getFirst_name());
				sb.append(";");
				sb.append(perso.getNickname());
				sb.append(";");
				sb.append(perso.getPhone_number());
				sb.append(";");
				sb.append(perso.getAddress());
				sb.append(";");
				sb.append(perso.getEmail_address());
				sb.append(";");
				sb.append(perso.getBirth_date().toString());
			}

			pw.write(sb.toString());
			pw.close();
		}
	}
}
