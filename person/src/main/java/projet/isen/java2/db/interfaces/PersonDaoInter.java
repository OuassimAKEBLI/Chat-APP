package projet.isen.java2.db.interfaces;

import java.util.List;

import projet.isen.java2.db.entity.Person;

public interface PersonDaoInter {
	
	public List<Person> listPersons();
	
	public Person addPerson(Person person);
	
	public void deletePerson(Integer personId);
	
	public void updatePerson(Person person, int id);

}
