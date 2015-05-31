package fhmqpd.cs3330.lab7;

/*
 * Name: Francois Mariette
 * PawPrint: FHMQPD
 * Section: E
 * Submission code: Gingerbread
 */

public class Person {
	private String name;
	private int age;
	private double bankAccountBalance;
	
	public Person(int age, String name, double balance){
		setAge(age);
		setName(name);
		setBalance(balance);
	}

	private void setBalance(double balance) {
		this.bankAccountBalance = balance;
		
	}

	private void setAge(int age) {
		this.age = age;
	}

	private void setName(String name) {
		this.name = name;
	}
	
	protected int getAge(){
		return this.age;
	}
	
	protected String getName(){
		return this.name;
	}
	
	protected double getBalance(){
		return this.bankAccountBalance;
	}
	
	
	@Override
	public String toString(){
		return "Name: " + getName() + "\nBank Balance: " + getBalance() + "\nAge: " + getAge();
	}
}
