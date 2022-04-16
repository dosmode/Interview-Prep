package com.jackson.interviewPrep.algoexpert.Easy.FindThreeLargestNumbers;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class ProgramTest {
	@Test
	public void TestCase1() {
		int[] expected = {18, 141, 541};
		assertTrue(
				compare(
						Program.findThreeLargestNumbers(new int[] {141, 1, 17, -7, -17, -27, 18, 541, 8, 7, 7}),
						expected));
	}

	public boolean compare(int[] arr1, int[] arr2) {
		if (arr1.length != arr2.length) {
			return false;
		}
		for (int i = 0; i < arr1.length; i++) {
			if (arr1[i] != arr2[i]) {
				return false;
			}
		}
		return true;
	}
}

class Program {
	public static int[] findThreeLargestNumbers(int[] array) {
		int temp[] = {Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE};
		for (int i : array) {
			findLocation(i, temp);
		}
		return temp;
	}

	public static void findLocation(int number, int[] temp) {
		if (number > temp[2]) {
			locationShifter(number, temp, 2);
		} else if (number > temp[1]) {
			locationShifter(number, temp, 1);
		} else if (number > temp[0]) {
			locationShifter(number, temp, 0);

		}
	}

	public static void locationShifter(int number, int[] temp, int index) {
		for (int i = 0; i <= index; i++) {
			if (index == i) {
				temp[i] = number;
			} else {
				temp[i] = temp[i + 1];
			}

		}
	}
}