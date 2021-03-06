package com.jackson.interviewPrep.algoexpert.Easy.nthfibonacci;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ProgramTest {
		@Test
		public void TestCase1() {
			assertTrue(Program.getNthFib(6) == 5);
		}
	}


class Program {
	public static int getNthFib(int n) {
		if(n == 2){
			return 1;
		}else if ( n == 1){
			return 0;
		}else{
			return getNthFib(n-1) + getNthFib(n-2);

		}
	}
}