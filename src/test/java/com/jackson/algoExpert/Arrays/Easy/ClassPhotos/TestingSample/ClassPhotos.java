package com.jackson.algoExpert.Arrays.Easy.ClassPhotos.TestingSample;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertTrue;

class ProgramTest {
	@Test
	public void TestCase1() {
		ArrayList<Integer> redShirtHeights = new ArrayList<Integer>(Arrays.asList(5, 8, 1, 3, 4));
		ArrayList<Integer> blueShirtHeights = new ArrayList<Integer>(Arrays.asList(6, 9, 2, 4, 5));
		boolean expected = true;
		boolean actual = new Program().classPhotos(redShirtHeights, blueShirtHeights);
		assertTrue(expected == actual);
	}
}

class Program {
	public boolean classPhotos(ArrayList<Integer> redShirtHeights, ArrayList<Integer> blueShirtHeights) {
		Collections.sort(redShirtHeights);
		Collections.sort(blueShirtHeights);

		Boolean redInFirstRow = redShirtHeights.get(0) < blueShirtHeights.get(0) ? true: false;

		for(int i = 0 ; i < redShirtHeights.size() ; i ++){
			int redHeight = redShirtHeights.get(i);
			int blueHeight = blueShirtHeights.get(i);

			if(redInFirstRow){
				if(redHeight>blueHeight){
					return false;
				}
			}else{
				if(redHeight<blueHeight){
					return false;
				}
			}
		}
		return true;
	}
}
