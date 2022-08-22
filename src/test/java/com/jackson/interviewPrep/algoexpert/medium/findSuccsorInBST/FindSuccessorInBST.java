package com.jackson.interviewPrep.algoexpert.medium.findSuccsorInBST;

import org.junit.jupiter.api.Test;

import java.util.ArrayDeque;

import static org.junit.jupiter.api.Assertions.assertTrue;
// This file is initialized with a code version of this
// question's sample test case. Feel free to add, edit,
// or remove test cases in this file as you see fit!

import java.util.*;
import java.util.function.BinaryOperator;

class ProgramTest {
	@Test
	public void TestCase1() {
		Program.BinaryTree root = new Program.BinaryTree(1);
		root.left = new Program.BinaryTree(2);
		root.left.parent = root;
		root.right = new Program.BinaryTree(3);
		root.right.parent = root;
		root.left.left = new Program.BinaryTree(4);
		root.left.left.parent = root.left;
		root.left.right = new Program.BinaryTree(5);
		root.left.right.parent = root.left;
		root.left.left.left = new Program.BinaryTree(6);
		root.left.left.left.parent = root.left.left;
		Program.BinaryTree node = root.left.right;
		Program.BinaryTree expected = root;
		Program.BinaryTree output = new Program().findSuccessor(root, node);
		assert (expected == output);
	}
}

class Program {
	// This is an input class. Do not edit.
	static class BinaryTree {
		public int value;
		public BinaryTree left = null;
		public BinaryTree right = null;
		public BinaryTree parent = null;

		public BinaryTree(int value) {
			this.value = value;
		}
	}

	public BinaryTree findSuccessor(BinaryTree tree, BinaryTree node) {

		List<BinaryTree> inOrder = new ArrayList<>();
		inOrder = findSuccessor(tree, inOrder);

		for(int i = 0 ; i < inOrder.size() ; i++){
			BinaryTree currentNode = inOrder.get(i);
			if(node != currentNode){
				continue;
			}
			if(i == inOrder.size()-1){
				return null;
			}
			return inOrder.get(i+1);
		}
		return null;
	}


	public List<BinaryTree> findSuccessor(BinaryTree tree, 	List<BinaryTree> list) {
		if(tree == null){
			return null;
		}
		findSuccessor(tree.left, list);
		list.add(tree);
		findSuccessor(tree.right, list);

		return list;
	}
}
