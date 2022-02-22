package com.jackson.algoExpert.Arrays.Easy.ValidateSubsequence;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class ValidateSubsequence {
	final Logger logger = LoggerFactory.getLogger(ValidateSubsequence.class);

	@Test
	public void TestCase1() {
		var array = Arrays.asList(5, 1, 22, 25, 6, -1, 8, 10);
		var sequence = Arrays.asList(1, 6, -1, 10);
		assertEquals(true, Program.isValidSubsequence(array, sequence));
	}

}

class Program {
	public static boolean isValidSubsequence(List<Integer> array, List<Integer> sequence) {
		int arrayPointer = 0;
		int sequencePointer = 0;
		while(arrayPointer < array.size() && sequencePointer < sequence.size() ){
			if(array.get(arrayPointer).equals(sequence.get(sequencePointer))){
				sequencePointer++;
				arrayPointer++;
			}else{
				arrayPointer++;
			}
		}
		return sequencePointer == sequence.size();
	}
}
