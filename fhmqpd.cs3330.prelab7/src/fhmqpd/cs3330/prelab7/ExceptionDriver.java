package fhmqpd.cs3330.prelab7;

import java.lang.reflect.Array;
import java.util.Scanner;

public class ExceptionDriver {

	public static void main(String[] args) {
		final Scanner input = new Scanner(System.in);
		
		while(!input.equals("quit")){
			System.out.println("Enter:");
			String word = input.nextLine();
			isWord(word);
			
		}
		
		
		input.close();
	}
	
	public static void isWord(String word){
		char[] invalid = null;
		
		for (int i = 0; i < 10; i++){
			invalid[i] = (char) i;
		}
		
	}

}
