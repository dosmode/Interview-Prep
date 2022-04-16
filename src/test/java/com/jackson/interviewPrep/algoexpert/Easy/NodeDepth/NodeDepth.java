package com.jackson.interviewPrep.algoexpert.Easy.NodeDepth;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ValidateSubsequence {
	final Logger logger = LoggerFactory.getLogger(ValidateSubsequence.class);

	@Test
	public void TestCase1() {
		var root = new Program.BinaryTree(1);
		root.left = new Program.BinaryTree(2);
		root.left.left = new Program.BinaryTree(4);
		root.left.left.left = new Program.BinaryTree(8);
		root.left.left.right = new Program.BinaryTree(9);
		root.left.right = new Program.BinaryTree(5);
		root.right = new Program.BinaryTree(3);
		root.right.left = new Program.BinaryTree(6);
		root.right.right = new Program.BinaryTree(7);
		int actual = Program.nodeDepths(root);
		assertEquals(16, actual);
	}

}

class Program {

//	public static int nodeDepths(BinaryTree root) {
//		return nodeDepths1(root, 0);
//	}
//	public static int nodeDepths1(BinaryTree root, int level){
//		if(root.left == null) return 0;
//		return level + nodeDepths1(root.left, level +1) + nodeDepths1(root.right, level +1);
//	}

	public static int nodeDepths(BinaryTree root) {
		// Write your code here.
		return nodeDepthsHelper(root,0);

	}
	public static int nodeDepthsHelper(BinaryTree root, int depth){
		if(root==null) {
			return 0;
		}
		return depth + nodeDepthsHelper(root.left,depth+1) + nodeDepthsHelper(root.right, depth + 1);
	}

	static class BinaryTree {
		int value;
		BinaryTree left;
		BinaryTree right;

		public BinaryTree(int value) {
			this.value = value;
			left = null;
			right = null;
		}
	}
}
