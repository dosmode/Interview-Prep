package com.jackson.interviewPrep.algoexpert.medium.reconstructBST;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;
class ProgramTest {

	public List<Integer> getDfsOrder(Program.BST node, List<Integer> values) {
		values.add(node.value);
		if (node.left != null) {
			getDfsOrder(node.left, values);
		}
		if (node.right != null) {
			getDfsOrder(node.right, values);
		}
		return values;
	}

	@Test
	public void TestCase1() {
		ArrayList<Integer> preOrderTraversalValues =
				new ArrayList<Integer>(Arrays.asList(10, 4, 2, 1, 3, 17, 19, 18));
		Program.BST tree = new Program.BST(10);
		tree.left = new Program.BST(4);
		tree.left.left = new Program.BST(2);
		tree.left.left.left = new Program.BST(1);
		tree.left.right = new Program.BST(3);
		tree.right = new Program.BST(17);
		tree.right.right = new Program.BST(19);
		tree.right.right.left = new Program.BST(18);
		List<Integer> expected = getDfsOrder(tree, new ArrayList<Integer>());
		var actual = new Program().reconstructBst(preOrderTraversalValues);
		List<Integer> actualValues = getDfsOrder(actual, new ArrayList<Integer>());
		assertTrue(expected.equals(actualValues));
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

	public BST reconstructBst(List<Integer> preOrderTraversalValues) {
		//base case
		if(preOrderTraversalValues.size()==0) return null;

		//tracking the end index using the array size.
		int endIndex= preOrderTraversalValues.size();
		//index would be 1 because we always take 0 as root value. after taking the root value(index = 0) then we can traverse the lest indexes
		for(int index =1 ; index<preOrderTraversalValues.size(); index++){
			if(preOrderTraversalValues.get(0)<= preOrderTraversalValues.get(index)){
				//if next node's value is greater than root then we can assume that value is the right node.
				//tracking the index.
				endIndex = index;
				break;
			}
		}


		//reconstructing the left child nodes
		BST left = reconstructBst( preOrderTraversalValues.subList(1,endIndex));
		//reconstructing the right child nodes
		BST right = reconstructBst(preOrderTraversalValues.subList(endIndex, preOrderTraversalValues.size()));

		BST newBST = new BST(preOrderTraversalValues.get(0));
		newBST.left =left;
		newBST.right = right;
		return newBST;
	}

}

