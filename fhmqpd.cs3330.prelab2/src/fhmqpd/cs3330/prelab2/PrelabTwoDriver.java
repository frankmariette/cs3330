/*************************************
 * Name Francois Mariette
 * Lab: 2
 * Section: E
 * Date: 2/10/14
 * Description: Prelab 2
 * Submission Code:
 * 
 * @author Frank
 *
*****************************************/
package fhmqpd.cs3330.prelab2;

import java.util.Scanner;

public class PrelabTwoDriver {
	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		System.out.println("How many people?");
		int entries = Integer.parseInt(scanner.nextLine());
		
		// Create an array of objects of type Person.
		Person[] people = new Person[entries];
		
		/*
		 * Here you should read in user input and instantiate
		 * Person objects depending on what user inputs.
		 */
		for (int i = 0; i < entries; ++i){
			System.out.println("Enter the name of person " + (i+1));
			String name = scanner.nextLine();
			System.out.println("Enter the age of person " + (i+1));
			int age = Integer.parseInt(scanner.nextLine());
			System.out.println("Enter the gender of the person " + (i+1));
			String gender = scanner.nextLine();
			
			people[i] = new Person(name, age, gender);
		}
		
		for (int i = 0; i < entries; ++i){
			System.out.println("Stats: " + people[i].getName() + ", " + people[i].getAge() + ", " + people[i].getGender());
		}
		
		// code to print arrays of objects
		scanner.close();
		System.exit(0);
	}
}
