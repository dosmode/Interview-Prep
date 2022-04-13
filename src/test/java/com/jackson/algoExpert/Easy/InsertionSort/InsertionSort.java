package com.jackson.algoExpert.Easy.InsertionSort;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class ProgramTest {
	@Test
	public void TestCase1() {
		int[] expected = {2, 3, 5, 5, 6, 8, 9};
		int[] input = {8, 5, 2, 9, 5, 6, 3};
		assertTrue(compare(Program.insertionSort(input), expected));
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
	public static int[] insertionSort(int[] array) {
		for(int i =1; i < array.length  ; i++) {
			int j = i;
			while( j > 0 && array[j-1]> array[j]){
					int temp = array[j-1];
					array[j-1] = array[j];
					array[j] = temp;
					j=j-1;
			}
		}
		return array;
	}
}