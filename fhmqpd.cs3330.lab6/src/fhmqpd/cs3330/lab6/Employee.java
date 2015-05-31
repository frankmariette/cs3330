package fhmqpd.cs3330.lab6;

public class Employee {
	private String name;
	private int SSN;
	
	public Employee(String name, int ssn){
		setName(name);
		setSSN(ssn);
	}

	protected void setSSN(int ssn) {
		this.SSN = ssn;
		
	}

	protected void setName(String name) {
		this.name = name;
	}
	
	public String getName(){
		return this.name;
	}
	
	public int getSSN(){
		return this.SSN;
	}
}
