package com.jackson.interviewPrep.algoexpert.medium.mergeOverlappingIntervals;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertTrue;


class ProgramTest {
	@Test
	public void TestCase1() {
		int[][] intervals =
				new int[][] {
						{1, 2},
						{3, 5},
						{4, 7},
						{6, 8},
						{9, 10}
				};
		int[][] expected =
				new int[][] {
						{1, 2},
						{3, 8},
						{9, 10}
				};
		int[][] actual = new Program().mergeOverlappingIntervals(intervals);
		for (int i = 0; i < actual.length; i++) {
			for (int j = 0; j < actual[i].length; j++) {
				assertTrue(expected[i][j] == actual[i][j]);
			}
		}
	}
}



class Program {

	public int[][] mergeOverlappingIntervals(int[][] intervals) {

		//Sort 2 dimensional array
		//Option 1:
		Arrays.sort(intervals , (a, b) -> Integer.compare(a[0], b[0]));
		//Option 2:
//		Arrays.sort(intervals, Comparator.comparingInt(a-> a[0]));

		List<int[]> result = new ArrayList<>();
		int[] currentInterval = intervals[0];
		result.add(currentInterval);
		for(int[] interval : intervals){
			int currentEnd = currentInterval[1];
			int nextBegin = interval[0];
			int nextEnd = interval[1];

			if(currentEnd >= nextBegin){
				currentInterval[1] = Math.max(currentEnd, nextEnd);
			}else{
				currentInterval = interval;
				result.add(currentInterval);
			}
		}
		return result.toArray(new int[result.size()][]);
	}
}
