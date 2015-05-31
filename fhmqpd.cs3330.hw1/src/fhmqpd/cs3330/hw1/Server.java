package fhmqpd.cs3330.hw1;

public class Server {
	private String name;
	private String type;
	private int strength;
	
	public Server (String name, String type, int strength ){
		setName(name);
		setType(type);
		setStrength(strength);
	}
	
	private void setName(String name){
		this.name = name;
	}
	
	private void setType(String type){
		this.type = type;
	}
	
	private void setStrength(int strength){
		this.strength = strength;
	}
	
	public void updateStrength(int additional_strength){
		setStrength(additional_strength + getStrength());
	}
	
	public String getName(){
		return this.name;
	}
	
	public String getType(){
		return this.type;
	}
	
	public int getStrength(){
		return this.strength;
	}
	
	public String toString(){
		return "SERVER INFO: " + getType() + " server with address of " + getName() + 
				" with " + getStrength() + " strength";
	}
}
