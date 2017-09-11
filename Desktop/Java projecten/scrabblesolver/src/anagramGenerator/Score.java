package anagramGenerator;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Score {
	private ArrayList<String> woordenlijst = new ArrayList<String>(354999);
	private Scanner scanner;
	/*
	 * Constructor, die ook het woordenlijst maakt uit het tekstbestand die gebruikt wordt in de methode zoeken().
	 */
	public Score(){
		try{
			scanner = new Scanner(new File("C:\\Users\\eigenaar\\Desktop\\Java projecten\\ScrabbleSolver\\src\\anagramGenerator\\words.txt"));
			while (scanner.hasNextLine()){
				woordenlijst.add(scanner.nextLine());
			}
		} catch (Exception e){
			
		}
		scanner.close();
	}
	
	/*
	 * Methode die gebruikt word om het woord uit het woordenlijst te vergelijken met de gevormde permutaties.
	 * Indien dit gelijk is, dan wordt de score opgeteld van het gecreëerde woord en wordt deze waarde gereturned.
	 */
	public String zoeken(String woord){
		for(String lijstwoord : woordenlijst){
			if(woord.equals(lijstwoord)){
				Integer resultaat = 0;
				StringBuffer characters = new StringBuffer(woord);
				for(int i = 0; i < characters.length(); i++){
					char letter = characters.charAt(i);
					switch (letter){
						case 'z': case 'q': resultaat += 10; break;
						case 'j': case 'x': resultaat += 8; break;
						case 'k': resultaat += 5; break;
						case 'f': case 'h': case 'v': case 'w': case 'y': resultaat += 4; break;
						case 'b': case 'c': case 'm': case 'p': resultaat += 3; break;
						case 'd': case 'g': resultaat += 2; break;
						case 'a': case 'e': case 'i': case 'l': case 'n': case 'o': case 'r': case 's': case 't': case 'u': resultaat += 1; break;
					}
				}
				return resultaat.toString();
			}
		}
		return "0";
	}
}