package com.java.modular.monitoria.models;

public class Student extends People {

	private Integer register;
	private SchoolRecord record;
	private CurriculumLattes curriculum;

	public int getRegister() {
		return register;
	}

	public void setRegister(int register) {
		this.register = register;
	}

	public SchoolRecord getRecord() {
		return record;
	}

	public void setRecord(SchoolRecord record) {
		this.record = record;
	}

	public CurriculumLattes getCurriculum() {
		return curriculum;
	}

	public void setCurriculum(CurriculumLattes curriculum) {
		this.curriculum = curriculum;
	}

	public Student(int register, String name, String email, String contact, String streat, SchoolRecord record,
			CurriculumLattes curriculum) {
		super(name, contact, email, streat);
		this.register = register;
		this.record = record;
		this.curriculum = curriculum;
	}

	public Student() {

	}

	
	
}
