package fhmqpd.cs3330.prelab5;

/*
 * Name: Francois Mariette
 * Lab: 5
 * Section: E
 * Submission Code: Honeycomb
 */

public class DatabaseDriver {

	public static void main(String[] args) {
		GoonDatabase goonDB = new GoonDatabase("goons.csv");
		goonDB.searchMenu();
	}

}
