package fhmqpd.cs3330.hw2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class BlackMarket extends Business {
	private ArrayList<Tool> tools;
	private static Scanner input = new Scanner(System.in);
	private Player buyer;

	public BlackMarket(String name, String contact, Grid grid, Player buyer) {
		super(name, contact, grid);
		setBuyer(buyer);
		loadTools();
	}

	private void setBuyer(Player buyer) {
		this.buyer = buyer;
	}

	private void loadTools() {
		tools = new ArrayList<Tool>();
		File toolDataFile = new File("tools_to_buy.txt");
		Scanner dataScanner = null;
		try {
			dataScanner = new Scanner(toolDataFile);
		} catch (FileNotFoundException e) {
			System.out.println("Error: Tools file not found.");
			System.exit(1);
		}
		this.tools = new ArrayList<Tool>();
		String input;
		// Read in the tools
		while (dataScanner.hasNext()) {
			// Read in each line, splitting the csv on the comma
			input = dataScanner.nextLine();
			String[] data = input.split(",");
			tools.add(new Tool(data[0], data[1], Integer.parseInt(data[2]),
					Integer.parseInt(data[3])));
		}
		dataScanner.close();
	}

	public void viewToolsDatabase() {
		for (int i = 0; i < tools.size(); i++) {
			System.out.println("PN:" + (i + 1) + "[" + tools.get(i).toString()
					+ "]");
		}

	}
	/**
	 * 
	 * @return
	 */
	public Tool buyATool(){
		int selection = 0;
		viewToolsDatabase();
		System.out.println("To cancel purchase enter -1");
		System.out.println("Selection:");
		while (selection != -1){
			selection = Integer.parseInt(input.next());
			if (selection > 0 && selection < tools.size() + 1){
				if(buyer.getMoney() > tools.get(selection -1).getCost()){
					buyer.updateMoney(tools.get(selection-1).getCost());
					return tools.get(selection - 1);
				}
			}else{
				System.out.println("Invalid selection: ");
			}
		}
		System.out.println("No tool bought");
		return null;
	}
}
