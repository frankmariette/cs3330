package fhmqpd.cs3330.hw2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Console {

	private static final Scanner input = new Scanner(System.in);

	Player player;
	ToolKit toolkit;
	Grid grid;
	ArrayList<Job> jobs;
	ArrayList<Business> contacts;
	BlackMarket blackMarket;

	/**
	 * Class constructor.
	 */
	public Console(Player player, Grid grid) {
		this.setPlayer(player);
		this.grid = grid;
		this.init();
	}

	/**
	 * Setter for player.
	 */
	private void setPlayer(Player player) {
		this.player = player;
	}

	/**
	 * Initalizes the TookKit and Grid attributes
	 */
	public void init() {
		this.toolkit = new ToolKit();
		this.grid = new Grid();
		this.blackMarket = new BlackMarket("New Tokyo Subterranean Sewer",
				"Katsu Tanaka", this.grid, this.player);
		this.jobs = new ArrayList<Job>();
		loadContacts();
	}

	/**
	 * Method that runs the game
	 * 
	 * @return false when the player dies
	 */
	public boolean use() {

		int option;
		int server_idx = 0;
		Job target_job = null;
		
		while (this.player.getHealth() > 0) {
			
			System.out.println(this.player.toString());
			option = displayOptionMenu();
			switch (option) {
			case 1:
				if (jobs.size() > 0) {
					target_job = pullAJob();
					server_idx = grid.search(target_job.getTargetAddress());
					if(runOnTheGrid(server_idx, target_job.getReward())){
						jobs.remove(target_job);
					}
				} else{
					System.out.println("You need to get a job first!");
				}
				break;
			case 2:
				if(player.getMoney() > 0){
					updateToolKit();
				} else{
					System.out.println("No funds to enter the black market");
				}
				break;
			case 3:
				if (jobs.size() < 10) {
					findJobOffer();
				} else {
					System.out.println("Too many jobs left undone.");
				}
				break;
			case 4:
				System.out.println("Logging off!");
				return false;
			default:
				break;
			}
		}
		System.out.println(player.toString() + "has FLATLINED");
		return false;

	}

	/**
	 * Updates a picked from the toolkit arraylist
	 */
	private void updateToolKit() {
		Tool newTool = null;
		newTool = blackMarket.buyATool();
		if(newTool != null){
			toolkit.addOrUpdateTool(newTool);
		}
	

	}

	/**
	 * 
	 * @param target_server
	 *            : int The method allow the player to attack a target server
	 *            with a selected tool.
	 */
	private boolean runOnTheGrid(int target_server, int possible_income) {
		this.toolkit.displayTools();
		System.out.print("Pick your ice breaker: ");
		int tool_choice = Integer.parseInt(input.next());
		--tool_choice;
		while (tool_choice < 0
				|| tool_choice > this.toolkit.getNumberOfTools() - 1) {
			System.out.print("Not a valid tool, enter your choice again: ");
			tool_choice = Integer.parseInt(input.next());
			--tool_choice;
		}
		System.out.println(" ");
		Tool tool = this.toolkit.getTool(tool_choice);
		while (player.getMoney() - tool.getCost() < 0) {
			System.out.print("Not enough funds, try again: ");
			tool_choice = Integer.parseInt(input.next());
			tool = this.toolkit.getTool(tool_choice);
		}
		int deduction = tool.getCost() * -1;
		this.player.updateMoney(deduction);
		int result = grid.attackServer(tool, target_server);
		if (result > 0) {
			System.out.println("RUN SUCCESSFUL");
			this.player.updateMoney(result);
			System.out.println(" ");
			System.out.println(player.toString());
			return true;
		} else {
			System.out.println("RUN FAILURE");
			this.player.updateHealth(result);
			System.out.println(" ");
			System.out.println(player.toString());
			return false;
		}
		
	}
	/**
	 * Displays the menu
	 * @return returns selection
	 */
	private int displayOptionMenu() {
		int selection;
		System.out.println("1) Run on the Grid");
		System.out.println("2) Visit the Black Market");
		System.out.println("3) Add a job to the list");
		System.out.println("4) Log off Console");
		System.out.println("Selection: ");
		selection = Integer.parseInt(input.next());
		while (selection < 1 && selection > 4) {
			System.out.println("Invalid input. Reenter:");
			selection = Integer.parseInt(input.next());
		}

		return selection;
	}
	/**
	 * Loads up all contacts
	 */
	private void loadContacts() {
		File contactDatafile = new File("contacts.txt");
		Scanner dataScanner = null;
		String type, name, contact;
		try {
			dataScanner = new Scanner(contactDatafile);
		} catch (FileNotFoundException e) {
			System.out.println("Error: Servers file not found.");
			System.exit(1);
		}
		this.contacts = new ArrayList<Business>();
		// Read in the tools
		while (dataScanner.hasNextLine()) {
			// Read in each line, splitting the csv on the comma
			Scanner line = new Scanner(dataScanner.nextLine());
			line.useDelimiter(",");
			type = line.next();
			name = line.next();
			contact = line.next();
			if (type.equals("Corporation")) {
				contacts.add(new Corporation(name, contact, this.grid));
			} else if (type.equals("NonProfit")) {
				contacts.add(new NonProfit(name, type, this.grid));
			} else {
				System.out.println("Invalid input");
				;
			}
			line.close();
		}
		dataScanner.close();
	}
	/**
	 * Shows all jobs currently available. 
	 * @return Job selected to complete
	 */
	private Job pullAJob() {
		int selection;
		for (int i = 0; i < jobs.size(); i++){
			System.out.println("Job) " + jobs.get(i).getTargetAddress() + " worth " + jobs.get(i).getReward());
		}
		System.out.println("Selection: ");
		selection = Integer.parseInt(input.next());
		while ( selection < 1 || selection > jobs.size()){
			System.out.println("Invalid input: ");
			selection = Integer.parseInt(input.next());
		}
		
		return jobs.get(selection - 1 );
		
	}
	/**
	 * Adds job from contacts to players currently jobs
	 */
	private void findJobOffer() {
		int contact;
		int job;
		System.out.println(contacts.size());
		for (int i = 0; i < contacts.size(); i++) {
			System.out.println((i + 1) + ") " + contacts.get(i).toString());
		}
		System.out.println("Selection:");
		contact = Integer.parseInt(input.next());
		while (contact > contacts.size() || contact < 1) {
			System.out.println("Invalid input please reenter:");
			contact = Integer.parseInt(input.next());
		}
		System.out.println(contacts.get(contact - 1).toString());
		contacts.get(contact - 1).viewJobOffers();
		System.out.println("Selection: ");

		job = Integer.parseInt(input.next());
		int numOfJobs = contacts.get(contact).getJobOfferCount();
		while (job > numOfJobs || job < 1) {
			System.out.println("Invalid input please reenter:");
			job = Integer.parseInt(input.next());
		}

		if (jobs.add(contacts.get(contact).getJobOffer(job - 1))) {
			System.out.println("Job added successfully.");
		} else {
			System.out.println("Job not added.");
		}
	}

}
