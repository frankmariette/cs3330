package fhmqpd.cs3330.lab7;

/*
 * Name: Francois Mariette
 * PawPrint: FHMQPD
 * Section: E
 * Submission code: Gingerbread
 */

@SuppressWarnings("serial")
public class InvalidNameException extends Exception {
	public InvalidNameException(){
		
	}
	
	public InvalidNameException(String error){
		super(error);
	}
}
