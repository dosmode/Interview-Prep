package com.jackson.interviewPrep.algoexpert.Easy.ProductSum;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

// This file is initialized with a code version of this
// question's sample test case. Feel free to add, edit,
// or remove test cases in this file as you see fit!

import java.util.*;

class ProgramTest {
	@Test
	public void TestCase1() {
		List<Object> test =
				new ArrayList<Object>(
						Arrays.asList(
								5,
								2,
								new ArrayList<Object>(Arrays.asList(7, -1)),
								3,
								new ArrayList<Object>(
										Arrays.asList(6, new ArrayList<Object>(Arrays.asList(-13, 8)), 4))));
		assertTrue(Program.productSum(test) == 12);
	}
}




class Program {
	// Tip: You can use `element instanceof ArrayList` to check whether an item
	// is an array or an integer.
	public static int productSum(List<Object> array) {

		return productSumWithLevel(array, 1);
	}
	public static int productSumWithLevel(List<Object> array, int level) {
		int sum = 0;
		for(Object element : array){
			if(element instanceof ArrayList){
				sum += productSumWithLevel((List) element, level + 1);
			}else{
				sum += (int) element;
			}
		}
		return sum * level;
	}
}
