package com.jackson.interviewPrep.algoexpert.medium.findKLarsestValue.minHeightBst;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

class ProgramTest {
	@Test
	public void TestCase1() {
		Program.BST root = new Program.BST(15);
		root.left = new Program.BST(5);
		root.left.left = new Program.BST(2);
		root.left.left.left = new Program.BST(1);
		root.left.left.right = new Program.BST(3);
		root.left.right = new Program.BST(5);
		root.right = new Program.BST(20);
		root.right.left = new Program.BST(17);
		root.right.right = new Program.BST(22);
		int k = 3;
		int expected = 17;
		var actual = new Program().findKthLargestValueInBst(root, k);
		assertTrue(expected == actual);
	}
}

class Program {
	// This is an input class. Do not edit.
	static class BST {
		public int value;
		public BST left = null;
		public BST right = null;

		public BST(int value) {
			this.value = value;
		}
	}

	public int findKthLargestValueInBst(BST tree, int k) {

		List<Integer> sortedLinkedList = new LinkedList<>();
		findKthLargestValueInBst(tree, k, sortedLinkedList);
		return sortedLinkedList.get(sortedLinkedList.size()-k);
	}

	public void findKthLargestValueInBst(BST tree, int k, List<Integer> list) {

		if(tree == null) return;
		findKthLargestValueInBst(tree.left, k, list);
		list.add(tree.value);
		findKthLargestValueInBst(tree.right, k, list);

	}
}
