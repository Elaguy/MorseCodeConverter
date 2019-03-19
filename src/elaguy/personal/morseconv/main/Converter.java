package elaguy.personal.morseconv.main;

public class Converter {
	
	// Indexes corresponds to letters, EX: A = 0, B = 1, etc...
	// After Z (--..), numbers begin at index 25, starting with 1
	private String[] morseAlphabet = {".-", "-...", "-.-.",
			"-..", ".", "..-.", "--.", "....", "..", ".---",
			"-.-", ".-..", "--", "-.", "---", ".--.", "--.-",
			".-.", "...", "-", "..-", "...-", ".--", "-..-",
			"-.--", "--..", ".----", "..---", "...--", "....-",
			".....", "-....", "--...", "---..", "----.", "-----"};
	
	private char[] alphabet = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i',
			'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't',
			'u', 'v', 'w', 'x', 'y', 'z', '1', '2', '3', '4', '5',
			'6', '7', '8', '9', '0'};
	
	// Seperation of words are represented by '/' (in morse output)
	public String textToMorse(String input) {
		String output = "";
		
		for(int i = 0; i < input.length(); i++) {
			if(input.charAt(i) == ' ') {
				output += "/ ";
			}
			
			else if(i == input.length()-1) {
				output += morseAlphabet[getMorseIndex(input.charAt(i))];
			}
			
			else {
				output += morseAlphabet[getMorseIndex(input.charAt(i))] + " ";
			}
		}
		
		return output;
	}
	
	public String morseToText(String input) {
		String output = "";
		String[] inputArray = input.split(" ");
		
		for(int i = 0; i < inputArray.length; i++) {
			if(inputArray[i].equals("/")) {
				output += " ";
			}
			
			else {
				output += alphabet[getAlphabetIndex(inputArray[i])];
			}
		}
		
		return output;
	}
	
	// Returns the index a given char/letter will correspond to
	// on the morseAlphabet array
	public int getMorseIndex(char letter) {
		int index = 0;
		
		for(int i = 0; i < alphabet.length; i++) {
			if(letter == alphabet[i]) {
				index = i;
				break;
			}
		}
		
		return index;
	}
	
	public int getAlphabetIndex(String morseLetter) {
		int index = 0;
		
		for(int i  = 0; i < morseAlphabet.length; i++) {
			if(morseLetter.equals(morseAlphabet[i])) {
				index = i;
				break;
			}
		}
		
		return index;
	}
	
}
