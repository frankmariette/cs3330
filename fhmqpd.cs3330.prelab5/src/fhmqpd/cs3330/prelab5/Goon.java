package fhmqpd.cs3330.prelab5;

public class Goon {
	private String name;
	private String DOB;
	
	public Goon(String name, String DOB){
		setName(name);
		setDOB(DOB);
	}
	
	protected void setName(String name){
		this.name = name;
	}
	
	protected void setDOB(String DOB){
		this.DOB = DOB;
	}
	
	public String getName(){
		return this.name;
	}
	
	public String getDOB(){
		return this.DOB;
	}
	
	@Override
	public String toString(){
		return "Goon " + getName() + "\n\tDOB: " + getDOB();
	}
}
