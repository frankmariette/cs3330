package fhmqpd.cs3330.lab6;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;




public class Database {
	private TreeMap<String, Employee> empDB = new TreeMap<String, Employee>();
	private int counter;
	private final static Scanner userInput = new Scanner(System.in);
	
	public Database(String filename){
		importFile(filename);
	}

	protected void importFile(String filename) {
		File empDatafile = new File(filename);
		Scanner dataScanner = null;
		String type = null;
		String name = null;
		String department = null;
		String langProf = null;
		int netWorth;
		int SSN;
		
		try{
			dataScanner = new Scanner(empDatafile);
		}catch(FileNotFoundException e){
			System.out.println("Error unable to load file");
			System.out.println("Exiting program");
			System.exit(1);
		}
		counter = 0;
		while (dataScanner.hasNextLine() && counter < 10){
			Scanner line = new Scanner(dataScanner.nextLine());
			line.useDelimiter(",");
			type = line.next();
			name = line.next();
			SSN = Integer.parseInt(line.next());
			
			if(type.equals("Developer")){
				langProf = line.next();
				empDB.put(type + " "+ name, new Developer(name, SSN, langProf));
				
			}
			else if(type.equals("Manager")){
				department = line.next();
				empDB.put(type + " "+ name,  new Manager(name, SSN, department));
			}
			else if(type.equals("CEO")){
				netWorth = Integer.parseInt(line.next());
				empDB.put(type + " "+ name, new CEO(name, SSN, netWorth));
			}
			else{
				System.out.println("Invalid input");
			}
			line.close();
			counter++;
		}
		dataScanner.close();
		System.out.println("Import completed.");
		
		}
	
	public void searchMenu(){
		String query = "";
		while(!query.equals("q")){
			System.out.println("Please enter your query (q to exit): ");
			query = userInput.nextLine();
			if (!query.equals("q")){
				ArrayList<Employee> result = searchDatabase(query);
				if(result.size() > 1){
					for (int i = 0; i < result.size(); i++) {
						System.out.println((i + 1) + " - "
								+ result.get(i).getName());
					}
				}
				else if(result.size() == 1){
					int index = 0;
					System.out.println(result.get(index).toString());
				}
				
				else{
					System.out.println("No results found...");
				}
			}
			
			
		}
		System.out.println("Program complete");
		userInput.close();
		System.exit(0);
	}

	
	// This search itself is in O(n) time but the addition of having to check each value two times make sit O(2n). The value is checked once to see if the base input
	// is found. If it isn't, the program will then capitalize the first letter to see if the string is contained. Will add to an arraylist if it is or continue if it
	// is not a match. 
	private ArrayList<Employee> searchDatabase(String input) {
		ArrayList<Employee> empAL = new ArrayList<Employee>();
		   for (Map.Entry<String, Employee> entry : empDB.entrySet()) {
	        	if(entry.getKey().contains(input.toLowerCase())){
	        		empAL.add(entry.getValue());
	        	}
	        	else{
	        		String temp_input = input.toLowerCase();
	        				temp_input = Character.toUpperCase(input.charAt(0)) + input.substring(1);
	        		if (entry.getKey().contains(temp_input)){
	        			empAL.add(entry.getValue());
	        		}
	        		else if(entry.getKey().contains(temp_input.toUpperCase())){
	        			empAL.add(entry.getValue());
	        		}
	        	
	        	}
	        }
	   return empAL;
	}
	
	
	
	
}
