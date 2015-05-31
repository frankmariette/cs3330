package fhmqpd.cs3330.Prelab2;

	import java.util.Scanner; 

import fhmqpd.cs3330.PrelabTwo.Person;
 
public class PrelabTwoDriver { 
 public static void main(String[] args) { 
 Scanner scanner = new Scanner(System.in); 
 System.out.println("How many people?"); 
 int entries = Integer.parseInt(scanner.nextLine()); 
 
 //Create an array of objects of type Person. 
 Person[] people = new Person[entries]; 
 
 /* 
 Here you should read in user input and instantiate 
 Person objects depending on what the user inputs. 
 */ 
 
 for (int i =0; i < entries; ++i){
	 System.out.println("What is the name of Person " + (i+1));
	 String name = scanner.nextLine();
	 
	 System.out.println("What is the age of Person " + (i+1));
	 int age = Integer.parseInt(scanner.nextLine());
	 
	 System.out.println("What is the gender of Person " + (i+1));
	 String gender = scanner.nextLine();
	 
	 people[i] = new Person(name, age, gender);
 }
 
 //Write code to print out the array of objects and 
//their attributes 
 
 for ( int i =0; i < entries; ++i){
	 System.out.println("Stats: " + people[i].getName() + ", " + people[i].getAge() + ", " + people[i].getGender());
 }
 
 System.out.println("Enter first string: ");
 String a = scanner.nextLine();

 System.out.println("Enter second strin: ");
 String b = scanner.nextLine();
 
 if (a.contains(b)){
	 System.out.println("String 'b' is a sub-string of String 'a'.");
 }
 else {
	 System.out.println("String 'a' and 'b' are not sub strings of each other.");
 }
 
 
 scanner.close(); 
 System.exit(0); 
 } 
} 


