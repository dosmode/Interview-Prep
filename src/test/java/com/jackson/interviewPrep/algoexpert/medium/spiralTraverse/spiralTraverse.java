package com.jackson.interviewPrep.algoexpert.medium.spiralTraverse;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;


class ProgramTest {
	@Test
	public void TestCase1() {
		var input =
				new int[][] {
						{1, 2, 3},
						{12, 13,4},
						{11,14,5},
						{10, 15,6},
						{9,8,7}
				};
		var expected = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15);
		var actual = Program.spiralTraverse(input);
		assertTrue(expected.equals(actual));
	}
}




class Program {
	public static List<Integer> spiralTraverse(int[][] array) {
		// Write your code here.
		int startCol =0;
		int endCol = array[0].length -1;
		int startRow = 0;
		int endRow = array.length -1;

		List<Integer> result = new LinkedList<>();
		while(startCol <= endCol && startRow <= endRow){
			for(int col = startCol ; col <= endCol; col++ ){
				System.out.println(array[startRow][col]);
				result.add(array[startRow][col]);
			}
			for(int row = startRow +1 ; row <= endRow ; row++){
				System.out.println(array[row][endCol]);
				result.add(array[row][endCol]);
			}
			for(int col = endCol -1 ; col >= startCol ; col--){
				if(startRow == endRow) break;
				System.out.println(array[endRow][col]);
				result.add(array[endRow][col]);
			}

			for(int row = endRow -1 ; row > startRow ; row--){
				if(startCol == endCol) break;
				System.out.println(array[row][startRow]);
				result.add(array[row][startRow]);
			}
			startCol++;
			endCol--;
			startRow++;
			endRow--;
		}



		return result;
	}
}
