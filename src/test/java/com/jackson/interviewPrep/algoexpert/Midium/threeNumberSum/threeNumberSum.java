package com.jackson.interviewPrep.algoexpert.Midium.threeNumberSum;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertTrue;

class ProgramTest {
	private boolean compare(List<Integer[]> triplets1, List<Integer[]> triplets2) {
		if (triplets1.size() != triplets2.size()) return false;
		for (int i = 0; i < triplets1.size(); i++) {
			if (!Arrays.equals(triplets1.get(i), triplets2.get(i))) {
				return false;
			}
		}
		return true;
	}

	@Test
	public void TestCase1() {
		List<Integer[]> expected = new ArrayList<Integer[]>();
		expected.add(new Integer[] {-8, 2, 6});
		expected.add(new Integer[] {-8, 3, 5});
		expected.add(new Integer[] {-6, 1, 5});
		List<Integer[]> output = Program.threeNumberSum(new int[] {12, 3, 1, 2, -6, 5, -8, 6}, 0);
		assertTrue(this.compare(output, expected));
	}
}


class Program {

	public static List<Integer[]> threeNumberSum(int[] array, int targetSum) {
		Arrays.sort(array);
		int arraySize = array.length -1 ;
		int[] indivisualResult = new int[0];
		List<Integer[]> result = new LinkedList<>();
		for(int index = 0; arraySize > index -2 ; index++){
			int startWindow = index +1;
			int endWindow = arraySize;
			while(startWindow < endWindow){
				if(array[index] + array[startWindow] + array[endWindow] > targetSum){
					endWindow--;
				}else if(array[index] + array[startWindow] + array[endWindow] < targetSum){
					startWindow++;
				}else if(array[index] + array[startWindow] + array[endWindow] == targetSum){
					indivisualResult = new int[]{array[index], array[startWindow] , array[endWindow]};
					startWindow++;
					endWindow--;
					result.add(Arrays.stream(indivisualResult).boxed().toArray(Integer[]::new));

				}
			}
		}

		return result;
	}
}