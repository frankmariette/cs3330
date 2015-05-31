package fhmqpd.cs3330.lab7;

/*
 * Name: Francois Mariette
 * PawPrint: FHMQPD
 * Section: E
 * Submission code: Gingerbread
 */

@SuppressWarnings("serial")
public class InvalidAgeException extends Exception {
	public InvalidAgeException(){
		
	}
	
	public InvalidAgeException(String error){
		super(error);
	}
}
