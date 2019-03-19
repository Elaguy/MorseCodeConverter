package elaguy.personal.morseconv.main;

import java.util.Scanner;

public class Display {
	
	public String getUserInput() {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Enter input: ");
		String input = scanner.nextLine();
		
		return input;
	}
	
}
