package com.jackson.interviewPrep.algoexpert.medium.firstDuplicateValue;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertTrue;


class ProgramTest {
	@Test
	public void TestCase1() {
		var input = new int[] {2, 1, 5, 2, 3, 3, 4};
		var expected = 2;
		var actual = new Program().firstDuplicateValue(input);
		assertTrue(expected == actual);
	}
}
class Program {

	public int firstDuplicateValue(int[] array) {

		Set<Integer> test = new HashSet<>();

		for(int a:array){
			if(test.contains(a)){
				return a;
			}else{
				test.add(a);
			}
		}
		return -1;
	}
}
