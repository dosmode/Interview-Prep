package com.jackson.interviewPrep.algoexpert.medium.longestPeak;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;


class ProgramTest {
	@Test
	public void TestCase1() {
		var input = new int[] {1, 2, 3, 3, 4, 0, 10, 6, 5, -1, -3, 2, 3};
		var expected = 6;
		var actual = Program.longestPeak(input);
		assertTrue(expected == actual);
	}
}


class Program {
	public static int longestPeak(int[] array) {
		if(array.length<3) return 0;
		int result =0;

		int increasing;
		int decreasing;
		for (int i = 1; i < array.length - 1; i++) {
			increasing = 0;
			decreasing = 0;
			int base = i;
			while (base <  array.length && array[base-1] < array[base]) {
				base++;
				increasing++;
			}
			while (base < array.length && array[base-1] > array[base] && increasing >0) {
				base++;
				decreasing++;
			}
			if (increasing > 0 && decreasing > 0) {
				result = Math.max(result, increasing + decreasing + 1);
			}
		}
		return result;
	}
}