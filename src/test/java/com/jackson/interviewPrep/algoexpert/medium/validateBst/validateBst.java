package com.jackson.interviewPrep.algoexpert.medium.validateBst;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;



class ProgramTest {
	@Test
	public void TestCase1() {
		var root = new Program.BST(10);
		root.left = new Program.BST(5);
		root.left.left = new Program.BST(2);
		root.left.left.left = new Program.BST(1);
		root.left.right = new Program.BST(5);
		root.right = new Program.BST(15);
		root.right.left = new Program.BST(13);
		root.right.left.right = new Program.BST(14);
		root.right.right = new Program.BST(22);

		assertTrue(Program.validateBst(root));
	}
}


class Program {
	public static boolean validateBst(BST tree) {
		if(tree.left != null){
			if(tree.left.value <= tree.value ){
				validateBst(tree.left);
			}else {
				return false;
			}
		}

		if(tree.right != null){
			if(tree.right.value > tree.value  ){
				validateBst(tree.right);
			}else{
				return false;
			}
		}
		return true;
	}

	static class BST {
		public int value;
		public BST left;
		public BST right;

		public BST(int value) {
			this.value = value;
		}
	}
}
