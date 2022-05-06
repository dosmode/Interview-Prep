package com.jackson.interviewPrep.algoexpert.Midium.arrayOfProducts;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertTrue;


class ProgramTest {
	@Test
	public void TestCase1() {
		var input = new int[] {5, 1, 4, 2};
		var expected = new int[] {8, 40, 10, 20};
		int[] actual = new Program().arrayOfProducts(input);
		assertTrue(expected.length == actual.length);
		for (int i = 0; i < actual.length; i++) {
			assertTrue(actual[i] == expected[i]);
		}
	}
}

class Program {
	public int[] arrayOfProducts(int[] array) {

		int[] result = new int[array.length];
		Arrays.fill(result,1);
		for(int i = 0 ; i < array.length ; i++){
			for(int j = 0; j <array.length ; j++){
				if(i != j) {
					result[i] = result[i] * array[j];
				}
			}
		}
			return result;
	}
}
