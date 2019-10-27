package com.java.modular.monitoria.models;

public class CurriculumLattes {
	
	private Integer id;
	private boolean estage;
	private boolean monitor;
	private boolean extention;
	private boolean topAcademic;
	private boolean articles;
	public boolean isEstage() {
		return estage;
	}
	public void setEstage(boolean estage) {
		this.estage = estage;
	}
	public boolean isMonitor() {
		return monitor;
	}
	public void setMonitor(boolean monitor) {
		this.monitor = monitor;
	}
	public boolean isExtention() {
		return extention;
	}
	public void setExtention(boolean extention) {
		this.extention = extention;
	}
	public boolean isTopAcademic() {
		return topAcademic;
	}
	public void setTopAcademic(boolean topAcademic) {
		this.topAcademic = topAcademic;
	}
	public boolean isArticles() {
		return articles;
	}
	public void setArticles(boolean articles) {
		this.articles = articles;
	}
	public CurriculumLattes(boolean estage, boolean monitor, boolean extention, boolean topAcademic, boolean articles) {
		super();
		this.estage = estage;
		this.monitor = monitor;
		this.extention = extention;
		this.topAcademic = topAcademic;
		this.articles = articles;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public CurriculumLattes() {
		
	}
}
