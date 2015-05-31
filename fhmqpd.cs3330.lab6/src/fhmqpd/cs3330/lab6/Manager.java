package fhmqpd.cs3330.lab6;

public class Manager extends Employee {
	private String department;
	
	public Manager(String name, int SSN, String department){
		super(name, SSN);
		setDepartment(department);
	}

	protected void setDepartment(String department) {
		this.department = department;
		
	}
	
	public String getDepartment(){
		return this.department;
	}
	
	@Override
	public String toString(){
		return "Manager " + super.getName() + "\n\tSSN: " + super.getSSN() + "\n\tDepartment: " + this.getDepartment();
	}
}
