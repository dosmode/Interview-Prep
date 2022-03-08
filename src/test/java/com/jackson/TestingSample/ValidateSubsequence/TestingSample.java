package com.jackson.TestingSample.ValidateSubsequence;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertTrue;

class ProgramTest {
	@Test
	public void TestCase1() {
		int[] queries = new int[] {3, 2, 1, 2, 6};
		int expected = 17;
		var actual = new Program().minimumWaitingTime(queries);
		assertTrue(actual == expected);
	}
}

class Program {
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
