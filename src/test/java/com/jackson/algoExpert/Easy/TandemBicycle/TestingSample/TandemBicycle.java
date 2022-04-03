package com.jackson.algoExpert.Easy.TandemBicycle.TestingSample;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertTrue;

class ProgramTest {
	@Test
	public void TestCase1() {
		int[] redShirtSpeeds = new int[] {5, 5, 3, 9, 2};
		int[] blueShirtSpeeds = new int[] {3, 6, 7, 2, 1};
		boolean fastest = true;
		int expected = 32;
		var actual = new Program().tandemBicycle(redShirtSpeeds, blueShirtSpeeds, fastest);
		assertTrue(expected == actual);
	}
}

class Program {
	public int tandemBicycle(int[] redShirtSpeeds, int[] blueShirtSpeeds, boolean fastest) {

		Arrays.sort(redShirtSpeeds);
		Arrays.sort(blueShirtSpeeds);

		int result = 0 ;

		if(fastest){
			int counter = 0;
			for(int i = redShirtSpeeds.length-1 ; i >=0 ; i--){
				result += Math.max(redShirtSpeeds[i], blueShirtSpeeds[counter]);
				counter++;
			}
		}else{
			for(int i = 0 ; i < redShirtSpeeds.length ; i++){
				result += Math.max(redShirtSpeeds[i], blueShirtSpeeds[i]);
			}
		}
		return result;
	}
}
