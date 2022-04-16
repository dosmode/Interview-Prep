package com.jackson.interviewPrep.algoexpert.Easy.TwoNumberSum;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class TwoNumberSum {
	final Logger logger = LoggerFactory.getLogger(TwoNumberSum.class);

	@Test
	void contextLoads() {
		twoNumberSum(new int[]{1, 2, 3, 4, 5, 6}, 4);
	}


	public int[] twoNumberSum(int[] array, int targetSum) {

		Set<Integer> hashSet = new HashSet<>();
		Arrays.stream(array).forEach(x -> hashSet.add(x));
		for (int element : array) {
			if (hashSet.contains(targetSum - element) && element != targetSum - element) {
				int[] result = new int[]{element, targetSum - element};
				logger.info(Arrays.toString(result));
				return result;
			}
		}
		return new int[0];
	}
}
