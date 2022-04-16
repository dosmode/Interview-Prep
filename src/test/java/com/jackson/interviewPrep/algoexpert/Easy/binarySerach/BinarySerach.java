package com.jackson.interviewPrep.algoexpert.Easy.binarySerach;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class ProgramTest {
	@Test
	public void TestCase1() {
		assertTrue(
				Program.binarySearch(new int[] {0, 1, 21, 33, 45, 45, 61, 71, 72, 73}, 33) == 3);
	}
}

class Program {
	public static int binarySearch(int[] array, int target) {
		return binarySearch(array, target, 0, array.length - 1);
	}

	public static int binarySearch(int[] array, int target, int start, int end) {
		if(start>end) return -1;

		int middlePoint =( start + end) / 2;
		if (target < array[middlePoint]) {
			return binarySearch(array, target, start, middlePoint-1);
		} else if (target > array[middlePoint]) {
			return binarySearch(array, target, middlePoint+1, end);
		} else{
			return middlePoint;
		}
	}
}
