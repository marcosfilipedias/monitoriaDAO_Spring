package com.java.modular.monitoria.models;

public class Teacher extends People{

	private int idNumber;
	private Integer id;

	public int getIdNumber() {
		return idNumber;
	}

	public void setIdNumber(int idNumber) {
		this.idNumber = idNumber;
	}
	
	public Teacher() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	public Teacher(String name, String contact, String email, String streat, int idNumber) {
		super(name, contact, email, streat);
		this.idNumber = idNumber;
	}
}
