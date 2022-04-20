package com.jackson.interviewPrep.algoexpert.Easy.palindromeCheck;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class ProgramTest {

	@Test
	public void TestCase1() {

		assertTrue(Program.isPalindrome("abcdcba"));
		assertTrue(!Program.isPalindrome("asdfasdfsda"));

	}

}


class Program {
	public static boolean isPalindrome(String str) {
		char[] ch=str.toCharArray();
		int strSize = ch.length - 1;

		for (int i = 0; i < strSize; i++) {
			if (ch[i] == ch[strSize]) {
				strSize--;
			} else {
				return false;
			}
		}
		return true;
	}
}
