package com.jackson.interviewPrep.algoexpert.medium.minHeightBst;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ProgramTest {
	@Test
	public void TestCase1() {
		List<Integer> array = Arrays.asList(1, 2, 5, 7, 10, 13, 14, 15, 22);
		var tree = Program.minHeightBst(array);

		assertTrue(validateBst(tree));
		assertEquals(4, getTreeHeight(tree));

		var inOrder = inOrderTraverse(tree, new ArrayList<Integer>());
		List<Integer> expected = Arrays.asList(1, 2, 5, 7, 10, 13, 14, 15, 22);
		assertTrue(expected.equals(inOrder));
	}

	static boolean validateBst(Program.BST tree) {
		return validateBst(tree, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}

	static boolean validateBst(Program.BST tree, int minValue, int maxValue) {
		if (tree.value < minValue || tree.value >= maxValue) {
			return false;
		}
		if (tree.left != null && !validateBst(tree.left, minValue, tree.value)) {
			return false;
		}
		if (tree.right != null && !validateBst(tree.right, tree.value, maxValue)) {
			return false;
		}
		return true;
	}

	static List<Integer> inOrderTraverse(Program.BST tree, List<Integer> array) {
		if (tree.left != null) {
			inOrderTraverse(tree.left, array);
		}
		array.add(tree.value);
		if (tree.right != null) {
			inOrderTraverse(tree.right, array);
		}
		return array;
	}

	static int getTreeHeight(Program.BST tree) {
		return getTreeHeight(tree, 0);
	}

	static int getTreeHeight(Program.BST tree, int height) {
		if (tree == null) return height;
		int leftTreeHeight = getTreeHeight(tree.left, height + 1);
		int rightTreeHeight = getTreeHeight(tree.right, height + 1);
		return Math.max(leftTreeHeight, rightTreeHeight);
	}

}

class Program {
	public static BST minHeightBst(List<Integer> array) {

		return minHeightBST(array, null, 0, array.size()-1);
	}
	public static BST minHeightBST(List<Integer> array, BST bst, int min, int max){
		if(max<min) return null;
		var mid = (min+max)/2;
		if(bst == null){
			bst = new BST(array.get(mid));
		}else{
			bst.insert(array.get(mid));
		}
		minHeightBST(array, bst, min, mid-1);
		minHeightBST(array, bst, mid+1, max);
		return bst;
	}

	static class BST {
		public int value;
		public BST left;
		public BST right;

		public BST(int value) {
			this.value = value;
			left = null;
			right = null;
		}

		public void insert(int value) {
			if (value < this.value) {
				if (left == null) {
					left = new BST(value);
				} else {
					left.insert(value);
				}
			} else {
				if (right == null) {
					right = new BST(value);
				} else {
					right.insert(value);
				}
			}
		}
	}
}
