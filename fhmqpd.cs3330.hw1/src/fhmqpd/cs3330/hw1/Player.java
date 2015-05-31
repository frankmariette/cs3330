package fhmqpd.cs3330.hw1;

public class Player {
	private String name;
	private int health;
	private int money;
	
	public Player(String name){
		setName(name);
		setHealth(100);
		setMoney(20000);
	}
	
	private void setName(String name){
		this.name = name;
	}
	
	private void setHealth(int health){
		this.health = health;
	}
	
	private void setMoney(int money){
		this.money = money;
	}
	/*
	 * Takes a negative or positive value and add that to existing money of the player and
	 * use the setMoney to update the Player money attribute. 
	 */
	public void updateMoney(int money){
		setMoney(this.money + money);
	}
	
	/*
	 * Takes a negative or positive value and add that to existing health of the player and
	 * use the setHealth to update the Player health attribute. 
	 */
	public void updateHealth(int health){
		setHealth(this.health + health);
	}
	
	public String getName(){
		return this.name;
	}
	
	public int getHealth(){
		return this.health;
	}
	
	public int getMoney(){
		return this.money;
	}
	
	public String toString(){
		health = getHealth();
		if (health < 0){
			return "Hacker " + getName() + " with health of 0 with " + getMoney() + " yen";
		}
		else {
			return "Hacker " + getName() + " with health of " + health + " with " + getMoney() + " yen";
		}
	}
	
}
