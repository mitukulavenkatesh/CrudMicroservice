package com.example.Predator.model;

public class EmployeModel {

	private double salary;
	private int age;
	private String city;
	private String name;

	public EmployeModel(String name, int age, String city, double salary) {
		this.name = name;
		this.age = age;
		this.city = city;
		this.salary = salary;
	}

	public double getSalary() { // <-- getter
		return salary;
	}

	public int getAge() {
		return age;
	}

	public String getCity() {
		return city;
	}

	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return "EmployeModel{" + "name='" + name + '\'' + ", age=" + age + ", city='" + city + '\'' + ", salary="
				+ salary + '}';
	}

}
