package service_center.dao;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class User{
	@Id
	@GeneratedValue
	int id;
	private String login;
	private String password;
	private String fName;
	private String sName;
	private int telNumber;
	@ManyToOne
	private Position position;

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public String getsName() {
		return sName;
	}

	public void setsName(String sName) {
		this.sName = sName;
	}

	public int getTelNumber() {
		return telNumber;
	}

	public void setTelNumber(int telNumber) {
		this.telNumber = telNumber;
	}

	public User() {
		super();
	}

	public User(String login, String password, String fName, String sName, int telNumber){ //Position position) {
		super();
		this.login = login;
		this.password = password;
		this.fName = fName;
		this.sName = sName;
		this.telNumber = telNumber;
	}
}
