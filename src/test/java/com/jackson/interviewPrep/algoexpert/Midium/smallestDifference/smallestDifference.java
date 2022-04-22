package com.jackson.interviewPrep.algoexpert.Midium.smallestDifference;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

class ProgramTest {
	@Test
	public void TestCase1() {
		int[] expected = {28, 26};
		assertTrue(
				Arrays.equals(
						Program.smallestDifference(
								new int[] {-1, 5, 10, 20, 28, 3}, new int[] {26, 134, 135, 15, 17}),
						expected));
	}
}


class Program {
	public static int[] smallestDifference(int[] arrayOne, int[] arrayTwo) {
		int smallestNumber = Integer.MAX_VALUE;
		int[] result = new int[0];
		Arrays.sort(arrayOne);
		Arrays.sort(arrayTwo);
		for(int one : arrayOne){
			for(int two : arrayTwo){
				if(smallestNumber > Integer.min(smallestNumber, Math.abs(one - two))){
					result = new int[]{one, two};
					smallestNumber=Math.abs(one - two);
				}

			}
		}
		return result;
	}
}