package service_center.dao;

import javax.persistence.*;

@Entity
public class Shop {
	@Id
	@GeneratedValue
	private int id;
	private String name;
	private String code;

	public Shop(int id, String name, String code) {
		this.id = id;
		this.name = name;
		this.code = code;
	}

	public Shop() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	@Override
	public String toString() {
		return "Shop [id=" + id + ", name=" + name + ", code=" + code + "]";
	}

}
