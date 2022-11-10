package com.greatlearning.lab6.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Student {
	
	public Student(){
		
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", department=" + department + ", country=" + country + "]";
	}
	public Student(String name, String department, String country) {
		super();
		this.name = name;
		this.department = department;
		this.country = country;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	private String name;
	private String department;
	private String country;

}
