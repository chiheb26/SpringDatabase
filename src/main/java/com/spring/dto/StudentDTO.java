package com.spring.dto;

public class StudentDTO {

	private int student_id=1000;
	private String name="unknown";
	private int age=0;
	private String city="none";
	
	public int getStudent_id() {
		return student_id;
	}
	@Override
	public String toString() {
		return "StudentDTO [student_id=" + student_id + ", name=" + name + ", age=" + age + ", city=" + city + "]";
	}
	public void setStudent_id(int student_id) {
		this.student_id = student_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	
}
