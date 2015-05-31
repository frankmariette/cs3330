/**
 * Name: Francois Mariette
 * Lab: 1
 * Section: E
 * Date: 1/31/14
 * Description: Prelab 1 Driver
 * Submission Code:
 * 
 */
package fhmqpd.cs3330.prelab1;

/**
 * @author fhmqpd
 *
 */

import java.util.Scanner;

public class PreLabOneDriver {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// Instantiate a Scanner class for reading input
		// from the keyboard
		Scanner input = new Scanner(System.in);
		
		// Ask user for input
		System.out.print("Enter num one:");
		
		//Scan in an integer from stdin buffer using the scanner class
		int num_1 = input.nextInt();
		
		System.out.print("Enter num two:");
		int num_2 = input.nextInt();
		
		// Instantiate the Adder class for addition. 
		// Calling the objects constructors
		Adder a = new Adder(num_1, num_2);
		
		// Calling the add method
		int result = a.add();
		
		// Display the results to user
		System.out.println("The sum of " + num_1 + " and " + num_2 + " = " + result);
		
		// Closing the Scanner class.
		input.close();
		
		// Return 0 for success
		System.exit(0);
		

	}

}
