package projet.isen.java2.db.entity;

import java.time.LocalDate;


/*
 * this class person contain all the informations that we need to store data in our table person
 * */
public class Person {

	private int id;
	private String last_name;
	private String first_name;
	private String nickname;
	private String phone_number;
	private String address;
	private String email_address;
	private LocalDate birth_date;
	
	
	public Person(int id, String last_name, String first_name, String nickname,
			String phone_number, String address, String email_address, LocalDate birth_date) {
		super();
		this.id = id;
		this.last_name = last_name;
		this.first_name = first_name;
		this.nickname = nickname;
		this.phone_number = phone_number;
		this.address = address;
		this.email_address = email_address;
		this.birth_date = birth_date;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getLast_name() {
		return last_name;
	}


	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}


	public String getFirst_name() {
		return first_name;
	}


	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}


	public String getNickname() {
		return nickname;
	}


	public void setNickname(String nickname) {
		this.nickname = nickname;
	}


	public String getPhone_number() {
		return phone_number;
	}


	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public String getEmail_address() {
		return email_address;
	}


	public void setEmail_address(String email_address) {
		this.email_address = email_address;
	}


	public LocalDate getBirth_date() {
		return birth_date;
	}


	public void setBirth_date(LocalDate birth_date) {
		this.birth_date = birth_date;
	}
	
	@Override
	public String toString() {
		String s = "";
		
		s += "ID : "+id+" Last Name : "+last_name+" First Name : "+first_name+" Nickname : "+nickname+" Phone Number : "+phone_number+" Address : "+address+" Email Address : "+email_address+" Birth Date : "+birth_date+"\n";
		
		return s;
	}
	
}
