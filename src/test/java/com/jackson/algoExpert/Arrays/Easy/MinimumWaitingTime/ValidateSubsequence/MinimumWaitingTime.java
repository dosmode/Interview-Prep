package com.jackson.algoExpert.Arrays.Easy.MinimumWaitingTime.ValidateSubsequence;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ProgramTest {
	@Test
	public void TestCase1() {
		int[] queries = new int[] {3, 2, 1, 2, 6};
		int expected = 17;
		var actual = new com.jackson.algoExpert.Arrays.Easy.MinimumWaitingTime.ValidateSubsequence.MinimumWaitingTime().minimumWaitingTime(queries);
		assertTrue(actual == expected);
	}
}

class MinimumWaitingTime {
	public int minimumWaitingTime(int[] queries) {
		Arrays.sort(queries);
		int result = 0;
		int counter = 0;
		for(int i  : queries){

			result += i * ( queries.length - counter -1 );
			counter++;
		}
		return result;
	}
}
