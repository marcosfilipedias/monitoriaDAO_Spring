package com.java.modular.monitoria.models;

public class Subject {

	private Integer id;
	private String name;
	private Double grade;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Double getGrade() {
		return grade;
	}
	public void setGrade(Double grade) {
		this.grade = grade;
	}
	public Subject(String name, Double grade) {
		super();
		this.name = name;
		this.grade = grade;
	}
	public Subject() {

	}
}
