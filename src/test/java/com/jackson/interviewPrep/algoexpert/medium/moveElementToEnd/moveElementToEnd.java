package com.jackson.interviewPrep.algoexpert.medium.moveElementToEnd;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertTrue;

class ProgramTest {
	@Test
	public void TestCase1() {
		List<Integer> array = new ArrayList<Integer>(Arrays.asList(2, 1, 2, 2, 2, 3, 4, 2));
		int toMove = 2;
		List<Integer> expectedStart = new ArrayList<Integer>(Arrays.asList(1, 3, 4));
		List<Integer> expectedEnd = new ArrayList<Integer>(Arrays.asList(2, 2, 2, 2, 2));
		List<Integer> output = Program.moveElementToEnd(array, toMove);
		List<Integer> outputStart = output.subList(0, 3);
		outputStart.sort(Comparator.naturalOrder());
		List<Integer> outputEnd = output.subList(3, output.size());
		assertTrue(outputStart.equals(expectedStart));
		assertTrue(outputEnd.equals(expectedEnd));
	}
}

class Program {
	public static List<Integer> moveElementToEnd(List<Integer> array, int toMove) {
		List<Integer> result = new LinkedList<>();
		List<Integer> temp = new LinkedList<>();
		for(Integer a: array){
			if(a==toMove){
				temp.add(a);
			}else{
				result.add(a);
			}
		}
		result.addAll(temp);
		return result;
	}
}
