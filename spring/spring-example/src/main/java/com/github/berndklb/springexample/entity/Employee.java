package com.github.berndklb.springexample.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Employee {
	
	@Id @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="empSeq")
	private long persid;
	private String name;
	private String firstname;
	private LocalDate birthday;
	public long getPersid() {
		return persid;
	}
	public void setPersid(long persid) {
		this.persid = persid;
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
		return "Employee [persId=" + persid + ", name=" + name + ", firstname=" + firstname + ", birthday=" + birthday
				+ "]";
	}
}
