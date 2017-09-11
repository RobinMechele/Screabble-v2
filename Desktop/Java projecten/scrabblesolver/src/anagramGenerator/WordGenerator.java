package anagramGenerator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;


public class WordGenerator {
	List<String> lijstPermutatie = new ArrayList<String>();
	List<String> lijstWoorden = new ArrayList<String>();
	private Score score = new Score();
	
	/*
	 * Methode die de methode permutaties zal oproepen, en achteraf de duplicates zal verwijderen
	 */
	public void generator(String characters){
		permutaties(characters);
		lijstPermutatie = lijstPermutatie.stream().distinct().collect(Collectors.toList());
	}
	
	/*
	 * Methode die de getallen zal inlezen en alle verschillende mogelijkheden in de lijstPermutatie zal bewaren.
	 */
	public void permutaties(String characters){
		int length = characters.length();
		characters.toLowerCase();
		if(length == 0){
			lijstPermutatie.add(characters);
		}
		else{
			for(int i = 0; i < length; i++){
				lijstPermutatie.add(characters);
				permutaties(characters.substring(0, i) + characters.substring(i+1, length));
			}
		}
	}
	
	/*
	 * Methode om alle gemaakte permutaties te vergelijken met het woordenboek (in de klasse Score) en de resultaten die
	 * uit score komen uitprinten op de console.
	 */
	
	public void print(){
		for(String woord : lijstPermutatie){
			if(score.zoeken(woord) != "0"){
				woord += ": " + score.zoeken(woord);
				lijstWoorden.add(woord);
			}
		}
		lijstWoorden = lijstWoorden.stream().distinct().collect(Collectors.toList());
		Collections.sort(lijstWoorden, new Comparator<String>(){			
			public int cutOfInt(String stringScore){
				String score = stringScore.replaceAll("\\D", "");
				if(score == null){
					return 0;
				}
				else{
					return Integer.parseInt(score);
				}
			}

			@Override
			public int compare(String a, String b) {
				return cutOfInt(b)-cutOfInt(a);
			}
		});
		
		for(String woorden : lijstWoorden){
			System.out.println(woorden);
		}
	}	
}