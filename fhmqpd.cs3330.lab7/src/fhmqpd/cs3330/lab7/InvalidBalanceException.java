package fhmqpd.cs3330.lab7;

/*
 * Name: Francois Mariette
 * PawPrint: FHMQPD
 * Section: E
 * Submission code: Gingerbread
 */

@SuppressWarnings("serial")
public class InvalidBalanceException extends Exception{
	public InvalidBalanceException(){
		
	}
	
	public InvalidBalanceException(String error){
		super(error);
	}
}
