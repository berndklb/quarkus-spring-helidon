package com.github.berndklb.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Employee {
	
	@Id @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="empSeq")
	private long persId;
	private String name;
	private String firstname;
	private LocalDate birthday;
	public long getPersId() {
		return persId;
	}
	public void setPersId(long persId) {
		this.persId = persId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public LocalDate getBirthday() {
		return birthday;
	}
	public void setBirthday(LocalDate birthday) {
		this.birthday = birthday;
	}
	@Override
	public String toString() {
		return "Employee [persId=" + persId + ", name=" + name + ", firstname=" + firstname + ", birthday=" + birthday
				+ "]";
	}
}
