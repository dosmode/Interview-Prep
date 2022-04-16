package com.jackson.interviewPrep.algoexpert.Easy.SortedSquaredArray;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ValidateSubsequence {
	final Logger logger = LoggerFactory.getLogger(ValidateSubsequence.class);

	@Test
	public void TestCase1() {
		var input = new int[]{1, 2, 3, 5, 6, 8, 9};
		var expected = new int[]{1, 4, 9, 25, 36, 64, 81};
		var actual = new Program().sortedSquaredArray(input);
		for (int i = 0; i < expected.length; i++) {
			assertTrue(expected[i] == actual[i]);
		}
	}

}

class Program {

	public int[] sortedSquaredArray(int[] array) {
		int pointer = 0 ;
		while(pointer < array.length){
			array[pointer] = (int) Math.pow(array[pointer],2);
			pointer++;
		}
		Arrays.sort(array);
		return array;
	}
}