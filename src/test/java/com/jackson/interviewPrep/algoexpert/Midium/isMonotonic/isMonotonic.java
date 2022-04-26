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
		boolean isGettingGreater = false;
		if(array[1] > array[0]){
			isGettingGreater = true ;
		}
		if(isGettingGreater){
			for(int i = 0 ; array.length-2 > i ; i++){
				if( array[i+1] < array[i] ){
					return false;
				}
			}
		}else{
			for(int i = 0 ; array.length-2 > i ; i++){
				if( array[i+1] > array[i] ){
					return false;
				}
			}
		}

		return true;
	}
}