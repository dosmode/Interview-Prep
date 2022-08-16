package com.jackson.interviewPrep.algoexpert.medium.BinaryTreeDiameter;

import org.junit.jupiter.api.Test;

import java.util.ArrayDeque;

import static org.junit.jupiter.api.Assertions.assertTrue;

class ProgramTest {
	@Test
	public void TestCase1() {
		TestBinaryTree input = new TestBinaryTree(1);
		input.insert(new int[] {2, 3, 4, 5, 6, 7}, 0);
		var expected = 4;
		var actual = new Program().binaryTreeDiameter(input);
		assertTrue(expected == actual);
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
	// This is an input class. Do not edit.
	static class BinaryTree {
		public int value;
		public BinaryTree left = null;
		public BinaryTree right = null;

		public BinaryTree(int value) {
			this.value = value;
		}
	}

	static class TreeInfo{
		int diameter;
		int height;

		public TreeInfo(int diameter, int height) {
			this.diameter = diameter;
			this.height = height;
		}
	}

	public int binaryTreeDiameter(BinaryTree tree) {
	return getTreeInfo(tree).diameter;
	}
	TreeInfo getTreeInfo(BinaryTree tree){
		if(tree == null){
			return new TreeInfo(0,0);
		}
		TreeInfo leftInfo = getTreeInfo(tree.left);
		TreeInfo rightInfo = getTreeInfo(tree.right);

		int longestPath = leftInfo.height + rightInfo.height;
		int maxDiameterSoFar= Math.max(leftInfo.diameter, rightInfo.diameter);
		int currentDiameter = Math.max(longestPath, maxDiameterSoFar);
		int currentHeight = Math.max(leftInfo.height , rightInfo.height) +1;

		return new TreeInfo(currentDiameter, currentHeight);
	}


}
