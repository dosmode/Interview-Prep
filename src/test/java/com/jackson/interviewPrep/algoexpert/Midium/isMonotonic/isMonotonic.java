package com.jackson.interviewPrep.algoexpert.Midium.isMonotonic;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


class ProgramTest {
	@Test
	public void TestCase1() {
		var array = new int[] {-1, -5, -10, -1100, -1100, -1101, -1102, -9001};
		var expected = true;
		var actual = Program.isMonotonic(array);
		assertEquals(expected, actual);
	}
}


class Program {
	public static boolean isMonotonic(int[] array) {
			return increasing(array) || decreasing(array);
		}

		static boolean increasing(int[] array) {
			for (int i = 0; i < array.length - 1; ++i)
				if (array[i] >array[i+1]) return false;
			return true;
		}

		static boolean decreasing(int[] array) {
			for (int i = 0; i <array.length - 1; ++i)
				if (array[i] < array[i+1]) return false;
			return true;
		}
}