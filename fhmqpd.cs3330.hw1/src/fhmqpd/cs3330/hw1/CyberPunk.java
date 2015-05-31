package fhmqpd.cs3330.hw1;
/*
 * Name: Francois Mariette
 * Pawprint: FHMQPD
 * Date: 2/28/14
 * Lead TA: Chao Fang
 * Lab section: E
 */

import java.util.Scanner;

public class CyberPunk {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter your name:");
		String name = input.nextLine();
		Player player = new Player(name);
		System.out.println("The year is 2077");
		System.out.println(player.toString());
		
		System.out.println("Starting Console");
		Console console = new Console(player);
		
		while (console.use()){}
		System.out.println("Game Over");
		
		input.close();
	}

}
