package com.sumit.java8;
class Employee{
	int id;
	int sal;
	int age;
	String name;
	
	public Employee(int id, int sal, int age, String name) {
		super();
		this.id = id;
		this.sal = sal;
		this.age = age;
		this.name = name;
	}
	
	
	
	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public int getSal() {
		return sal;
	}



	public void setSal(int sal) {
		this.sal = sal;
	}



	public int getAge() {
		return age;
	}



	public void setAge(int age) {
		this.age = age;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public Employee(){}
	
	@Override
	public String toString() {
		return "Employee [id=" + id + ", sal=" + sal + ", age=" + age
				+ ", name=" + name + "]";
	}
}