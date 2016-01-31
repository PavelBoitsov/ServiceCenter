package service_center.dao;

import java.util.*;
import javax.persistence.*;


@Entity
public class History{
	@Id
	@GeneratedValue
	private int id;
	private String status;
	private Date date;
//	private User user;

	public History() {
		super();
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

/*	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}*/

	public int getId() {
		return id;
	}
}
