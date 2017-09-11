package anagramGenerator;

import java.util.Scanner;

public class Interface {
/*
 * Interface klasse dient om in de console uw letters in te vullen en dan de resultaten te verkrijgen, alsook de tijd hoe lang het geduurd heeft.
 */
	public static void main(String args[]) {
		WordGenerator scrabbler = new WordGenerator();
		System.out.println("Typ uw letters in ");
		Scanner scanner = new Scanner(System.in);
		String letters = scanner.nextLine();
		long a = System.nanoTime();
		scrabbler.generator(letters);
		scrabbler.print();
		System.out.print((double)((System.nanoTime()-a)/1000000000)+ "seconden");
		scanner.close();
	}
}