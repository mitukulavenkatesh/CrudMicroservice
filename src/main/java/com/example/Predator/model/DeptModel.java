package com.example.Predator.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "department")
public class DeptModel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String dep_name;
	private String names;
	private Integer dep_salary;
	private Integer age;
	private String city;
	private String state;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDep_name() {
		return dep_name;
	}

	public void setDep_name(String dep_name) {
		this.dep_name = dep_name;
	}

	public String getNames() {
		return names;
	}

	public void setNames(String names) {
		this.names = names;
	}

	public Integer getDep_salary() {
		return dep_salary;
	}

	public void setDep_salary(Integer dep_salary) {
		this.dep_salary = dep_salary;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	@Override
	public String toString() {
		return "DeptModel [id=" + id + ", dep_name=" + dep_name + ", names=" + names + ", dep_salary=" + dep_salary
				+ ", age=" + age + ", city=" + city + ", state=" + state + "]";
	}

}
