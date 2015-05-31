package fhmqpd.cs3330.lab3;
/*
 * Creates a Fighter class that keeps track of the name, healthPoints and the living status
 * of fighters. The constructor initiates the fighter with user provided names and health
 * points and defaults the alive status to alive.  
 */



public class Fighter {
	private String name;
	private int healthPoints;
	private boolean isAlive;
	
	// Constructor class
	public Fighter(String name, int healthPoints){
		setName(name);
		setHealth(healthPoints);
		setAlive(true);
	}
	
	// Sets the name for the object. This method is only called in the constructor.
	private void setName(String name){
		this.name = name;
	}
	
	public String getName(){
		return name;
	}
	
	// Sets the HP of an object. This method is called initially in the constructor and
	// called again when beingHit() is used. 
	private void setHealth(int health){
		this.healthPoints = health;
	}
	
	public int getHealth(){
		return healthPoints;
	}
	
	private void setAlive(boolean alive){
		this.isAlive = alive;
	}
	
	public boolean getAlive(){
		return isAlive;
	}
	/*
	 * This function sets the behavior for when an object is hit.  Damage taken is based off
	 * of distance from the target. This function also announces to the user who was hit and
	 * the amount of damage done. If the person hit falls to or below 0 health, they are 
	 * killed off. If the fighter is still alive it will announce their remaining hitpoints. 
	 */
	public void beingHit(int distance){
		int health = getHealth();
		int damage;
		if (getAlive()){
			// This code is somewhat repetitive but is designed this way for readability
			// and to allow an if, else if, else structure control flow.
			// Variables are used so that changes to values make future changes easier.
			if (distance <= 5){
				damage = 30;
				health = health - damage;
				System.out.println(getName() + ": I was hit for " + damage + "." );
			}
			else if (distance > 5 && distance < 8){
				damage = 10;
				health = health - damage;
				System.out.println(getName() + ": I was hit for " + damage + "." );
			}
			else {
				System.out.println(getName() + ": I dodged!!!");
			}
		}
		setHealth(health);
		if (getHealth() <= 0){
			die();
		}
		else{
			System.out.println(this.toString());
			System.out.println("\n");
		}
	}
	
	// Outputs death message and sets the boolean Alive to false. The boolean value is hard
	// coded in to make sure that the fighter is classified as dead.
	private void die(){
		System.out.println(this.getName() + " has died.");
		setAlive(false);
	}
	// Outputs the name and HP of a fighter. It is implied that the fighter is alive for
	// this method to be called. 
	public String toString(){
		return ("My name is " + getName() + "! " + "I've " + getHealth() + " health points remaining");
	}
}
