package fhmqpd.cs3330.hw1;

import java.util.Scanner;
import java.util.Random;

public class Console {
	
	private static final Scanner input = new Scanner(System.in);
	private Player player;
	private ToolKit toolkit;
	private Grid grid;
	
	public Console(Player player){
		setPlayer(player);
		init();
	}
	
	private void setPlayer(Player player){
		this.player = player;
	}

	private void init(){
		/*
		 * Instantiates a Grid object to the grid attribute, and will instantiate a ToolKit
		 * object to the toolkit attribute.
		 */
		grid = new Grid();
		toolkit = new ToolKit();
		
	}

	public boolean use(){
		/*
		 * Will instantiate a random generator to create random range between the number of
		 * servers on the grid. The use method will terminate when the players health is less
		 * or equal to zero.
		 */
		while (player.getHealth() > 0){
			int randomServer = new Random().nextInt(grid.numberOfServers());
			displayRunOptions();
			String answer = input.nextLine();
			if (answer.equals("yes")){
				System.out.println("Enter the address to server ");
				String name = input.nextLine();
				int search = grid.search(name);
				if (search > 0){
					runOnTheGrid(search);
					updateToolKit();
				}
				else{
					System.out.println("Invalid server");
				}

			}
			else{
				runOnTheGrid(randomServer);
				updateToolKit();
			}
		}
		return false;
	}

	private void updateToolKit(){
		/*
		 * Will call displayTools from the toolkit instance, allowing the user to pick the tool
		 * to update (error checking the index entered). Then ask the player how much to udpate
		 * (error checking if the user has enough money to update). Update the money of the 
		 * player and update the tool. 
		 */
		int breaker, additional_strength;
		System.out.println(player.toString());
		displayUpdateOptions();
		String update_tool = input.nextLine();
		if (update_tool.equals("yes")){
			toolkit.displayTools();
			System.out.println("Which tool do you want to update?");
			breaker = Integer.parseInt(input.nextLine());
			while (breaker > toolkit.getNumberOfTools() || breaker < 0){
				System.out.println("Not a valid tool, enter your choice again:");
				breaker = Integer.parseInt(input.nextLine());
			}
			System.out.println("How much strength to add? (each 1 additional costs 10000 yen) ");
			additional_strength = Integer.parseInt(input.nextLine());
			if (player.getMoney() > (additional_strength * 10000)){
				toolkit.updateTool(breaker, additional_strength);
			}
			else {
				System.out.println("Not enough funds.");
			}
		}
		else{
			return;
		}
	}

	private void runOnTheGrid(int target_server){
		/*
		 * Display the tools using the ToolKit class method displayTools. Scan in the index of
		 * the tool (error checking if the user can use a tool with his money). If the run had a
		 * positive value returned add that to the player's money. If a negative value is returned
		 * decrement the player's life by the returned value. Display the player's info.
		 */
		int result;
		toolkit.displayTools();
		System.out.println("Pick an Ice Breaker:");
		int breaker = Integer.parseInt(input.nextLine());
		while (breaker > toolkit.getNumberOfTools() || breaker < 0){
			System.out.println("Not a valid tool, enter your choice again:");
			breaker = Integer.parseInt(input.nextLine());
		}
		breaker = breaker - 1; // Corrects the index to prevent an off by one error. 
		System.out.println("ICE ENCOUNTERED, ATTEMPTING BREAK IN......");
		if(player.getMoney() > toolkit.getTool(breaker).getCost()){
			player.updateMoney(player.getMoney() - toolkit.getTool(breaker).getCost());
			result = grid.attack(toolkit.getTool(breaker), target_server);
			if (result > 0){
				System.out.println("RUN SUCCESSFUL");
				player.updateMoney(result);
			}
			else{
				System.out.println("RUN FAILED");
				player.updateHealth(result);
			}
		}
		else {
			System.out.println("Not enough funds.");
		}
		
		
		
	}
	
	private void displayRunOptions(){
		System.out.println("Do you have a particular target server IP address to probe the grid?(yes/no)");
	}
	
	private void displayUpdateOptions(){
		System.out.println("Would you like to update a tool in the toolkit? (yes/no)");
	}
	
}