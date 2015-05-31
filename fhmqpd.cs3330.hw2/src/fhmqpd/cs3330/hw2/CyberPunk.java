package fhmqpd.cs3330.hw2;
import java.util.Scanner;

/*
 * Name: Francois Mariette
 * Date: 03/21/2014
 * Lab: E
 * TA: Chao Fang
 * 
 */

public class CyberPunk {
	private static final Scanner input = new Scanner(System.in);
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.print("Enter your name: ");
		String name = input.nextLine();
		Player player = new Player(name);
		Grid grid = new Grid();
		System.out.println("The year is 2077");
		System.out.println("Starting Console");
		Console console = new Console(player, grid);
		while(console.use()) {
			;
		}
		input.close();
		System.out.println("Game over!");
		System.exit(0);
			
	}

}

