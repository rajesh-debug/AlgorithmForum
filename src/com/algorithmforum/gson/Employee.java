package com.algorithmforum.gson;

public class Employee {
	private int age;

	private String name;

	private String gender;

	public Employee(int age, String name, String gender) {
		this.age = age;
		this.name = name;
		this.gender = gender;
	}

	public int getAge() {
		return age;
	}

	public String getName() {
		return name;
	}

	public String getGender() {
		return gender;
	}

}