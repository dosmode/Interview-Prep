package com.jackson.interviewPrep.algoexpert.medium.BSTConstruction.mergeOverlappingIntervals;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

		root.insert(12);
		assertTrue(root.right.left.left.value == 12);

		root.remove(10);
		assertTrue(root.contains(10) == false);
		assertTrue(root.value == 12);

		assertTrue(root.contains(15));
	}
}


class Program {
	static class BST {
		public int value;
		public BST left;
		public BST right;

		public BST(int value) {
			this.value = value;
		}

		public BST insert(int value) {
			// Write your code here.
			// Do not edit the return statement of this method.

			//if the value is bigger than left, insert to right
			if (this.value > value) {
				if (this.right == null) {
					BST newRight = new BST(value);
					this.right = newRight;
				} else {
					right.insert(value);
				}
				//if the value is smaller than right, insert to left

			} else if (this.value < value) {
				if( this.left == null){
					BST newLeft = new BST(value);
					this.left = newLeft;
				}else{
					left.insert(value);
				}
			}
			return this;
		}

		public boolean contains(int value) {
			// Write your code here.
			if (this.value > value) {
				if (this.right == null) {
					return false;
				}else {
					return right.contains(value);
				}
			} else if (this.value < value) {
				if( this.left == null){
					return false;
				}else{
					return left.contains(value);
				}
			}else{
				return true;
			}
		}

		public BST remove(int value) {
			// Write your code here.
			// Do not edit the return statement of this method.
			remove(value, null);
			return this;
		}
		public BST remove(int value, BST parent){
			if( this.value = value){

			}
			if()
			return new BST(1);
		}
	}
}
