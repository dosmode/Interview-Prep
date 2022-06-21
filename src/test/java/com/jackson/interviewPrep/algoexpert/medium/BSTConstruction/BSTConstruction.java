package com.jackson.interviewPrep.algoexpert.medium.BSTConstruction;

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
			if (value < this.value) {
				if (left == null) {
					BST newLeft = new BST(value);
					left = newLeft;
				} else {
					left.insert(value);
				}
			} else {
				if (right == null) {
					BST newRight = new BST(value);
					right = newRight;
				} else {
					right.insert(value);
				}
			}
			return this;
		}

		public boolean contains(int value) {
			// Write your code here.
			if (this.value < value) {
				if (this.right == null) {
					return false;
				}else {
					return right.contains(value);
				}
			} else if (this.value > value) {
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
		public void remove(int value, BST parent){
			if (this.value > value){
				if(this.left != null) {
					left.remove(value, this);
				}
			}else if (this.value < value){
				if(this.right != null){
					right.remove(value, this);
				}
			}else{
				if(left != null && right != null){
					this.value = right.smallestNumberFinder();
					right.remove(this.value, this);
				}else if(parent == null){
					if(this.left != null){
						this.value = this.left.value;
						this.right = this.left.right;
						this.left = this.left.left;
					}
					else if(this.right != null){
						this.value  = right.value;
						this.right = this.right.right;
						this.left = right.left;
					}
					else{
						//do nothing.
					}
				}
				//handling only one leaf
				else if(parent.left == this){
					parent.left = this.left != null ? left : right;
				} else if (parent.right == this) {
					parent.right = this.right != null? right : left;
				}

			}
		}
		public int smallestNumberFinder( ){
			if(left == null){
				return this.value;
			}else {
				return left.smallestNumberFinder();
			}
		}
	}
}
