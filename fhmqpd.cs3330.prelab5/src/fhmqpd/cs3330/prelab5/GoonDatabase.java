package fhmqpd.cs3330.prelab5;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;
import java.util.Scanner;

public class GoonDatabase {
	private TreeMap<String, Goon> goonDB = new TreeMap<String, Goon>();
	private final Scanner input = new Scanner(System.in);
	
	
	public GoonDatabase(String fileName){
		importFile(fileName);
	}
	/*
	 * Inputs values from the user and exits upon the user entering q. I placed a second check inside the loop to prevent a query
	 * from being initiated after the initial user input. After they query is performed the results are printed out for the user.
	 */
	public void searchMenu(){
		String query = "";
		while(!query.equals("q")){
			System.out.println("Please enter your query (q to exit): ");
			query = input.nextLine();
			if (!query.equals("q")){
				ArrayList<Goon> result = searchDatabase(query);
				if(result.size() > 0){
					for (int i = 0; i < result.size(); i++) {
						System.out.println((i + 1) + " - "
								+ result.get(i).getName());
					}
				}
				else{
					System.out.println("No results found...");
				}
			}
			
			
		}
		System.out.println("Program complete");
		input.close();
		System.exit(0);
		
	}
	/*
	 * Imports a file into the program and then proceeds to sort the information based on type provided in the datafile. If the type doesn't
	 * meet the parameters of an available class the program will output an error message and continue on. The program closes the Scanner object
	 * used to import the file at the end of the method.
	 */
	protected void importFile(String fileName){
		File goonDatafile = new File(fileName);
		Scanner dataScanner = null;
		String type = null;
		String name = null;
		String DOB = null;
		String mobName = null;
		String skill = null;
		String sector = null;
		int netWorth;
		
		
		try{
			dataScanner = new Scanner(goonDatafile);
		}catch(FileNotFoundException e) {
			System.out.println("Error: Unable to load data file");
		}
		
		while (dataScanner.hasNextLine()){
			Scanner line = new Scanner(dataScanner.nextLine());
			line.useDelimiter(",");
			type = line.next();
			name = line.next();
			DOB = line.next();
			
			if(type.equals("Overseer")){
				sector = line.next();
				goonDB.put(type + " "+ name, new Overseer(name, DOB, sector));
				
			}
			else if(type.equals("Don")){
				mobName = line.next();
				netWorth = Integer.parseInt(line.next());
				goonDB.put(type + " "+ name,  new Don(name, DOB, mobName, netWorth));
			}
			else if(type.equals("Talent")){
				skill = line.next();
				goonDB.put(type + " "+ name, new Talent(name, DOB, skill));
			}
			else{
				System.out.println("Invalid input");
			}
			line.close();
		}
		dataScanner.close();
		System.out.println("Import completed.");
		
	}
	
	/*
	 * This function searchs the database in n*log(n) time. The method instantiates a new instance of ArrayList<Goon>
	 * to prevent the list from returning values from previous queries.  Returns an ArrayList.
	 */
	protected ArrayList<Goon> searchDatabase(String input){
		
		input = Character.toUpperCase(input.charAt(0)) + input.substring(1);
		ArrayList<Goon> goonAL = new ArrayList<Goon>(); 
		// Loops through the treemap and adds correct values to an array list
	        for (Map.Entry<String, Goon> entry : goonDB.entrySet()) {
	        	if(entry.getKey().contains(input)){
	        		goonAL.add(entry.getValue());
	        	}
	        }
	        
	   return goonAL;
	}
	
	
}

