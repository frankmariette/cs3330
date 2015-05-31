package fhmqpd.cs3330.lab6;
/*
 * Name: Francois Mariette
 * PawPrint: fhmqpd
 * Lab: 7
 * Section: e
 * Submission Code: cupcake
 * Date: 03/17/14
 */
public class DatabaseDriver {

	public static void main(String[] args) {
		Database empDB = new Database("empData.csv");
		
		empDB.searchMenu();

	}

}
