package com.jackson.interviewPrep.algoexpert.Easy.caesarCypherEncryptor;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class ProgramTest {
	@Test
	public void TestCase1() {
		assertTrue(Program.caesarCypherEncryptor("xyz", 2).equals("zab"));
	}
}



class Program {
	public static String caesarCypherEncryptor(String str, int key) {

		int reMappingKey = key % 26;

		char[] charArray = str.toCharArray();

		for (int a = 0; charArray.length> a; a++) {
			if (charArray[a] + reMappingKey <= 122) {
				charArray[a] = (char) (charArray[a] + reMappingKey);

			} else {
				charArray[a] = (char)( 96 + (charArray[a] + reMappingKey )%122);
			}
		}
		return new String(charArray);

	}
}
