/**
 * This program uses a recursive method to determine if a String is a palindrome (the same forwards and backwards).
 * It first filters out any whitespace and punctuation, and capitalizes all letters. This program is not case sensitive.
 * 
 * 
 * @author Tyler Wilkinson
 * @date November 26, 2021
 */

import java.util.Scanner;

public class IsPalindrome {
	/**
	 * filters and processes a String to determine if it is a palindrome.
	 * @param string	an input string
	 * @return	boolean is true if the input string is the same forwards and backwards.
	 */
	public static boolean isPalindrome(String string) {
		
		// Capitalize all letters, remove all punctuation and whitespace.
		string = string.toUpperCase().replaceAll("\\p{Punct}","").replaceAll("\\s", ""); 
		
		
		// Set the default to true
		boolean isItPal = true;
		
		
		// If the length of the string is greater than 1, compare the first and last characters
		if (string.length() > 1) {
			
			if (string.charAt(0) != string.charAt(string.length() - 1)) {
				// The first and last chars don't match... not a palindrome
				isItPal = false;
			}
			else {
				// chop off the first and last characters, call the method with the new String
				isItPal = isPalindrome(string.substring(1, string.length() - 1));
			}
		}
		
		// return boolean value
		return isItPal;
	
	}
	

	
	public static void main(String[] args) {

		// Scanner input
		Scanner keyboard = new Scanner(System.in);
		
		// Loop the palindrome test until the user opts out
		do {
			System.out.print("Enter a word or phrase to see if it is a palindrome: ");
			if(isPalindrome(keyboard.nextLine())) {
				System.out.println("Yes, that's a palindrome!");
			}
			else {
				System.out.println("Nope, not a palindrome!");
			}
			
			System.out.print("Press ENTER to continue... (Any key + ENTER to quit)" );
		} while (keyboard.nextLine() == "");
		
		keyboard.close();
		
		System.out.println("\nGoodbye.");
	}
}
