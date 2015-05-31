package fhmqpd.cs3330.lab3;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;


/*
 * Name: Francois Mariette
 * Lab: 3
 * Section: E
 * PawPrint: fhmqpd
 * Date: 2/17/14
 * Submission Code: Icecream Sandwich
 */


public class MKDriver {

	public static void main(String[] args) {
		
		// File object and ArrayList instantiation
		File fighterDataFile = new File ("Fighters.data");
		ArrayList<Fighter> Fighters = new ArrayList<Fighter>();
		
		Scanner	dataScanner	= null;	
		
		System.out.println("!!!Welcome to Mortal Kombat!!!");
		System.out.println("\n");
		
		// Exception catching for the loading of the data file. 
		try	{
		 	 dataScanner = new Scanner(fighterDataFile);
		 	 System.out.println("Loading Data...");
		 }	catch	(FileNotFoundException	e)	{	
		 	 System.out.println("Error:	Fighter	stats file not found.");
		 	 System.exit(0); 
		 }
		
		/*
		 * This takes a full string and then splits the string into tokens with a ","
		 * delimiter. It keeps inputting strings until the end of the file is reached.
		 * Each string is added to the Fighters ArrayList and parsed appropriately.  
		 */
		String string = null;
		String[] tokens = null;
	 	 while (dataScanner.hasNextLine()){
	 		 string = dataScanner.nextLine();
	 		 tokens = string.split(",");
	 		 Fighters.add(new Fighter(tokens[0], Integer.parseInt(tokens[1]))); 
	 	 }
	 	 // Closes the scanner upon completion of gathering input to prevent leaks.
	 	 System.out.println("Loading completed!");
	 	 System.out.println("\n");
		 dataScanner.close();
		
		// This code outputs all the fighters in the ArrayList using the Iterator class
		System.out.println("Here's the list of Fighters:");
		Iterator<Fighter> fighterIT = Fighters.iterator();
		while (fighterIT.hasNext()){
			System.out.println(fighterIT.next().toString());
		}
		
		System.out.println("\n"); 
		System.out.println("3...2...1...Fight!!!");
		System.out.println("\n"); 
		
		/*
		 *  Initializes/declares variables outside of the while loop to make the program more
		 * efficient. The while loop randomly generates numbers to determine fighter hit as
		 * well as the distance between the two fighters. Using the Math.random() as the Random
		 * class was not re-seeding causing the numbers to not truly be random. 
		 */ 
		int fighterHit = 0;
		int distance;
		
		while (Fighters.get(fighterHit).getAlive()){
			fighterHit = (int)(Math.random() * 2);
			distance = (int)(Math.random() * 11);
			Fighters.get(fighterHit).beingHit(distance);;
		}
		
		System.out.println("Round over...");
		
		
		/* 
		 * Loops through the fighters to announce a winner. This will only work with a 1v1 fight
		 * Iterates back through the ArrayList checking for the victor that is alive.  
		 */
		fighterIT = Fighters.iterator();
		while (fighterIT.hasNext()){
			Fighter winner = fighterIT.next();
			if (winner.getAlive() == true){
				System.out.println(winner.getName() + " won!");
			}
		}
		
	}

}
