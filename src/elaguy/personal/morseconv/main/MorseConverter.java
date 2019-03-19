package elaguy.personal.morseconv.main;

/*
 * A command-line text to Morse code and vice versa (non-audio)
 * 
 * by Elaguy (Austin Schultz) (C) 2016 (Updated January 2019)
 */

public class MorseConverter {
	
	private Converter converter;
	private Display display;
	
	public void startConverter() {
		String input = display.getUserInput().toLowerCase();
		String output;
		
		if(isAlphanumeric(input))
			output = converter.textToMorse(input);
		
		
		else if(isMorse(input))
			output = converter.morseToText(input);
		
		else
			output = "Cannot interpret input!";
		
		System.out.println(output);
	}
	
	private boolean isAlphanumeric(String str) {
		for(int i = 0; i < str.length(); i++) {
			char current = str.charAt(i);
			
			if(!Character.isLetter(current) && !Character.isDigit(current) && current != ' ')
				return false;
		}
		
		return true;
	}
	
	private boolean isMorse(String str) {
		for(int i = 0; i < str.length(); i++) {
			char current = str.charAt(i);
			
			if(current != '.' && current != '-' && current != '/' && current != ' ')
				return false;
		}
		
		return true;
	}
	
	public static void main(String[] args) {
		MorseConverter ms = new MorseConverter();
		ms.converter = new Converter();
		ms.display = new Display();
		
		ms.startConverter();
	}
	
}