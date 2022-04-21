package com.jackson.interviewPrep.algoexpert.Easy.GenerateDocument;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertTrue;

class ProgramTest {
	@Test
	public void TestCase1() {
		String characters = "Bste!hetsi ogEAxpelrt x ";
		String document = "AlgoExpert is the Best!";
		boolean expected = true;
		var actual = new Program().generateDocument(characters, document);

		assertTrue(expected == actual);
	}
}

class Program {
	public boolean generateDocument(String characters, String document) {
		HashMap<Character, Integer> charactersMap = new HashMap<>();

		for(char c : characters.toCharArray()){
			charactersMap.put(c, charactersMap.getOrDefault(c,0) +1) ;
		}
		for(char d : document.toCharArray()){
			charactersMap.put(d, charactersMap.getOrDefault(d,0) -1) ;
			if(charactersMap.get(d) == -1){
				return false;
			}
		}
		return true;
	}
}
