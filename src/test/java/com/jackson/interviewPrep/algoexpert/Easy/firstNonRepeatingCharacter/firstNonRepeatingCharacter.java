package com.jackson.interviewPrep.algoexpert.Easy.firstNonRepeatingCharacter;

import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertTrue;

class ProgramTest {
	@Test
	public void TestCase1() {
		String input = "abcdcaf";
		int expected = 1;
		var actual = new Program().firstNonRepeatingCharacter(input);
		assertTrue(expected == actual);
	}
}
class Program {
	public int firstNonRepeatingCharacter(String string) {
		HashMap<Character, Integer> hashMap = new HashMap<>();
		for(char c : string.toCharArray()){
			hashMap.put(c, hashMap.getOrDefault(c,0) +1);
		}

		for(int i =0; string.length() > i ; i++){
			if(hashMap.get(string.charAt(i)) == 1){
				return i;
			}
		}
		return -1;
	}
}
