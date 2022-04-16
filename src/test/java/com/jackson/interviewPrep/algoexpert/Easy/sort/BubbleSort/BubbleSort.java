package com.jackson.interviewPrep.algoexpert.Easy.sort.BubbleSort;

import org.junit.jupiter.api.Test;

import static java.util.Arrays.compare;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ProgramTest {
	@Test
	public void TestCase1() {
		int[] expected = {2, 3, 5, 5, 6, 8, 9};
		int[] input = {8, 5, 2, 9, 5, 6, 3};
		assertTrue(compare(Program.bubbleSort(input), expected));
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
	public static int[] bubbleSort(int[] array) {
		int arraySize = array.length-1;
		for(int i = 0 ; i < array.length-1; i++){
			for(int j = 0 ; j < arraySize -i ; j++){
				if(array[j] > array[j+1]){
					int temp = array[j+1];
					array[j+1] = array[j];
					array[j] = temp;
				}
			}
		}
		return array;
	}
}