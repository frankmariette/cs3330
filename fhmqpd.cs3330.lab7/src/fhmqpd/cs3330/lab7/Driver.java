package fhmqpd.cs3330.lab7;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;

/*
 * Name: Francois Mariette
 * PawPrint: FHMQPD
 * Section: E
 * Submission code: Donut
 */

public class Driver {

	public static void main(String[] args) {
		String name, age, balance, list = "Person List:\n\n";

		ArrayList<Person> people = new ArrayList<Person>();

		// Checks after each variable is entered if the user wants to quit. The
		// while condition is redundant as the break has to occur after the loop
		// starts.
		while (true) {
			JOptionPane.showMessageDialog(null,
					"Enter person info or q to quit");
			name = JOptionPane.showInputDialog("Please enter a name:",
					JOptionPane.QUESTION_MESSAGE);
			if (name == null) {
				continue;
			}
			if (name.equals("q")) {
				break;
			}

			try {
				isName(name);
			} catch (InvalidNameException e) {
				JOptionPane.showMessageDialog(null, e, "Name Error",
						JOptionPane.ERROR_MESSAGE);
				continue;
			}
			age = JOptionPane.showInputDialog(
					"Please enter an age for this person: ",
					JOptionPane.QUESTION_MESSAGE);

			if (age.equals("q")) {
				break;
			}
			try {
				isValidAge(age);
			} catch (InvalidAgeException e) {
				JOptionPane.showMessageDialog(null, e, "Age Error",
						JOptionPane.ERROR_MESSAGE);
				continue;
			}
			balance = JOptionPane
					.showInputDialog("Please enter a bank account balance for this person: ");
			if (balance.equals("q")) {
				break;
			}
			try {
				isBalance(balance);
			} catch (InvalidBalanceException e) {
				JOptionPane.showMessageDialog(null, e, "Balance Error",
						JOptionPane.ERROR_MESSAGE);
				continue;
			}
			// Only runs if everything entered is valid
			people.add(new Person(Integer.parseInt(age), name, Double
					.parseDouble(balance)));
			JOptionPane.showMessageDialog(null, name + ", aged " + age
					+ "with balance " + balance
					+ "has been added to your list.");
		}

		if (people.isEmpty()) {
			JOptionPane
					.showMessageDialog(null, "You did not enter any people.");
		} else {
			// Quick loop to print out ArrayList
			for (int i = 0; i < people.size(); i++) {
				list = list + "\n\n" + (people.get(i).toString());
			}
			JOptionPane.showMessageDialog(null, list);
		}
	}

	/*
	 * Makes sure the input entered can be converted into a double. Throws an
	 * error if it can't be.
	 */
	public static void isBalance(String input) throws InvalidBalanceException {

		if (input.isEmpty()) {
			throw new InvalidBalanceException("You did not enter a balance");
		}
		try {
			Double.parseDouble(input);
		} catch (NumberFormatException e) {
			throw new InvalidBalanceException("Not a number.");
		}
	}

	/*
	 * Uses a RegEx to check the string for digits or special chars. If the
	 * Matcher finds any it returns true and throws an error. Also checks if the
	 * name entered is empty
	 */
	public static void isName(String input) throws InvalidNameException {
		String pattern = "[0-9\\p{Punct}]";
		Pattern re = Pattern.compile(pattern);
		Matcher match = re.matcher(input);

		if (match.find()) {
			throw new InvalidNameException("You have entered an invalid name.");
		} else if (input.isEmpty()) {
			throw new InvalidNameException("You did not enter a name.");
		}

	}

	/*
	 * Validates that age entered is between 0 and 150.
	 */
	public static void isValidAge(String input) throws InvalidAgeException {
		if (input.isEmpty()) {
			throw new InvalidAgeException("You did not enter an age");
		}
		try {
			int age = Integer.parseInt(input);
			if (age <= 0 || age >= 150) {
				throw new InvalidAgeException(
						"Input can't be negative or over 150");
			}
		} catch (NumberFormatException e) {
			throw new InvalidAgeException("Input is not a number!");
		}
	}
}
