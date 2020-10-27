package projet.isen.java2.db.daos;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.tuple;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import com.mysql.jdbc.PreparedStatement;
import projet.isen.java2.db.daos.DataSourceFactory;
import projet.isen.java2.db.daos.PersonDao;
import projet.isen.java2.db.entity.Person;
import org.assertj.db.type.Table;

public class PersonDaoTestCase {
	
	private PersonDao personDao = new PersonDao();
	Table table = new Table(DataSourceFactory.getDataSource(), "person");
	
	/*
	 * this function is initializing our JUnit test by adding data into the database
	 * @param :  none
	 * @return void
	 * @author : Ouassim AKEBLI
	 * */
	@Before
	public void initDatabase() throws Exception {
		Connection connection = DataSourceFactory.getDataSource().getConnection();
		Statement stmt = connection.createStatement();
		stmt.executeUpdate("DELETE FROM person");

		stmt.executeUpdate("INSERT INTO person(idperson, lastname, firstname, nickname, phone_number, address, email_address, birth_date)"
				+ "VALUES (1, 'JOBS', 'Steve', 'Blow', '0654847956', '178th New York', 'jobs_jobs@steve.com', '1955-02-24')");
		
		stmt.executeUpdate("INSERT INTO person(idperson, lastname, firstname, nickname, phone_number, address, email_address, birth_date)"
				+ "VALUES (2, 'frank', 'labal', 'franko', '0654497956', '178th Detroit', 'frank@gmail.com', '1987-12-23')");
		
		stmt.executeUpdate("INSERT INTO person(idperson, lastname, firstname, nickname, phone_number, address, email_address, birth_date)"
				+ "VALUES (3, 'adam', 'hope', 'adimo', '0654717956', '178th New Jersey', 'adimo@hotmail.com', '1977-04-24')");
		
		stmt.executeUpdate("INSERT INTO person(idperson, lastname, firstname, nickname, phone_number, address, email_address, birth_date)"
				+ "VALUES (4, 'Ellen', 'Gray', 'Elo', '0654841356', 'Lille Vauban', 'ellen@outlook.com', '1997-12-26')");
		
		stmt.close();
		connection.close();
	}
	
	/*
	 * this function test if we are going to obtain the same data that we initialized using the listPersons method
	 * @param :  none
	 * @return void
	 * @author : Ouassim AKEBLI
	 * */
	@Test
	public void shouldListPersons() {
		
		List<Person> listOfPersons = personDao.listPersons();
		
		assertThat(listOfPersons).hasSize(4);				
		
		assertThat(listOfPersons).extracting("id", "last_name", "first_name", "nickname", "phone_number", "address", "email_address", "birth_date").containsOnly(
				tuple(1, "JOBS", "Steve", "Blow", "0654847956", "178th New York", "jobs_jobs@steve.com", LocalDate.of(1955, 02, 24)), 
				tuple(2, "frank", "labal", "franko", "0654497956", "178th Detroit", "frank@gmail.com", LocalDate.of(1987, 12, 23)),
				tuple(3, "adam", "hope", "adimo", "0654717956", "178th New Jersey", "adimo@hotmail.com", LocalDate.of(1977, 04, 24)),
				tuple(4, "Ellen", "Gray", "Elo", "0654841356", "Lille Vauban", "ellen@outlook.com", LocalDate.of(1997, 12, 26))
				);
	}
	
	/*
	 * this function test if we are going to obtain the person data that we used that we added using the addPerson method
	 * @param :  none
	 * @return void
	 * @author : Ouassim AKEBLI
	 * */
	@Test
	public void shouldAddPerson() throws Exception {
		// WHEN 
		Person per = new Person(1, "kiki", "koko", "floor", "0665457895", "178 rue sadi carnot", "lflfl@fjfjhf.com", LocalDate.of(2015, 12, 31));
		personDao.addPerson(per);
		// THEN
		Connection connection = DataSourceFactory.getDataSource().getConnection();
		Statement statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery("SELECT * FROM person WHERE lastname='kiki'");
		assertThat(resultSet.next()).isTrue();
		assertThat(resultSet.getInt("idperson")).isNotNull();
		assertThat(resultSet.getString("lastname")).isEqualTo("kiki");
		assertThat(resultSet.next()).isFalse();
		resultSet.close();
		statement.close();
		connection.close();
	}
	
	/*
	 * this function test if we can delete data from the table person using the function deletePerson
	 * @param :  none
	 * @return void
	 * @author : Ouassim AKEBLI
	 * */
	@Test
    public void shouldDeletePerson() throws Exception {
        // WHEN
        personDao.deletePerson(4);
        // THEN
        String sql= "SELECT * FROM person WHERE idperson=4"; 
        try(Connection connection= DataSourceFactory.getDataSource().getConnection()){
        	try(PreparedStatement statement=  (PreparedStatement) connection.prepareStatement(sql)){
        		try(ResultSet results= statement.executeQuery()){
        			while(results.next()) 
        				assertThat(results.next()).isFalse();
                 }
             }
        }catch(Exception e) {
        	e.printStackTrace();
        }
    }
	
	/*
	 * this function test if we can update an existing data person in our table person
	 * @param :  none
	 * @return void
	 * @author : Ouassim AKEBLI
	 * */
	@Test
    public void shouldUpdatePerson() throws SQLException {
		//GIVEN
		Person per = new Person(1, "kiki", "koko", "floor", "0665457895", "178 rue sadi carnot", "lflfl@fjfjhf.com", LocalDate.of(2015, 12, 31));
		//WHEN
		personDao.updatePerson(per, 1);
		//THEN
		String sql= "SELECT * FROM person WHERE idperson= ?";
		try(Connection connection= DataSourceFactory.getDataSource().getConnection()){
			 try(PreparedStatement statement= (PreparedStatement) connection.prepareStatement(sql)){
			 	statement.setInt(1, per.getId());
			 		try(ResultSet results= statement.executeQuery()){
			 			while(results.next()) {
			 				assertThat(results.getString("lastname")).isEqualTo(per.getLast_name());
			 				assertThat(results.getString("firstname")).isEqualTo(per.getFirst_name());     
			 				assertThat(results.getString("nickname")).isEqualTo(per.getNickname()); 
			 				assertThat(results.getString("phone_number")).isEqualTo(per.getPhone_number()); 
			 				assertThat(results.getString("address")).isEqualTo(per.getAddress()); 
			 				assertThat(results.getString("email_address")).isEqualTo(per.getEmail_address()); 
			 				assertThat(results.getString("birth_date")).isEqualTo(per.getBirth_date().toString());
			 			}
			 		}
			 }
		}catch(Exception e) {
			e.printStackTrace();
		}
	}



}
