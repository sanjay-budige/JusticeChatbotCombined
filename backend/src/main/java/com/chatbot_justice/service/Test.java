package com.chatbot_justice.service;

import com.google.gson.Gson;

public class Test {
	public static void main(String[] args) {
		
		Employe employe = new Employe();
		employe.setFirstName("sanjay");
		employe.setLastName("Budige");
		Gson gson = new Gson();
		String json = gson.toJson(employe);
		System.out.println(json);
		
		Student employe2 = gson.fromJson(json, Student.class);
		
		System.out.println(employe2.getFirstName());
		System.out.println(employe2.getLastName());
	}

}

class Employe {
	private String firstName;
	private String lastName;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
}


class Student {
	private String firstName;
	private String lastName;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
}