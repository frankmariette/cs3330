package fhmqpd.cs3330.prelab2;

public class Person {
	private String name;
	private int age;
	private String gender;
	
	public Person( String name, int age, String gender){
		setName(name);
		setAge(age);
		setGender(gender);
	}
	
	public String getName(){
		return name;
	};
	
	public int getAge(){
		return age;
	};
	
	public String getGender(){
		return gender;
	}
	
	private void setName(String name){
		this.name = name;
	}
	
	private void setAge(int age){
		this.age = age;
	}
	
	private void setGender(String gender){
		this.gender = gender;
	}
	
}
