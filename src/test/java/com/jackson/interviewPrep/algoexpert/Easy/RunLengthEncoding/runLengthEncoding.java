package com.jackson.interviewPrep.algoexpert.Easy.RunLengthEncoding;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertTrue;

class ProgramTest {
	@Test
	public void TestCase1() {
		var input = "AAAAAAAAAAAAABBCCCCDD";
		var expected = "9A4A2B4C2D";
		var actual = new Program().runLengthEncoding(input);
		assertTrue(expected.equals(actual));
	}


}

class Program {
	public String runLengthEncoding(String string) {
		String result = "";
		int occurance = 1;

		for (int i = 0; i < string.length() - 1; i++) {
			char charValue = string.charAt(i);
			if (occurance > 8) {
				result = result + String.valueOf(occurance) + charValue;
				occurance = 0;
				charValue = string.charAt(i + 1);
			} else {
				if (i > string.length() - 1) {
					result = result + charValue + String.valueOf(occurance);
					occurance = 0;
					charValue = string.charAt(i + 1);
				}
				if (string.charAt(i) == string.charAt(i + 1)) {
					occurance++;
				} else {
					occurance++;
					result = result + String.valueOf(occurance) + charValue;
					occurance = 0;
					charValue = string.charAt(i + 1);
				}
			}
			if (i == string.length() - 2) {
				occurance++;
				result = result + String.valueOf(occurance) + charValue;
				occurance = 0;
				charValue = string.charAt(i + 1);
			}


		}
		return result;
	}
}
