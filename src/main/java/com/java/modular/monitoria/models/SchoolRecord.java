package com.java.modular.monitoria.models;

public class SchoolRecord {
	
	private int studentId;
	private String subject;
	private int grade;
	public int getStudentId() {
		return studentId;
	}
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
	public SchoolRecord(int studentId, String subject, int grade) {
		super();
		this.studentId = studentId;
		this.subject = subject;
		this.grade = grade;
	}
	public SchoolRecord() {
		
	}
}
