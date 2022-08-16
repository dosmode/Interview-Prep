package com.jackson.interviewPrep.algoexpert.medium.InvertBinaryTree;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayDeque;

class ProgramTest {
	@Test
	public void TestCase1() {
		TestBinaryTree tree = new TestBinaryTree(1);
		tree.insert(new int[] {2, 3, 4, 5, 6, 7, 8, 9}, 0);
		Program.invertBinaryTree(tree);
		InvertedBinaryTree invertedTree = new InvertedBinaryTree(1);
		invertedTree.insert(new int[] {2, 3, 4, 5, 6, 7, 8, 9}, 0);
		assertTrue(compareBT(tree, invertedTree));
	}

	private boolean compareBT(Program.BinaryTree tree1, InvertedBinaryTree tree2) {
		if (tree1 == null && tree2 == null) {
			return true;
		}
		if (tree1 != null && tree2 != null) {
			return tree1.value == tree2.value
					&& compareBT(tree1.left, tree2.left)
					&& compareBT(tree1.right, tree2.right);
		}
		return false;
	}

	class InvertedBinaryTree {
		public int value;
		public InvertedBinaryTree left;
		public InvertedBinaryTree right;

		public InvertedBinaryTree(int value) {
			this.value = value;
		}

		public void insert(int[] values, int i) {
			if (i >= values.length) {
				return;
			}
			ArrayDeque<InvertedBinaryTree> queue = new ArrayDeque<InvertedBinaryTree>();
			queue.addLast(this);
			while (queue.size() > 0) {
				InvertedBinaryTree current = queue.pollFirst();
				if (current.right == null) {
					current.right = new InvertedBinaryTree(values[i]);
					break;
				}
				queue.addLast(current.right);
				if (current.left == null) {
					current.left = new InvertedBinaryTree(values[i]);
					break;
				}
				queue.addLast(current.left);
			}
			insert(values, i + 1);
		}
	}

	class TestBinaryTree extends Program.BinaryTree {
		public TestBinaryTree(int value) {
			super(value);
		}

		public void insert(int[] values, int i) {
			if (i >= values.length) {
				return;
			}
			ArrayDeque<Program.BinaryTree> queue = new ArrayDeque<Program.BinaryTree>();
			queue.addLast(this);
			while (queue.size() > 0) {
				Program.BinaryTree current = queue.pollFirst();
				if (current.left == null) {
					current.left = new Program.BinaryTree(values[i]);
					break;
				}
				queue.addLast(current.left);
				if (current.right == null) {
					current.right = new Program.BinaryTree(values[i]);
					break;
				}
				queue.addLast(current.right);
			}
			insert(values, i + 1);
		}
	}
}



class Program {
	public static void invertBinaryTree(BinaryTree tree) {
		if(tree == null){
			return;
		}
		swapBinaryTree(tree);
		invertBinaryTree(tree.left);
		invertBinaryTree(tree.right);
	}
	private static void swapBinaryTree(BinaryTree tree){
		BinaryTree left = tree.left;
		tree.left = tree.right;
		tree.right = left;
	}

	static class BinaryTree {
		public int value;
		public BinaryTree left;
		public BinaryTree right;

		public BinaryTree(int value) {
			this.value = value;
		}
	}
}

