package fhmqpd.cs3330.hw1;

public class Tool {
	private String name;
	private String type;
	private int cost;
	private int strength;
	
	public Tool(String name, String type, int cost, int strength){
		setName(name);
		setType(type);
		setCost(cost);
		setStrength(strength);
	}
	
	private void setName(String name){
		this.name = name;
	}
	
	private void setType(String type){
		this.type = type;
	}
	
	private void setCost(int cost){
		this.cost = cost;
	}
	
	private void setStrength(int strength){
		this.strength = strength;
	}
	
	public void updateStrength(int additional_strength){
		setStrength(this.getStrength() + additional_strength);
	}
	
	public String getName(){
		return this.name;
	}
	
	public String getType(){
		return this.type;
	}
	
	public int getCost(){
		return this.cost;
	}
	
	public int getStrength(){
		return this.strength;
	}
	
	public String toString(){
		return getType() + " tool named " + getName() + " with " + getStrength() + " strength and a cost of " + getCost();
	}
}
